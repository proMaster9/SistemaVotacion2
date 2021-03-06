/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JH
 */
public class Conexion {

    public static Conexion instance;
    private Connection cnn;

    private Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sistemavotacion", "postgres", "Itca");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized static Conexion conectar() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }

    public Connection getCnn() {
        return cnn;
    }

    public void desconectar() {
        instance = null;
    }

}
