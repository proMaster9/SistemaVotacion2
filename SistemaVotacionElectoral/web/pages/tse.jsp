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
                    <img src="../images/TSE.png" width="100%"/>
                </div>
                
            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
    </body>
</html>
