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
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("\n");
      out.write("                function buscarMagistrado(dui, password, div, servlet) {\n");
      out.write("                    $(\"#\" + password + \", #\" + dui).on(\"keyup\", function () {\n");
      out.write("                        var coincidencia = 0;\n");
      out.write("                        //se recorren todos los campos donde se ingresan los duis\n");
      out.write("                        $(\"input[data-tipo=dui]\").each(function (i) {\n");
      out.write("                            //evaluamos si hay campos repetidos\n");
      out.write("                            if ($(this).val() == $(\"#\" + dui).val()) {\n");
      out.write("                                coincidencia++;\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                        //si el valor de la caja de texo se repite solo con ella misma\n");
      out.write("                        //significa que el campo no se ha duplicado\n");
      out.write("                        if (coincidencia == 1) {\n");
      out.write("                            //se verifica que el campo dui no este vacio\n");
      out.write("                            if ($(\"#\" + dui).val() != \"\") {\n");
      out.write("                                $.post(servlet, {\n");
      out.write("                                    dui: $(\"#\" + dui).val(),\n");
      out.write("                                    password: $(\"#\" + password).val()\n");
      out.write("                                }, function (data) {\n");
      out.write("                                    $(\"#\" + div).html(data);\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            $(\"#\" + div).html('<input type=\"hidden\" value=\"0\" data-tipo=\"resultado\">');\n");
      out.write("                            if ($(\"#\" + dui).val() != \"\") {\n");
      out.write("                                $(\"#\" + div).append(\"Dui repetido\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                $(\"#btnImportar\").on(\"click\", function () {\n");
      out.write("                    var coincidencia = 0;\n");
      out.write("                    //se recorren los campos ocultos, para verificar que todos tengan un resultado correcto\n");
      out.write("                    $(\"input[data-tipo=resultado]\").each(function (i) {\n");
      out.write("                        if ($(this).val() == 0) {\n");
      out.write("                            coincidencia++;\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    if (coincidencia == 0) {\n");
      out.write("                        $(\"#frmCnr\").submit();\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"No puedes enviar\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                buscarMagistrado('dui1', 'password1', 'divMagistrado1', '../SerMagistrado');\n");
      out.write("                buscarMagistrado('dui2', 'password2', 'divMagistrado2', '../SerMagistrado');\n");
      out.write("                buscarMagistrado('dui3', 'password3', 'divMagistrado3', '../SerMagistrado');\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Importacion de registros CNR</h1>\n");
      out.write("        <h3>Credenciales de magistrados</h3>\n");
      out.write("        <form id=\"frmCnr\" action=\"../SerCiudadano\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Identificacion</th>\n");
      out.write("                    <th>Contraseña</th>\n");
      out.write("                    <th>Estado</th>\n");
      out.write("                </tr>\n");
      out.write("                <!--Magistrado 1-->\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"text\" id=\"dui1\" data-tipo=\"dui\" name=\"dui1\"></td>\n");
      out.write("                    <td><input type=\"password\" id=\"password1\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <div id=\"divMagistrado1\">\n");
      out.write("                            <input type=\"hidden\" value=\"0\" data-tipo=\"resultado\">\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <!--Magistrado 2-->\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"text\" id=\"dui2\" data-tipo=\"dui\" name=\"dui2\"></td>\n");
      out.write("                    <td><input type=\"password\" id=\"password2\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <div id=\"divMagistrado2\">\n");
      out.write("                            <input type=\"hidden\" value=\"0\" data-tipo=\"resultado\">\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                <!--Magistrado 3-->\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"text\" id=\"dui3\" data-tipo=\"dui\" name=\"dui3\"></td>\n");
      out.write("                    <td><input type=\"password\" id=\"password3\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <div id=\"divMagistrado3\">\n");
      out.write("                            <input type=\"hidden\" value=\"0\" data-tipo=\"resultado\">\n");
      out.write("                        </div>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <input type=\"file\" name=\"btnArchivo\" id=\"btnSubir\"><br>\n");
      out.write("            <input type=\"button\" id=\"btnImportar\" value=\"Importar datos\">\n");
      out.write("        </form>\n");
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
