<%-- 
    Document   : tse
    Created on : 09-oct-2016, 23:39:55
    Author     : JH
--%>

<%@page import="modelo.DepartamentoDTO"%>
<%@page import="modelo.Departamento"%>
<%@page import="modelo.MunicipioDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Municipio"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Usuarios Principales | TSE</title>
        <jsp:include page="modulos/head.jsp"/>
        <script>
            $(document).on("ready", function () {
                //agregar usuario principal
                $("#btnAgregar").on("click",function(){
                    var btn="agregar";
                    var tipo=$('select[id=slTipo]').val();
                    var dui=$("#txtDui").val();
                    var nom=$("#txtNombre").val();
                    var ape=$("#txtApellido").val();
                    var sexo = $("input:radio[name=rdSexo]:checked").val();
                    var mun=$('select[id=slMunicipio]').val();
                    var fecha= $("#txtFecha").val();
                    var dir=$("#txtDireccion").val();
                    alert("dato "+tipo+" "+dui+" "+nom+" "+ape+" "+sexo+" "+fecha+" "+dir+" "+mun);
                    $.post('../SerUsuariosPrincipales',{
                        accion:btn,
                        tipo:tipo,
                        dui:dui,
                        nom:nom,
                        ape:ape,
                        sexo:sexo,
                        fecha:fecha,
                        mun:mun,
                        dir:dir
                    },function(data){
                        $("#mostrarUsuarios").html(data);
                    });
                });
            });

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
                <jsp:include page="modulos/menu.jsp"/>
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
                <!--Formulario-->
                <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                    <div class="card">
                        <div class="header">
                            <h2>
                                <i class="material-icons icons-align col-light-blue">person_add</i>
                                AGREGAR USUARIO PRINCIPAL
                            </h2>
                            <ul class="header-dropdown m-r-0">
                                <li>
                                    <a data-toggle="modal" href="#modalInfoF" >
                                        <i class="material-icons col-light-blue">info_outline</i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="body">
                            <form id="formulario_magistrado">
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                        <label>Tipo Usuario:</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                        <div class="form-group">
                                            <select class="form-control show-tick" data-live-search="true" name="slTipo" id="slTipo">
                                                <option>Seleccione tipo usuario</option>
                                                <option value="2">Magistrado</option>
                                                <option value="3">Director CNR</option>
                                                <option value="6">Director TSE</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                        <label>DUI:</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="txtDui" id="txtDui" placeholder="Ingresar número DUI">
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
                                                <input type="text" class="form-control" id="txtNombre" name="txtNombre" placeholder="Ingresar nombre">
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
                                                <input type="text" class="form-control" id="txtApellido" name="txtApellido" placeholder="Ingresar apellido">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                        <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                            <label>Género:</label>
                                        </div>
                                        <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                            <div class="form-group">
                                                <input type="radio" name="rdSexo" value="M" id="male" class="with-gap radio-col-light-blue">
                                                <label for="male">Hombre</label>
                                                <input type="radio" name="rdSexo" id="female"  value="F"  class="with-gap radio-col-light-blue">
                                                <label for="female" class="m-l-20">Mujer</label>
                                            </div>
                                        </div>
                                    </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                        <label>Fecha Nacimiento:</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="date" class="form-control" name="txtFecha" id="txtFecha"  >
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                        <label>Dirección:</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                        <div class="form-group">
                                            <div class="form-line">
                                                <input type="text" class="form-control" name="txtDireccion" id="txtDireccion" placeholder="Ingresar domicilio">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-lg-4 col-md-4 col-sm-3 col-xs-6 form-control-label">
                                        <label>Municipio:</label>
                                    </div>
                                    <div class="col-lg-8 col-md-8 col-sm-9 col-xs-6">
                                        <div class="form-group">
                                            <select class="form-control show-tick" data-live-search="true" name="slMunicipio" id="slMunicipio" >
                                                <option>Seleccione municipio</option>
                                                <%
                                                ArrayList<Municipio> mun = MunicipioDTO.mostrarMunicipios();
                                                for(Municipio lista : mun){
                                                %>
                                                <option value="<%=lista.getIdMunicipio()%>"><%=lista.getNombreMunicipio()%></option>
                                                <%
                                                }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="row clearfix">
                                    <div class="col-md-12 align-center">
                                        <button type="button" class="btn bg-light-blue waves-effect waves-light" id="btnAgregar">Guardar</button>
                                        <button type="reset" class="btn bg-cyan waves-effect waves-light">Limpiar</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- #END# Formulario -->
                <!--Tabla-->
                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
                    <div class="card">
                        <div class="header">
                            <h2>
                                <i class="material-icons icons-align col-light-blue">assignment_ind</i>
                                USUARIOS PRINCIPALES REGISTRADOS EN EL SISTEMA
                            </h2>
                            <ul class="header-dropdown m-r-0">
                                <li>
                                    <a href="javascript:void(0);" >
                                        <i class="material-icons col-light-blue">save</i>
                                    </a>
                                </li>
                                <li>
                                    <a href="javascript:void(0);">
                                        <i class="material-icons col-light-blue">print</i>
                                    </a>
                                </li>
                                <li>
                                    <a data-toggle="modal" href="#modalInfoT" >
                                        <i class="material-icons col-light-blue">info_outline</i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="body table-responsive">
                            <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>DUI:</th>
                                        <th>Nombre:</th>
                                        <th>Apellido:</th>
                                        <th>Sexo:</th>
                                        <th>Municipio:</th>
                                        <th>Tipo Usuario:</th>
                                        <th>Opciones:</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>0000000-0</td>
                                        <td>Juan Carlos</td>
                                        <td>Lopez Avalos</td>
                                        <td>M</td>
                                        <td>Santa Tecla</td>
                                        <td>Administrador</td>
                                        <td>
                                            <button type="button" class="btn btn2 bg-cyan waves-effect m-r-0 waves-light" data-toggle="modal" data-target="#modalModificar" ><i class="material-icons">create</i></button>
                                            <button type="button" class="btn btn2 bg-grey waves-effect m-r-0 waves-light" data-toggle="modal" data-target="#modalEliminar" ><i class="material-icons">delete_forever</i></button>
                                        </td>
                                    </tr>
                                    <tr>
                                    
                                </tbody>
                            </table>
                            <div id="mostrarUsuarios"></div>
                        </div>
                    </div>
                </div>
                <!-- #END# Tabla -->
            </div>
            <!-- Modal Dialogs ====================================================================================================================== -->
            <!-- Modal Modificar -->
            <div class="modal fade" id="modalModificar" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="defaultModalLabel">Modificar</h4>
                        </div>
                        <div class="modal-body">
                            Formulario para modificar
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect">Guardar</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Modal Modificar -->
            <!-- Modal Eliminar -->
            <div class="modal fade" id="modalEliminar" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="defaultModalLabel">Eliminar</h4>
                        </div>
                        <div class="modal-body">
                            Formulario para eliminar
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect">Si, Eliminar</button>
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">No, Cancelar</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Modal Eliminar -->
            <!-- Modal Info F-->
            <div class="modal fade" id="modalInfoF" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="defaultModalLabel">Informacion sobre el formulario</h4>
                        </div>
                        <div class="modal-body">
                            Algunos datos que le podrian ayudar al usuario a registrar otros usuarios
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Ok</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Modal Info T -->
            <!-- Modal Info F-->
            <div class="modal fade" id="modalInfoT" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title" id="defaultModalLabel">Informacion sobre el Tabla</h4>
                        </div>
                        <div class="modal-body">
                            Datos sobre la tabla y los permisos que tienen esos usuarios
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-link waves-effect" data-dismiss="modal">Ok</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #END# Modal Info T -->
        </section>
        <jsp:include page="modulos/scripts.jsp"/>
    </body>
</html>
