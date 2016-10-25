package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cnr_005fimportacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\",function(){\n");
      out.write("                $(\"#password1\").on(\"keyup\",function(){\n");
      out.write("                    if($(\"#magistrado1\").val() != \"\") {\n");
      out.write("                        var dui = $(\"#magistrado1\").val();\n");
      out.write("                        var password = $(\"#password1\").val();\n");
      out.write("                        $.post('../SerMagistrado',{\n");
      out.write("                            dui : dui,\n");
      out.write("                            password : password\n");
      out.write("                        }, function(data){\n");
      out.write("                            $(\"#divMagistrado1\").html(data);\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Importacion de registros CNR</h1>\n");
      out.write("        <h3>Credenciales de magistrados</h3>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Identificacion</th>\n");
      out.write("                <th>Contraseña</th>\n");
      out.write("                <th>Estado</th>\n");
      out.write("            </tr>\n");
      out.write("            <!--Magistrado 1-->\n");
      out.write("            <tr>\n");
      out.write("                <td><input type=\"text\" id=\"magistrado1\"></td>\n");
      out.write("                <td><input type=\"text\" id=\"password1\"></td>\n");
      out.write("                <td><div id=\"divMagistrado1\"></div></td>\n");
      out.write("            </tr>\n");
      out.write("            <!--Magistrado 2-->\n");
      out.write("            <tr>\n");
      out.write("                <td><input type=\"text\" id=\"magistrado2\"></td>\n");
      out.write("                <td><input type=\"text\" id=\"password2\"></td>\n");
      out.write("                <td><div id=\"divMagistrado2\"></div></td>\n");
      out.write("            </tr>\n");
      out.write("            <!--Magistrado 3-->\n");
      out.write("            <tr>\n");
      out.write("                <td><input type=\"text\" id=\"magistrado3\"></td>\n");
      out.write("                <td><input type=\"text\" id=\"password3\"></td>\n");
      out.write("                <td><div id=\"divMagistrado3\"></div></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <input type=\"file\" id=\"btnSubir\"><br>\n");
      out.write("        <input type=\"button\" id=\"btnImportar\" value=\"Importar datos\">\n");
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
