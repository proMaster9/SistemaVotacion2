package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tse_005fcentro_005fvotacion_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\">\r\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\r\n");
      out.write("        <title>Centro Votacion | TSE</title>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/head.jsp", out, false);
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body class=\"theme-light-blue\">\r\n");
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/menu.jsp", out, false);
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
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/opciones.jsp", out, false);
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
      out.write("                <!--Formulario-->\r\n");
      out.write("                <div class=\"col-xs-12 col-sm-12 col-md-4 col-lg-4\">\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"header\">\r\n");
      out.write("                            <h2>\r\n");
      out.write("                                <i class=\"material-icons icons-align col-light-blue\">store_mall_directory</i>\r\n");
      out.write("                                AGREGAR CENTRO DE VOTACIÓN\r\n");
      out.write("                            </h2>\r\n");
      out.write("                            <ul class=\"header-dropdown m-r-0\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a data-toggle=\"modal\" href=\"#modalInfoF\" >\r\n");
      out.write("                                        <i class=\"material-icons col-light-blue\">info_outline</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"body\">\r\n");
      out.write("                            <form id=\"frmCentroVotacion\">\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>Nombre:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" id=\"txtNombre\" class=\"form-control\" name=\"txtNombre\" placeholder=\"Ingresar nombre Centro Votación\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>JRV Disponibles:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"number\" class=\"form-control\" id=\"txtJrv\" name=\"txtJrv\" placeholder=\"Ingresar JRV disponibles\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>Departamento:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <select class=\"form-control show-tick\" data-live-search=\"true\" name=\"slDepartamento\" id=\"slDepartamento\" >\r\n");
      out.write("                                                <option >Seleccione departamento</option>\r\n");
      out.write("                                                <option value=\"1\">x</option>\r\n");
      out.write("                                                <option>y</option>\r\n");
      out.write("                                                <option>z</option>\r\n");
      out.write("                                                <option>a</option>\r\n");
      out.write("                                                <option>w</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>Municipio:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <select class=\"form-control show-tick\" data-live-search=\"true\" name=\"slMunicipio\">\r\n");
      out.write("                                                <option value=\"\">Seleccione municipio</option>\r\n");
      out.write("                                                <option value=\"1\">x</option>\r\n");
      out.write("                                                <option>y</option>\r\n");
      out.write("                                                <option>z</option>\r\n");
      out.write("                                                <option>a</option>\r\n");
      out.write("                                                <option>w</option>\r\n");
      out.write("                                            </select>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>Dirección:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" id=\"txtDireccion\" class=\"form-control\" name=\"txtDireccion\" placeholder=\"Ingresar dirección Centro Votación\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>DUI:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" id=\"txtDuiD\" class=\"form-control\" name=\"txtDuiD\" placeholder=\"Buscar\">\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                        <label>Nombre:</label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                        <div class=\"form-group\">\r\n");
      out.write("                                            <div class=\"form-line\">\r\n");
      out.write("                                                <input type=\"text\" class=\"form-control\" id=\"txtNombreD\" name=\"txtNombreD\" placeholder=\"Esperando Nombre\" disabled>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                        <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                            <label>Apellido:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <div class=\"form-line\">\r\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" id=\"txtApellidoD\" name=\"txtApellidoD\" placeholder=\"Esperando Apellido\" disabled>\r\n");
      out.write("                                                </div>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                        <div class=\"col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label\">\r\n");
      out.write("                                            <label>Género:</label>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                        <div class=\"col-lg-8 col-md-8 col-sm-9 col-xs-6\">\r\n");
      out.write("                                            <div class=\"form-group\">\r\n");
      out.write("                                                <input type=\"radio\" name=\"rdbSexo\" id=\"male\" value=\"M\" class=\"with-gap radio-col-light-blue\" disabled>\r\n");
      out.write("                                                <label for=\"male\">Hombre</label>\r\n");
      out.write("                                                <input type=\"radio\" name=\"rdbSexo\" id=\"female\"  value=\"F\"  class=\"with-gap radio-col-light-blue\" disabled>\r\n");
      out.write("                                                <label for=\"female\" class=\"m-l-20\">Mujer</label>\r\n");
      out.write("                                            </div>\r\n");
      out.write("                                        </div>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                <div class=\"row clearfix\">\r\n");
      out.write("                                    <div class=\"col-md-12 align-center\">\r\n");
      out.write("                                        <button type=\"button\" class=\"btn bg-light-blue waves-effect waves-light\" id=\"btnAg\">Guardar</button>\r\n");
      out.write("                                        <button type=\"reset\" class=\"btn bg-cyan waves-effect waves-light\">Limpiar</button>\r\n");
      out.write("                                        <button type=\"button\" class=\"btn  bg-cyan waves-effect waves-light\">Cancelar</button>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- #END# Formulario -->\r\n");
      out.write("                <!--Tabla-->\r\n");
      out.write("                <div class=\"col-lg-8 col-md-8 col-sm-12 col-xs-12\">\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"card\">\r\n");
      out.write("                        <div class=\"header\">\r\n");
      out.write("                            <h2>\r\n");
      out.write("                                <i class=\"material-icons icons-align col-light-blue\">assignment</i>\r\n");
      out.write("                                CENTROS DE VOTACION REGISTRADOS EN EL SISTEMA\r\n");
      out.write("                            </h2>\r\n");
      out.write("                            <ul class=\"header-dropdown m-r-0\">\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"javascript:void(0);\" >\r\n");
      out.write("                                        <i class=\"material-icons col-light-blue\">save</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a href=\"javascript:void(0);\">\r\n");
      out.write("                                        <i class=\"material-icons col-light-blue\">print</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                                <li>\r\n");
      out.write("                                    <a data-toggle=\"modal\" href=\"#modalInfoT\" >\r\n");
      out.write("                                        <i class=\"material-icons col-light-blue\">info_outline</i>\r\n");
      out.write("                                    </a>\r\n");
      out.write("                                </li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"body\">\r\n");
      out.write("                            <table class=\"table table-bordered table-striped table-hover js-basic-example dataTable\">\r\n");
      out.write("                                <thead>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <th>#</th>\r\n");
      out.write("                                        <th>Nombre Centro:</th>\r\n");
      out.write("                                        <th>Municipio:</th>\r\n");
      out.write("                                        <th>Departamento:</th>\r\n");
      out.write("                                        <th>Numero JRV:</th>\r\n");
      out.write("                                        <th>Director:</th>\r\n");
      out.write("                                        <th>Opciones:</th>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </thead>\r\n");
      out.write("                                <tbody>\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        <td>1</td>\r\n");
      out.write("                                        <td>Parque</td>\r\n");
      out.write("                                        <td>Santa Tecla</td>\r\n");
      out.write("                                        <td>La Libertad</td>\r\n");
      out.write("                                        <td>12</td>\r\n");
      out.write("                                        <td>00124584-5</td>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn2 bg-cyan waves-effect m-r-0 waves-light\" data-toggle=\"modal\" data-target=\"#modalModificar\" >MODIFICAR</button>\r\n");
      out.write("                                            <button type=\"button\" class=\"btn btn2 bg-grey waves-effect m-r-0 waves-light\" data-toggle=\"modal\" data-target=\"#modalEliminar\" >ELIMINAR</button>\r\n");
      out.write("                                        </td>\r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                </tbody>\r\n");
      out.write("                            </table>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- #END# Tabla -->\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- Modal Dialogs ====================================================================================================================== -->\r\n");
      out.write("            <!-- Modal Modificar -->\r\n");
      out.write("            <div class=\"modal fade\" id=\"modalModificar\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h4 class=\"modal-title\" id=\"defaultModalLabel\">Modificar</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            Formulario para modificar\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\">Guardar</button>\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\" data-dismiss=\"modal\">Cancelar</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- #END# Modal Modificar -->\r\n");
      out.write("            <!-- Modal Eliminar -->\r\n");
      out.write("            <div class=\"modal fade\" id=\"modalEliminar\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h4 class=\"modal-title\" id=\"defaultModalLabel\">Eliminar</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            Formulario para eliminar\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\">Si, Eliminar</button>\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\" data-dismiss=\"modal\">No, Cancelar</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- #END# Modal Eliminar -->\r\n");
      out.write("            <!-- Modal Info F-->\r\n");
      out.write("            <div class=\"modal fade\" id=\"modalInfoF\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h4 class=\"modal-title\" id=\"defaultModalLabel\">Informacion sobre el formulario</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            Algunos datos que le podrian ayudar al usuario a registrar otros usuarios\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\" data-dismiss=\"modal\">Ok</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- #END# Modal Info T -->\r\n");
      out.write("            <!-- Modal Info F-->\r\n");
      out.write("            <div class=\"modal fade\" id=\"modalInfoT\" tabindex=\"-1\" role=\"dialog\">\r\n");
      out.write("                <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                    <div class=\"modal-content\">\r\n");
      out.write("                        <div class=\"modal-header\">\r\n");
      out.write("                            <h4 class=\"modal-title\" id=\"defaultModalLabel\">Informacion sobre el Tabla</h4>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-body\">\r\n");
      out.write("                            Datos sobre la tabla y los permisos que tienen esos usuarios\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"modal-footer\">\r\n");
      out.write("                            <button type=\"button\" class=\"btn btn-link waves-effect\" data-dismiss=\"modal\">Ok</button>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- #END# Modal Info T -->\r\n");
      out.write("        </section>\r\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "modulos/scripts.jsp", out, false);
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
