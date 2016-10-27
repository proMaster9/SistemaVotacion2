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
import modelo.CentroVotacion;
import modelo.CentroVotacionDTO;
import modelo.CiudadanoDTO;
import modelo.MunicipioDTO;

/**
 *
 * @author Icchigo
 */
public class SerCentroVotacion extends HttpServlet {

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
        if (request.getParameter("btnAgregar") != null) {
            int departamento = Integer.parseInt(request.getParameter("txtDepartamento"));
            CentroVotacion c = new CentroVotacion();
            c.setNombreCentro(request.getParameter("txtNombre"));
            c.setNumJrvDisponible(Integer.parseInt(request.getParameter("txtJrv")));
            c.setNumDui(request.getParameter("txtDui"));
            c.setIdMunicipio(Integer.parseInt(request.getParameter("slMunicipio")));
            c.setDireccion(request.getParameter("txtDireccion"));
            if (CentroVotacionDTO.agregarCentro(c)) {
                for (CentroVotacion centro : CentroVotacionDTO.mostrarCentrosDep(departamento)) {
                    out.print("<tr>");
                    out.print("<td>" + centro.getNombreCentro() + "</td>");
                    out.print("<td>" + centro.getNumJrvDisponible() + "</td>");
                    out.print("<td>" + centro.getNumDui() + ", " + CiudadanoDTO.mostrarVotante(centro.getNumDui()).getApellido() + " " + CiudadanoDTO.mostrarVotante(centro.getNumDui()).getNombre() + "</td>");
                    out.print("<td>" + MunicipioDTO.mostrarUnMunicipio(centro.getIdMunicipio()).getNombreMunicipio() + "</td>");
                    out.print("<td>");
                    out.print("<a href='#'>Modificar</a>");
                    out.print("<a hrf='#>Eliminar</a>");
                    out.print("</td>");
                    out.print("</tr>");
                }
            } else {
                out.print("Error al agregar");
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
