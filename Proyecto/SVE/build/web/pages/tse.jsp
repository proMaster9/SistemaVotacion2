<%-- 
    Document   : tse
    Created on : 09-oct-2016, 23:39:55
    Author     : JH
--%>

<%@page import="modelo.Ciudadano"%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>) sesion.getAttribute("usuario");
    if (usuario != null) {
        if (usuario.get(0).getNumDui() != null && usuario.get(0).getContrasenia() != null && sesion.getAttribute("key") != null) {
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
                } else if (usuario.get(0).getTipoUsuario() == 6) {
                %>
                <jsp:include page="modulos/menu_director_tse.jsp"/>
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
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <%=usuario.get(0).getNombre()%>
                </div>

            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
    </body>
</html>
<%
        } else {
            response.sendRedirect("notificacion/tse_aviso.jsp");
        }

    }else {
        response.sendRedirect("login/tse_usuario.jsp");
    }
%>
