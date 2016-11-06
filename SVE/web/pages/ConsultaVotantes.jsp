<%-- 
    Document   : ConsultaVotantes
    Created on : 11-06-2016, 11:58:11 AM
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../plugins/jquery/jquery.js"></script>
        <script>
            $(document).on("ready", function () {
                $("#btnBuscar").on("click", function () {
                    var dui = $("#txtDui").val();
                    var pass = $("#txtPass").val();
                    if (dui.length == 0) {
                        $("#lblDui").html("Debes ingresar tu numero de dui");
                    }
                    else {
                        $("#lblDui").html("");
                    }
                    if (pass.length == 0) {
                        $("#lblPass").html("Debes ingresar tu contraseña");
                    }
                    else {
                        $("#lblPass").html("");
                    }
                    //cuando los campos no estan vacios
                    if (pass.length > 0 && dui.length > 0) {
                        $("lblDui").html("");
                        $("#lblPass").html("");
                        $.post('../SerAsignacionVotantes', {
                            btnBuscarCiudadano: 'true',
                            txtDui: dui,
                            txtPass: pass
                        }, function (data) {
                            $("#txtDui").val("");
                            $("#txtPass").val("");
                            $("#divConsulta").html(data);
                        });
                    }
                });
            });
        </script>
    </head>
    <body>
        <h1>Bienvenido al sistema de consultas del TSE</h1>
        <h3>no sabes donde te toco votar?</h3>
        <h4>ingresa tus credenciales y averigualo</h4>
        <form>
            dui: <input type="text" name="txtDui" id="txtDui">
            <label id="lblDui"></label>
            <br>
            contraseña: <input type="password" name="txtPass" id="txtPass">
            <label id="lblPass"></label>
            <br>
            <input type="button" value="Buscar" id="btnBuscar" name="btnBuscar">
        </form>
        <div id="divConsulta">
        </div>
    </body>
</html>
