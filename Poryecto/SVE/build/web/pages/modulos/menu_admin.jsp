<%-- 
    Document   : menu-admin
    Created on : 25-sep-2016, 15:11:32
    Author     : Icchigo
--%>
<%@page import="modelo.Ciudadano"%>
<%@page import="java.util.ArrayList"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>)sesion.getAttribute("usuario");
    
    if(usuario.get(0).getTipoUsuario()==1){
%>
<div class="menu">
    <ul class="list">
        <li class="header">MENÚ</li>
        <li class="active">
            <a href="tse.jsp">
                <i class="material-icons">home</i>
                <span>Inicio</span>
            </a>
        </li>
        <li class="header">Configuración del Sistema</li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons col-black">settings</i>
                <span>Configuraciones</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="configuracion_inicial.jsp">Configuracion Inicial</a>
                </li>
                <li>
                    <a href="apertura_jrv.jsp">Apertura de JRV</a>
                </li>
                <li>
                    <a href="cierre_jrv.jsp">Cierre de JRV</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="importar_registros.jsp">
                <i class="material-icons col-black">cloud_upload</i>
                <span>Imporatar Registros CNR</span>
            </a>
        </li>

    </ul>
</div>
<%
} else {
%>
<div class="menu">
    <ul class="list">
        <li class="header">MENÚ</li>
    </ul>
</div>
<%
    }
%>