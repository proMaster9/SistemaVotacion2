/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.util.ArrayList;
import conexion.Conexion;
import modelo.CargoDirectiva;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author roberto
 */
public class CargoDirectivaBTO {
    PreparedStatement pst;
    ResultSet rs;
    Conexion con = new Conexion();
    
    public ArrayList<CargoDirectiva> mostrar(){
    ArrayList<CargoDirectiva> lista = new ArrayList<>();
    
    try{
    String consu = "select * from cargoDirectiva";
    pst = con.getCnn().prepareStatement(consu);
    rs = pst.executeQuery();
    
    while(rs.next()){
        CargoDirectiva cd = new CargoDirectiva();
        cd.setIdCargoDirectiva(rs.getInt("id_cargo_directiva"));
        cd.setCargo(rs.getString("cargo"));
        lista.add(cd);
        
    
    }
    
    
    }catch(Exception e){
    System.err.println("error al mostrar Cargo Directiva "+e);

    }
    return lista;
    }
    

 public void main(String[] args) {
     CargoDirectivaBTO pr = new CargoDirectivaBTO();
     
     
     
 }    
}
    
    
    

