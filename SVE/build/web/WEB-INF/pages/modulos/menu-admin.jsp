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
            <a href="tse-usuarios.jsp">
                <i class="material-icons">person</i>
                <span>Usuarios</span>
            </a>
        </li>
        <li>
            <a href="tse-partidos.jsp">
                <i class="material-icons">book</i>
                <span>Partidos Políticos</span>
            </a>
        </li>
        <li>
            <a href="tse-candidatos.jsp">
                <i class="material-icons">location_disabled</i>
                <span>Candidatos</span>
            </a>
        </li>
        <li>
            <a href="tse-centros-votacion.jsp">
                <i class="material-icons">location_disabled</i>
                <span>Centros Votación</span>
            </a>
        </li>
        <li>
            <a href="tse-centros-votacion.jsp">
                <i class="material-icons">location_disabled</i>
                <span>Observaciones</span>
            </a>
        </li>
        <li>
            <a href="tse-estado-elecciones.jsp">
                <i class="material-icons">location_disabled</i>
                <span>Estado Elecciones</span>
            </a>
        </li>
        <li>
            <a href="javascript:void(0);" class="menu-toggle">
                <i class="material-icons">location_disabled</i>
                <span>Usuarios</span>
            </a>
            <ul class="ml-menu">
                <li>
                    <a href="javascript:void(0);" class="menu-toggle">
                        <span>Supervisor Externo</span>
                    </a>
                    <ul class="ml-menu">
                        <li>
                            <a href="">Option 1</a>
                        </li>
                        <li>
                            <a href="">Option 2</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="javascript:void(0);" class="menu-toggle">
                        <span>Submenu</span>
                    </a>
                    <ul class="ml-menu">
                        <li>
                            <a href="">Option 1</a>
                        </li>
                        <li>
                            <a href="">Option 2</a>
                        </li>
                    </ul>
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
                    <a href="tse-configuracion-inicial.jsp">Configuracion Inicial</a>
                </li>
                <li>
                    <a href="tse-configuracion-inicial.jsp">Apertura de JRV</a>
                </li>
                <li>
                    <a href="tse-configuracion-inicial.jsp">Cierre de JRV</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="tse-importar-registros.jsp">
                <i class="material-icons">cloud_upload</i>
                <span>Imporatar Registros CNR</span>
            </a>
        </li>
        
    </ul>
</div>
