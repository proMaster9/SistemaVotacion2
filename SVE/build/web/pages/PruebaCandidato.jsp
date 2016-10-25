<%-- 
    Document   : crud_candidatos
    Created on : 10-20-2016, 11:01:51 AM
    Author     : carlos
--%>

<%@page import="modelo.Departamento"%>
<%@page import="modelo.DepartamentoDTO"%>
<%@page import="modelo.CiudadanoDTO"%>
<%@page import="modelo.Candidato"%>
<%@page import="modelo.CandidatoDTO"%>
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
                mostrarCiudadano('txtDui', 'divCiudadano', '../SerCiudadano', 0);
                enviarForm('frmCandidato', 'btnAgregar');
                cargarImagen("btnImagen", "divImg");
                //evitar la actualizacion si no se selecciona un registro
                $("#btnModificar").on("click", function () {
                    var modificar = $("#txtId").val();
                    if (modificar != 0) {
                        $("#frmCandidato").submit();
                    }
                    else {
                        alert("No puedes modificar");
                    }
                });

            });
            function modificar(idCandidato, idPartido, idDepartamento, dui, foto) {
                $("#txtId").val(idCandidato);
                $("#slPartido").val(idPartido);
                $("#slDepartamento").val(idDepartamento);
                $("#txtDui").val(dui);
                $("#divImg").html(foto);
            }

        </script>
    </head>
    <body>
        <h1>Candidatos</h1>
        <form method="post" name="frmCandidato" id="frmCandidato" action="../SerCandidato" enctype="multipart/form-data">
            <input type="hidden" name="txtId" id="txtId" value="0">
            Partido: 
            <select name="slPartido" id="slPartido">
                <%
                    for (Partido p : PartidoDTO.mostrarPartidos()) {
                %>
                <option value="<%= p.getIdPartido()%>"><%= p.getAcronimo()%></option>
                <% }%>
            </select><br>
            Departamento:
            <select name="slDepartamento" id="slDepartamento">
                <% for (Departamento d : DepartamentoDTO.mostrarDepartamentos()) {%>
                <option value="<%= d.getIdDepartamento()%>"><%= d.getDepartamento()%></option>
                <% } %>
            </select>
            <!--Busqueda de ciudadano-->
            <div>
                Dui: <input type="text" name="txtDui" id="txtDui" autocomplete="off"><br>

                <!--Impresion de resultados de busqueda-->
                <div id="divCiudadano">
                    <input type="hidden" name="txtResultado" id="txtResultado">
                </div>
                <!--Fin de impresion de resultados-->
                Foto: <input type="file" name="btnImagen" id="btnImagen">
                <br>
                <div id="divImg"></div>

            </div>
            <!--Fin de busqueda-->
            <input type="button" value="Agregar" id="btnAgregar">
            <input type="button" value="Modificar" id="btnModificar">
        </form>
        <table>
            <tr>
                <th>Departamento</th>
                <th>Candidato</th>
                <th>Nombre</th>
                <th>Partido</th>
                <th>Foto</th>
                <th></th>
            </tr>
            <tbody>
            <div id="divCandidato">
                <% for (Candidato c : CandidatoDTO.mostrarCandidatos()) {%>
                <tr>
                    <td><%= DepartamentoDTO.mostrarDepartamento(c.getIdDepartamento()).getDepartamento()%></td>
                    <td><%= c.getNumDui()%></td>
                    <td>
                        <%= CiudadanoDTO.mostrarVotante(c.getNumDui()).getApellido()%>, 
                        <%= CiudadanoDTO.mostrarVotante(c.getNumDui()).getNombre()%>
                    </td>
                    <td><%= PartidoDTO.mostrarPartido(c.getIdPartido()).getAcronimo()%></td>
                    <td><img src="../images/files/candidatos/<%= c.getFoto()%>"></td>
                    <td>
                        <a href="javascript:modificar('<%= c.getIdCandidato()%>','<%= c.getIdPartido()%>','<%= c.getIdDepartamento()%>','<%= c.getNumDui()%>','<img src=../images/files/candidatos/<%= c.getFoto()%>>')">Modificar</a>
                        <a href="../SerCandidato?idCandidato=<%= c.getIdCandidato() %>">Eliminar</a>
                    </td>
                </tr>
                <% }%>
            </div>
        </tbody>
    </table>
</body>
</html>
