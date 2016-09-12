<%-- 
    Document   : tse-admin
    Created on : 10-sep-2016, 20:38:35
    Author     : Icchigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="../WEB-INF/jspf/head.jspf" %>
    </head>
    <body class="no-skin">

        <!-- contenedor del menu -->
        <div id="navbar" class="navbar navbar-default">

        </div><!-- /contenedor del munu -->
        <div class="space"></div>
        <div class="main-container">
            <div class="main-content">
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">
                        <div class="login-container">
                            <div class="center">
                                <div id="login-box" class="login-box visible widget-box">
                                    <div class="widget-body">
                                        <div class="widget-main">
                                            <h4 class="header blue lighter bigger">
                                                <i class="ace-icon fa fa-user bigger-300 blue"></i>
                                                <div class="space-6"></div>
                                                TSE
                                            </h4>
                                            <div class="space-6"></div>
                                            <form>
                                                <div class="row">
                                                    <label class="col-sm-3 control-label no-padding-right">DUI:</label>

                                                    <div class="col-sm-9">
                                                        <!-- #section:elements.form.input-icon -->
                                                        <span class="input-icon">
                                                            <input type="text" id="form-field-icon-1">
                                                            <i class="ace-icon fa fa-user blue"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="space-4"></div>
                                                <div class="row">
                                                    <label class="col-sm-3 control-label no-padding-right">Contraseña:</label>
                                                    <div class="col-sm-9">
                                                        <!-- #section:elements.form.input-icon -->
                                                        <span class="input-icon">
                                                            <input type="text" id="form-field-icon-1">
                                                            <i class="ace-icon fa fa-key blue"></i>
                                                        </span>
                                                    </div>
                                                </div>
                                                <div class="space"></div>
                                                <div class="clearfix">
                                                    <button class="btn btn-info" type="button">
                                                        <i class="ace-icon fa fa-check bigger-110"></i>
                                                        Iniciar Sesión
                                                    </button>
                                                </div>
                                                <div class="space-4"></div>
                                                <div class="hr hr32 hr-dotted"></div>
                                                <div class="row orange">
                                                    <label class="col-sm-6 control-label pull-right">
                                                        Recuperar contraseña
                                                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
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
            </div>
        </div>
    </div><!-- /.main-content -->
    <div class="footer">
        <%@include file="../WEB-INF/jspf/footer.jspf" %>
    </div>
</div><!-- /.main-container -->

<%@include file="../WEB-INF/jspf/script.jspf" %>
</body>
</html>
