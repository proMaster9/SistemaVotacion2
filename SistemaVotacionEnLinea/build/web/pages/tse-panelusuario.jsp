<%-- 
    Document   : tse-panelusuario
    Created on : 11-sep-2016, 0:52:33
    Author     : JH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios TSE</title>
        <%@include file="../WEB-INF/jspf/head.jspf" %><!-- se incluye el archivo que contiene todos los links -->
    </head>
    <body class="no-skin">
        
        <div id="navbar" class="navbar navbar-default">
            <%@include file="../WEB-INF/jspf/nav.jspf" %><!-- se incluye el archivo que contiene el menu -->
        </div>

        <div class="main-container" id="main-container">

            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed');
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar responsive">
                <%@include file="../WEB-INF/jspf/sidebar-menu-admin.jspf" %><!-- se incluye el archivo que contiene el sidebar menu -->
            </div>

            <div class="main-content">
                <div class="main-content-inner">
                    
                    <div class="breadcrumbs" id="breadcrumbs">
                        <%@include file="../WEB-INF/jspf/breadcrumb.jspf" %><!-- se incluye el archivo que contiene la barra de navegacion -->
                    </div>
                    
                    <div class="page-content">
                        <%@include file="../WEB-INF/jspf3/centrovotacion.jspf" %>
                    </div>
 
                </div>
            </div>

            <div class="footer">
                <%@include file="../WEB-INF/jspf/footer.jspf" %><!-- se incluye el archivo que contiene el footer -->
            </div>
        </div>
            
        <%@include file="../WEB-INF/jspf/script.jspf" %><!-- se incluye el archivo que contiene los jQuery-->
    </body>
</html>
