<%-- 
    Document   : Prueba
    Created on : 10-oct-2016, 20:27:12
    Author     : Icchigo
--%>

<%@page import="modelo.Partido"%>
<%@page import="modelo.PartidoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.SupervisorExt"%>
<%@page import="modelo.SupervisorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../plugins/jquery/jquery.js"></script>
        <script>
            $(document).on("ready",function(){
                //esta funcion muestra al publicista que se agrego
                $("#btnPublicista").on("click",function(){
                    var dui = $("#txtDuiPublicista").val();
                    $.post('../SerDirectorTSE',{
                        duiPublicista : dui
                    }, function(e){
                        $("#divPublicista").html(e);
                    });
                });
            });
        </script>
        <script>
            function modificarSupervisor(id,identificacion,nombre,apellido,sexo,pais,organizacion) {
                document.frmSupervisor.txtIdUsuario.value = id;
                document.frmSupervisor.txtIdentificacion.value = identificacion;
                document.frmSupervisor.txtNombre.value = nombre;
                document.frmSupervisor.txtApellido.value = apellido;
                document.frmSupervisor.txtPais.value = pais;
                document.frmSupervisor.txtOrganizacion.value = organizacion;
                if(sexo == "m") {
                    document.frmSupervisor.txtSexo[0].checked = true;
                } else {
                    document.frmSupervisor.txtSexo[1].checked = true;
                }
            }
        </script>
    </head>
    <body>
        <h1>Supervisor externo</h1>
        <form method="post" action="../SerDirectorTSE" name="frmSupervisor">
            <input type="hidden" name="usuario" value="supervisor">
            <input type="hidden" name="txtIdUsuario">
            idenfiticacion: <input type="text" name="txtIdentificacion"><br>
            nombre: <input type="text" name="txtNombre"><br>
            apellido: <input type="text" name="txtApellido"><br>
            sexo: 
            <input type="radio" name="txtSexo" value="m"/>M
            <input type="radio" name="txtSexo" value="f"/>F
            <br/>
            pais: <input type="text" name="txtPais"><br/>
            oganizacion: <input type="text" name="txtOrganizacion"><br/>
            <input type="submit" value="Agregar" name="btnAgregar"/>
            <input type="submit" value="Modificar" name="btnModificar"/>
        </form>
        <table>
            <td>Identificacion</td>
            <td>Nombre</td>
            <td>Sexo</td>
            <td>Pais</td>
            <td>Organizacion</td>
            <td></td>
        </th>
        <tbody>
            <%
                ArrayList<SupervisorExt> sup = SupervisorDTO.mostrarSupervisores();
                for (SupervisorExt lista : sup) {
            %>
            <tr>
                <td><%= lista.getIdentificacion()%></td>
                <td><%= lista.getApellido() %>, <%= lista.getNombre()%></td>
                <td><%= lista.getSexo()%></td>
                <td><%= lista.getPais()%></td>
                <td><%= lista.getOrganizacion()%></td>
                <td>
                    <a href="javascript:modificarSupervisor('<%= lista.getIdUsuario() %>','<%= lista.getIdentificacion()%>','<%= lista.getNombre() %>','<%= lista.getApellido()%>','<%= lista.getSexo()%>','<%= lista.getPais()%>','<%= lista.getOrganizacion()%>')">Modificar<a>
                    <a href="../SerDirectorTSE?idSupervisor=<%= lista.getIdUsuario() %>">Eliminar</a>
                </td>
            </tr>
            <% }%>
        </tbody>
    </table>
        <h1>Publicista</h1>
        <form method="post" action="../SerDirector">
            <input type="text" name="txtDuiPublicista" id="txtDuiPublicista">
            <input type="button" value="Buscar" id="btnPublicista">
        </form>
        <!--Acase muestra por ajax, con la funcion que esta arriba-->
        <div id="divPublicista">
            
        </div>
        
        <h1>Partidos</h1>
        <form action="../SerDirectorTSE" enctype="MULTIPART/FORM-DATA" method="post">
            Acronimo: <input type="text"name="txtAcronimo"><br>
            Nombre: <input type="text" name="txtNombre"><br>
            Representante: <input type="text" name="txtRepresentante"><br>
            <input type="submit" value="Agregar" name="btnAgregarPartido">
        </form>
        <table>
            <th>
            <td>Acronimo</td>
            <td>Nombre</td>
            <td>Representante</td>
            </th>
            <tbody>
            </tbody>
        </table>
</body>
</html>
