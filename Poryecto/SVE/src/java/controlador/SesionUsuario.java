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
import javax.servlet.http.HttpSession;
import modelo.Ciudadano;
import static modelo.CiudadanoDTO.entrarSecundario;

/**
 *
 * @author Icchigo
 */
public class SesionUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SesionUsuario</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SesionUsuario at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            HttpSession sesion = request.getSession(true);
//            sesion.invalidate();
//
//        } catch (Exception e) {
//        }
//        response.sendRedirect("index.jsp");
//    }

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
         try{
            HttpSession sesion = request.getSession();
            if(sesion.getAttribute("key")!=null){
                sesion.invalidate();
            }
            if (request.getParameter("entrarUsuario") != null) {
                String user = request.getParameter("txtUser");
                String pass = request.getParameter("txtPass");
                if (!user.equals("") && !pass.equals("")) {
                    Ciudadano c = entrarSecundario(user, pass);
                    if(c.getConfirmacion() == 0 ){
                        if (user.equals(c.getNumDui()) && pass.equals(c.getContrasenia())){
                            ArrayList<Ciudadano> usuario = new ArrayList<>();
                            usuario.add(c);
                            sesion.setAttribute("usuario",usuario);
                            sesion.setAttribute("key", "3");
                            response.sendRedirect("pages/tse.jsp");
                        } else {
                            //datos incorrectos
                            response.sendRedirect("pages/login/tse_usuario.jsp");
                        }
                    }else{
                        //activar modal notificando que la cuenta no esta activa
                    }
                } else {
                    //debes completar campos
                }
            } else {
                response.sendRedirect("pages/notificacion/tse_aviso.jsp");
            }
        } catch (Exception e) {
            response.sendRedirect("pages/notificacion/tse_error.jsp");
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
