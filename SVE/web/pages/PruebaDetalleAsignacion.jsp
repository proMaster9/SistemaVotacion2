<%-- 
    Document   : PruebaDetalleAsignacion
    Created on : 11-06-2016, 09:06:05 AM
    Author     : carlos
--%>

<%@page import="controlador.SerAsignacionVotantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Asignacion de votantes</h1>
        <!--no se muestran datos, a menos que ya esten asignados los ciudadanos-->
        <% if (SerAsignacionVotantes.cantidadAsignacion() == 0) { %>
            noticia: los ciudadanos aun no han sido asignados a los centros de votacion<br>
        <% } else {%>
        <!--Impresion en caso de que ya esten asignados-->
        <table>
            <tr>
                <th>Departamento</th>
                <th>Municipio</th>
                <th>Centro</th>
                <th>Correlativo</th>
                <th>Ciudadano</th>
            </tr>
            <tbody>
                <%= SerAsignacionVotantes.mostrarAsignacion() %>
            </tbody>
        </table>
        <% } %>
    </body>
</html>
