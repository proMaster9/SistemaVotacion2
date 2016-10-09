<%-- 
    Document   : panel-usuario
    Created on : 25-sep-2016, 1:33:21
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
            <div class="row clearfix" >
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="row clearfix">
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
                                  <div class=" col-md-3 ">
                                                <div class="demo-google-material-icon">
                                                   
                                                   
                                                    
                                                </div>
                                
                                   
                            </div>
                            <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">assignment_ind</i>
                                                    <span>Dui</span>
                                                    
                                                </div>
                                
                                   
                            </div>
                          <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">assignment</i>
                                                    <span>Contra</span>
                                                    
                                                </div>
                                
                                   
                            </div>
                                 <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">error</i>
                                                    <span>Estado</span>
                                                    
                                                </div>
                                
                                   
                            </div>
                        </div>
                            <form>
                            <div class="row clearfix">
                                 <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                  
                                                    <label>Presidente:</label>
                                                    
                                                </div>
                                
                                   
                            </div>
                                 <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                  
                                                   
                                                     <div class="input-group">
                                                         <span class="input-group-addon"> <i class="material-icons col-green icons-align">assignment</i></span>
                                                            <div class="form-line">
                                                                
                                     <input type="text" class="form-control" name="" placeholder="Ingresar número dui">
                                                            </div>
                                                        </div>
                                                    
                                                </div>
                                
                                   
                            </div>
                          <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">assignment</i>
                                                    <span>Contra</span>
                                                    
                                                </div>
                                
                                   
                            </div>
                                 <div class="col-md-3">
                                                <div class="demo-google-material-icon">
                                                    <i class="material-icons col-green icons-align">error</i>
                                                    <span>Estado</span>
                                                    
                                                </div>
                                
                                   
                            </div>
                            </div>
                            </form>
                    </div>
                    
                </div>
                <!-- #END# Configuracion Inicial -->
                <!-- Resultados -->
                
                <!-- #END# Resultados -->
            </div>
                    
                </div>
                
            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
    </body>
</html>
