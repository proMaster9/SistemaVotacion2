<%-- 
    Document   : tse-panelusuario
    Created on : 11-sep-2016, 0:52:33
    Author     : JH
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios TSE</title>
        <%@include file="../section-page/head.jspf" %><!-- se incluye el archivo que contiene todos los links -->
    </head>
    <body class="no-skin">
        <div id="navbar" class="navbar navbar-default">
            <%@include file="../section-page/header.jspf" %><!-- se incluye el archivo que contiene el menu -->
        </div>

        <div class="main-container" id="main-container">

            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed');
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar responsive">
                <%@include file="../section-page/sidebar-menu-admin.jspf" %><!-- se incluye el archivo que contiene el sidebar menu -->
            </div>

            <div class="main-content">
                <div class="main-content-inner">

                    <div class="breadcrumbs" id="breadcrumbs">
                        <%@include file="../section-page/breadcrumb.jspf" %><!-- se incluye el archivo que contiene la barra de navegacion -->
                    </div>

                    <div class="page-content">
                        <%@include file="../section-crud/centrovotacion.jspf" %>
                    </div>

                </div>
            </div>

            <div class="footer">
                <%@include file="../section-page/footer.jspf" %><!-- se incluye el archivo que contiene el footer -->
            </div>
        </div>
        <%@include file="../section-page/script.jspf" %><!-- se incluye el archivo que contiene los jQuery-->
    </body>
</html>
