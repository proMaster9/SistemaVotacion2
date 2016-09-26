package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_002dusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");

    if (request.getParameter("cerrar") != null) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("tipo");
        request.getSession().removeAttribute("id_tipo");
        session.invalidate();
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../pages/secciones/head.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene todos los links --> \r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"no-skin\">\r\n");
      out.write("        <div class=\"space-32\"></div>\r\n");
      out.write("        <div class=\"space-32\"></div>\r\n");
      out.write("        <div class=\"main-container\">\r\n");
      out.write("            <div class=\"main-content\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("                        <div class=\"login-container\">\r\n");
      out.write("                            <div id=\"login-box\" class=\"login-box visible widget-box\">\r\n");
      out.write("                                <div class=\"widget-body\">\r\n");
      out.write("                                    <div class=\"widget-main\">\r\n");
      out.write("                                        <center>\r\n");
      out.write("                                            <h4 class=\"header blue lighter bigger\">\r\n");
      out.write("                                                <img src=\"../assets/images/logo_tse.jpg\"> \r\n");
      out.write("                                            </h4>\r\n");
      out.write("                                        </center>\r\n");
      out.write("\r\n");
      out.write("                                        <div class=\"space-6\"></div>\r\n");
      out.write("                                        <form action=\"../iniciarsesion.do\" method=\"post\">\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <!--<label class=\"col-md-3 control-label no-padding-right\">DUI:</label>-->\r\n");
      out.write("                                                <div class=\"col-md-10 col-md-offset-1\">\r\n");
      out.write("                                                    <span class=\"input-icon\">\r\n");
      out.write("                                                        <input type=\"text\" name=\"txtUser\" placeholder=\"Ingrese número Dui\" id=\"form-field-icon-2\">\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-user blue\"></i>\r\n");
      out.write("                                                    </span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"space-4\"></div>\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("                                                <!--<label class=\"col-sm-3 control-label no-padding-right\">Contraseña:</label>-->\r\n");
      out.write("                                                <div class=\"col-md-10 col-md-offset-1\">\r\n");
      out.write("                                                    <span class=\"input-icon\">\r\n");
      out.write("                                                        <input type=\"password\" name=\"txtPass\" placeholder=\"Ingrese su contraseña\"  id=\"form-field-icon-2\">\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-key blue\"></i>\r\n");
      out.write("                                                    </span>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"space\"></div>\r\n");
      out.write("                                            <div class=\"clearfix\">\r\n");
      out.write("                                                <center>\r\n");
      out.write("                                                    <button class=\"btn btn-info\" type=\"submit\" name=\"btnIngresar\">\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-check bigger-110\"></i>\r\n");
      out.write("                                                        Iniciar Sesión\r\n");
      out.write("                                                    </button>\r\n");
      out.write("                                                </center>\r\n");
      out.write("\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                            <div class=\"space-4\"></div>\r\n");
      out.write("                                            <div class=\"hr hr32 hr-dotted\"></div>\r\n");
      out.write("                                            <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("                                                <label class=\"col-sm-6 control-label pull-right\">\r\n");
      out.write("                                                    <a href=\"\">\r\n");
      out.write("                                                        Recuperar contraseña\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-arrow-right icon-on-right bigger-110\"></i>\r\n");
      out.write("                                                    </a>\r\n");
      out.write("\r\n");
      out.write("                                                </label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </form>\r\n");
      out.write("                                    </div><!-- /.widget-main -->  \r\n");
      out.write("                                </div><!-- /.widget-body -->\r\n");
      out.write("                            </div><!-- /.login-box -->   \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"footer\">\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../pages/secciones/footer.jsp", out, false);
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><!-- /.main-container -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../pages/secciones/script.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
