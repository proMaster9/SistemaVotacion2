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

/**
 *
 * @author NACHO
 */
public class CiudadanoDTO {

    static PreparedStatement pst;
    static ResultSet rs;
    private static final Conexion con = Conexion.conectar();

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

    public static void agregarUsuario(Ciudadano c) {
        int tipo = c.getTipoUsuario();
        if(tipo == 2 || tipo == 3 || tipo == 6) {
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
