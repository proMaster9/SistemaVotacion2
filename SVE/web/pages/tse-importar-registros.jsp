<%-- 
    Document   : tse-importar-registros
    Created on : 30-sep-2016, 21:00:59
    Author     : Icchigo
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
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-light-blue">
                            <h2><i class="material-icons icons-align">settings</i>Importar Registros CNR
                                <i><small>Para poder importar los archivos deben cumplir los requerimientos de validación</small></i>
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
                            <div class="row clearfix align-center">
                                      <div class="col-md-4">
                                            <label>Dui:</label>
                                        </div>
                                        <div class="col-md-4">
                                            <label>Contraseña:</label>
                                        </div>
                                        <div class="col-md-4">
                                            <label>Estado:</label>
                                        </div>
                            </div>
                            <form action="" method="POST">
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
       
                                            <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                        
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                                
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                                
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg-4 col-md-4 col-sm-4 col-xs-4">
                                        <div class="form-group">
                                                
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <button type="button" class="btn btn-primary waves-effect">Seleccionar Archivo</button>
                                    <button type="button" class="btn btn-success waves-effect">Importar Datos</button>
                                </div>
                            </form>
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
