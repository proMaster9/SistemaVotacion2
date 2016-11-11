<%-- 
    Document   : PruebaAsignacionVotantes
    Created on : 11-06-2016, 07:40:32 AM
    Author     : carlos
--%>

<%@page import="controlador.SerAsignacionVotantes"%>
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

                $("#btnAsignar").on("click", function () {
                    var coincidencia = 0;
                    //se recorren los campos ocultos, para verificar que todos tengan un resultado correcto
                    $("input[data-tipo=resultado]").each(function (i) {
                        if ($(this).val() == 0) {
                            coincidencia++;
                        }
                    });
                    if (coincidencia == 0) {
                        var dui1 = $("#dui1").val();
                        var dui2 = $("#dui2").val();
                        var dui3 = $("#dui3").val();
                        $("#btnAsignar").attr("disabled","disabled");
                        $("#btnAsignar").attr("value","Asignando...");
                        $.post('../SerAsignacionVotantes', {
                            btnAsignacion: true,
                            txtDui1: dui1,
                            txtDui2: dui2,
                            txtDui3: dui3
                        }, function (data) {
                            //Se muestra una alerta con un mensaje de exito
                            alert(data);
                            //se oculta el formulario y cambia el mensaje
                            $("#divNoticia").html("noticia: los votantes han sido asignados correctamente a los centros de votacion");
                            $("#frmAsignacion").hide();
                        });
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
        <div id="divAsignacion">
            <!--Accion en caso de que los votantes no esten asignados-->
            <% if (SerAsignacionVotantes.cantidadAsignacion() == 0) { %>
            <label id="divNoticia">
                noticia: los ciudadanos aun no han sido asignados a los centros de votacion<br>
            </label>
            <form id="frmAsignacion">
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
                <input type="button" id="btnAsignar" value="Asignar">
            </form>
            <!--Fin de accion-->
            <!--Accion en caso de que los votantes esten asignados-->
            <% } else {%>
            noticia: los votantes han sido asignados correctamente a los centros de votacion
            <% }%>
            <!--Fin de la accion-->
        </div>
        <!--Impresion de datos estadisticos-->
        Total de centros de votacion: <%= SerAsignacionVotantes.totalCentros() %><br>
        Total de votantes: <%= SerAsignacionVotantes.totalVotantes() %><br>
        <table>
            <tr>
                <th>Departamento</th>
                <th>Municipio</th>
                <th>Total de Centros</th>
                <th>#Votantes</th>
                <th>Votantes x Centro</th>
            </tr>
            <tbody>
                <%= SerAsignacionVotantes.mostrarDistribucion()%>
            </tbody>
        </table>
    </body>
</html>
