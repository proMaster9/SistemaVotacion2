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
    public static boolean agregarSupervisor(SupervisorExt supervisor) {
        String query = "select agregarSupervisor(?,?,?,?,?,?,?)";
        try {
            pst = con.getCnn().prepareStatement(query);
            pst.setString(1, supervisor.getIdentificacion());
            pst.setString(2, supervisor.getContrasenia());
            pst.setString(3, supervisor.getNombre());
            pst.setString(4, supervisor.getApellido());
            pst.setString(5, supervisor.getSexo());
            pst.setString(6, supervisor.getPais());
            pst.setString(7, supervisor.getOrganizacion());
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
    }
}
