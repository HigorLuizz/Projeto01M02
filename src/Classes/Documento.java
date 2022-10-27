package Classes;
import java.util.Random;

public class Documento {
    Random r = new Random();
    private Float ID = r.nextFloat();
    private Float IDresponsavel;
    private Float IDcriador;
    private String link;
    private Boolean ativo = true;

    public Documento() {
    }

    public Documento(Float IDresponsavel, Float IDcriador, String link) {
        this.IDresponsavel = IDresponsavel;
        this.IDcriador = IDcriador;
        this.link = link;
    }

    public Float getID() {
        return ID;
    }

    public void setID(Float ID) {
        this.ID = ID;
    }

    public Float getIDresponsavel() {
        return IDresponsavel;
    }

    public void setIDresponsavel(Float IDresponsavel) {
        this.IDresponsavel = IDresponsavel;
    }

    public Float getIDcriador() {
        return IDcriador;
    }

    public void setIDcriador(Float IDcriador) {
        this.IDcriador = IDcriador;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getEstado() {
        return ativo;
    }

    public void setEstado(Boolean estado) {
        this.ativo = estado;
    }
}