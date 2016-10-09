package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_002dimportar_002dregistros_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"es\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/head.jsp", out, false);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"theme-light-blue\">\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/loader.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Overlay For Sidebars -->\r\n");
      out.write("        <div class=\"overlay\"></div>\r\n");
      out.write("        <!-- #END# Overlay For Sidebars -->\r\n");
      out.write("        <!-- Search Bar -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/search-bar.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- #END# Search Bar -->\r\n");
      out.write("        <!-- Top Bar -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/navbar.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- #Top Bar -->\r\n");
      out.write("\r\n");
      out.write("        <section>\r\n");
      out.write("            <!-- Left Sidebar -->\r\n");
      out.write("            <aside id=\"leftsidebar\" class=\"sidebar\">\r\n");
      out.write("                <!-- User Info -->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/user-info.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- #User Info -->\r\n");
      out.write("                <!-- Menu -->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu-admin.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- #Menu -->\r\n");
      out.write("                <!-- Footer -->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/footer.jsp", out, false);
      out.write("\r\n");
      out.write("                <!-- #Footer -->\r\n");
      out.write("            </aside>\r\n");
      out.write("            <!-- #END# Left Sidebar -->\r\n");
      out.write("            <!-- Right Sidebar -->\r\n");
      out.write("            <aside id=\"rightsidebar\" class=\"right-sidebar\">\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/opciones-ico.jsp", out, false);
      out.write("\r\n");
      out.write("            </aside>\r\n");
      out.write("            <!-- #END# Right Sidebar -->\r\n");
      out.write("        </section>\r\n");
      out.write("\r\n");
      out.write("        <section class=\"content\">\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"block-header\">\r\n");
      out.write("                    <h2></h2>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"row clearfix\">\r\n");
      out.write("                <!-- Configuracion Inicial -->\r\n");
      out.write("                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"header bg-light-blue\">\r\n");
      out.write("                            <h2><i class=\"material-icons icons-align\">settings</i>Importar Registros CNR\r\n");
      out.write("                                <i><small>Para poder importar los archivos deben cumplir los requerimientos de validación</small></i>\r\n");
      out.write("                            </h2>\r\n");
      out.write("                            <ul class=\"header-dropdown m-r-0\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"javascript:void(0);\">\r\n");
      out.write("                                        <i class=\"material-icons\">info_outline</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"javascript:void(0);\">\r\n");
      out.write("                                        <i class=\"material-icons\">help_outline</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"body\">\r\n");
      out.write("                            <div class=\"row clearfix align-center\">\r\n");
      out.write("                                      <div class=\"col-md-4\">\r\n");
      out.write("                                            <label>Dui:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            <label>Contraseña:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-md-4\">\r\n");
      out.write("                                            <label>Estado:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <form action=\"\" method=\"POST\">\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("       \r\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                        \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                                \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                                \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" name=\"\" placeholder=\"Ingresar número dui\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                                \r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-primary waves-effect\">Seleccionar Archivo</button>\r\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-success waves-effect\">Importar Datos</button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- #END# Configuracion Inicial -->\r\n");
      out.write("        </div>\r\n");
      out.write("    </section>\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/scripts.jsp", out, false);
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
