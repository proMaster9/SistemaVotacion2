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
        <script>
            $(document).on("ready",function(){
                alert("Jquery funciona");
                //funcion que carga la vista previa de la imagen
                function mostrarImagen(input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();
                        reader.onload = function (e) {
                            //$('#img_destino').attr('src', e.target.result);
                            var ruta =  e.target.result;
                            $("#divImg").html("<img src='"+ruta+"'/>");
                        }
                        reader.readAsDataURL(input.files[0]);
                    }
                }
                
                //cargamos la vista previa cuando se selecciona una imagen 
                $("#btnImagen").change(function () {
                    mostrarImagen(this);
                });
                
                //busqueda de Representante por el numero de dui
                $("#btnDui").on("click",function(){
                    var txtDui = $("#txtDui").val();
                    $.post('../SerCiudadano',{
                        txtDui : txtDui
                    },function(e){
                        $("#divRepresentante").html(e);
                    });
                });
            });
            //Cargar datos en el formulario
            function modificar(id,acronimo,nombre,dui,imagen) {
                $("input[name=txtId]").val(id);
                $("input[name=txtAcronimo]").val(acronimo);
                $("input[name=txtNombre]").val(nombre);
                $("input[name=txtDui]").val(dui);
                $("#divImg").html(imagen);
                $("#divRepresentante").html("<input type='submit' value='Modificar' name='btnModificar'>");
            }
        </script>

    </head>
    <body>
        <h1>HPartidos politicos</h1>
        <form method="post" name="frmPartido" action="../SerDirectorTSE" enctype="multipart/form-data">
            <input type="text" name="txtId">
            Acronimo: <input type="text" name="txtAcronimo" id="txtAcronimo"><br>
            Nombre: <input type="text" name="txtNombre" id="txtNombre"><br>
            Bandera: <input type="file" name="btnBandera" id="btnImagen"><br>
            <div id="divImg"></div>
            Dui de representante: <input type="text" name="txtDui" id="txtDui">
            <input type="button"value="Buscar" id="btnDui"><br>
            <div id="divRepresentante">
                <input type="button" value="Agregar partido" disabled="true">
            </div>
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
                <% for(Partido p:PartidoDTO.mostrarPartidos()) { %>
                <tr>
                    <td><%= p.getAcronimo() %></td>
                    <td><%= p.getNombre() %></td>
                    <td><%= p.getNumDui() %></td>
                    <td><img src="../images/files/partidos/<%= p.getImagen() %>"></td>
                    <td>
                        <a href="javascript:modificar('<%= p.getIdPartido()%>','<%= p.getAcronimo() %>','<%= p.getNombre() %>','<%= p.getNumDui() %>','<img src=../images/files/partidos/<%= p.getImagen() %> >')">Modificar</a>
                        <a href="../SerDirectorTSE?partido=<%= p.getIdPartido()%>">Eliminar</a
                    </td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </body>
</html>
