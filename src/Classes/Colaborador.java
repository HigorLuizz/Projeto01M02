package Classes;

public class Colaborador extends Pessoa{
    String cargo;
    public Colaborador() {
    }

    public Colaborador(String nome, String cargo,String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float cadastrarDocumento(){
        return getID();
    }

    public void listarDocumentos(){

    }

    public void tramitarDocumento(){

    }
}
