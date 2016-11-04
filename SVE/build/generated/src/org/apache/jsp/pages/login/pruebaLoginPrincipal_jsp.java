package org.apache.jsp.pages.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.SerActivacion;

public final class pruebaLoginPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Login usuarios principales</h1>\n");
      out.write("        <!--\n");
      out.write("            No se envian los datos a ningun servlet, solo tiene las validaciones\n");
      out.write("            para que dejar iniciar sesion a las cuentas no activadas.\n");
      out.write("        -->\n");
      out.write("        <form>\n");
      out.write("            Dui: <input type=\"text\" name=\"txtUser\" id=\"txtUser\"><br>\n");
      out.write("            <!--\n");
      out.write("                si la cuenta esta activada, imprime un mensaje de\n");
      out.write("                \"la cuenta ha sido activada exitosamente\", si no esta activada,\n");
      out.write("                se imprime el formulario para la activacion\n");
      out.write("            -->\n");
      out.write("            <div id=\"divActivacion\">\n");
      out.write("                <!--Cuenta activada-->\n");
      out.write("                ");
 if(SerActivacion.verificarActivacion("00000001-0", 1) == 1) { 
      out.write("\n");
      out.write("                    la cuenta ha sido activada exitosamente\n");
      out.write("                <!--Cuenta no activada-->\n");
      out.write("                ");
 } else if(SerActivacion.verificarActivacion("00000001-0", 1) == 0) { 
      out.write("\n");
      out.write("                    porfavor, activa tu cuenta\n");
      out.write("                <!--Cuenta inexistente-->\n");
      out.write("                ");
 } else { 
      out.write("\n");
      out.write("                    parece que el numero de dui no existe\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("                Contraseña: <input type=\"password\" name=\"txtPass\" id=\"txtPass\">\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
