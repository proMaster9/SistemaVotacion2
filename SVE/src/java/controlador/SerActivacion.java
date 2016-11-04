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
import modelo.Pregunta;
import modelo.PreguntaDTO;

/**
 *
 * @author carlos
 */
public class SerActivacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //JOEL, ESTE ES EL METODO, SOLO PASA POR PARAMETROS, LOS MISMOS
    //QUE LOS ENVIOS GET Y POST DEL SERVLET
    //ESTE METODO ESTA DENTRO DEL SERVLET
    public static String mostrarPreguntas() {
        String html = "";
        html = "<select>";
        for (Pregunta p : PreguntaDTO.mostrar()) {
            html += "<option value='" + p.getIdPregunta() + "'>" + p.getPregunta() + "</option>";
        }
        html += "</select>";
        return html;
    }

    //comprueba si la cuenta del usuario esta activada o no
    //el primer parametro es el dui, el parametro tipo recibe 2 valores
    //1 = usuario principal y 2 = usuarios secundarios y ciudadanos
    //cuando es usuario principal, se verifican los datos de la tabla excepcionusuario
    //cuando es usuario secundario o votante, los datos se verifican en la tabla padronelectoral
    //cuando el usuario no existe, se retorna -1

    public static int verificarActivacion(String dui, int tipo) {
        Ciudadano c;
        if (tipo == 1) {
            //usuarios principales
            c = CiudadanoDTO.mostrarPrincipal(dui);
            //si el usuario no existe, se retorna -1
            if(c.getIdUsuario() == 0) {
                c.setConfirmacion(-1);
            }
        } else {
            //usuarios secundarios o votantes
            c = CiudadanoDTO.mostrarVotante(dui);
            //si el usuario no existe, se retorna -1
            if(c.getIdUsuario() == 0) {
                c.setConfirmacion(-1);
            }
        }
        return c.getConfirmacion();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //validacion del dui cuando se inicia sesion, aca se verifica que
        //el usuario tenga activa su cuenta, para poder iniciar sesion
        if(request.getParameter("btnValidarDui") != null) {
            String dui = request.getParameter("txtDui");
            int tipo = Integer.parseInt(request.getParameter("txtTipo"));
            if(verificarActivacion(dui,tipo) == 0) {
                //cuenta no activada
                out.print("Debes activar tu cuenta para poder iniciar sesion<br>");
                out.print("<a href=\"../activacionPrincipal.jsp\">Activar cuenta</a>");
            }
            else {
                //cuando la cuenta esta activada, hay que volver a imprimir el formulario,
                //desde el campo contraseña :(
                out.print("Contraseña: <input type='password' name='txtPass' id='txtPass'><br>");
                out.print("<input type='button' name='btnEntrar' value='entrar'><br>");
                out.print("<a href='../activacionPrincipal.jsp'>Activar cuenta</a>");
                out.print("<a href='#'>Olvide mi contraseña</a>");
            }
        }
        
        
        //validacion de las credenciales del usuario principal
        //durante la activacion de la cuenta de usuario
        if (request.getParameter("txtPrincipal") != null) {
            String dui = request.getParameter("txtDui");
            String pass = request.getParameter("txtPass");
            Ciudadano c = CiudadanoDTO.entrarPrincipal(dui, pass);
            //comprobamos que las credenciales ingresadas sean correctas
            if (c.getIdUsuario() != 0) {
                out.print("Credenciales correctas<br>");
                out.print("Eliga una pregunta: " + mostrarPreguntas() + "<br>");
                out.print("Respuesta: <input type='text' name='txtRespuesta' id='txtResúesta'><br>");
                out.print("<input type='button' name='btnActivar' id='btnActivar' onclick=\"activar()\" value='Activar'>");
            } else {
                out.print("Lo sentimos, la contraseña ingresada es incorrecta");
            }
        }
        //activacion de cuentas de usuarios principales
        if (request.getParameter("txtActivacionPrincipal") != null) {
            out.print("Cuenta Activada");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
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
