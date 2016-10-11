package org.apache.jsp.pages.notificacion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_005ferror_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("    <title>Aviso | TSE</title>\r\n");
      out.write("        <!-- Favicon-->\r\n");
      out.write("        <link rel=\"icon\" href=\"\" type=\"image/x-icon\">\r\n");
      out.write("        \r\n");
      out.write("        <!-- Google Fonts -->\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link href=\"../../plugins/iconfont/material-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap Core Css -->\r\n");
      out.write("        <link href=\"../../plugins/bootstrap/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Waves Effect Css -->\r\n");
      out.write("        <link href=\"../../plugins/node-waves/waves.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- Animation Css -->\r\n");
      out.write("        <link href=\"../../plugins/animate-css/animate.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom Css -->\r\n");
      out.write("        <link href=\"../../css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"four-zero-four\">\r\n");
      out.write("    <div class=\"four-zero-four-container\">\r\n");
      out.write("        <div class=\"error-code\">Servidor</div>\r\n");
      out.write("        <div class=\"error-message\">Estamos solucionando este problema</div>\r\n");
      out.write("        <div class=\"button-place\">\r\n");
      out.write("            <a href=\"../../index.jsp\" class=\"btn btn-default btn-lg waves-effect\">Regresar</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <!-- Jquery Core Js -->\r\n");
      out.write("    <script src=\"../../plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap Core Js -->\r\n");
      out.write("    <script src=\"../../plugins/bootstrap/js/bootstrap.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- Waves Effect Plugin Js -->\r\n");
      out.write("    <script src=\"../../plugins/node-waves/waves.js\"></script>\r\n");
      out.write("</body>\r\n");
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
