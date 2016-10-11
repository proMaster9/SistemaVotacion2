/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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
        if(request.getParameter("idSupervisor") != null) {
            int id = Integer.parseInt(request.getParameter("idSupervisor"));
            if(SupervisorDTO.eliminarSupervisor(id)) {
                response.sendRedirect("pages/supervisor_externo.jsp");
            }
            else {
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
                    response.sendRedirect("pages/Prueba.jsp");
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
        if(request.getParameter("duiPublicista") != null) {
            Ciudadano c = CiudadanoDTO.mostrarVotante(request.getParameter("duiPublicista"));
            if(c.getIdUsuario() != 0) {
                c.setTipoUsuario(9);
                c.setApellido("12345");
                if(CiudadanoDTO.agregarUsuario(c)) {
                    out.println("Publicista agregado");
                    out.println("Nombre: " + c.getNombre() + "<br>");
                    out.println("Apellido: " + c.getApellido() + "<br>");
                    out.println("Sexo: " + c.getSexo() + "<br>");
                } 
                else {
                    out.println("Error al modificar");
                }

            } else {
                out.println("Ciudadano no encontrado");
            }
        }
        
        //procesando datos de partido
        if(request.getParameter("btnAgregarPartido") != null) {
            String acronimo = request.getParameter("txtAcronimo");
            String nombre = request.getParameter("txtNombre");
            String representante = request.getParameter("txtRepresentante");
            Partido p = new Partido();
            p.setAcronimo(acronimo);
            p.setNombre(nombre);
            p.setNumDui(representante);
            p.setImagen("...");
            if(PartidoDTO.agregarPartido(p)) {
                response.sendRedirect("pages/supervisor_externo.jsp");
            }
            else {
            
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
