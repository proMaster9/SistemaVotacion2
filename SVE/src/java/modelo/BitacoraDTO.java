/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import java.sql.*;
import conexion.Conexion;
import java.util.HashSet;
import java.util.Set;
import modelo.Bitacora;

/**
 *
 * @author roberto
 */
public class BitacoraBTO {
    PreparedStatement pst;
    ResultSet rs;
    Conexion con = new Conexion();
    
    public boolean AgregarBitacora(Bitacora bita){
        String consu = "insert into bitacoraAcciones(id_bitacora , fecha , hora , accion) values("
                + "? , ? , ? , ?)";
        
        try{
        pst = con.getCnn().prepareStatement(consu);
        pst.setInt(1, bita.getIdBitacora());
        pst.setString(2, bita.getFecha());
        pst.setString(3, bita.getHora());
        pst.setString(4, bita.getAccion());
        pst.execute();
        System.out.println("AgregarBitacora ejecutado exitosamente");
        return true;    
        
        }catch(Exception e){
        System.err.println("Error al ejecutar AgregarBitacora "+e);
        return false;
        }
    
    
    }
    
    public ArrayList<Bitacora> MostrarBitacora(){
        ArrayList<Bitacora> lista = new ArrayList<>();
        
        try{
        String consu = "select * from bitacoraAcciones";
        pst = con.getCnn().prepareStatement(consu);
        rs = pst.executeQuery();
        
        while(rs.next()){
         Bitacora bit = new Bitacora();
         
         bit.setIdBitacora(rs.getInt("id_bitacora"));
         bit.setFecha(rs.getString("fecha"));
         bit.setHora(rs.getString("hora"));
         bit.setAccion(rs.getString("accion"));
         lista.add(bit);
        
        }
        con.desconectar();
        
        }catch(Exception e){
        System.err.println("Error al ejecutar MostrarBitacora "+e);
            
        }
        return lista;
    
    }
    
}
