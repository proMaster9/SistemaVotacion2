
package crud;
import clases.CentroVotacionDTO;
import obligaciones.Obligacion;
import java.util.List;
import conexion.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Icchigo
 */
public class CentroVotacionDAO implements Obligacion<CentroVotacionDTO>{
    private static final String SQL_INSERT = "insert into centrovotacion (id_municipio,direccion_especifica,num_dui,nombre_centro,num_jrv_disponibles) values (?,?,?,?,?)";
    private static final String SQL_DELETE = "delete from centrovotacion where nombre_centro = ?";
    private static final String SQL_UPDATE = "update centrovotacion set id_municipio=?,direccion_especifica=?,num_dui=?,nombre_centro=?,num_jrv_disponibles=? where nombre_centro=?";
    private static final String SQL_READ = "select * from centrovotacion where nombre_centro = ?";
    private static final String SQL_READALL = "select m.nombre_municipio,direccion_especifica,num_dui,nombre_centro,num_jrv_disponibles from centrovotacion cv INNER JOIN municipio m on m.id_municipio=cv.id_municipio";

    private static final Conexion con = Conexion.conectar();
    
    @Override
    public boolean create(CentroVotacionDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getIdMunicipio());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getNumDui());
            ps.setString(4, c.getNombreCentro());
            ps.setInt(5, c.getNumJRV());
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentroVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.desconectar();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1,key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentroVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.desconectar();
        }
        return false;
    }

    @Override
    public boolean update(CentroVotacionDTO c) {
        PreparedStatement ps;
        try {
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, c.getIdMunicipio());
            ps.setString(2, c.getDireccion());
            ps.setString(3, c.getNumDui());
            ps.setString(4, c.getNombreCentro());
            ps.setInt(5, c.getNumJRV());
            ps.setString(6, c.getNombreCentro());
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CentroVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.desconectar();
        }
        return false;
    }
    
    @Override
    public List<CentroVotacionDTO> readAll() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList cv = new ArrayList();
        try {
            ps = con.getCnn().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while (rs.next()){
                cv.add(new Object []{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)});
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CentroVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.desconectar();
        }
        return cv;
    }
    
}
