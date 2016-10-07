/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NACHO
 */
public class CiudadanoDTO {

    static PreparedStatement pst;
    static ResultSet rs;
    private static final Conexion con = Conexion.conectar();

    /*
    inicio de sesion del administrador, recibe como parametros el usuarios
    y la contrasenia, esta funcion retorna un objeto Ciudadano.
    en caso de que las credenciales sean correctas el objeto retornado
    contiene los datos basicos del admi, para que puedan ser manipulados
    mediante sesiones segun sea la necesidad
    */
    public static Ciudadano entrarAdmi(String credencial, String contrasenia) {
        Ciudadano c = new Ciudadano();
        String query = "select * from entrarAdministrador(?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, credencial);
            pst.setString(2, contrasenia);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setNumDui(rs.getString("num_dui"));
                c.setContrasenia(rs.getString("contrasenia"));
                c.setConfirmacion(rs.getInt("confirmacion"));
                c.setTipoUsuario(rs.getInt("tipo_usuario"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return c;
    }

    /*
    esta funcion es utilizada por los usuarios principales del sistema que son
    los magistrados, usuario del cnr y director del tse.
    recibe como parametros las credenciales de usuario y retorna un objeto tipo
    Ciudadano con la informacion del usuario en caso de que las credenciales sean
    correctas, en caso contrario retorna un objeto vacio.
    son usuarios principales porque no necesitan aparecer en la tabla con los
    datos proporcionados del cnr para poder tener una cuenta en el sistema
    */
    public static Ciudadano entrarPrincipal(String credencial, String contrasenia) {
        Ciudadano c = new Ciudadano();
        String query = "select * from entrarPrincipal(?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, credencial);
            pst.setString(2, contrasenia);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setNumDui(rs.getString("num_dui"));
                c.setContrasenia(rs.getString("contrasenia"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setConfirmacion(rs.getInt("confirmacion"));
                c.setTipoUsuario(rs.getInt("tipo_usuario"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return c;
    }

    /*
    esta funcion es usada por los usuarios secundarios del sistema, que son
    el representante de partido, director de centro de votaciones, publicista,
    presidente de jrv y gestor de jrv.
    recibe como parametro las credenciales de usuario y retorna un objeto Ciudadano
    con los datos del usuario en caso de que las credenciales sean correctas,
    en caso contrario retorna un objeto vacio.
    son usuarios secundarios ya que para que posean una cuenta es necesario que
    aparezcan en los registros que el cnr nos proporciona
    */
    public static Ciudadano entrarSecundario(String credencial, String contrasenia) {
        Ciudadano c = new Ciudadano();
        String query = "select * from entrarSecundario(?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, credencial);
            pst.setString(2, contrasenia);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setNumDui(rs.getString("num_dui"));
                c.setContrasenia(rs.getString("contrasenia"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setConfirmacion(rs.getInt("confirmacion"));
                c.setTipoUsuario(rs.getInt("tipo_usuario"));
                c.setIdMunicipio(rs.getInt("id_municipio"));
                c.setIdDepartamento(rs.getInt("id_departamento"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return c;
    }

    /*
    funcion en la que inician sesion todos los usuarios que aparezcan en los registros
    del cnr, no importa si tienen una cuenta de usuario secundario, por esta funcion
    entrar como votantes.
    se reciben como parametros las credenciales de usuario, y se retorna un objeto
    con el tipo Ciudadano que contiene la información del votante, en caso contrario
    retorna el objeto vacio
    */
    public static Ciudadano entrarVotante(String credencial, String contrasenia) {
        Ciudadano c = new Ciudadano();
        String query = "select * from entrarVotante(?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, credencial);
            pst.setString(2, contrasenia);
            rs = pst.executeQuery();
            while (rs.next()) {
                c.setIdUsuario(rs.getInt("id_usuario"));
                c.setNumDui(rs.getString("num_dui"));
                c.setContrasenia(rs.getString("contrasenia"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setConfirmacion(rs.getInt("confirmacion"));
                c.setTipoUsuario(rs.getInt("tipo_usuario"));
                c.setIdMunicipio(rs.getInt("id_municipio"));
                c.setIdDepartamento(rs.getInt("id_departamento"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return c;
    }
<<<<<<< HEAD

    public static void agregarUsuario(Ciudadano c) {
        int tipo = c.getTipoUsuario();
        if(tipo == 2 || tipo == 3 || tipo == 6) {
=======
    
    /*
    en esta funcion se registran todos los usuarios del sistema a excepcion
    del supervisor externo.
    se recibe como parametro un objeto del tipo ciudadano y segun el valor 
    que tenga en su atributo tipoUsuario se registra como usuarioPrincipal
    o usuarioSecundario.
    se retorna true cuando el registro es un exito, en caso de fallas se
    retorna un false
    */
    public static void agregarUsuario(Ciudadano c) {
        int tipo = c.getTipoUsuario();
        String query;
        if(tipo == 2 || tipo == 3 || tipo == 6) {
            query = "select agregarPrincipal(?,?,?,?,?,?,?,?,?)";
            try {
                pst = con.getCnn().prepareStatement(query);
                pst.setString(1, c.getNumDui());
                pst.setString(2, c.getContrasenia());
                pst.setString(3, c.getNombre());
                pst.setString(4, c.getApellido());
                pst.setString(5, c.getFechaNac());
                pst.setString(6, c.getSexo());
                pst.setString(7, c.getDireccion());
                pst.setInt(8, c.getIdMunicipio());
                pst.setInt(9, tipo);
                pst.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(CiudadanoDTO.class.getName()).log(Level.SEVERE, null, ex);
            }
>>>>>>> origin/master
            System.out.println("Usuario principal");
        }
        else if(tipo == 5 || (tipo >= 7 && tipo <= 10)) {
            System.out.println("Usuario secundario");
        }
        else {
            System.out.println("Tipo de usuario incorrecto");
        }
    }
    public static void main(String[] args) {
        Ciudadano c = new Ciudadano();
        c.setTipoUsuario(2);
        agregarUsuario(c);
        c.setTipoUsuario(3);
        agregarUsuario(c);
        c.setTipoUsuario(6);
        agregarUsuario(c);
        c.setTipoUsuario(5);
        agregarUsuario(c);
        c.setTipoUsuario(8);
        agregarUsuario(c);
        c.setTipoUsuario(9);
        agregarUsuario(c);
        c.setTipoUsuario(10);
        agregarUsuario(c);
        c.setTipoUsuario(7);
        agregarUsuario(c);
        
        /*
        Ciudadano c = entrarAdmi("00000000-0","12345");
        if(c.getIdUsuario() != 0) {
            System.out.println("Hola: " + c.getNumDui());
        } else {
            System.out.println("Credenciales incorrectas");
        }
        */
    }

}
