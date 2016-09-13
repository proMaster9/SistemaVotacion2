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
                if (request.getParameter("txtUser") != null && request.getParameter("txtPass") != null) {
                    String user = request.getParameter("txtUser");
                    String pass = request.getParameter("txtPass");
                    int tipo =0;
                    Login login = new Login(user,pass);
                    try {
                        ps = con.getCnn().prepareStatement("select * from entrar('"+login.getUser()+"','"+login.getPass()+"');");
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            tipo = rs.getInt(1);
                            user = rs.getString(2);
                            pass = rs.getString(3);
                        }
                        HttpSession sesion = request.getSession();
                        switch(tipo){
                            case 1:
                                sesion.setAttribute("user",user);
                                sesion.setAttribute("pass", pass);
                                sesion.setAttribute("tipo", tipo);
                                response.sendRedirect("pages/tse-panelusuario.jsp");
                            break;
                            case 2:
                                sesion.setAttribute("user",user);
                                sesion.setAttribute("pass", pass);
                                sesion.setAttribute("tipo", tipo);
                                response.sendRedirect("pages/tse-panelusuario.jsp");
                            break;
                            case 3:
                                sesion.setAttribute("user",user);
                                sesion.setAttribute("pass", pass);
                                sesion.setAttribute("tipo", tipo);
                                response.sendRedirect("pages/tse-panelusuario.jsp");
                            break;
                            default:
                                response.sendRedirect("");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error" + ex);
                    } finally {
                        con.desconectar();
                    }
                }else{
                    response.sendRedirect("../login/tse-usuario.jsp");
                }
        } catch (Exception e) {
            System.out.println("Error" + e);
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
