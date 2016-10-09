<%-- 
    Document   : panel-usuario
    Created on : 25-sep-2016, 1:33:21
    Author     : JH
--%>

<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<%
    HttpSession sesion = request.getSession();
    String user = (String) sesion.getAttribute("user");
    String rol = (String) sesion.getAttribute("rol");
    int idTipo = (Integer) sesion.getAttribute("idTipo");
    if (user == null && rol==null) {
        System.out.println("prueba"+sesion.getAttribute("user"));
        response.sendRedirect("login/admin/tse_admin.jsp");
    } else {

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
                    if(idTipo==1){
                %>
                <jsp:include page="modulos/menu_admin.jsp"/>
                <%
                    }else if(idTipo==2){
                %>
                <jsp:include page="modulos/menu_magistrado.jsp"/>
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
                    <%=user%>
                </div>

            </div>
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
    </body>
</html>
<%
    }

%>
