package Classes;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Random;

public class Documento {
    Random r = new Random();
    private String data;
    private Integer ID = r.nextInt(10000);
    private Float IDresponsavel;
    private Float IDcriador;
    private String link;
    private Boolean ativo = true;

    public Documento() {
    }

    public Documento(String data, Float IDresponsavel, Float IDcriador, String link) {
        this.data = data;
        this.IDresponsavel = IDresponsavel;
        this.IDcriador = IDcriador;
        this.link = link;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
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
