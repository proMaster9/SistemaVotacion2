/* 
    Name Class   : Centro Votación 
    Created on   : 12-sep-2016, 2:52:33
    Author       : JH
 */
package clases;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Icchigo
 */
public class Login {
    private String user;
    private String pass;

    public Login(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    

}
