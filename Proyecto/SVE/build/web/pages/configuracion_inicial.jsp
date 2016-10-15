<%-- 
    Document   : configuracion_inicial
    Created on : 10-oct-2016, 20:34:24
    Author     : Icchigo
--%>
<%@page import="modelo.Ciudadano"%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>) sesion.getAttribute("usuario");
    if (usuario != null) {
        if (usuario.get(0).getNumDui() != null && usuario.get(0).getNumDui() != null && sesion.getAttribute("key") != null) {
%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Panel Usuario | TSE</title>
        <jsp:include page="modulos/head.jsp"/>
    </head>

    <body class="theme-light-blue">

        <jsp:include page="modulos/loader.jsp"/>
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Top Bar -->
        <jsp:include page="modulos/navbar.jsp"/>
        <!-- #Top Bar -->

        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- Menu -->
                <%
                    if (usuario.get(0).getTipoUsuario() == 1) {
                %>
                <jsp:include page="modulos/menu_admin.jsp"/>
                <%
                } else if (usuario.get(0).getTipoUsuario() == 2) {
                %>
                <jsp:include page="modulos/menu_magis.jsp"/>
                <%
                } else if (usuario.get(0).getTipoUsuario() == 3) {
                %>
                <jsp:include page="modulos/menu_cnr.jsp"/>
                <%
                    }
                %>
                <!-- #Menu -->
                <!-- Footer -->
                <jsp:include page="modulos/footer.jsp"/>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
            <!-- Right Sidebar -->
            <aside id="rightsidebar" class="right-sidebar">
                <jsp:include page="modulos/opciones.jsp"/>
            </aside>
            <!-- #END# Right Sidebar -->
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="block-header">
                    <h2></h2>
                </div>
            </div>
            <div class="row clearfix" >
                <!-- Configuracion Inicial -->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-light-blue">
                            <h2><i class="material-icons icons-align">settings</i>Configuración Inicial
                                <i><small>Para que el sistema inicie debe ingresar la siguiente información</small></i>
                            </h2>
                            <ul class="header-dropdown m-r-0">
                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="material-icons">info_outline</i>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="material-icons">help_outline</i>
                                    </a>
                                </li>
                            </ul>

                        </div>
                        <div class="body">
                            <div class="row clearfix">
                                <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs tab-nav-right" role="tablist">
                                        <li role="presentation"><a href="#registrar_magistrado" data-toggle="tab">Paso 1</a></li>
                                        <li role="presentation"><a href="#registrar_dir_cnr" data-toggle="tab">Paso 2</a></li>
                                        <li role="presentation"><a href="#registrar_dir_tse" data-toggle="tab">Paso 3</a></li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane animated zoomIn active" id="registrar_magistrado">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">group_add</i>
                                                    <span>Registrar Magistrado</span>
                                                </div>
                                            </div><form id="formulario_magistrado">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Dui:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="mdui" placeholder="Ingresar número dui">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Nombre:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="mnombre" placeholder="Ingresar nombre">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Apellido:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="mapellido" placeholder="Ingresar apellido">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Fecha Nacimiento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="date" class="form-control" name="mfecha" >
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Municipio:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="mmunicipio">
                                                                <option value="">Seleccione municipio</option>
                                                                <option value="1">x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Departamento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="mdepartamento">
                                                                <option value="">Seleccione departamento</option>
                                                                <option value="1">x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn bg-light-blue waves-effect agregarUsuario">Guardar</button>
                                                <button type="reset" class="btn bg-light-blue waves-effect">Limpiar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Cancelar</button>
                                            </form>

                                        </div>
                                        <div role="tabpanel" class="tab-pane animated zoomIn" id="registrar_dir_cnr">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">person_add</i>
                                                    <span>Registrar Director CNR</span>
                                                </div>
                                            </div><form action="" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Dui:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Nombre:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar nombre">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Apellido:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar apellido">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Fecha Nacimiento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="date" class="form-control" name="" >
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Municipio:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="">
                                                                <option value="">Seleccione departamento</option>
                                                                <option>x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Departamento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="">
                                                                <option value="">Hot Dog, Fries and a Soda</option>
                                                                <option>x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn bg-light-blue waves-effect">Guardar</button>
                                                <button type="reset" class="btn bg-light-blue waves-effect">Limpiar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Cancelar</button>
                                            </form>
                                        </div>
                                        <div role="tabpanel" class="tab-pane animated zoomIn" id="registrar_dir_tse">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">person_add</i>
                                                    <span>Registrar Director TSE</span>
                                                </div>
                                            </div>
                                            <form action="" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Dui:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Nombre:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar nombre">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Apellido:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Ingresar apellido">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Fecha Nacimiento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="date" class="form-control" name="" >
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Municipio:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="">
                                                                <option value="">Seleccione municipio</option>
                                                                <option>x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Departamento:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <select class="form-control show-tick" data-live-search="true" name="">
                                                                <option value="">Seleccione departamento</option>
                                                                <option value="1">x</option>
                                                                <option>y</option>
                                                                <option>z</option>
                                                                <option>a</option>
                                                                <option>w</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn bg-light-blue waves-effect">Guardar</button>
                                                <button type="reset" class="btn bg-light-blue waves-effect">Limpiar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Cancelar</button>
                                            </form>
                                        </div>
                                    </div>
                                    <!--#END# Tab panes-->
                                </div>
                                <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
                                    <!-- Datos Table -->
                                    <div class="row clearfix">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Usuarios a Registrar
                                                        <small>Al registrar los usuairos podran tener acceso al sistema</small>
                                                    </h2>
                                                </div>
                                                <div class="body table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>
                                                                <th>#</th>
                                                                <th>FIRST NAME</th>
                                                                <th>LAST NAME</th>
                                                                <th>USERNAME</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <div id="tabla"></div>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- #END# Datos Table -->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Configuracion Inicial -->

            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
        
    </body>
</html>
<%
        } else {
            response.sendRedirect("notificacion/tse_aviso.jsp");
        }
    } else if (sesion.getAttribute("key") != null) {
        response.sendRedirect("../cerrar_sesion");
    }
%>

