package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.VotoBandera;
import controlador.SerPapeleta;

public final class Papeleta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            //remplaza este por el id de sesion
            int idUsuario = 9;
            if(SerPapeleta.estadoVotante(idUsuario) == 1) {
                response.sendRedirect("login/votante.jsp");
            }
        
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/head.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("                var partidos = $(\"img[data-tipo=partido]\").length;\n");
      out.write("                var candidatos = $(\"img[data-tipo=candidato]\").length;\n");
      out.write("                var votantesxcentro = candidatos / partidos;\n");
      out.write("                $(\"#lblPartido\").html(partidos);\n");
      out.write("                $(\"#lblCandidato\").html(candidatos);\n");
      out.write("                $('img[data-seleccion=\"deseleccionado\"]').each(function () {\n");
      out.write("                    $(this).addClass(\"deseleccionada\");\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\"img[data-tipo='partido']\").hover(function () {\n");
      out.write("                    if ($(this).attr(\"data-estado\") == \"habilitado\") {\n");
      out.write("                        $(this).toggleClass(\"seleccionada\");\n");
      out.write("                        var partido = $(this).attr(\"data-id-partido\");\n");
      out.write("                        $(\"img[data-partido='\" + partido + \"']\").each(function () {\n");
      out.write("                            $(this).toggleClass(\"seleccionada\");\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\"img[data-tipo='partido']\").on(\"click\", function () {\n");
      out.write("                    if ($(this).attr(\"data-estado\") == \"habilitado\") {\n");
      out.write("                        $(this).addClass(\"seleccionada\");\n");
      out.write("                        //$(\"img[data-tipo='candidato' data-partido='\"+$(this).attr(\"data-id-partido\")+\"']\").removeClass(\"seleccionada\");\n");
      out.write("                        var partido = $(this).attr(\"data-id-partido\");\n");
      out.write("                        $(\"img[data-partido!='\" + partido + \"']\").each(function () {\n");
      out.write("                            $(this).removeClass(\"seleccionada\");\n");
      out.write("                        });\n");
      out.write("                        $(this).addClass(\"seleccionada\");\n");
      out.write("\n");
      out.write("                        $(\"img[data-id-partido != '\" + partido + \"']\").each(function () {\n");
      out.write("                            $(this).toggleClass(\"deshabilitada\");\n");
      out.write("                            var estado = $(this).attr(\"data-estado\");\n");
      out.write("                            if (estado == \"habilitado\") {\n");
      out.write("                                $(this).attr(\"data-estado\", \"deshabilidato\");\n");
      out.write("                            }\n");
      out.write("                            if (estado == \"deshabilidato\") {\n");
      out.write("                                $(this).attr(\"data-estado\", \"habilitado\");\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("                        $(\"img[data-partido = '\" + partido + \"']\").each(function () {\n");
      out.write("                            $(this).toggleClass(\"deshabilitada\");\n");
      out.write("                            $(this).toggleClass(\"deseleccionada\");\n");
      out.write("                            $(this).toggleClass(\"seleccionada\");\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                    $(\"#lblNumCandidatos\").html($(\"img.seleccionada[data-tipo!='partido']\").length);\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\"img[data-tipo='candidato']\").hover(function () {\n");
      out.write("                    if ($(this).attr(\"data-estado\") == \"habilitado\") {\n");
      out.write("                        $(this).toggleClass(\"seleccionada\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\"img[data-tipo='candidato']\").on(\"click\", function () {\n");
      out.write("                    if ($(\"img.seleccionada\").length <= votantesxcentro) {\n");
      out.write("                        if ($(this).attr(\"data-estado\") == \"habilitado\") {\n");
      out.write("                            $(this).toggleClass(\"seleccionada\");\n");
      out.write("                            $(\"#lblNumCandidatos\").html($(\"img.seleccionada[data-tipo!='partido']\").length + 1);\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"Solo puedes seleccionar \" + votantesxcentro + \" candidatos\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $(\"#btnVotar\").on(\"click\", function () {\n");
      out.write("                    if ($(\"img.seleccionada\").length <= votantesxcentro) {\n");
      out.write("                        if ($(\"img.seleccionada\").length > 0) {\n");
      out.write("                            if ($(\"img.seleccionada\").length <= votantesxcentro) {\n");
      out.write("                                var bandera = false;\n");
      out.write("                                var partido = 0;\n");
      out.write("                                var idPartido = $(\"img.seleccionada\").attr(\"data-partido\");\n");
      out.write("                                var candidatos = \"\";\n");
      out.write("                                $(\"img.seleccionada\").each(function () {\n");
      out.write("                                    candidatos += $(this).attr(\"data-id-candidato\") + \" \";\n");
      out.write("                                });\n");
      out.write("                                $.post('../SerPapeleta', {\n");
      out.write("                                    voto: 'true',\n");
      out.write("                                    txtIdUsuario: ");
      out.print( idUsuario);
      out.write(",\n");
      out.write("                                    txtCandidatos: candidatos\n");
      out.write("                                }, function (data) {\n");
      out.write("                                    if (data == \"1\") {\n");
      out.write("                                        alert(\"Voto realizado correctamente\");\n");
      out.write("                                    }\n");
      out.write("                                    else {\n");
      out.write("                                        alert(\"Hubo un error\");\n");
      out.write("                                    }\n");
      out.write("                                });\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            alert(\"Selecciona por lo menos un candidato\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"Solo puedes seleccionar \" + votantesxcentro + \" Candidatos\");\n");
      out.write("                    }\n");
      out.write("\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                //abstencion de voto\n");
      out.write("                $(\"#btnAbstener\").on(\"click\", function () {\n");
      out.write("                    $.post('../SerPapeleta', {\n");
      out.write("                        votoAbstenido: 'true',\n");
      out.write("                        txtIdUsuario: ");
      out.print( idUsuario);
      out.write("\n");
      out.write("                    }, function (data) {\n");
      out.write("                        if (data == \"1\") {\n");
      out.write("                            alert(\"Voto Abstenido correctamente\");\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            alert(\"Hubo un error\");\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            .partido {\n");
      out.write("                display: inline;\n");
      out.write("                float: left;\n");
      out.write("            }\n");
      out.write("            img {\n");
      out.write("                height: 50px;\n");
      out.write("            }\n");
      out.write("            .deseleccionada {\n");
      out.write("                opacity: 0.6;\n");
      out.write("            }\n");
      out.write("            .seleccionada {\n");
      out.write("                opacity: 1.0;\n");
      out.write("            }\n");
      out.write("            .deshabilitada {\n");
      out.write("                filter:grayscale(100%);\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            out.print("id Departamento: " + SerPapeleta.departamentoUsuario(idUsuario) + "<br>");
            out.print("Departamento: " + SerPapeleta.nombreDepartamento(idUsuario));
        
      out.write("\n");
      out.write("        <div>\n");
      out.write("            Partidos: <label id=\"lblPartido\"></label><br>\n");
      out.write("            Candidatos: <label id=\"lblCandidato\"></label>\n");
      out.write("            Candidatos Seleccionados: <label id=\"lblNumCandidatos\">0</label>\n");
      out.write("        </div>\n");
      out.write("        <h1>Papeleta</h1>\n");
      out.write("        <input type=\"button\" id=\"btnVotar\" value=\"Emitir Voto\">\n");
      out.write("        <input type=\"button\" id=\"btnAbstener\" value=\"Abstener Voto\">\n");
      out.write("        <div id=\"divBandera\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      out.print( SerPapeleta.mostrarPapeleta(SerPapeleta.departamentoUsuario(idUsuario)));
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
