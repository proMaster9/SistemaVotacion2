package org.apache.jsp.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_002dusuario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/login/../section-page/head.jspf");
    _jspx_dependants.add("/login/../section-page/footer.jspf");
    _jspx_dependants.add("/login/../section-page/script.jspf");
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n");
      out.write("    <!-- bootstrap & fontawesome -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/bootstrap.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/font-awesome.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/ace-fonts.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/css/ace.css\" class=\"ace-main-stylesheet\" id=\"main-ace-style\" />\r\n");
      out.write("    <!--[if lte IE 9]>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"../assets/css/ace-part2.css\" class=\"ace-main-stylesheet\" />\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    <!--[if lte IE 9]>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../assets/css/ace-ie.css\" />\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("    <script src=\"../assets/js/ace-extra.js\"></script>\r\n");
      out.write("    <!--[if lte IE 8]>\r\n");
      out.write("\t<script src=\"../assets/js/html5shiv.js\"></script>\r\n");
      out.write("\t<script src=\"../assets/js/respond.js\"></script>\r\n");
      out.write("    <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body class=\"no-skin\">\r\n");
      out.write("        <div class=\"space-32\"div>\r\n");
      out.write("        <div class=\"space-32\"></div>\r\n");
      out.write("        <div class=\"main-container\">\r\n");
      out.write("            <div class=\"main-content\">\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("                        <div class=\"login-container\">\r\n");
      out.write("                            <div class=\"center\">\r\n");
      out.write("                                <div id=\"login-box\" class=\"login-box visible widget-box\">\r\n");
      out.write("                                    <div class=\"widget-body\">\r\n");
      out.write("                                        <div class=\"widget-main\">\r\n");
      out.write("                                            <h4 class=\"header blue lighter bigger\">\r\n");
      out.write("                                                <img src=\"../assets/images/logo_tse.JPG\"> \r\n");
      out.write("                                            </h4>\r\n");
      out.write("                                            <div class=\"space-6\"></div>\r\n");
      out.write("                                            <form action=\"../iniciarsesion.do\" method=\"post\">\r\n");
      out.write("                                                <div class=\"row\">\r\n");
      out.write("                                                    <label class=\"col-sm-3 control-label no-padding-right\">DUI:</label>\r\n");
      out.write("                                                    <div class=\"col-md-12\">\r\n");
      out.write("                                                        <span class=\"input-icon\">\r\n");
      out.write("                                                            <input type=\"text\" name=\"txtUser\" id=\"form-field-icon-1\">\r\n");
      out.write("                                                            <i class=\"ace-icon fa fa-user blue\"></i>\r\n");
      out.write("                                                        </span>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"space-4\"></div>\r\n");
      out.write("                                                <div class=\"row\">\r\n");
      out.write("                                                    <label class=\"col-sm-3 control-label no-padding-right\">Contraseña:</label>\r\n");
      out.write("                                                    <div class=\"col-sm-9\">\r\n");
      out.write("                                                        <span class=\"input-icon\">\r\n");
      out.write("                                                            <input type=\"text\" name=\"txtPass\"id=\"form-field-icon-1\">\r\n");
      out.write("                                                            <i class=\"ace-icon fa fa-key blue\"></i>\r\n");
      out.write("                                                        </span>\r\n");
      out.write("                                                    </div>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"space\"></div>\r\n");
      out.write("                                                <div class=\"clearfix\">\r\n");
      out.write("                                                    <button class=\"btn btn-info\" type=\"submit\" name=\"btnIngresar\">\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-check bigger-110\"></i>\r\n");
      out.write("                                                        Iniciar Sesión\r\n");
      out.write("                                                    </button>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                                <div class=\"space-4\"></div>\r\n");
      out.write("                                                <div class=\"hr hr32 hr-dotted\"></div>\r\n");
      out.write("                                                <div class=\"row orange\">\r\n");
      out.write("                                                    <label class=\"col-sm-6 control-label pull-right\">\r\n");
      out.write("                                                        Recuperar contraseña\r\n");
      out.write("                                                        <i class=\"ace-icon fa fa-arrow-right icon-on-right bigger-110\"></i>\r\n");
      out.write("                                                    </label>     \r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </form>\r\n");
      out.write("                                        </div><!-- /.widget-main -->  \r\n");
      out.write("                                    </div><!-- /.widget-body -->\r\n");
      out.write("                                </div><!-- /.login-box -->   \r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div><!-- /.main-content -->\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"footer-inner\">\r\n");
      out.write("    <!-- #section:basics/footer -->\r\n");
      out.write("    <div class=\"footer-content\">\r\n");
      out.write("        <span class=\"bigger-120\">\r\n");
      out.write("            <span class=\"blue bolder\">TSE</span>\r\n");
      out.write("            Tribula Supremo Electoral &copy; 2018-2021\r\n");
      out.write("        </span>\r\n");
      out.write("        &nbsp; &nbsp;\r\n");
      out.write("        <span class=\"action-buttons\">\r\n");
      out.write("            <a href=\"#\">\r\n");
      out.write("                <i class=\"ace-icon fa fa-twitter-square light-blue bigger-150\"></i>\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("            <a href=\"#\">\r\n");
      out.write("                <i class=\"ace-icon fa fa-facebook-square text-primary bigger-150\"></i>\r\n");
      out.write("            </a>\r\n");
      out.write("\r\n");
      out.write("            <a href=\"#\">\r\n");
      out.write("                <i class=\"ace-icon fa fa-rss-square orange bigger-150\"></i>\r\n");
      out.write("            </a>\r\n");
      out.write("        </span>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<a href=\"#\" id=\"btn-scroll-up\" class=\"btn-scroll-up btn btn-sm btn-inverse\">\r\n");
      out.write("    <i class=\"ace-icon fa fa-angle-double-up icon-only bigger-110\"></i>\r\n");
      out.write("</a>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div><!-- /.main-container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- basic scripts -->\r\n");
      out.write("<!--[if !IE]> -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    window.jQuery || document.write(\"<script src='../assets/js/jquery.js'>\" + \"<\" + \"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- <![endif]-->\r\n");
      out.write("\r\n");
      out.write("<!--[if IE]>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("window.jQuery || document.write(\"<script src='../assets/js/jquery1x.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    if ('ontouchstart' in document.documentElement)\r\n");
      out.write("        document.write(\"<script src='../assets/js/jquery.mobile.custom.js'>\" + \"<\" + \"/script>\");\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"../assets/js/bootstrap.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/jquery-ui.custom.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/jquery.ui.touch-punch.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/elements.scroller.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.ajax-content.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.touch-drag.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.sidebar.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.sidebar-scroll-1.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.submenu-hover.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/jquery.maskedinput.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/jquery.autosize.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/jquery.inputlimiter.1.3.1.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.ajax-content.js\"></script>\r\n");
      out.write("<script src=\"../assets/js/ace.widget-box.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\"> ace.vars['base'] = '..';</script>");
      out.write("\r\n");
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
