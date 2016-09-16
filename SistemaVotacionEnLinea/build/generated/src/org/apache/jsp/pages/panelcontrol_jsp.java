package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class panelcontrol_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession sesion = request.getSession();
    if (sesion.getAttribute("id_tipo") != null && sesion.getAttribute("tipo") != null && sesion.getAttribute("user") != null) {
        String user = (String) sesion.getAttribute("user");
        String tipo = (String) sesion.getAttribute("tipo");
        int id_tipo = (Integer) sesion.getAttribute("id_tipo");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Usuarios TSE</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/head.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene todos los links --> \n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#print1\").on(\"click\", function () {\n");
      out.write("                    $(\"#cargarArchivo\").load('InicioSistema.jspf');\n");
      out.write("                });\n");
      out.write("                 $(\"#print2\").on(\"click\", function () {\n");
      out.write("                    $(\"#cargarArchivo\").load('ImportarSql.jspf');\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"no-skin\">\n");
      out.write("        <div id=\"navbar\" class=\"navbar navbar-default\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/header.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene el menu -->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"main-container\" id=\"main-container\">\n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                try {\n");
      out.write("                    ace.settings.check('main-container', 'fixed');\n");
      out.write("                } catch (e) {\n");
      out.write("                }\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("            <div id=\"sidebar\" class=\"sidebar responsive\">\n");
      out.write("                ");

                    if (id_tipo == 1) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/sidebar-admin.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene el sidebar menu -->\n");
      out.write("                ");

                } else if (id_tipo == 2) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/sidebar-magistrado.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene el sidebar menu -->\n");
      out.write("                ");
 
                } else if (id_tipo == 3) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "./secciones/sidebar-cnr.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene el sidebar menu -->\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"main-content\">\n");
      out.write("                <div class=\"main-content-inner\">\n");
      out.write("\n");
      out.write("                    <div class=\"breadcrumbs\" id=\"breadcrumbs\">\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/breadcrumb.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene la barra de navegacion -->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"page-content\">\n");
      out.write("                        <div id=\"cargarArchivo\"></div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/footer.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene el footer -->\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/secciones/script.jsp", out, false);
      out.write("<!-- se incluye el archivo que contiene los jQuery-->\n");
      out.write("        ");
    } else {
                out.print("<script>location.replace('../login/tse-usuario.jsp?cerrar=true');</script>");
            }
        
      out.write("\n");
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
