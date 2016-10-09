<%-- 
    Document   : tse-usuarios
    Created on : 30-sep-2016, 20:56:41
    Author     : JH
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <jsp:include page="modulos/head.jsp"/>
    </head>

    <body class="theme-light-blue">
        <jsp:include page="modulos/loader.jsp"/>
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Search Bar -->
        <jsp:include page="modulos/search-bar.jsp"/>
        <!-- #END# Search Bar -->
        <!-- Top Bar -->
        <jsp:include page="modulos/navbar.jsp"/>
        <!-- #Top Bar -->

        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <jsp:include page="modulos/user-info.jsp"/>
                <!-- #User Info -->
                <!-- Menu -->
                <jsp:include page="modulos/menu-admin.jsp"/>
                <!-- #Menu -->
                <!-- Footer -->
                <jsp:include page="modulos/footer.jsp"/>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
            <!-- Right Sidebar -->
            <aside id="rightsidebar" class="right-sidebar">
                <jsp:include page="modulos/opciones-ico.jsp"/>
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
             
                <!-- #END# Configuracion Inicial -->
                <!-- Resultados -->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-light-blue">
                            <h2><i class="material-icons icons-align">add</i>Usuarios
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
                           <form action="" method="post" class="">
                                <button type="button" class="btn bg-light-blue waves-effect">Nuevo Usuario <i class="material-icons col-green icons-align" >person_add</i></button>
                                             
                           </form>
                                <div class="formu">
                            <div class="row clearfix">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs tab-nav-right" role="tablist">
                                        <li role="presentation"><a href="#registrar_magistrado" data-toggle="tab">Supervisor Externo</a></li>
                                       
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane animated zoomIn active" id="registrar_magistrado">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">group_add</i>
                                                    <span>Registrar Nuevo Supervisor Externo</span>
                                                </div>
                                            </div><form action="" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Identificacion:</label>
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
                                                        <label>Nombres:</label>
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
                                                        <label>Apellidos:</label>
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
                                                        <label>Sexo:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="col-xs-4">
                                                                  <label class="radio-inline">
                                                                <input type="radio" name="generoRadios" value="M"> Maculino
                                                                  </label>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <label class="radio-inline">
                                                             <input type="radio" name="generoRadios" value="F"> Femenino
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                 <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Pais</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Pais">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                 <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Organizacion</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Organizacion">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn bg-light-blue waves-effect">Guardar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Limpiar</button>
                                               
                                            </form>

                                        </div>
                                     
                                    
                                    </div>
                                    <!--#END# Tab panes-->
                                </div>
                            </div>
                        </div>
                    
                            <br>
                            <table class="table table-bordered table-striped table-hover dataTable js-exportable ">
                                <thead>
                                    <tr>
                                        <th>Identificacion</th>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>Sexo</th>
                                        <th>Pais </th>
                                        <th>Organizacion</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tfoot>
                                    <tr>
                                        <th>Identificacion</th>
                                        <th>Nombre</th>
                                        <th>Apellidos</th>
                                        <th>Sexo</th>
                                        <th>Pais </th>
                                        <th>Organizacion</th>
                                        <th></th>
                                        
                                    </tr>
                                </tfoot>
                                <tbody>
                                    <tr>
                                        <td>Tiger Nixon</td>
                                        <td>System Architect</td>
                                        <td>Edinburgh</td>
                                        <td>61</td>
                                        <td>2011/04/25</td>
                                        <td>$320,800</td>
                                         <td><a>Modificar</a></td>
                                    </tr>
                                    
                                   
                                </tbody>
                            </table>
                            <div class="formu">
                            <div class="row clearfix">
                                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                    <!-- Nav tabs -->
                                    <ul class="nav nav-tabs tab-nav-right" role="tablist">
                                        <li role="presentation"><a href="#registrar_magistrado" data-toggle="tab">Modificar Supervisor Externo</a></li>
                                       
                                    </ul>

                                    <!-- Tab panes -->
                                    <div class="tab-content">
                                        <div role="tabpanel" class="tab-pane animated zoomIn active" id="registrar_magistrado">
                                            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">group_add</i>
                                                    <span>Modificar Supervisor Externo</span>
                                                </div>
                                            </div><form action="" method="POST">
                                                <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Identificacion:</label>
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
                                                        <label>Nombres:</label>
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
                                                        <label>Apellidos:</label>
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
                                                        <label>Sexo:</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="col-xs-4">
                                                                  <label class="radio-inline">
                                                                <input type="radio" name="generoRadios" value="M"> Maculino
                                                                  </label>
                                                            </div>
                                                            <div class="col-xs-4">
                                                                <label class="radio-inline">
                                                             <input type="radio" name="generoRadios" value="F"> Femenino
                                                                </label>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                 <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Pais</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Pais">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                 <div class="row clearfix">
                                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                        <label>Organizacion</label>
                                                    </div>
                                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                        <div class="form-group">
                                                            <div class="form-line">
                                                                <input type="text" class="form-control" name="" placeholder="Organizacion">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="button" class="btn bg-light-blue waves-effect">Modificar</button>
                                                <button type="button" class="btn bg-light-blue waves-effect">Limpiar</button>
                                               
                                            </form>

                                        </div>
                                     
                                    
                                    </div>
                                    <!--#END# Tab panes-->
                                </div>
                            </div>
                        </div>
                        </div>
                    </div>
                </div>
                <!-- #END# Resultados -->
            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>

    </body>
</html>

