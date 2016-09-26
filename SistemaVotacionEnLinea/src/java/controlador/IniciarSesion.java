/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clases.Login;
import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Icchigo
 */
public class IniciarSesion extends HttpServlet {

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
        Conexion con = Conexion.conectar();
        PreparedStatement ps;
        ResultSet rs;
        try {
            if (!"".equals(request.getParameter("txtUser")) && !"".equals(request.getParameter("txtPass"))) {
                String user = "";
                String tipo = "";
                int id_tipo = 0;
                Login login = new Login(request.getParameter("txtUser"), request.getParameter("txtPass"));
                ps = con.getCnn().prepareStatement("select * from entrar('" + login.getUser() + "','" + login.getPass() + "');");
                rs = ps.executeQuery();
                while (rs.next()) {
                    try {
                        id_tipo = rs.getInt(1);
                        tipo = rs.getString(2);
                        user = rs.getString(3);
                        if (id_tipo != 0 && request.getParameter("txtUser").equals(user)) {
                            response.setHeader("Pragma", "no-cache");
                            response.setHeader("Cache-Control", "no-store");
                            response.setHeader("Cache-Control", "must-revalidate");
                            response.setHeader("Canche-control", "no-cache");
                            HttpSession sesion = request.getSession();
                            sesion.setAttribute("id_tipo", id_tipo);
                            sesion.setAttribute("tipo", tipo);
                            sesion.setAttribute("user", user);
                            response.sendRedirect("pages/panelcontrol.jsp");
                        } else {
                            response.sendRedirect("login/tse-usuario.jsp");
                        }
                    } catch (SQLException ex) {
                        response.sendRedirect("login/tse-usuario.jsp");
                    }
                }
            } else {
                response.sendRedirect("login/tse-usuario.jsp");
            }
        } catch (SQLException ex) {
            System.out.println("Error" + ex);
            response.sendRedirect("login/tse-usuario.jsp");
        } finally {
            con.desconectar();
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
