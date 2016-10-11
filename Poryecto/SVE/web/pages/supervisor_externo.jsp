<%-- 
    Document   : supervisor_externo
    Created on : 11-oct-2016, 2:03:43
    Author     : Icchigo
--%>
<%@page import="modelo.SupervisorDTO"%>
<%@page import="modelo.SupervisorExt"%>
<%@page import="modelo.Ciudadano"%>
<%@page contentType="text/html" import="java.util.*" pageEncoding="UTF-8" session="true"%>
<%
    HttpSession sesion = request.getSession();
    ArrayList<Ciudadano> usuario = (ArrayList<Ciudadano>) sesion.getAttribute("usuario");
    if (usuario != null) {
        if (usuario.get(0).getNumDui() != null && usuario.get(0).getNumDui() != null && sesion.getAttribute("key") != null) {
%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Supervisor Externo | TSE</title>
        <jsp:include page="modulos/head.jsp"/>
        <script>
            $(document).on("ready", function () {
                //esta funcion muestra al publicista que se agrego
                $("#btnPublicista").on("click", function () {
                    var dui = $("#txtDuiPublicista").val();
                    $.post('../SerDirectorTSE', {
                        duiPublicista: dui
                    }, function (e) {
                        $("#divPublicista").html(e);
                    });
                });
            });
        </script>
        <script>
            function modificarSupervisor(id, identificacion, nombre, apellido, sexo, pais, organizacion) {
                document.frmSupervisor.txtIdUsuario.value = id;
                document.frmSupervisor.txtIdentificacion.value = identificacion;
                document.frmSupervisor.txtNombre.value = nombre;
                document.frmSupervisor.txtApellido.value = apellido;
                document.frmSupervisor.txtPais.value = pais;
                document.frmSupervisor.txtOrganizacion.value = organizacion;
                if (sexo == "m") {
                    document.frmSupervisor.txtSexo[0].checked = true;
                } else {
                    document.frmSupervisor.txtSexo[1].checked = true;
                }
            }
        </script>
    </head>

    <body class="theme-light-blue">
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Top Bar -->
        <jsp:include page="modulos/navbar.jsp"/>
        <!-- #Top Bar -->

        <section>
            <!-- Left Sidebar -->
            <aside id="leftsidebar" class="sidebar">
                <!-- Menu -->
                <%
                    if (usuario.get(0).getTipoUsuario() == 1) {
                %>
                <jsp:include page="modulos/menu_admin.jsp"/>
                <%
                } else if (usuario.get(0).getTipoUsuario() == 2) {
                %>
                <jsp:include page="modulos/menu_magis.jsp"/>
                <%
                } else if (usuario.get(0).getTipoUsuario() == 3) {
                %>
                <jsp:include page="modulos/menu_cnr.jsp"/>
                <%
                } else if (usuario.get(0).getTipoUsuario() == 4) {
                %>

                <%
                } else if (usuario.get(0).getTipoUsuario() == 5) {
                %>

                <%
                } else if (usuario.get(0).getTipoUsuario() == 6) {
                %>
                <jsp:include page="modulos/menu_director_tse.jsp"/>
                <%
                    }
                %>
                <!-- #Menu -->
                <!-- Footer -->
                <jsp:include page="modulos/footer.jsp"/>
                <!-- #Footer -->
            </aside>
            <!-- #END# Left Sidebar -->
            <!-- Right Sidebar -->
            <aside id="rightsidebar" class="right-sidebar">
                <jsp:include page="modulos/opciones.jsp"/>
            </aside>
            <!-- #END# Right Sidebar -->
        </section>

        <section class="content">
            <div class="container-fluid">
                <div class="block-header">
                    <h2></h2>
                </div>
            </div>
            <div class="row clearfix" >
                <!-- Configuracion Inicial -->
                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div class="card">
                        <div class="header bg-light-blue">
                            <h2>Agregar Supervisor Externo</h2>
                            <ul class="header-dropdown m-r-0">
                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="material-icons">info_outline</i>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="material-icons">help_outline</i>
                                    </a>
                                </li>
                            </ul>

                        </div>
                        <div class="body">
                            <div class="row clearfix">
                                <div class="col-xs-12 col-sm-4 col-md-4 col-lg-4">
                                    <div class="row clearfix">
                                        <div class="demo-google-material-icon">
                                            <i class="material-icons col-green icons-align">group_add</i>
                                            <span>Registrar Supervisor</span>
                                        </div>
                                    </div>
                                    <form method="post" action="../SerDirectorTSE" name="frmSupervisor">
                                        <div class="row clearfix">
                                            <input type="hidden" name="usuario" value="supervisor">
                                            <input type="hidden" name="txtIdUsuario">
                                        </div>

                                        <div class="row clearfix">
                                            <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                <label>Identificación:</label>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="txtIdentificacion" placeholder="Ingresar identificación:">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                <label>Nombre:</label>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="txtNombre" placeholder="Ingresar nombre">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                <label>Apellido:</label>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="txtApellido" placeholder="Ingresar apellido">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-md-12">
                                                <div class="form-group align-center">
                                                    <input type="radio" name="txtSexo" value="m">M
                                                    <input type="radio" name="txtSexo" value="f">F

                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                <label>País:</label>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="txtPais" placeholder="Ingresar país">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row clearfix">
                                            <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                                <label>Organización:</label>
                                            </div>
                                            <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                                <div class="form-group">
                                                    <div class="form-line">
                                                        <input type="text" class="form-control" name="txtOrganizacion" placeholder="Ingresar organización">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn bg-light-blue waves-effect" name="btnAgregar">Agregar</button>
                                        <button type="reset" class="btn bg-light-blue waves-effect">Limpiar</button>
                                        <button type="submit" class="btn bg-light-blue waves-effect" name="btnModificar">Modificar</button>
                                    </form>

                                </div>
                                <div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">
                                    <!-- Datos Table -->
                                    <div class="row clearfix">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Usuarios a Registrar
                                                        <small>Al registrar los usuairos podran tener acceso al sistema</small>
                                                    </h2>
                                                </div>
                                                <div class="body table-responsive">
                                                    <table class="table table-bordered">
                                                        <thead>
                                                            <tr>

                                                                <th>Identificaicon</th>
                                                                <th>Nombre</th>
                                                                <th>Sexo</th>
                                                                <th>País</th>
                                                                <th>Organización</th>
                                                                <th>Acciones:</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <%
                                                                ArrayList<SupervisorExt> sup = SupervisorDTO.mostrarSupervisores();
                                                                for (SupervisorExt lista : sup) {
                                                            %>
                                                            <tr>

                                                                <td><%= lista.getIdentificacion()%></td>
                                                                <td><%= lista.getApellido()%>, <%= lista.getNombre()%></td>
                                                                <td><%= lista.getSexo()%></td>
                                                                <td><%= lista.getPais()%></td>
                                                                <td><%= lista.getOrganizacion()%></td>
                                                                <td>
                                                                    <a href="javascript:modificarSupervisor('<%= lista.getIdUsuario()%>','<%= lista.getIdentificacion()%>','<%= lista.getNombre()%>','<%= lista.getApellido()%>','<%= lista.getSexo()%>','<%= lista.getPais()%>','<%= lista.getOrganizacion()%>')">Modificar</a>
                                                                    <a href="../SerDirectorTSE?idSupervisor=<%= lista.getIdUsuario()%>">Eliminar</a>
                                                                </td>
                                                            </tr>
                                                            <% }%>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- #END# Datos Table -->
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- #END# Configuracion Inicial -->


        </section>
        <jsp:include page="modulos/scripts.jsp"/>

    </body>
</html>
<%
        } else {
            response.sendRedirect("notificacion/tse_aviso.jsp");
        }
    } else if (sesion.getAttribute("key") != null) {
        response.sendRedirect("../cerrar_sesion");
    }
%>
