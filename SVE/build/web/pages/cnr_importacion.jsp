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
                /*
                 $("#password1").on("keyup",function(){
                 if($("#magistrado1").val() != "") {
                 var dui = $("#magistrado1").val();
                 var password = $("#password1").val();
                 $("#divMagistrado1").html("");
                 $.post('../SerMagistrado',{
                 dui : dui,
                 password : password
                 }, function(data){
                 $("#divMagistrado1").html(data);
                 });
                 }
                 });
                 */
                function buscarMagistrado(dui, password, div, servlet) {
                    $("#" + password).on("keyup", function () {
                        if ($("#" + dui).val() != "") {
                            $.post(servlet, {
                                dui:  $("#" + dui).val(),
                                password: $("#" + password).val()
                            }, function (data) {
                                $("#" + div).html(data);
                            });
                        }
                    });
                }

                buscarMagistrado('dui1', 'password1', 'divMagistrado1', '../SerMagistrado');
                buscarMagistrado('dui2', 'password2', 'divMagistrado2', '../SerMagistrado');
                buscarMagistrado('dui3', 'password3', 'divMagistrado3', '../SerMagistrado');
            });
        </script>
    </head>
    <body>
        <h1>Importacion de registros CNR</h1>
        <h3>Credenciales de magistrados</h3>
        <table>
            <tr>
                <th>Identificacion</th>
                <th>Contraseña</th>
                <th>Estado</th>
            </tr>
            <!--Magistrado 1-->
            <tr>
                <td><input type="text" id="dui1" data-tipo="dui" ></td>
                <td><input type="password" id="password1"></td>
                <td>
                    <div id="divMagistrado1"></div>
                </td>
            </tr>
            <!--Magistrado 2-->
            <tr>
                <td><input type="text" id="dui2" data-tipo="dui"></td>
                <td><input type="password" id="password2"></td>
                <td>
                    <div id="divMagistrado2"></div>
                </td>
            </tr>
            <!--Magistrado 3-->
            <tr>
                <td><input type="text" id="dui3" data-tipo="dui"></td>
                <td><input type="password" id="password3"></td>
                <td>
                    <div id="divMagistrado3"></div>
                </td>
            </tr>
        </table>
        <input type="file" id="btnSubir"><br>
        <input type="button" id="btnImportar" value="Importar datos">
    </body>
</html>
