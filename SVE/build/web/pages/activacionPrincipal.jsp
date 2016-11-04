<%-- 
    Document   : activacionPrincipal
    Created on : 11-03-2016, 08:41:59 PM
    Author     : carlos
--%>

<%@page import="controlador.SerActivacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../plugins/jquery/jquery.js"></script>
        <script>
            $(document).on("ready",function(){
                $("#btnVerificar").on("click",function(){
                    var dui = $("#txtDui").val();
                    var pass = $("#txtPass").val();
                    $("#txtPass").val("");
                    $.post('../SerActivacion',{
                        txtPrincipal : 'true',
                        txtDui : dui,
                        txtPass : pass
                    },function(data){
                        $("#divActivacion").html(data);
                    });
                });
            });
            function activar() {
                var dui = $("#txtDui").val();
                $.post('../SerActivacion',{
                    txtActivacionPrincipal : 'true',
                    txtDui : dui
                },function(data){
                    $("#divActivacion").html(data);
                });
            }
       
        </script>
    </head>
    <body>
        <h1>Activacion de cuenta</h1>
        <form>
            <input type="hidden" name="txtDui" id="txtDui">
            dui: <input type="text" name="txtDui" id="txtDui"><br>
            <br>
            contraseña: <input type="password" name="txtPass" id="txtPass">
            <input type="button" name="btnVerificar" id="btnVerificar" value="Verificar">
            <div id="divActivacion">
            </div>
        </form>
    </body>
</html>
