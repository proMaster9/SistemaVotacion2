<%-- 
    Document   : cnr_importacion
    Created on : 10-23-2016, 04:43:18 PM
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

                function buscarMagistrado(dui, password, div, servlet) {
                    $("#" + password + ", #" + dui).on("keyup", function () {
                        var coincidencia = 0;
                        //se recorren todos los campos donde se ingresan los duis
                        $("input[data-tipo=dui]").each(function (i) {
                            //evaluamos si hay campos repetidos
                            if ($(this).val() == $("#" + dui).val()) {
                                coincidencia++;
                            }
                        });
                        //si el valor de la caja de texo se repite solo con ella misma
                        //significa que el campo no se ha duplicado
                        if (coincidencia == 1) {
                            //se verifica que el campo dui no este vacio
                            if ($("#" + dui).val() != "") {
                                $.post(servlet, {
                                    dui: $("#" + dui).val(),
                                    password: $("#" + password).val()
                                }, function (data) {
                                    $("#" + div).html(data);
                                });
                            }
                        }
                        else {
                            $("#" + div).html('<input type="hidden" value="0" data-tipo="resultado">');
                            if ($("#" + dui).val() != "") {
                                $("#" + div).append("Dui repetido");
                            }
                        }

                    });
                }

                $("#btnImportar").on("click", function () {
                    var coincidencia = 0;
                    //se recorren los campos ocultos, para verificar que todos tengan un resultado correcto
                    $("input[data-tipo=resultado]").each(function (i) {
                        if ($(this).val() == 0) {
                            coincidencia++;
                        }
                    });
                    if (coincidencia == 0) {
                        $("#frmCnr").submit();
                    }
                    else {
                        alert("No puedes enviar");
                    }
                });
                buscarMagistrado('dui1', 'password1', 'divMagistrado1', '../SerMagistrado');
                buscarMagistrado('dui2', 'password2', 'divMagistrado2', '../SerMagistrado');
                buscarMagistrado('dui3', 'password3', 'divMagistrado3', '../SerMagistrado');
            });
        </script>
    </head>
    <body>
        <h1>Importacion de registros CNR</h1>
        <h3>Credenciales de magistrados</h3>
        <form id="frmCnr" action="../SerCiudadano" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <th>Identificacion</th>
                    <th>Contraseña</th>
                    <th>Estado</th>
                </tr>
                <!--Magistrado 1-->
                <tr>
                    <td><input type="text" id="dui1" data-tipo="dui" name="dui1"></td>
                    <td><input type="password" id="password1"></td>
                    <td>
                        <div id="divMagistrado1">
                            <input type="hidden" value="0" data-tipo="resultado">
                        </div>
                    </td>
                </tr>
                <!--Magistrado 2-->
                <tr>
                    <td><input type="text" id="dui2" data-tipo="dui" name="dui2"></td>
                    <td><input type="password" id="password2"></td>
                    <td>
                        <div id="divMagistrado2">
                            <input type="hidden" value="0" data-tipo="resultado">
                        </div>
                    </td>
                </tr>
                <!--Magistrado 3-->
                <tr>
                    <td><input type="text" id="dui3" data-tipo="dui" name="dui3"></td>
                    <td><input type="password" id="password3"></td>
                    <td>
                        <div id="divMagistrado3">
                            <input type="hidden" value="0" data-tipo="resultado">
                        </div>
                    </td>
                </tr>
            </table>
            <input type="file" name="btnArchivo" id="btnSubir"><br>
            <input type="button" id="btnImportar" value="Importar datos">
        </form>

    </body>
</html>
