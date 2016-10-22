<%-- 
    Document   : menu-admin
    Created on : 25-sep-2016, 15:11:32
    Author     : Icchigo
--%>

<div class="menu">
    <ul class="list">
        <li class="header">MENÚ</li>
        <li class="active">
            <a href="tse.jsp">
                <i class="material-icons">home</i>
                <span>Inicio</span>
            </a>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons col-black">group</i>
                <span>Usuarios</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="tse_usuarios_principales.jsp">Usuarios Principales</a>
                </li>
                <li>
                    <a href="tse_usuarios_secundarios.jsp">Usuarios Secundarios</a>
                </li>
                <li>
                    <a href="tse_usuarios_invitados.jsp">Usuarios Invitados</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons col-black">store</i>
                <span>Centros Votación</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="tse_centro_votacion.jsp">Centros Votación</a>
                </li>
                <li>
                    <a href="tse_asignacion_jrv.jsp">JRV</a>
                </li>
               
            </ul>
        </li>
        <li class="header">Configuración del Sistema</li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons col-black">settings</i>
                <span>Configuraciones</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="configuracion_inicial.jsp">Estado Elecciones</a>
                </li>
                <li>
                    <a href="tse_asignacion_jrv.jsp">Asignación de JRV</a>
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

<div class="menu">
    <ul class="list">
        <li class="header">MENÚ</li>
    </ul>
</div>
