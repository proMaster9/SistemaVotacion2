/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ciudadano;
import modelo.CiudadanoDTO;
import modelo.Partido;
import modelo.PartidoDTO;
import modelo.SupervisorDTO;
import modelo.SupervisorExt;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Icchigo
 */
public class SerDirectorTSE extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ruta = "/home/carlos/SistemaVotacion2/Proyecto/SVE/web/images/files/partidos/";
        Partido p = new Partido();
        int accion = 1; //1=gregar  2=modificar
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            diskFileItemFactory.setSizeThreshold(40960);
            File repositoryPath = new File("/temp");
            diskFileItemFactory.setRepository(repositoryPath);
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            servletFileUpload.setSizeMax(81920); // bytes
            upload.setSizeMax(307200); // 1024 x 300 = 307200 bytes = 300 Kb
            List listUploadFiles = null;
            FileItem item = null;
            try {
                listUploadFiles = upload.parseRequest(request);
                Iterator it = listUploadFiles.iterator();
                while (it.hasNext()) {
                    item = (FileItem) it.next();
                    if (!item.isFormField()) {
                        if (item.getSize() > 0) {
                            String nombre = item.getName();
                            String tipo = item.getContentType();
                            long tamanio = item.getSize();
                            String extension = nombre.substring(nombre.lastIndexOf("."));
                            File archivo = new File(ruta, nombre);
                            item.write(archivo);
                            if (archivo.exists()) {
                                p.setImagen(nombre);
                                out.println("GUARDADO " + archivo.getAbsolutePath() + "</p>");
                            } else {
                                out.println("FALLO AL GUARDAR. NO EXISTE " + archivo.getAbsolutePath() + "</p>");
                            }
                            out.println("Finalizado");
                        }
                    } else {
                        if (item.getFieldName().equals("txtAcronimo")) {
                            out.print("Nombre: " + item.getString());
                            p.setAcronimo(item.getString());
                        }
                        if (item.getFieldName().equals("txtNombre")) {
                            p.setNombre(item.getString());
                        }
                        if (item.getFieldName().equals("txtDui")) {
                            p.setNumDui(item.getString());
                        }
                        if (item.getFieldName().equals("txtId")) {
                            if (item.getString().length() > 0) {
                                p.setIdPartido(Integer.parseInt(item.getString()));
                                accion = 2;
                            }
                        }
                    }
                }
                if (accion == 1) {
                    if (PartidoDTO.agregarPartido(p)) {
                        response.sendRedirect("pages/crud_partidos.jsp");
                    } else {
                        //cambiar por alguna accion en caso de error
                        out.print("Error al insertar");
                    }
                } else if (accion == 2) {
                    String imagen = PartidoDTO.mostrarPartido(p.getIdPartido()).getImagen();
                    if (p.getImagen().equals("")) {
                        p.setImagen(imagen);
                    }
                    if (PartidoDTO.modificarPartido(p)) {
                        response.sendRedirect("pages/crud_partidos.jsp");
                    } else {
                        out.print("Error al modificar");
                    }
                }

            } catch (FileUploadException e) {
                out.println("Error Upload: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                out.println("Error otros: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        if (request.getParameter("idSupervisor") != null) {
            int id = Integer.parseInt(request.getParameter("idSupervisor"));
            if (SupervisorDTO.eliminarSupervisor(id)) {
                response.sendRedirect("pages/supervisor_externo.jsp");
            } else {
                out.print("Error");
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        if (request.getParameter("btnAgregar") != null) {
            if ("supervisor".equals(request.getParameter("usuario"))) {
                String identificacion = request.getParameter("txtIdentificacion");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String sexo = request.getParameter("txtSexo");
                String pais = request.getParameter("txtPais");
                String organizacion = request.getParameter("txtOrganizacion");
                SupervisorExt sup = new SupervisorExt();
                sup.setIdentificacion(identificacion);
                sup.setContrasenia("12345");
                sup.setNombre(nombre);
                sup.setApellido(apellido);
                sup.setSexo(sexo);
                sup.setPais(pais);
                sup.setOrganizacion(organizacion);
                if (SupervisorDTO.agregarSupervisor(sup)) {
                    response.sendRedirect("pages/supervisor_externo.jsp");
                } else {
                    //en caso de error
                    out.print("Error");
                }
            }
        }

        if (request.getParameter("btnModificar") != null) {
            if ("supervisor".equals(request.getParameter("usuario"))) {
                int id = Integer.parseInt(request.getParameter("txtIdUsuario"));
                String identificacion = request.getParameter("txtIdentificacion");
                String nombre = request.getParameter("txtNombre");
                String apellido = request.getParameter("txtApellido");
                String sexo = request.getParameter("txtSexo");
                String pais = request.getParameter("txtPais");
                String organizacion = request.getParameter("txtOrganizacion");
                SupervisorExt sup = new SupervisorExt();
                sup.setIdUsuario(id);
                sup.setIdentificacion(identificacion);
                sup.setContrasenia("12345");
                sup.setNombre(nombre);
                sup.setApellido(apellido);
                sup.setSexo(sexo);
                sup.setPais(pais);
                sup.setOrganizacion(organizacion);
                if (SupervisorDTO.modificarSupervisor(sup)) {
                    response.sendRedirect("pages/supervisor_externo.jsp");
                } else {
                    //en caso de error
                    out.print("Error");
                }
            }
        }

        //procesando datos del publicista
        if (request.getParameter("duiPublicista") != null) {
            Ciudadano c = CiudadanoDTO.mostrarVotante(request.getParameter("duiPublicista"));
            if (c.getIdUsuario() != 0) {
                c.setTipoUsuario(9);
                c.setApellido("12345");
                if (CiudadanoDTO.agregarUsuario(c)) {
                    out.println("Publicista agregado");
                    out.println("Nombre: " + c.getNombre() + "<br>");
                    out.println("Apellido: " + c.getApellido() + "<br>");
                    out.println("Sexo: " + c.getSexo() + "<br>");
                } else {
                    out.println("Error al modificar");
                }

            } else {
                out.println("Ciudadano no encontrado");
            }
        }

        //procesando datos de partido
        if (request.getParameter("txtDui") != null) {
            Ciudadano c = CiudadanoDTO.mostrarVotante(request.getParameter("txtDui"));
            if (c.getIdUsuario() != 0) {
                out.println("Nombre: " + c.getNombre() + "<br>");
                out.println("Apellido: " + c.getApellido() + "<br>");
            }
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
