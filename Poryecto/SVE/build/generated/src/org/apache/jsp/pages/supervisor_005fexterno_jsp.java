package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Ciudadano;
import java.util.*;

public final class supervisor_005fexterno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>) sesion.getAttribute("usuario");
    if (usuario != null) {
        if (usuario.get(0).getNumDui() != null && usuario.get(0).getNumDui() != null && sesion.getAttribute("key") != null) {

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <title>Supervisor Externo | TSE</title>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/head.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("                //esta funcion muestra al publicista que se agrego\n");
      out.write("                $(\"#btnPublicista\").on(\"click\", function () {\n");
      out.write("                    var dui = $(\"#txtDuiPublicista\").val();\n");
      out.write("                    $.post('../SerDirectorTSE', {\n");
      out.write("                        duiPublicista: dui\n");
      out.write("                    }, function (e) {\n");
      out.write("                        $(\"#divPublicista\").html(e);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <script>\n");
      out.write("            function modificarSupervisor(id, identificacion, nombre, apellido, sexo, pais, organizacion) {\n");
      out.write("                document.frmSupervisor.txtIdUsuario.value = id;\n");
      out.write("                document.frmSupervisor.txtIdentificacion.value = identificacion;\n");
      out.write("                document.frmSupervisor.txtNombre.value = nombre;\n");
      out.write("                document.frmSupervisor.txtApellido.value = apellido;\n");
      out.write("                document.frmSupervisor.txtPais.value = pais;\n");
      out.write("                document.frmSupervisor.txtOrganizacion.value = organizacion;\n");
      out.write("                if (sexo == \"m\") {\n");
      out.write("                    document.frmSupervisor.txtSexo[0].checked = true;\n");
      out.write("                } else {\n");
      out.write("                    document.frmSupervisor.txtSexo[1].checked = true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"theme-light-blue\">\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/loader.jsp", out, false);
      out.write("\n");
      out.write("        <!-- Overlay For Sidebars -->\n");
      out.write("        <div class=\"overlay\"></div>\n");
      out.write("        <!-- #END# Overlay For Sidebars -->\n");
      out.write("        <!-- Top Bar -->\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/navbar.jsp", out, false);
      out.write("\n");
      out.write("        <!-- #Top Bar -->\n");
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <!-- Left Sidebar -->\n");
      out.write("            <aside id=\"leftsidebar\" class=\"sidebar\">\n");
      out.write("                <!-- Menu -->\n");
      out.write("                ");

                    if (usuario.get(0).getTipoUsuario() == 1) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_admin.jsp", out, false);
      out.write("\n");
      out.write("                ");

                } else if (usuario.get(0).getTipoUsuario() == 2) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_magis.jsp", out, false);
      out.write("\n");
      out.write("                ");

                } else if (usuario.get(0).getTipoUsuario() == 3) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_cnr.jsp", out, false);
      out.write("\n");
      out.write("                ");

                } else if (usuario.get(0).getTipoUsuario() == 4) {
                
      out.write("\n");
      out.write("\n");
      out.write("                ");

                } else if (usuario.get(0).getTipoUsuario() == 5) {
                
      out.write("\n");
      out.write("\n");
      out.write("                ");

                } else if (usuario.get(0).getTipoUsuario() == 6) {
                
      out.write("\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu_director_tse.jsp", out, false);
      out.write("\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                <!-- #Menu -->\n");
      out.write("                <!-- Footer -->\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/footer.jsp", out, false);
      out.write("\n");
      out.write("                <!-- #Footer -->\n");
      out.write("            </aside>\n");
      out.write("            <!-- #END# Left Sidebar -->\n");
      out.write("            <!-- Right Sidebar -->\n");
      out.write("            <aside id=\"rightsidebar\" class=\"right-sidebar\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/opciones.jsp", out, false);
      out.write("\n");
      out.write("            </aside>\n");
      out.write("            <!-- #END# Right Sidebar -->\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <section class=\"content\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"block-header\">\n");
      out.write("                    <h2></h2>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row clearfix\" >\n");
      out.write("                <!-- Configuracion Inicial -->\n");
      out.write("                <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"header bg-light-blue\">\n");
      out.write("                            <h2>Agregar Supervisor Externo</h2>\n");
      out.write("                            <ul class=\"header-dropdown m-r-0\">\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"javascript:void(0);\">\n");
      out.write("                                        <i class=\"material-icons\">info_outline</i>\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <a href=\"javascript:void(0);\">\n");
      out.write("                                        <i class=\"material-icons\">help_outline</i>\n");
      out.write("                                    </a>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"body\">\n");
      out.write("                            <div class=\"row clearfix\">\n");
      out.write("                                <div class=\"col-xs-12 col-sm-4 col-md-4 col-lg-4\">\n");
      out.write("                                    <div class=\"row clearfix\">\n");
      out.write("                                        <div class=\"demo-google-material-icon\">\n");
      out.write("                                            <i class=\"material-icons col-green icons-align\">group_add</i>\n");
      out.write("                                            <span>Registrar Supervisor</span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <form method=\"post\" action=\"../SerDirectorTSE\" name=\"frmSupervisor\">\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <input type=\"hidden\" name=\"usuario\" value=\"supervisor\">\n");
      out.write("                                            <input type=\"hidden\" name=\"txtIdUsuario\">\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\n");
      out.write("                                                <label>Identificación:</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <div class=\"form-line\">\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"txtIdentificacion\" placeholder=\"Ingresar identificación:\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\n");
      out.write("                                                <label>Nombre:</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <div class=\"form-line\">\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"txtNombre\" placeholder=\"Ingresar nombre\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\n");
      out.write("                                                <label>Apellido:</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <div class=\"form-line\">\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"txtApellido\" placeholder=\"Ingresar apellido\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-md-12\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <input type=\"radio\" name=\"txtSexo\" value=\"m\"  id=\"radio_37\" class=\"with-gap radio-col-cyan\"/>\n");
      out.write("                                                    <label for=\"radio_37\">M</label>\n");
      out.write("                                                    <input type=\"radio\" name=\"txtSexo\" value=\"f\" id=\"radio_37\" class=\"with-gap radio-col-cyan\" />\n");
      out.write("                                                    <label for=\"radio_37\">F</label>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\n");
      out.write("                                                <label>País:</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <div class=\"form-line\">\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"txtPais\" placeholder=\"Ingresar país\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"row clearfix\">\n");
      out.write("                                            <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\n");
      out.write("                                                <label>Organización:</label>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <div class=\"form-line\">\n");
      out.write("                                                        <input type=\"text\" class=\"form-control\" name=\"txtOrganizacion\" placeholder=\"Ingresar organización\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <button type=\"button\" class=\"btn bg-light-blue waves-effect agregarUsuario\">Guardar</button>\n");
      out.write("                                        <button type=\"reset\" class=\"btn bg-light-blue waves-effect\">Limpiar</button>\n");
      out.write("                                        <button type=\"button\" class=\"btn bg-light-blue waves-effect\">Cancelar</button>\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xs-12 col-sm-8 col-md-8 col-lg-8\">\n");
      out.write("                                    <!-- Datos Table -->\n");
      out.write("                                    <div class=\"row clearfix\">\n");
      out.write("                                        <div class=\"col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                                            <div class=\"card\">\n");
      out.write("                                                <div class=\"header\">\n");
      out.write("                                                    <h2>\n");
      out.write("                                                        Usuarios a Registrar\n");
      out.write("                                                        <small>Al registrar los usuairos podran tener acceso al sistema</small>\n");
      out.write("                                                    </h2>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"body table-responsive\">\n");
      out.write("                                                    <table class=\"table table-bordered\">\n");
      out.write("                                                        <thead>\n");
      out.write("                                                            <tr>\n");
      out.write("                                                                <th>#</th>\n");
      out.write("                                                                <th>FIRST NAME</th>\n");
      out.write("                                                                <th>LAST NAME</th>\n");
      out.write("                                                                <th>USERNAME</th>\n");
      out.write("                                                            </tr>\n");
      out.write("                                                        </thead>\n");
      out.write("                                                        <tbody>\n");
      out.write("                                                        <div id=\"tabla\"></div>\n");
      out.write("                                                        </tbody>\n");
      out.write("                                                    </table>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- #END# Datos Table -->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- #END# Configuracion Inicial -->\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/scripts.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");

        } else {
            response.sendRedirect("notificacion/tse_aviso.jsp");
        }
    } else if (sesion.getAttribute("key") != null) {
        response.sendRedirect("../cerrar_sesion");
    }

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
