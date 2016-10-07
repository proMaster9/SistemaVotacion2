<%-- 
    Document   : recuperar-contraseña
    Created on : 25-sep-2016, 0:57:36
    Author     : Icchigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Recuperar Contraseña | TSE </title>
    <!-- Favicon-->
    <link rel="icon" href="../../favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="../../plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="../../plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="../../plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="../../css/style.css" rel="stylesheet">
</head>

<body class="fp-page">
    <div class="fp-box">
        <div class="card">
            <div class="logo">
                <br>
                <div class="msg"><img src="../../images/tse-logo.jpg"/></div>
            </div>
            <div class="body">
                <form id="forgot_password" method="POST">
                    <div class="msg">
                        Para recuperar tu cuenta debes seguir los pasos:
                        Paso 1.Ingresa número de dui
                    </div>
                    <div class="input-group">
                            <span class="input-group-addon">
                                <i class="material-icons">person</i>
                            </span>
                            <div class="form-line">
                                <input type="text" class="form-control" name="txtUser" placeholder="Ingrese su número de dui" required autofocus>
                            </div>
                    </div>
                    <button class="btn btn-block btn-lg bg-light-blue waves-effect" type="submit">Recuperar Contraseña</button>

                    <div class="row m-t-20 m-b--5 align-center">
                        <a href="login-usuario.jsp">Iniciar Sesión!</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Jquery Core Js -->
    <script src="../../plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="../../plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="../../plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="../../plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="../../js/admin.js"></script>
    <script src="../../js/pages/login/forgot-password.js"></script>
</body>

</html>