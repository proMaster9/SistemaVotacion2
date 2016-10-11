package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Ciudadano;
import java.util.*;

public final class tse_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession sesion = request.getSession();
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>)sesion.getAttribute("usuario");
    if(usuario==null){
        response.sendRedirect("../");//redireccionamiento a una pagina de error del sevidor
    }
    
    if (usuario.get(0).getNumDui()== null && usuario.get(0).getRol()==null) {
        System.out.println("prueba"+sesion.getAttribute("user"));
        response.sendRedirect("../");
    } else {


      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("        <title>Panel Usuario | TSE</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/head.jsp", out, false);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"theme-light-blue\">\r\n");
      out.write("\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/loader.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- Overlay For Sidebars -->\r\n");
      out.write("        <div class=\"overlay\"></div>\r\n");
      out.write("        <!-- #END# Overlay For Sidebars -->\r\n");
      out.write("        <!-- Top Bar -->\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/navbar.jsp", out, false);
      out.write("\r\n");
      out.write("        <!-- #Top Bar -->\r\n");
      out.write("\r\n");
      out.write("        <section>\r\n");
      out.write("            <!-- Left Sidebar -->\r\n");
      out.write("            <aside id=\"leftsidebar\" class=\"sidebar\">\r\n");
      out.write("                <!-- Menu -->\r\n");
      out.write("                ");

                    if(usuario.get(0).getTipoUsuario()==1){
                
      out.write("\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_admin.jsp", out, false);
      out.write("\r\n");
      out.write("                ");

                    }else if(usuario.get(0).getTipoUsuario()==2){
                
      out.write("\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_magis.jsp", out, false);
      out.write("\r\n");
      out.write("                ");

                    }else if(usuario.get(0).getTipoUsuario()==3){
                
      out.write("\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_cnr.jsp", out, false);
      out.write("\r\n");
      out.write("                ");

                    }
                
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
      out.write("            <div class=\"row clearfix\" >\r\n");
      out.write("                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\r\n");
      out.write("                    ");
      out.print(usuario.get(0).getNombre());
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </section>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/scripts.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");

    }


      out.write('\r');
      out.write('\n');
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
