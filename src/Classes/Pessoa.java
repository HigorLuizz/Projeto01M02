package Classes;
import java.util.Random;

public class Pessoa {
    Random r = new Random();
    private Float ID = r.nextFloat();
    private String nome;
    private String sobrenome;
    private String dataDeNascimento;
    private String CPF;
    private String nomeRua;
    private String numeroRua;

    public Pessoa(){

    }

    public Pessoa(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataDeNascimento = dataDeNascimento;
        this.CPF = CPF;
        this.nomeRua = nomeRua;
        this.numeroRua = numeroRua;
    }

    public Float getID() {
        return ID;
    }

    public void setID(Float ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        sobrenome = sobrenome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public String getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(String numeroRua) {
        this.numeroRua = numeroRua;
    }
}
