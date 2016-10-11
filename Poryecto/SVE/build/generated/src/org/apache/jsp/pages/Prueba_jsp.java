package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Partido;
import modelo.PartidoDTO;
import java.util.ArrayList;
import modelo.SupervisorExt;
import modelo.SupervisorDTO;

public final class Prueba_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).on(\"ready\",function(){\r\n");
      out.write("                //esta funcion muestra al publicista que se agrego\r\n");
      out.write("                $(\"#btnPublicista\").on(\"click\",function(){\r\n");
      out.write("                    var dui = $(\"#txtDuiPublicista\").val();\r\n");
      out.write("                    $.post('../SerDirectorTSE',{\r\n");
      out.write("                        duiPublicista : dui\r\n");
      out.write("                    }, function(e){\r\n");
      out.write("                        $(\"#divPublicista\").html(e);\r\n");
      out.write("                    });\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("        <script>\r\n");
      out.write("            function modificarSupervisor(id,identificacion,nombre,apellido,sexo,pais,organizacion) {\r\n");
      out.write("                document.frmSupervisor.txtIdUsuario.value = id;\r\n");
      out.write("                document.frmSupervisor.txtIdentificacion.value = identificacion;\r\n");
      out.write("                document.frmSupervisor.txtNombre.value = nombre;\r\n");
      out.write("                document.frmSupervisor.txtApellido.value = apellido;\r\n");
      out.write("                document.frmSupervisor.txtPais.value = pais;\r\n");
      out.write("                document.frmSupervisor.txtOrganizacion.value = organizacion;\r\n");
      out.write("                if(sexo == \"m\") {\r\n");
      out.write("                    document.frmSupervisor.txtSexo[0].checked = true;\r\n");
      out.write("                } else {\r\n");
      out.write("                    document.frmSupervisor.txtSexo[1].checked = true;\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Supervisor externo</h1>\r\n");
      out.write("        <form method=\"post\" action=\"../SerDirectorTSE\" name=\"frmSupervisor\">\r\n");
      out.write("            <input type=\"hidden\" name=\"usuario\" value=\"supervisor\">\r\n");
      out.write("            <input type=\"hidden\" name=\"txtIdUsuario\">\r\n");
      out.write("            idenfiticacion: <input type=\"text\" name=\"txtIdentificacion\"><br>\r\n");
      out.write("            nombre: <input type=\"text\" name=\"txtNombre\"><br>\r\n");
      out.write("            apellido: <input type=\"text\" name=\"txtApellido\"><br>\r\n");
      out.write("            sexo: \r\n");
      out.write("            <input type=\"radio\" name=\"txtSexo\" value=\"m\"/>M\r\n");
      out.write("            <input type=\"radio\" name=\"txtSexo\" value=\"f\"/>F\r\n");
      out.write("            <br/>\r\n");
      out.write("            pais: <input type=\"text\" name=\"txtPais\"><br/>\r\n");
      out.write("            oganizacion: <input type=\"text\" name=\"txtOrganizacion\"><br/>\r\n");
      out.write("            <input type=\"submit\" value=\"Agregar\" name=\"btnAgregar\"/>\r\n");
      out.write("            <input type=\"submit\" value=\"Modificar\" name=\"btnModificar\"/>\r\n");
      out.write("        </form>\r\n");
      out.write("        <table>\r\n");
      out.write("            <td>Identificacion</td>\r\n");
      out.write("            <td>Nombre</td>\r\n");
      out.write("            <td>Sexo</td>\r\n");
      out.write("            <td>Pais</td>\r\n");
      out.write("            <td>Organizacion</td>\r\n");
      out.write("            <td></td>\r\n");
      out.write("        </th>\r\n");
      out.write("        <tbody>\r\n");
      out.write("            ");

                ArrayList<SupervisorExt> sup = SupervisorDTO.mostrarSupervisores();
                for (SupervisorExt lista : sup) {
            
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>");
      out.print( lista.getIdentificacion());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( lista.getApellido() );
      out.write(',');
      out.write(' ');
      out.print( lista.getNombre());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( lista.getSexo());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( lista.getPais());
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( lista.getOrganizacion());
      out.write("</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <a href=\"javascript:modificarSupervisor('");
      out.print( lista.getIdUsuario() );
      out.write("','");
      out.print( lista.getIdentificacion());
      out.write("','");
      out.print( lista.getNombre() );
      out.write("','");
      out.print( lista.getApellido());
      out.write("','");
      out.print( lista.getSexo());
      out.write("','");
      out.print( lista.getPais());
      out.write("','");
      out.print( lista.getOrganizacion());
      out.write("')\">Modificar<a>\r\n");
      out.write("                    <a href=\"../SerDirectorTSE?idSupervisor=");
      out.print( lista.getIdUsuario() );
      out.write("\">Eliminar</a>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
 }
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("        <h1>Publicista</h1>\r\n");
      out.write("        <form method=\"post\" action=\"../SerDirector\">\r\n");
      out.write("            <input type=\"text\" name=\"txtDuiPublicista\" id=\"txtDuiPublicista\">\r\n");
      out.write("            <input type=\"button\" value=\"Buscar\" id=\"btnPublicista\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <!--Acase muestra por ajax, con la funcion que esta arriba-->\r\n");
      out.write("        <div id=\"divPublicista\">\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <h1>Partidos</h1>\r\n");
      out.write("        <form action=\"../SerDirectorTSE\" enctype=\"MULTIPART/FORM-DATA\" method=\"post\">\r\n");
      out.write("            Acronimo: <input type=\"text\"name=\"txtAcronimo\"><br>\r\n");
      out.write("            Nombre: <input type=\"text\" name=\"txtNombre\"><br>\r\n");
      out.write("            Representante: <input type=\"text\" name=\"txtRepresentante\"><br>\r\n");
      out.write("            <input type=\"submit\" value=\"Agregar\" name=\"btnAgregarPartido\">\r\n");
      out.write("        </form>\r\n");
      out.write("        <table>\r\n");
      out.write("            <th>\r\n");
      out.write("            <td>Acronimo</td>\r\n");
      out.write("            <td>Nombre</td>\r\n");
      out.write("            <td>Representante</td>\r\n");
      out.write("            </th>\r\n");
      out.write("            <tbody>\r\n");
      out.write("            </tbody>\r\n");
      out.write("        </table>\r\n");
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
