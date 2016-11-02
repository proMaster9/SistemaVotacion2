package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.MunicipioDTO;
import modelo.Ciudadano;
import modelo.CiudadanoDTO;
import modelo.Departamento;
import modelo.DepartamentoDTO;

public final class PruebaUsuariosPrincipales_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"../plugins/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"../js/funciones.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).on(\"ready\", function () {\n");
      out.write("                $(\"#rdbMasculino\").attr(\"checked\", true);\n");
      out.write("                //alert(\"Columnas: \" + $(\"td[data-rol=2]\").length);\n");
      out.write("                $(\"#btnAgregar\").on(\"click\", function () {\n");
      out.write("                    var magistrados = $(\"td[data-rol=2]\").length;\n");
      out.write("                    var cnr = $(\"td[data-rol=3]\").length;\n");
      out.write("                    var tse = $(\"td[data-rol=6]\").length;\n");
      out.write("                    //variables enviadas por ajax\n");
      out.write("                    var dui = $(\"#txtDui\").val();\n");
      out.write("                    var nombre = $(\"#txtNombre\").val();\n");
      out.write("                    var apellido = $(\"#txtApellido\").val();\n");
      out.write("                    var sexo = $(\"input[name=rbdSexo]:checked\").val();\n");
      out.write("                    var fecha = $(\"#txtFecha\").val();\n");
      out.write("                    var departamento = $(\"#slDepartamento\").val();\n");
      out.write("                    var municipio = $(\"#slMunicipio\").val();\n");
      out.write("                    var direccion = $(\"#txtDireccion\").val();\n");
      out.write("                    var tipo = $(\"#slTipoUsuario\").val();\n");
      out.write("                    //bandera que decide si se envia la informacion\n");
      out.write("                    var bandera = false;\n");
      out.write("                    //se comprueba que se puedan ingresar magistrados\n");
      out.write("                    if (tipo == 2) {\n");
      out.write("                        //se permiten solo 5 magistrados\n");
      out.write("                        if (magistrados <= 5) {\n");
      out.write("                            bandera = true;\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            alert(\"El maximo de magistrados en 5\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    //se comprueba que se pueda ingresar un representante cnr\n");
      out.write("                    if (tipo == 3) {\n");
      out.write("                        //se permite un representante del cnr\n");
      out.write("                        if (cnr < 2) {\n");
      out.write("                            bandera = true;\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            alert(\"El maximo de cnr es 1\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    //se comprueba que se pueda ingresar un director de tse\n");
      out.write("                    if (tipo == 6) {\n");
      out.write("                        //Se permite un director de tse\n");
      out.write("                        if (tse < 2) {\n");
      out.write("                            bandera = true;\n");
      out.write("                        }\n");
      out.write("                        else {\n");
      out.write("                            alert(\"El maximo de tse es 1\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    if (bandera == true && $(\"#txtResultado\").val() == \"1\") {\n");
      out.write("                        $.post('../SerUsuariosPrincipales', {\n");
      out.write("                            btnAgregar: 'true',\n");
      out.write("                            txtDui: dui,\n");
      out.write("                            txtNombre: nombre,\n");
      out.write("                            txtApellido: apellido,\n");
      out.write("                            rdbSexo: sexo,\n");
      out.write("                            txtFecha: fecha,\n");
      out.write("                            slDepartamento: departamento,\n");
      out.write("                            slMunicipio: municipio,\n");
      out.write("                            txtDireccion: direccion,\n");
      out.write("                            slTipo: tipo\n");
      out.write("                        }, function (data) {\n");
      out.write("                            $(\"#divUsuarios\").html(data);\n");
      out.write("                            //actualizamos el div que muestra la cantidad de usuarios registrados\n");
      out.write("                            var magistrados = $(\"td[data-rol=2]\").length;\n");
      out.write("                            var cnr = $(\"td[data-rol=3]\").length;\n");
      out.write("                            var tse = $(\"td[data-rol=6]\").length;\n");
      out.write("                            $(\"#divRegistros\").html(\"Magistrados: \" + magistrados + \"<br>\");\n");
      out.write("                            $(\"#divRegistros\").append(\"CNR: \" + cnr + \"<br>\");\n");
      out.write("                            $(\"#divRegistros\").append(\"TSE:\" + tse);\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                    //mensaje en caso de ingresar un dui en uso\n");
      out.write("                    if ($(\"#txtResultado\").val() == \"0\") {\n");
      out.write("                        alert(\"Ingresa un dui que no este en uso\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                //verifica que el dui ingresado sea valido\n");
      out.write("                $(\"#txtDui\").on(\"keyup\", function () {\n");
      out.write("                    var dui = $(\"#txtDui\").val();\n");
      out.write("                    var longitud = dui.length;\n");
      out.write("                    if (longitud >= 10) {\n");
      out.write("                        $.post(\"../SerUsuariosPrincipales\", {\n");
      out.write("                            btnBuscar: 'true',\n");
      out.write("                            txtDui: dui\n");
      out.write("                        }, function (data) {\n");
      out.write("                            $(\"#divUsuario\").html(data);\n");
      out.write("                        });\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        $(\"#divUsuario\").html(\"<input type='hidden' value='0' id='txtResultado'>\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                //modificar la informacion del usuario, no se puede cambiar el tipo de usuario\n");
      out.write("                //si se ha llegado al limite de usuarios creados de ese tipo\n");
      out.write("                $(\"#btnModificar\").on(\"click\", function () {\n");
      out.write("                    if ($(\"#txtResultado\").val() == 1) {\n");
      out.write("                        //envio\n");
      out.write("                        var magistrados = $(\"td[data-rol=2]\").length;\n");
      out.write("                        var cnr = $(\"td[data-rol=3]\").length;\n");
      out.write("                        var tse = $(\"td[data-rol=6]\").length;\n");
      out.write("                        //variables enviadas por ajax\n");
      out.write("                        var id = $(\"#txtId\").val();\n");
      out.write("                        var dui = $(\"#txtDui\").val();\n");
      out.write("                        var nombre = $(\"#txtNombre\").val();\n");
      out.write("                        var apellido = $(\"#txtApellido\").val();\n");
      out.write("                        var sexo = $(\"input[name=rbdSexo]:checked\").val();\n");
      out.write("                        var fecha = $(\"#txtFecha\").val();\n");
      out.write("                        var departamento = $(\"#slDepartamento\").val();\n");
      out.write("                        var municipio = $(\"#slMunicipio\").val();\n");
      out.write("                        var direccion = $(\"#txtDireccion\").val();\n");
      out.write("                        var tipo = $(\"#slTipoUsuario\").val();\n");
      out.write("                        //bandera que decide si se envia la informacion\n");
      out.write("                        var bandera = false;\n");
      out.write("                        //se comprueba que se puedan ingresar magistrados\n");
      out.write("                        if (tipo == 2) {\n");
      out.write("                            //se permiten solo 5 magistrados\n");
      out.write("                            if (magistrados <= 5) {\n");
      out.write("                                bandera = true;\n");
      out.write("                            }\n");
      out.write("                            else {\n");
      out.write("                                alert(\"El maximo de magistrados en 5\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        //se comprueba que se pueda ingresar un representante cnr\n");
      out.write("                        if (tipo == 3) {\n");
      out.write("                            //se permite un representante del cnr\n");
      out.write("                            if (cnr < 2) {\n");
      out.write("                                bandera = true;\n");
      out.write("                            }\n");
      out.write("                            else {\n");
      out.write("                                alert(\"El maximo de cnr es 1\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        //se comprueba que se pueda ingresar un director de tse\n");
      out.write("                        if (tipo == 6) {\n");
      out.write("                            //Se permite un director de tse\n");
      out.write("                            if (tse < 2) {\n");
      out.write("                                bandera = true;\n");
      out.write("                            }\n");
      out.write("                            else {\n");
      out.write("                                alert(\"El maximo de tse es 1\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                        if (bandera == true && $(\"#txtResultado\").val() == \"1\") {\n");
      out.write("                            $.post('../SerUsuariosPrincipales', {\n");
      out.write("                                btnModificar: 'true',\n");
      out.write("                                txtId : id,\n");
      out.write("                                txtDui: dui,\n");
      out.write("                                txtNombre: nombre,\n");
      out.write("                                txtApellido: apellido,\n");
      out.write("                                rdbSexo: sexo,\n");
      out.write("                                txtFecha: fecha,\n");
      out.write("                                slDepartamento: departamento,\n");
      out.write("                                slMunicipio: municipio,\n");
      out.write("                                txtDireccion: direccion,\n");
      out.write("                                slTipo: tipo\n");
      out.write("                            }, function (data) {\n");
      out.write("                                $(\"#divUsuarios\").html(data);\n");
      out.write("                                //actualizamos el div que muestra la cantidad de usuarios registrados\n");
      out.write("                                var magistrados = $(\"td[data-rol=2]\").length;\n");
      out.write("                                var cnr = $(\"td[data-rol=3]\").length;\n");
      out.write("                                var tse = $(\"td[data-rol=6]\").length;\n");
      out.write("                                $(\"#divRegistros\").html(\"Magistrados: \" + magistrados + \"<br>\");\n");
      out.write("                                $(\"#divRegistros\").append(\"CNR: \" + cnr + \"<br>\");\n");
      out.write("                                $(\"#divRegistros\").append(\"TSE:\" + tse);\n");
      out.write("                            });\n");
      out.write("                        }\n");
      out.write("                        //mensaje en caso de ingresar un dui en uso\n");
      out.write("                        if ($(\"#txtResultado\").val() == \"0\") {\n");
      out.write("                            alert(\"Ingresa un dui que no este en uso\");\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                    else {\n");
      out.write("                        alert(\"Ingresa un dui que no este en uso\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            function cargar(idUsuario, dui, nombre, apellido, sexo, fecha, departamento, municipio, direccion, tipoUsuario) {\n");
      out.write("                $(\"#txtId\").val(idUsuario);\n");
      out.write("                $(\"#txtDui\").val(dui);\n");
      out.write("                $(\"#txtNombre\").val(nombre);\n");
      out.write("                $(\"#txtApellido\").val(apellido);\n");
      out.write("                //se cargan de nuevo los input, si los seleccionaba de la forma normal, cambiando\n");
      out.write("                //la propiedad checked, solo se cambiaba una vez, luego ya no funcionaba\n");
      out.write("                if (sexo === \"m\") {\n");
      out.write("                    $(\"#divSexo\").html('<input type=\"radio\" value=\"m\" id=\"rdbMasculino\" name=\"rbdSexo\" checked=\"checked\">Masculino');\n");
      out.write("                    $(\"#divSexo\").append('<input type=\"radio\" value=\"f\" id=\"rdbFemenino\" name=\"rbdSexo\">Femenino');\n");
      out.write("                }\n");
      out.write("                else {\n");
      out.write("                    $(\"#divSexo\").html('<input type=\"radio\" value=\"m\" id=\"rdbMasculino\" name=\"rbdSexo\">Masculino');\n");
      out.write("                    $(\"#divSexo\").append('<input type=\"radio\" value=\"f\" id=\"rdbFemenino\" name=\"rbdSexo\" checked=\"checked\">Femenino');\n");
      out.write("                }\n");
      out.write("                $(\"#txtFecha\").val(fecha);\n");
      out.write("                $(\"#slDepartamento\").val(departamento);\n");
      out.write("                //luego de seleccionar departamento, debo cargar nuevamente los municipios\n");
      out.write("                $.post('../SerDepartamento', {\n");
      out.write("                    dep: departamento\n");
      out.write("                }, function (data) {\n");
      out.write("                    //Se cargan los municipios\n");
      out.write("                    $(\"#divMunicipio\").html(data);\n");
      out.write("                    //se selecciona el municipio \n");
      out.write("                    $(\"#slMunicipio\").val(municipio);\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\"#txtDireccion\").val(direccion);\n");
      out.write("                $(\"#slTipoUsuario\").val(tipoUsuario);\n");
      out.write("                //Se cambia el valor de este campo a 1, para que no sea necesario buscar de nuevo\n");
      out.write("                //el numero de dui del usuario seleccionado\n");
      out.write("                $(\"#divUsuario\").html('<input type=\"hidden\" value=\"1\" id=\"txtResultado\">');\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Usuarios principales</h1>\n");
      out.write("        <form method=\"post\" id=\"frmUsuarios\" action=\"../SerUsuariosPrincipales\">\n");
      out.write("            <input type=\"hidden\" name=\"txtId\" id=\"txtId\">\n");
      out.write("            Dui: <input type=\"text\" id=\"txtDui\" name=\"txtDui\" maxlength=\"10\">\n");
      out.write("            <!--Se carga el mensaje de validacion del dui-->\n");
      out.write("            <label id=\"divUsuario\">\n");
      out.write("                <input type=\"hidden\" value=\"0\" id=\"txtResultado\">\n");
      out.write("            </label>\n");
      out.write("            <br>\n");
      out.write("            Nombre: <input type=\"text\" id=\"txtNombre\" name=\"txtNombre\"><br>\n");
      out.write("            Apellido: <input type=\"text\" id=\"txtApellido\" name=\"txtApellido\"><br>\n");
      out.write("            Sexo: \n");
      out.write("            <label id=\"divSexo\">\n");
      out.write("                <input type=\"radio\" value=\"m\" id=\"rdbMasculino\" name=\"rbdSexo\">Masculino\n");
      out.write("                <input type=\"radio\" value=\"f\" id=\"rdbFemenino\" name=\"rbdSexo\">Femenino\n");
      out.write("            </label>\n");
      out.write("            <br>\n");
      out.write("            Fecha Nacimiento: <input type=\"date\" id=\"txtFecha\" name=\"txtFecha\"><br>\n");
      out.write("            Departamento: \n");
      out.write("            <select id=\"slDepartamento\" name=\"slDepartamento\">\n");
      out.write("                <option value=\"0\">--Seccione un aoption--</option>\n");
      out.write("                ");
 for (Departamento dep : DepartamentoDTO.mostrarDepartamentos()) {
      out.write("\n");
      out.write("                <option value=\"");
      out.print( dep.getIdDepartamento());
      out.write('"');
      out.write('>');
      out.print( dep.getDepartamento());
      out.write("</option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <!--Aca se cargan dinamicamente los municipios-->\n");
      out.write("            <div id=\"divMunicipio\">\n");
      out.write("                Municipio: <select name=\"slMunicipio\"></select>\n");
      out.write("            </div>\n");
      out.write("            Direccion: <input type=\"text\" name=\"txtDireccion\" id=\"txtDireccion\"><br>\n");
      out.write("            Tipo de usuario: \n");
      out.write("            <select name=\"slTipoUsuario\" id=\"slTipoUsuario\">\n");
      out.write("                <option value=\"2\">Magistrado</option>\n");
      out.write("                <option value=\"3\">Representante CNR</option>\n");
      out.write("                <option value=\"6\">Director TSE</option>\n");
      out.write("            </select>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"button\" id=\"btnAgregar\" name=\"btnAgregar\" value=\"Agregar\">\n");
      out.write("            <input type=\"button\" id=\"btnModificar\" name=\"btnModificar\" value=\"Modificar\">\n");
      out.write("        </form>\n");
      out.write("        <!--Muestra un conteo con los usuario registrados-->\n");
      out.write("        <div id=\"divRegistros\">\n");
      out.write("            Magistrados: ");
      out.print( CiudadanoDTO.mostrarUsuarios(2, 0).size());
      out.write("<br>\n");
      out.write("            CNR: ");
      out.print( CiudadanoDTO.mostrarUsuarios(3, 0).size());
      out.write("<br>\n");
      out.write("            TSE: ");
      out.print( CiudadanoDTO.mostrarUsuarios(6, 0).size());
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("                <th>Dui</th>\n");
      out.write("                <th>Nombre</th>\n");
      out.write("                <th>Sexo</th>\n");
      out.write("                <th>Usuario</th>\n");
      out.write("                <th>Fecha Nacimiento</th>\n");
      out.write("                <th>Ubicacion</th>\n");
      out.write("                <th>Direccion</th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("            <!--Se cargan dinamicamente los usuarios en el tbody-->\n");
      out.write("            <tbody id=\"divUsuarios\">\n");
      out.write("                ");
 for (Ciudadano us : CiudadanoDTO.mostrarUsuariosPrincipales()) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( us.getNumDui());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( us.getApellido());
      out.write(',');
      out.write(' ');
      out.print( us.getNombre());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        ");

                            if (us.getSexo().equals("m")) {
                                out.print("Masculino");
                            } else {
                                out.print("Femenino");
                            }
                        
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td data-rol=\"");
      out.print( us.getTipoUsuario());
      out.write('"');
      out.write('>');
      out.print( us.getRol());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( us.getFechaNac());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( DepartamentoDTO.mostrarDepartamento(us.getIdDepartamento()).getDepartamento());
      out.write(',');
      out.write(' ');
      out.print( MunicipioDTO.mostrarUnMunicipio(us.getIdMunicipio()).getNombreMunicipio());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( us.getDireccion());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"javascript:cargar('");
      out.print(us.getIdUsuario());
      out.write("','");
      out.print(us.getNumDui());
      out.write("','");
      out.print(us.getNombre());
      out.write("','");
      out.print(us.getApellido());
      out.write("','");
      out.print(us.getSexo());
      out.write("','");
      out.print(us.getFechaNac());
      out.write("','");
      out.print(us.getIdDepartamento());
      out.write("','");
      out.print(us.getIdMunicipio());
      out.write("','");
      out.print(us.getDireccion());
      out.write("','");
      out.print(us.getTipoUsuario());
      out.write("')\">Modificar</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}