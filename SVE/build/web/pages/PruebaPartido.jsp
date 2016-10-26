<%-- 
    Document   : crud_partidos
    Created on : 10-13-2016, 05:40:17 PM
    Author     : carlos
--%>

<%@page import="modelo.Partido"%>
<%@page import="modelo.PartidoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../plugins/jquery/jquery.js"></script>
        <script src="../js/funciones.js"></script>
        <script>
            $(document).on("ready", function () {
                cargarImagen("btnImagen", "divImg");

                /*cuando se presiona el boton de modificar, se comprueba primero
                 que se haya selecciona un registro, y que sus datos esten cargados*/
                $("#btnModificar").on("click", function () {
                    var modificar = $("#txtId").val();
                    if (modificar != 0) {
                        $("#frmPartido").submit();
                    }
                    else {
                        alert("No puedes modificar");
                    }
                });

                mostrarCiudadano('txtDui', 'divCiudadano', '../SerCiudadano', 0);
                enviarForm('frmPartido', 'btnAgregar');
            });
            //Cargar datos en el formulario
            function modificar(id, acronimo, nombre, dui, imagen) {
                $("input[name=txtId]").val(id);
                $("input[name=txtAcronimo]").val(acronimo);
                $("input[name=txtNombre]").val(nombre);
                $("input[name=txtDui]").val(dui);
                $("#divImg").html(imagen);
            }
        </script>

    </head>
    <body>

        <h1>Partidos politicos</h1>
        <form method="post" name="frmPartido" id="frmPartido" action="../SerPartido" enctype="multipart/form-data">
            <input type="hidden" name="txtId" id="txtId" value="0">
            Acronimo: <input type="text" name="txtAcronimo" id="txtAcronimo">
            <br>
            Nombre: <input type="text" name="txtNombre" id="txtNombre">
            <br>
            Bandera: <input type="file" name="btnBandera" id="btnImagen">
            <br>
            <div id="divImg"></div>
            <!--Busqueda de ciudadano-->
            <div>
                Representante: <input type="text" name="txtDui" id="txtDui" autocomplete="off">
                <!--Impresion de resultados de busqueda-->
                <div id="divCiudadano">
                    <input type="hidden" name="txtResultado" id="txtResultado">
                </div>
                <!--Fin de impresion de resultados-->
            </div>
            <!--Fin de busqueda-->
            <input type="button" value="Agregar" id="btnAgregar">
            <input type="button" value="Modificar" id="btnModificar">
        </form>
        <table>
            <tr>
                <th>Acronimo</th>
                <th>Nombre</th>
                <th>Representante</th>
                <th>Bandera</th>
                <th></th>
            </tr>
            <tbody>
            <div id="divPartido">
                <% for (Partido p : PartidoDTO.mostrarPartidos()) {%>
                <tr>
                    <td><%= p.getAcronimo()%></td>
                    <td><%= p.getNombre()%></td>
                    <td><%= p.getNumDui()%></td>
                    <td><img src="../images/files/partidos/<%= p.getImagen()%>"></td>
                    <td>
                        <a href="javascript:modificar('<%= p.getIdPartido()%>','<%= p.getAcronimo()%>','<%= p.getNombre()%>','<%= p.getNumDui()%>','<img src=../images/files/partidos/<%= p.getImagen()%> >')">Modificar</a>
                        <a href="../SerPartido?idPartido=<%= p.getIdPartido()%>">Eliminar</a>
                    </td>
                </tr>
                <% }%>
            </div>
        </tbody>
    </table>
</body>
</html>
