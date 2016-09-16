<%-- 
    Document   : tse-admin
    Created on : 10-sep-2016, 20:38:35
    Author     : Icchigo
--%>
<%@page session="true"  %>
<%
    if (request.getParameter("cerrar") != null) {
        session.invalidate();
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
          <jsp:include page="../pages/secciones/head.jsp" /><!-- se incluye el archivo que contiene todos los links --> 
    </head>
    <body class="no-skin">
        <div class="space-32"></div>
        <div class="space-32"></div>
        <div class="main-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div id="login-box" class="login-box visible widget-box">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <center>
                                            <h4 class="header blue lighter bigger">
                                                <img src="../assets/images/logo_tse.jpg"> 
                                            </h4>
                                        </center>

                                        <div class="space-6"></div>
                                        <form action="../iniciarsesion.do" method="post">
                                            <div class="row">
                                                <!--<label class="col-md-3 control-label no-padding-right">DUI:</label>-->
                                                <div class="col-md-10 col-md-offset-1">
                                                    <span class="input-icon">
                                                        <input type="text" name="txtUser" placeholder="Ingrese número Dui" id="form-field-icon-2">
                                                        <i class="ace-icon fa fa-user blue"></i>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="space-4"></div>
                                            <div class="row">
                                                <!--<label class="col-sm-3 control-label no-padding-right">Contraseña:</label>-->
                                                <div class="col-md-10 col-md-offset-1">
                                                    <span class="input-icon">
                                                        <input type="password" name="txtPass" placeholder="Ingrese su contraseña"  id="form-field-icon-2">
                                                        <i class="ace-icon fa fa-key blue"></i>
                                                    </span>
                                                </div>
                                            </div>
                                            <div class="space"></div>
                                            <div class="clearfix">
                                                <center>
                                                    <button class="btn btn-info" type="submit" name="btnIngresar">
                                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                                        Iniciar Sesión
                                                    </button>
                                                </center>

                                            </div>
                                            <div class="space-4"></div>
                                            <div class="hr hr32 hr-dotted"></div>
                                            <div class="row">

                                                <label class="col-sm-6 control-label pull-right">
                                                    <a href="">
                                                        Recuperar contraseña
                                                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                                                    </a>

                                                </label>
                                            </div>
                                        </form>
                                    </div><!-- /.widget-main -->  
                                </div><!-- /.widget-body -->
                            </div><!-- /.login-box -->   
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="../pages/secciones/footer.jsp" />
            </div>
        </div><!-- /.main-container -->
        <jsp:include page="../pages/secciones/script.jsp"/>
    </body>
</html>
