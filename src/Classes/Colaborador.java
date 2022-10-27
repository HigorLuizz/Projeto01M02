package Classes;

public class Colaborador extends Pessoa{
    public Colaborador() {
    }

    public Colaborador(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(ID, nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }

    public Float cadastrarDocumento(){
        return getID();
    }

    public void listarDocumentos(){

    }

    public void tramitarDocumento(){

    }
}
