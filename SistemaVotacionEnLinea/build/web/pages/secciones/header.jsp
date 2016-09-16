<%-- 
    Document   : header
    Created on : 16-sep-2016, 1:38:30
    Author     : Icchigo
--%>
<%@ page pageEncoding="UTF-8" %>
<%@page session="true" %>
<script type="text/javascript"></script>
<%
 HttpSession sesion = request.getSession();
        String tipo = (String)sesion.getAttribute("tipo");
%>
<div class="navbar-container" id="navbar-container">
    <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
        <span class="sr-only">Menú</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <div class="navbar-header pull-left">
        <a href="#" class="navbar-brand">
            <small>
                <img src="../assets/images/logo_tse.jpg" class="width-60"> 
            </small>
        </a>
    </div>
    <div class="navbar-buttons navbar-header pull-left" role="navigation">
        <div class="space-8"></div>
        <ul class="nav ace-nav"> 
            <li class="light-blue">
                <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                    <img class="nav-user-photo" src="../assets/avatars/avatar5.png" alt="ADMIN" />
                    <span class="user-info">
                        <small><% out.println(""+tipo);%></small>
                    </span>

                    <i class="ace-icon fa fa-caret-down"></i>
                </a>

                <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                    <li>
                        <a href="#">
                            <i class="ace-icon fa fa-cog"></i>
                            Configuración
                        </a>
                    </li>

                    <li>
                        <a href="profile.html">
                            <i class="ace-icon fa fa-user"></i>
                            Perfil
                        </a>
                    </li>

                    <li class="divider"></li>

                    <li>
                        <a href="../login/tse-usuario.jsp?cerrar=true">
                            <i class="ace-icon fa fa-power-off"></i>
                            Cerrar Sesión
                        </a>
                    </li>
                </ul>
            </li>

            <!-- /section:basics/navbar.user_menu -->
        </ul>
    </div>

    <!-- /section:basics/navbar.dropdown -->
</div><!-- /.navbar-container -->