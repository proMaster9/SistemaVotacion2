<%-- 
    Document   : PruebaDetalleCentro
    Created on : 11-06-2016, 10:28:24 AM
    Author     : carlos
--%>

<%@page import="controlador.SerMunicipio"%>
<%@page import="modelo.CentroVotacion"%>
<%@page import="controlador.SerAsignacionVotantes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="../plugins/jquery/jquery.js"></script>
    </head>
    <body>
        <% 
            //el id del director de centros de votacion que ha iniciado sesion
            //si lo probas asi, revisa que id de usuario tienen los directores de centro de votacion
            int idUsuario= 7;
            int idCentro = SerAsignacionVotantes.getIdCentroVotacion(idUsuario);
            //se almacena la informacion del centro votacion
            CentroVotacion c = SerAsignacionVotantes.informacionCentro(idCentro);
        %>
        <h1>Asignacion de votantes al centro</h1>
        Centro: <%= c.getNombreCentro() %><br>
                Departamento: <%= SerMunicipio.obtenerDepartamento(c.getIdMunicipio()) %><br>
                Municipio: <%= SerMunicipio.obtenerMunicipio(c.getIdMunicipio()) %><br>
        Direccion: <%= c.getDireccion() %>
        Total de personas: <%= SerAsignacionVotantes.totalPersonasCentro(idCentro) %>
        <table>
            <tr>
                <th>Correlativo JRV</th>
                <th>Ciudadano</th>
            </tr>
            <tbody>
                <%= SerAsignacionVotantes.mostrarAsignacionCentro(idCentro) %>
            </tbody>
        </table>
    </body>
</html>
