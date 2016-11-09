package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Partido;
import modelo.PartidoDTO;

public final class PruebaPartido_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/funciones.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("                cargarImagen(\"btnImagen\", \"divImg\");\n");
      out.write("\n");
      out.write("                /*cuando se presiona el boton de modificar, se comprueba primero\n");
      out.write("                 que se haya selecciona un registro, y que sus datos esten cargados*/\n");
      out.write("                $(\"#btnModificar\").on(\"click\", function () {\n");
      out.write("                    var modificar = $(\"#txtId\").val();\n");
      out.write("                    if (modificar != 0) {\n");
      out.write("                        $(\"#frmPartido\").submit();\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"No puedes modificar\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                mostrarCiudadano('txtDui', 'divCiudadano', '../SerCiudadano', 0);\n");
      out.write("                enviarForm('frmPartido', 'btnAgregar');\n");
      out.write("            });\n");
      out.write("            //Cargar datos en el formulario\n");
      out.write("            function modificar(id, acronimo, nombre, dui, imagen) {\n");
      out.write("                $(\"input[name=txtId]\").val(id);\n");
      out.write("                $(\"input[name=txtAcronimo]\").val(acronimo);\n");
      out.write("                $(\"input[name=txtNombre]\").val(nombre);\n");
      out.write("                $(\"input[name=txtDui]\").val(dui);\n");
      out.write("                $(\"#divImg\").html(imagen);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <h1>Partidos politicos</h1>\n");
      out.write("        <form method=\"post\" name=\"frmPartido\" id=\"frmPartido\" action=\"../SerPartido\" enctype=\"multipart/form-data\">\n");
      out.write("            <input type=\"hidden\" name=\"txtId\" id=\"txtId\" value=\"0\">\n");
      out.write("            Acronimo: <input type=\"text\" name=\"txtAcronimo\" id=\"txtAcronimo\">\n");
      out.write("            <br>\n");
      out.write("            Nombre: <input type=\"text\" name=\"txtNombre\" id=\"txtNombre\">\n");
      out.write("            <br>\n");
      out.write("            Bandera: <input type=\"file\" name=\"btnBandera\" id=\"btnImagen\">\n");
      out.write("            <br>\n");
      out.write("            <div id=\"divImg\"></div>\n");
      out.write("            <!--Busqueda de ciudadano-->\n");
      out.write("            <div>\n");
      out.write("                Representante: <input type=\"text\" name=\"txtDui\" id=\"txtDui\" autocomplete=\"off\">\n");
      out.write("                <!--Impresion de resultados de busqueda-->\n");
      out.write("                <div id=\"divCiudadano\">\n");
      out.write("                    <input type=\"hidden\" name=\"txtResultado\" id=\"txtResultado\">\n");
      out.write("                </div>\n");
      out.write("                <!--Fin de impresion de resultados-->\n");
      out.write("            </div>\n");
      out.write("            <!--Fin de busqueda-->\n");
      out.write("            <input type=\"button\" value=\"Agregar\" id=\"btnAgregar\">\n");
      out.write("            <input type=\"button\" value=\"Modificar\" id=\"btnModificar\">\n");
      out.write("        </form>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Acronimo</th>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Representante</th>\n");
      out.write("                <th>Bandera</th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("            <tbody>\n");
      out.write("            <div id=\"divPartido\">\n");
      out.write("                ");
 for (Partido p : PartidoDTO.mostrarPartidos()) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getAcronimo());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getNombre());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getNumDui());
      out.write("</td>\n");
      out.write("                    <td><img src=\"../images/files/partidos/");
      out.print( p.getImagen());
      out.write("\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"javascript:modificar('");
      out.print( p.getIdPartido());
      out.write("','");
      out.print( p.getAcronimo());
      out.write("','");
      out.print( p.getNombre());
      out.write("','");
      out.print( p.getNumDui());
      out.write("','<img src=../images/files/partidos/");
      out.print( p.getImagen());
      out.write(" >')\">Modificar</a>\n");
      out.write("                        <a href=\"../SerPartido?idPartido=");
      out.print( p.getIdPartido());
      out.write("\">Eliminar</a>\n");
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
