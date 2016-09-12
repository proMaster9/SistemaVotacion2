/* 
    Name Class   : Centro Votación 
    Created on   : 11-sep-2016,
    Author       : JH
*/
package clases;

public class CentroVotacionDTO {
    private int idMunicipio;
    private String direccion;
    private String numDui;
    private String nombreCentro;
    private int numJRV;

    public CentroVotacionDTO(int idMunicipio, String direccion, String numDui, String nombreCentro, int numJRV) {
        this.idMunicipio = idMunicipio;
        this.direccion = direccion;
        this.numDui = numDui;
        this.nombreCentro = nombreCentro;
        this.numJRV = numJRV;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumDui() {
        return numDui;
    }

    public void setNumDui(String numDui) {
        this.numDui = numDui;
    }

    public String getNombreCentro() {
        return nombreCentro;
    }

    public void setNombreCentro(String nombreCentro) {
        this.nombreCentro = nombreCentro;
    }

    public int getNumJRV() {
        return numJRV;
    }

    public void setNumJRV(int numJRV) {
        this.numJRV = numJRV;
    }
    
    
}
