<%-- 
    Document   : PruebaCentro
    Created on : 21-oct-2016, 22:38:04
    Author     : Icchigo
--%>

<%@page import="modelo.CiudadanoDTO"%>
<%@page import="modelo.CentroVotacion"%>
<%@page import="modelo.CentroVotacionDTO"%>
<%@page import="modelo.Municipio"%>
<%@page import="modelo.MunicipioDTO"%>
<%@page import="modelo.Departamento"%>
<%@page import="modelo.DepartamentoDTO"%>
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
                mostrarCiudadano('txtDui', 'divCiudadano', '../SerCiudadano', 0);
                $("#btnAgregar").on("click", function () {
                    var nombre = $("#txtNombre").val();
                    var departamento = $("#txtDepartamento").val();
                    var jrv = $("#txtJrv").val();
                    var dui = $("#txtDui").val();
                    var municipio = $("#slMunicipio").val();
                    var direccion = $("#txtDireccion").val();
                    if ($("#txtResultado").val() == 0) {
                        alert("No puedes enviar");
                    }
                    else {
                        $.post('../SerCentroVotacion', {
                            btnAgregar: 'true',
                            txtDepartamento : departamento,
                            txtNombre: nombre,
                            txtJrv: jrv,
                            txtDui: dui,
                            slMunicipio: municipio,
                            txtDireccion: direccion
                        }, function (data) {
                            $("#divCentro").html(data);
                        });
                    }
                });
            });
        </script>
    </head>
    <body>
        <%
            //hagamos de cuenta que el gestor de jrv es de san ahuachapan,
            //el departamento 1, este valor se tomaria de la variable de sesion
            int departamento = 1;
        %>
        <h1>Centros de votacion</h1>
        <form>
            <input type="hidden" name="txtDepartamento" id="txtDepartamento" value="<%= departamento %>">
            Nombre: <input type="text" name="txtNombre" id="txtNombre"><br>
            JRV's Disponibles: <input type="number" name="txtJrv" id="txtJrv"><br>
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
            Municipio: 
            <select name='slMunicipio' id='slMunicipio'>
                <%
                    for (Municipio m : MunicipioDTO.mostrarMunicipiosDep(departamento)) {
                %>
                <option value='<%= m.getIdMunicipio()%>'><%= m.getNombreMunicipio()%></option>
                <% }%>
            </select>
            <br>
            Direccion: <input type="text" name="txtDireccion" id="txtDireccion"><br>
            <input type="button" value="Agregar" name="btnAgregar" id="btnAgregar">
            <input type="button" value="Eliminar" name="btnEliminar" id="btnEliminar">
        </form>
        Centros del departamento de <%= DepartamentoDTO.mostrarDepartamento(departamento).getDepartamento()%>
        <table>
            <tr>
                <th>Centro</th>
                <th>JRV's</th>
                <th>Encargado</th>
                <th>Municipio</th>
                <th></th>
            </tr>
            <tbody>
            <div id="divCentro">
                <% for (CentroVotacion c : CentroVotacionDTO.mostrarCentrosDep(departamento)) {%>
                <tr>
                    <td><%= c.getNombreCentro()%></td>
                    <td><%= c.getNumJrvDisponible()%></td>
                    <!--Impresio del numero de dui, apellidos y nombres del director de centro de votacion-->
                    <td><%= c.getNumDui()%>, <%= CiudadanoDTO.mostrarVotante(c.getNumDui()).getApellido()%> <%= CiudadanoDTO.mostrarVotante(c.getNumDui()).getNombre()%></td>
                    <td><%= MunicipioDTO.mostrarUnMunicipio(c.getIdMunicipio()).getNombreMunicipio() %></td>
                    <td>
                        <a href='#'>Modificar</a>
                        <a href="#">Eliminar</a>
                    </td>
                </tr>
                <% }%>
            </div>
        </tbody>
    </table>
</body>
</html>
