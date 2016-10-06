<%-- 
    Document   : tse-votante
    Created on : 30-sep-2016, 20:53:03
    Author     : Icchigo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <jsp:include page="../modulos/head.jsp"/>
    </head>

    <body class="theme-light-blue">
        <jsp:include page="../modulos/loader.jsp"/>
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Search Bar -->
        <jsp:include page="../modulos/search-bar.jsp"/>
        <!-- #END# Search Bar -->
        <!-- Top Bar -->
        <jsp:include page="../modulos/navbar.jsp"/>
        <!-- #Top Bar -->

        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <jsp:include page="../modulos/user-info.jsp"/>
                <!-- #User Info -->
                <!-- Menu -->
                <jsp:include page="../modulos/menu-admin.jsp"/>
                <!-- #Menu -->
                <!-- Footer -->
                <jsp:include page="../modulos/footer.jsp"/>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
            <!-- Right Sidebar -->
            <aside id="rightsidebar" class="right-sidebar">
                <jsp:include page="../modulos/opciones-ico.jsp"/>
            </aside>
            <!-- #END# Right Sidebar -->
        </section>

            <section class="content">
            <div class="container-fluid">
                <div class="block-header">
                    <h2></h2>
                </div>
            </div>
            <div class="row clearfix">
                <!-- Configuracion Inicial -->
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
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
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs tab-nav-right" role="tablist">
                                        <li role="presentation"><a href="#registrar_magistrado" data-toggle="tab">Paso 1</a></li>
                                        <li role="presentation"><a href="#registrar_dir_cnr" data-toggle="tab">Paso 2</a></li>
                                        <li role="presentation"><a href="#registrar_dir_tse" data-toggle="tab">Paso 3</a></li>
                                        <li role="presentation"><a href="#settings_animation_1" data-toggle="tab">Paso 4</a></li>
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane animated zoomIn active" id="registrar_magistrado">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">group_add</i>
                                                    <span>Registrar Magistrado</span>
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
                                                <button type="button" class="btn bg-light-blue waves-effect">Limpiar</button>
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
                                                <button type="button" class="btn bg-light-blue waves-effect">Limpiar</button>
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
                                                <button type="button" class="btn bg-light-blue waves-effect">Limpiar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Cancelar</button>
                                            </form>
                                        </div>
                                    </div>
                                    <!--#END# Tab panes-->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Configuracion Inicial -->
                <!-- Resultados -->
                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-light-blue">
                            <h2><i class="material-icons icons-align">add</i>Datos
                                <i><small>Para poder guardar la información debes seleccionar el botón guardar</small></i>
                            </h2>
                            <ul class="header-dropdown m-r--5">
                                <li>
                                    <a href="javascript:void(0);" data-toggle="cardloading" data-loading-effect="rotation" data-loading-color="lightGreen">
                                        <i class="material-icons">loop</i>
                                    </a>
                                </li>
                                <li class="dropdown">
                                    <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                        <i class="material-icons">more_vert</i>
                                    </a>
                                    <ul class="dropdown-menu pull-right">
                                        <li><a href="javascript:void(0);" class=" waves-effect waves-block">Action</a></li>
                                        <li><a href="javascript:void(0);" class=" waves-effect waves-block">Another action</a></li>
                                        <li><a href="javascript:void(0);" class=" waves-effect waves-block">Something else here</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <div class="body table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Dui:</th>
                                        <th>Nombre:</th>
                                        <th>Apellido:</th>
                                        <th>Fecha Nac:</th>
                                        <th>Municipio:</th>
                                        <th>Departamento:</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>12345678-9</td>
                                        <td>Joel</td>
                                        <td>Hernandez</td>
                                        <td>12/12/1900</td>
                                        <td>San Salvador</td>
                                        <td>San Salvador</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>12345678-9</td>
                                        <td>Joel</td>
                                        <td>Hernandez</td>
                                        <td>12/12/1900</td>
                                        <td>San Salvador</td>
                                        <td>San Salvador</td>
                                    </tr>

                                </tbody>
                            </table>
                            <div class="row clearfix">

                                <button type="button" class="btn bg-light-blue waves-effect">Guardar</button>
                                <button type="button" class="btn waves-effect">Cancelar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Resultados -->
            </div>
        </section>
        <jsp:include page="../modulos/scripts.jsp"/>

    </body>
</html>

