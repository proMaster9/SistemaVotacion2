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

/**
 *
 * @author Icchigo
 */
public class SerCiudadano extends HttpServlet {

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
        /*
        out.print(getServletContext().getRealPath("/")+"images/files/partidos/ <br>");
        out.print(getServletContext().getContextPath()+"/web/images/files/candidatos/<br>");
        out.print(System.getProperty("user.dir") + "<br>");
        out.print(System.getProperty("user.home") + "<br>");
        out.print(this.getClass().getProtectionDomain().getCodeSource().getLocation()+"<br>");
        */
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
        PrintWriter out = response.getWriter();

        if (request.getParameter("dui") != null && request.getParameter("tipo") != null) {
            if (Integer.parseInt(request.getParameter("tipo")) == 0) {
                Ciudadano c = CiudadanoDTO.mostrarVotante(request.getParameter("dui"));
                if (c.getIdMunicipio() != 0) {
                    out.print("<input type='hidden' name='txtResultado' id='txtResultado' value='1'>");
                    out.print("Nombre: " + c.getNombre() + "<br>");
                    out.print("Apellido: " + c.getApellido() + "<br>");
                    if (c.getSexo().equals("m")) {
                        out.print("Genero: Masculino<br>");
                    } else {
                        out.print("Genero: Femenino<br>");
                    }
                }
                else {
                    out.print("Ciudadano no encontrado<br>");
                    out.print("<input type='hidden' name='txtResultado' id='txtResultado' value='0'>");
                }
            } else {
                Ciudadano c = CiudadanoDTO.mostrarVotante(request.getParameter("dui"));
                if (c.getIdMunicipio() != 0) {
                    out.print("<input type='hidden' name='txtResultado' id='txtResultado' value='1'>");
                    out.print("Correcto");
                } 
                else {
                    out.print("<input type='hidden' name='txtResultado' id='txtResultado' value='0'>");
                    out.print("Incorrecto");
                }
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
