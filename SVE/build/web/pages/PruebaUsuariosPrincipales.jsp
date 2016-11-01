<%-- 
    Document   : PruebaUsuariosPrincipales
    Created on : 10-29-2016, 09:42:45 AM
    Author     : carlos
--%>

<%@page import="modelo.MunicipioDTO"%>
<%@page import="modelo.Ciudadano"%>
<%@page import="modelo.CiudadanoDTO"%>
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
                $("#rdbMasculino").attr("checked", true);
                $("#btnModificar").attr("disabled","disabled");
                //alert("Columnas: " + $("td[data-rol=2]").length);
                $("#btnAgregar").on("click", function () {
                    var magistrados = $("td[data-rol=2]").length;
                    var cnr = $("td[data-rol=3]").length;
                    var tse = $("td[data-rol=6]").length;
                    //variables enviadas por ajax
                    var dui = $("#txtDui").val();
                    var nombre = $("#txtNombre").val();
                    var apellido = $("#txtApellido").val();
                    var sexo = $("input[name=rbdSexo]:checked").val();
                    var fecha = $("#txtFecha").val();
                    var departamento = $("#slDepartamento").val();
                    var municipio = $("#slMunicipio").val();
                    var direccion = $("#txtDireccion").val();
                    var tipo = $("#slTipoUsuario").val();
                    //bandera que decide si se envia la informacion
                    var bandera = false;
                    //se comprueba que se puedan ingresar magistrados
                    if (tipo == 2) {
                        //se permiten solo 5 magistrados
                        if (magistrados <= 4) {
                            bandera = true;
                        }
                        else {
                            alert("El maximo de magistrados en 5");
                        }
                    }
                    //se comprueba que se pueda ingresar un representante cnr
                    if (tipo == 3) {
                        //se permite un representante del cnr
                        if (cnr < 1) {
                            bandera = true;
                        }
                        else {
                            alert("El maximo de cnr es 1");
                        }
                    }
                    //se comprueba que se pueda ingresar un director de tse
                    if (tipo == 6) {
                        //Se permite un director de tse
                        if (tse < 1) {
                            bandera = true;
                        }
                        else {
                            alert("El maximo de tse es 1");
                        }
                    }
                    if (bandera == true && $("#txtResultado").val() == "1") {
                        $.post('../SerUsuariosPrincipales', {
                            btnAgregar: 'true',
                            txtDui: dui,
                            txtNombre: nombre,
                            txtApellido: apellido,
                            rdbSexo: sexo,
                            txtFecha: fecha,
                            slDepartamento: departamento,
                            slMunicipio: municipio,
                            txtDireccion: direccion,
                            slTipo: tipo
                        }, function (data) {
                            $("#divUsuarios").html(data);
                            //actualizamos el div que muestra la cantidad de usuarios registrados
                            var magistrados = $("td[data-rol=2]").length;
                            var cnr = $("td[data-rol=3]").length;
                            var tse = $("td[data-rol=6]").length;
                            //impresion de cuenta de usuarios
                            $("#divRegistros").html("Magistrados: " + magistrados + "<br>");
                            $("#divRegistros").append("CNR: " + cnr + "<br>");
                            $("#divRegistros").append("TSE: " + tse);
                            //limpieza del formulario
                            $("#frmUsuarios")[0].reset();
                            $("#divUsuario").html('<input type="hidden" value="0" id="txtResultado">');
                        });
                    }
                    //mensaje en caso de ingresar un dui en uso
                    if ($("#txtResultado").val() == "0") {
                        alert("Ingresa un dui que no este en uso");
                    }
                });

                //verifica que el dui ingresado sea valido
                $("#txtDui").on("keyup", function () {
                    var dui = $("#txtDui").val();
                    var longitud = dui.length;
                    if (longitud >= 10) {
                        $.post("../SerUsuariosPrincipales", {
                            btnBuscar: 'true',
                            txtDui: dui
                        }, function (data) {
                            $("#divUsuario").html(data);
                        });
                    }
                    else {
                        $("#divUsuario").html("<input type='hidden' value='0' id='txtResultado'>");
                    }
                });
                //modificar la informacion del usuario, no se puede cambiar el tipo de usuario
                //si se ha llegado al limite de usuarios creados de ese tipo
                //ya que hay una candidad establecida de usuarios a registrar, no se puede modificar el tipo de usuario
                $("#btnModificar").on("click", function () {
                    if ($("#txtResultado").val() == 1) {
                        //variables enviadas por ajax
                        var id = $("#txtId").val();
                        var dui = $("#txtDui").val();
                        var nombre = $("#txtNombre").val();
                        var apellido = $("#txtApellido").val();
                        var sexo = $("input[name=rbdSexo]:checked").val();
                        var fecha = $("#txtFecha").val();
                        var departamento = $("#slDepartamento").val();
                        var municipio = $("#slMunicipio").val();
                        var direccion = $("#txtDireccion").val();
                        var tipo = $("#slTipoUsuario").val();

                        $.post('../SerUsuariosPrincipales', {
                            btnModificar: 'true',
                            txtId: id,
                            txtDui: dui,
                            txtNombre: nombre,
                            txtApellido: apellido,
                            rdbSexo: sexo,
                            txtFecha: fecha,
                            slDepartamento: departamento,
                            slMunicipio: municipio,
                            txtDireccion: direccion,
                            slTipo: tipo
                        }, function (data) {
                            $("#divUsuarios").html(data);
                            //actualizamos el div que muestra la cantidad de usuarios registrados
                            var magistrados = $("td[data-rol=2]").length;
                            var cnr = $("td[data-rol=3]").length;
                            var tse = $("td[data-rol=6]").length;
                            //impresion de la cuenta de usuarios
                            $("#divRegistros").html("Magistrados: " + magistrados + "<br>");
                            $("#divRegistros").append("CNR: " + cnr + "<br>");
                            $("#divRegistros").append("TSE: " + tse);
                            //desactivacion y activacion de campos
                            $("#slTipoUsuario").prop('disabled',false);
                            $("#btnModificar").prop('disabled','disabled');
                            $("#btnAgregar").prop('disabled',false);
                            $("#frmUsuarios")[0].reset();
                            $("#divUsuario").html('<input type="hidden" value="0" id="txtResultado">');
                        });

                    }
                    else {
                        alert("Ingresa un dui que no este en uso");
                    }
                });
            });
            function cargar(idUsuario, dui, nombre, apellido, sexo, fecha, departamento, municipio, direccion, tipoUsuario) {
                $("#txtId").val(idUsuario);
                $("#txtDui").val(dui);
                $("#txtNombre").val(nombre);
                $("#txtApellido").val(apellido);
                //se cargan de nuevo los input, si los seleccionaba de la forma normal, cambiando
                //la propiedad checked, solo se cambiaba una vez, luego ya no funcionaba
                if (sexo === "m") {
                    $("#divSexo").html('<input type="radio" value="m" id="rdbMasculino" name="rbdSexo" checked="checked">Masculino');
                    $("#divSexo").append('<input type="radio" value="f" id="rdbFemenino" name="rbdSexo">Femenino');
                }
                else {
                    $("#divSexo").html('<input type="radio" value="m" id="rdbMasculino" name="rbdSexo">Masculino');
                    $("#divSexo").append('<input type="radio" value="f" id="rdbFemenino" name="rbdSexo" checked="checked">Femenino');
                }
                $("#txtFecha").val(fecha);
                $("#slDepartamento").val(departamento);
                //luego de seleccionar departamento, debo cargar nuevamente los municipios
                $.post('../SerDepartamento', {
                    dep: departamento
                }, function (data) {
                    //Se cargan los municipios
                    $("#divMunicipio").html(data);
                    //se selecciona el municipio 
                    $("#slMunicipio").val(municipio);
                });
                $("#txtDireccion").val(direccion);
                $("#slTipoUsuario").val(tipoUsuario);
                //Se cambia el valor de este campo a 1, para que no sea necesario buscar de nuevo
                //el numero de dui del usuario seleccionado
                $("#divUsuario").html('<input type="hidden" value="1" id="txtResultado">');
                //deshabilitamos el combo de tipo de usuario, para evitar que cambie ese campo
                $("#slTipoUsuario").prop('disabled','disabled');
                $("#btnModificar").prop('disabled',false);
                $("#btnAgregar").prop('disabled','disabled');
    }
        </script>
    </head>
    <body>
        <h1>Usuarios principales</h1>
        <form method="post" id="frmUsuarios" action="../SerUsuariosPrincipales">
            <input type="hidden" name="txtId" id="txtId">
            Dui: <input type="text" id="txtDui" name="txtDui" maxlength="10">
            <!--Se carga el mensaje de validacion del dui-->
            <label id="divUsuario">
                <input type="hidden" value="0" id="txtResultado">
            </label>
            <br>
            Nombre: <input type="text" id="txtNombre" name="txtNombre"><br>
            Apellido: <input type="text" id="txtApellido" name="txtApellido"><br>
            Sexo: 
            <label id="divSexo">
                <input type="radio" value="m" id="rdbMasculino" name="rbdSexo">Masculino
                <input type="radio" value="f" id="rdbFemenino" name="rbdSexo">Femenino
            </label>
            <br>
            Fecha Nacimiento: <input type="date" id="txtFecha" name="txtFecha"><br>
            Departamento: 
            <select id="slDepartamento" name="slDepartamento">
                <option value="0">---Seleccione---</option>
                <% for (Departamento dep : DepartamentoDTO.mostrarDepartamentos()) {%>
                <option value="<%= dep.getIdDepartamento()%>"><%= dep.getDepartamento()%></option>
                <% }%>
            </select>
            <!--Aca se cargan dinamicamente los municipios-->
            <div id="divMunicipio">
                Municipio: <select name="slMunicipio"></select>
            </div>
            Direccion: <input type="text" name="txtDireccion" id="txtDireccion"><br>
            Tipo de usuario: 
            <select name="slTipoUsuario" id="slTipoUsuario">
                <option value="2">Magistrado</option>
                <option value="3">Representante CNR</option>
                <option value="6">Director TSE</option>
            </select>
            <br>
            <input type="button" id="btnAgregar" name="btnAgregar" value="Agregar">
            <input type="button" id="btnModificar" name="btnModificar" value="Modificar">
        </form>
        <!--Muestra un conteo con los usuario registrados-->
        <div id="divRegistros">
            Magistrados: <%= CiudadanoDTO.mostrarUsuarios(2, 0).size()%><br>
            CNR: <%= CiudadanoDTO.mostrarUsuarios(3, 0).size()%><br>
            TSE: <%= CiudadanoDTO.mostrarUsuarios(6, 0).size()%>
        </div>
        <table>
            <tr>
                <th>Dui</th>
                <th>Nombre</th>
                <th>Sexo</th>
                <th>Usuario</th>
                <th>Fecha Nacimiento</th>
                <th>Ubicacion</th>
                <th>Direccion</th>
                <th></th>
            </tr>
            <!--Se cargan dinamicamente los usuarios en el tbody-->
            <tbody id="divUsuarios">
                <% for (Ciudadano us : CiudadanoDTO.mostrarUsuariosPrincipales()) {%>
                <tr>
                    <td><%= us.getNumDui()%></td>
                    <td><%= us.getApellido()%>, <%= us.getNombre()%></td>
                    <td>
                        <%
                            if (us.getSexo().equals("m")) {
                                out.print("Masculino");
                            } else {
                                out.print("Femenino");
                            }
                        %>
                    </td>
                    <td data-rol="<%= us.getTipoUsuario()%>"><%= us.getRol()%></td>
                    <td><%= us.getFechaNac()%></td>
                    <td><%= DepartamentoDTO.mostrarDepartamento(us.getIdDepartamento()).getDepartamento()%>, <%= MunicipioDTO.mostrarUnMunicipio(us.getIdMunicipio()).getNombreMunicipio()%></td>
                    <td><%= us.getDireccion()%></td>
                    <td>
                        <a href="javascript:cargar('<%=us.getIdUsuario()%>','<%=us.getNumDui()%>','<%=us.getNombre()%>','<%=us.getApellido()%>','<%=us.getSexo()%>','<%=us.getFechaNac()%>','<%=us.getIdDepartamento()%>','<%=us.getIdMunicipio()%>','<%=us.getDireccion()%>','<%=us.getTipoUsuario()%>')">Modificar</a>
                    </td>
                </tr>
                <% }%>

            </tbody>
        </table>
    </body>
</html>
