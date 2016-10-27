package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Departamento;
import modelo.DepartamentoDTO;

public final class PruebaCentro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\",function(){\n");
      out.write("                $(\"#slDepartamento\").on(\"change\",function(){\n");
      out.write("                    alert(\"Departamento: \" + $(this).val());\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Centros de votacion</h1>\n");
      out.write("        <form>\n");
      out.write("            Nombre: <input type=\"text\" name=\"txtNombre\" id=\"txtNombre\"><br>\n");
      out.write("            JRV's Disponibles: <input type=\"number\" name=\"txtJrv\" id=\"txtJrv\"><br>\n");
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
      out.write("            Departamento: \n");
      out.write("            <select name=\"slDepartamento\" id=\"slDepartamento\">\n");
      out.write("                <option>--Seleccione---</option>\n");
      out.write("                ");
 for (Departamento dep : DepartamentoDTO.mostrarDepartamentos()) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print( dep.getIdDepartamento());
      out.write('"');
      out.write('>');
      out.print( dep.getDepartamento());
      out.write("</option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            Municipio: \n");
      out.write("            <select name=\"slMunicipio\" id=\"lsMunicipio\">\n");
      out.write("                <div id=\"divMunicipio\">\n");
      out.write("                    <!--Aca se cargan los municipios segun el dpto seleccionado-->\n");
      out.write("                </div>\n");
      out.write("            </select>\n");
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
