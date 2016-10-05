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
public class SupervisorDTO {
    static PreparedStatement pst;
    static ResultSet rs;
    private static final Conexion con = Conexion.conectar();
    
    public SupervisorDTO() {}
    public static boolean agregarSupervisor(SupervisorExt sup) {
        String query = "select agregarSupervisor(?,?,?,?,?,?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, sup.getIdentificacion());
            pst.setString(2, sup.getContrasenia());
            pst.setString(3, sup.getNombre());
            pst.setString(4, sup.getApellido());
            pst.setString(5, sup.getSexo());
            pst.setString(6, sup.getPais());
            pst.setString(7, sup.getOrganizacion());
            pst.execute();
            System.out.println(pst);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            con.desconectar();
        }
    }
    
    
    public static SupervisorExt entrarSupervisor(String identificacion, String contrasenia) {
        SupervisorExt sup = new SupervisorExt();
        String query = "select * from entrarSupervisor(?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1,identificacion);
            pst.setString(2,contrasenia);
            rs = pst.executeQuery();
            while(rs.next()) {
                sup.setIdUsuario(rs.getInt("id_usuario"));
                sup.setIdentificacion(rs.getString("identificacion"));
                sup.setContrasenia(rs.getString("contrasenia"));
                sup.setNombre(rs.getString("nombre"));
                sup.setApellido(rs.getString("apellido"));
                sup.setSexo(rs.getString("sexo"));
                sup.setConfirmacion(rs.getInt("confirmacion"));
                sup.setTipoUsuario(rs.getInt("id_tipo_usuario"));
                sup.setPais(rs.getString("pais"));
                sup.setOrganizacion(rs.getString("organizacion"));
            }
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        finally {
            con.desconectar();
        }
        return sup;
    }
    /*
    public static void main(String[] args) {
 
        SupervisorExt s = new SupervisorExt();
        s.setIdentificacion("6555-11");
        s.setContrasenia("543211");
        s.setNombre("Carlos Eliseo");
        s.setApellido("Menjivar Batres");
        s.setSexo("m");
        s.setPais("Venezuela");
        s.setOrganizacion("FBI");
        System.out.println(agregarSupervisor(s));
  
        SupervisorExt sup = entrarSupervisor("110002-0","543210");
        if(sup.getIdentificacion() != null) {
            System.out.println("Nombre: " + sup.getNombre());
            System.out.println("Apellido: " + sup.getApellido());
        }
        else {
            System.out.println("No te conozco");
        }

    }
    */
}
