
package modelo;

/**
 *
 * @author daniel
 */
public class Candidato {
    
    private int idCandidato;
    private String numDui;
    private String foto;
    private int tipo;
    private int idDepartamento;

    public Candidato() {
    }

    public Candidato(int idCandidato, String numDui, String foto, int tipo, int idDepartamento) {
        this.idCandidato = idCandidato;
        this.numDui = numDui;
        this.foto = foto;
        this.tipo = tipo;
        this.idDepartamento = idDepartamento;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNumDui() {
        return numDui;
    }

    public void setNumDui(String numDui) {
        this.numDui = numDui;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }
    
   
}
