/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Ciudadano;
import modelo.CiudadanoDTO;
import modelo.Municipio;
import modelo.MunicipioDTO;

/**
 *
 * @author Icchigo
 */
public class SerUsuariosPrincipales extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SerUsuariosPrincipales</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SerUsuariosPrincipales at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        PrintWriter out = response.getWriter();
        if(request.getParameter("idDepar")!=null){
            int idDepar=Integer.valueOf(request.getParameter("idDepar"));

            out.print("<option>Seleccione municipio</option>");
            ArrayList<Municipio> mun = MunicipioDTO.mostrarMunicipios();
            for(Municipio lista : mun){
                if(idDepar==lista.getIdDepartmento()){
                    out.print("<option value="+lista.getIdMunicipio()+">"+lista.getNombreMunicipio()+"</option>");
                }
            }

        }
        if(request.getParameter("Agregar")!=null){
            int tipo = Integer.valueOf(request.getParameter("tipo"));
            if(tipo == 2 || tipo == 3 || tipo == 6){
                Ciudadano ciu = new Ciudadano();
                //recuperando los datos enviados desde la vista
                ciu.setNumDui(request.getParameter("dui"));
                ciu.setNombre(request.getParameter("nom"));
                ciu.setApellido(request.getParameter("ape"));
                ciu.setSexo(request.getParameter("sexo"));
                ciu.setDireccion(request.getParameter("dir"));
                ciu.setIdMunicipio(Integer.valueOf(request.getParameter("mun")));
                ciu.setFechaNac(request.getParameter("fecha"));
                ciu.setContrasenia("12345");
                ciu.setTipoUsuario(tipo);
                //enviando los datos al modelo
                if(CiudadanoDTO.agregarUsuario(ciu)){
                    
                }else{}
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
