
package modelo;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Bitacora{
    
    private int idBitacora;
    private String fecha;
    private String hora;
    private String accion;
    private ArrayList<Ciudadano> responsable;

    public Bitacora() {
    }

    public Bitacora(int idBitacora, String fecha, String hora, String accion, ArrayList<Ciudadano> responsable) {
        this.idBitacora = idBitacora;
        this.fecha = fecha;
        this.hora = hora;
        this.accion = accion;
        this.responsable = responsable;
    }

    public int getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(int idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public ArrayList<Ciudadano> getResponsable() {
        return responsable;
    }

    public void setResponsable(ArrayList<Ciudadano> responsable) {
        this.responsable = responsable;
    }

    
}
