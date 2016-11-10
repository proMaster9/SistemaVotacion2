package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import controlador.SerActivacion;

public final class activacionPrincipal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\",function(){\n");
      out.write("                $(\"#btnVerificar\").on(\"click\",function(){\n");
      out.write("                    var dui = $(\"#txtDui\").val();\n");
      out.write("                    var pass = $(\"#txtPass\").val();\n");
      out.write("                    $(\"#txtPass\").val(\"\");\n");
      out.write("                    $.post('../SerActivacion',{\n");
      out.write("                        txtPrincipal : 'true',\n");
      out.write("                        txtDui : dui,\n");
      out.write("                        txtPass : pass\n");
      out.write("                    },function(data){\n");
      out.write("                        $(\"#divActivacion\").html(data);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            function activar() {\n");
      out.write("                var dui = $(\"#txtDui\").val();\n");
      out.write("                $.post('../SerActivacion',{\n");
      out.write("                    txtActivacionPrincipal : 'true',\n");
      out.write("                    txtDui : dui\n");
      out.write("                },function(data){\n");
      out.write("                    $(\"#divActivacion\").html(data);\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("       \n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Activacion de cuenta</h1>\n");
      out.write("        <form>\n");
      out.write("            <input type=\"hidden\" name=\"txtDui\" id=\"txtDui\">\n");
      out.write("            dui: <input type=\"text\" name=\"txtDui\" id=\"txtDui\"><br>\n");
      out.write("            <br>\n");
      out.write("            contraseña: <input type=\"password\" name=\"txtPass\" id=\"txtPass\">\n");
      out.write("            <input type=\"button\" name=\"btnVerificar\" id=\"btnVerificar\" value=\"Verificar\">\n");
      out.write("            <div id=\"divActivacion\">\n");
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
