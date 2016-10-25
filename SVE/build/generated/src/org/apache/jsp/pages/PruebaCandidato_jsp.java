package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Departamento;
import modelo.DepartamentoDTO;
import modelo.CiudadanoDTO;
import modelo.Candidato;
import modelo.CandidatoDTO;
import modelo.Partido;
import modelo.PartidoDTO;

public final class PruebaCandidato_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/funciones.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("                mostrarCiudadano('txtDui', 'divCiudadano', '../SerCiudadano', 0);\n");
      out.write("                enviarForm('frmCandidato', 'btnAgregar');\n");
      out.write("                cargarImagen(\"btnImagen\", \"divImg\");\n");
      out.write("                //evitar la actualizacion si no se selecciona un registro\n");
      out.write("                $(\"#btnModificar\").on(\"click\", function () {\n");
      out.write("                    var modificar = $(\"#txtId\").val();\n");
      out.write("                    if (modificar != 0) {\n");
      out.write("                        $(\"#frmCandidato\").submit();\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"No puedes modificar\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("            function modificar(idCandidato, idPartido, idDepartamento, dui, foto) {\n");
      out.write("                $(\"#txtId\").val(idCandidato);\n");
      out.write("                $(\"#slPartido\").val(idPartido);\n");
      out.write("                $(\"#slDepartamento\").val(idDepartamento);\n");
      out.write("                $(\"#txtDui\").val(dui);\n");
      out.write("                $(\"#divImg\").html(foto);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Candidatos</h1>\n");
      out.write("        <form method=\"post\" name=\"frmCandidato\" id=\"frmCandidato\" action=\"../SerCandidato\" enctype=\"multipart/form-data\">\n");
      out.write("            <input type=\"hidden\" name=\"txtId\" id=\"txtId\" value=\"0\">\n");
      out.write("            Partido: \n");
      out.write("            <select name=\"slPartido\" id=\"slPartido\">\n");
      out.write("                ");

                    for (Partido p : PartidoDTO.mostrarPartidos()) {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print( p.getIdPartido());
      out.write('"');
      out.write('>');
      out.print( p.getAcronimo());
      out.write("</option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </select><br>\n");
      out.write("            Departamento:\n");
      out.write("            <select name=\"slDepartamento\" id=\"slDepartamento\">\n");
      out.write("                ");
 for (Departamento d : DepartamentoDTO.mostrarDepartamentos()) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print( d.getIdDepartamento());
      out.write('"');
      out.write('>');
      out.print( d.getDepartamento());
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <!--Busqueda de ciudadano-->\n");
      out.write("            <div>\n");
      out.write("                Dui: <input type=\"text\" name=\"txtDui\" id=\"txtDui\" autocomplete=\"off\"><br>\n");
      out.write("\n");
      out.write("                <!--Impresion de resultados de busqueda-->\n");
      out.write("                <div id=\"divCiudadano\">\n");
      out.write("                    <input type=\"hidden\" name=\"txtResultado\" id=\"txtResultado\">\n");
      out.write("                </div>\n");
      out.write("                <!--Fin de impresion de resultados-->\n");
      out.write("                Foto: <input type=\"file\" name=\"btnImagen\" id=\"btnImagen\">\n");
      out.write("                <br>\n");
      out.write("                <div id=\"divImg\"></div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--Fin de busqueda-->\n");
      out.write("            <input type=\"button\" value=\"Agregar\" id=\"btnAgregar\">\n");
      out.write("            <input type=\"button\" value=\"Modificar\" id=\"btnModificar\">\n");
      out.write("        </form>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Departamento</th>\n");
      out.write("                <th>Candidato</th>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Partido</th>\n");
      out.write("                <th>Foto</th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("            <tbody>\n");
      out.write("            <div id=\"divCandidato\">\n");
      out.write("                ");
 for (Candidato c : CandidatoDTO.mostrarCandidatos()) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( DepartamentoDTO.mostrarDepartamento(c.getIdDepartamento()).getDepartamento());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( c.getNumDui());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");
      out.print( CiudadanoDTO.mostrarVotante(c.getNumDui()).getApellido());
      out.write(", \n");
      out.write("                        ");
      out.print( CiudadanoDTO.mostrarVotante(c.getNumDui()).getNombre());
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>");
      out.print( PartidoDTO.mostrarPartido(c.getIdPartido()).getAcronimo());
      out.write("</td>\n");
      out.write("                    <td><img src=\"../images/files/candidatos/");
      out.print( c.getFoto());
      out.write("\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"javascript:modificar('");
      out.print( c.getIdCandidato());
      out.write("','");
      out.print( c.getIdPartido());
      out.write("','");
      out.print( c.getIdDepartamento());
      out.write("','");
      out.print( c.getNumDui());
      out.write("','<img src=../images/files/candidatos/");
      out.print( c.getFoto());
      out.write(">')\">Modificar</a>\n");
      out.write("                        <a href=\"#\">Eliminar</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("</body>\n");
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
