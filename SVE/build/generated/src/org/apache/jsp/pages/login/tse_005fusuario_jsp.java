package org.apache.jsp.pages.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_005fusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');

    response.addHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "no-cache, must-revalidate");
    response.addHeader("Cache-Control", "post-check=0, pre-check=0");
    response.addHeader("Cache-Control", "private");
    response.setDateHeader("Expires", 0);

      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <title>Login Usuario | TSE </title>\n");
      out.write("        <!-- Favicon-->\n");
      out.write("        <link rel=\"icon\" href=\"\" type=\"image/x-icon\">\n");
      out.write("\n");
      out.write("        <!-- Google Fonts -->\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <link href=\"../../../plugins/iconfont/material-icons.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core Css -->\n");
      out.write("        <link href=\"../../../plugins/bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("        <!-- Waves Effect Css -->\n");
      out.write("        <link href=\"../../../plugins/node-waves/waves.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Animation Css -->\n");
      out.write("        <link href=\"../../../plugins/animate-css/animate.css\" rel=\"stylesheet\" />\n");
      out.write("\n");
      out.write("        <!-- Custom Css -->\n");
      out.write("        <link href=\"../../../css/style.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"login-page\">\n");
      out.write("        <div class=\"login-box\">\n");
      out.write("            <div class=\"card\">\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"msg\"><img src=\"tse-logo.jpg\"/></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"body\" >\n");
      out.write("                    <form id=\"sign_in\" method=\"POST\" action=\"../../sesion_usuario\">                 \n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\">\n");
      out.write("                                <i class=\"material-icons col-light-blue\">person</i>\n");
      out.write("                            </span>\n");
      out.write("                            <div class=\"form-line\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"txtUser\" placeholder=\"Ingrese su número de dui\" required autofocus>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("                            <span class=\"input-group-addon\">\n");
      out.write("                                <i class=\"material-icons col-light-blue\">lock</i>\n");
      out.write("                            </span>\n");
      out.write("                            <div class=\"form-line\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"txtPass\" placeholder=\"Ingrese su contraseña\" required>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-xs-8 p-t-5\">\n");
      out.write("                                <input type=\"checkbox\" name=\"rememberme\" id=\"rememberme\" class=\"filled-in chk-col-light-blue\">\n");
      out.write("                                <label for=\"rememberme\">Recuerdame</label>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-4\">\n");
      out.write("                                <button class=\"btn btn-block bg-light-blue waves-effect\" type=\"submit\" name=\"entrarUsuario\">Entrar</button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row m-t-15 m-b--20\">\n");
      out.write("                            <div class=\"col-xs-5\">\n");
      out.write("                                <a href=\"sign-up.html\">Activar cuenta</a>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"col-xs-7 align-right\">\n");
      out.write("                                <a href=\"recuperar-contraseña.jsp\">¿Olvido su Contraseña?</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Jquery Core Js -->\n");
      out.write("        <script src=\"../../../plugins/jquery/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap Core Js -->\n");
      out.write("        <script src=\"../../../plugins/bootstrap/js/bootstrap.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Waves Effect Plugin Js -->\n");
      out.write("        <script src=\"../../../plugins/node-waves/waves.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Validation Plugin Js -->\n");
      out.write("        <script src=\"../../../plugins/jquery-validation/jquery.validate.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Custom Js -->\n");
      out.write("        <script src=\"../../../js/admin.js\"></script>\n");
      out.write("        <script src=\"../../../js/pages/login/sign-in.js\"></script>\n");
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
