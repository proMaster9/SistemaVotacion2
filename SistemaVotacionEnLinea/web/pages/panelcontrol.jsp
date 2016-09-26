<%-- 
    Document   : panelcontrol
    Created on : 16-sep-2016, 1:58:29
    Author     : Icchigo
--%>
<%@page session="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("cerrar") != null) {
               response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setHeader("Pragma", "no-cache");
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("tipo");
        request.getSession().removeAttribute("id_tipo");
        session.invalidate();
}
HttpSession sesion = request.getSession();
if (sesion.getAttribute("id_tipo") != null && sesion.getAttribute("tipo") != null && sesion.getAttribute("user") != null) {
String user = (String) sesion.getAttribute("user");
String tipo = (String) sesion.getAttribute("tipo");
int id_tipo = (Integer) sesion.getAttribute("id_tipo");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuarios TSE</title>
        <jsp:include page="secciones/head.jsp" /><!-- se incluye el archivo que contiene todos los links --> 
        <script>
            $(document).ready(function () {
                $("#print1").on("click", function () {
                    $("#cargarArchivo").load('InicioSistema.jspf');
                });
                $("#print2").on("click", function () {
                    $("#cargarArchivo").load('ImportarSql.jspf');
                });

            });
        </script>
    </head>
    <body class="no-skin">
     
        <div id="navbar" class="navbar navbar-default">
            <jsp:include page="secciones/header.jsp"/><!-- se incluye el archivo que contiene el menu -->
        </div>

        <div class="main-container" id="main-container">
            <script type="text/javascript">
                try {
                    ace.settings.check('main-container', 'fixed');
                } catch (e) {
                }
            </script>

            <div id="sidebar" class="sidebar responsive">
                <%
                    if (id_tipo == 1) {
                %>
                <jsp:include page="secciones/sidebar-admin.jsp" /><!-- se incluye el archivo que contiene el sidebar menu -->
                <%
                } else if (id_tipo == 2) {
                %>
                <jsp:include page="secciones/sidebar-magistrado.jsp" /><!-- se incluye el archivo que contiene el sidebar menu -->
                <% 
                } else if (id_tipo == 3) {
                %>
                <jsp:include page="secciones/sidebar-cnr.jsp" /><!-- se incluye el archivo que contiene el sidebar menu -->
                <%
                    }
                %>

            </div>

            <div class="main-content">
                <div class="main-content-inner">

                    <div class="breadcrumbs" id="breadcrumbs">
                        <jsp:include page="secciones/breadcrumb.jsp" /><!-- se incluye el archivo que contiene la barra de navegacion -->
                    </div>
                    <div class="page-content">
                        <div id="cargarArchivo"></div>
                        
                    </div>

                </div>
            </div>

            <div class="footer">
                <jsp:include page="secciones/footer.jsp" /><!-- se incluye el archivo que contiene el footer -->
            </div>
        </div>
        <jsp:include page="secciones/script.jsp"/><!-- se incluye el archivo que contiene los jQuery-->
        <%    } else {
                out.print("<script>location.replace('../login/tse-usuario.jsp?cerrar=true');</script>");
            }
        %>
    </body>
</html>
