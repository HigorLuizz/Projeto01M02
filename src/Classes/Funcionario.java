package Classes;
import java.util.LinkedList;


public class Funcionario extends Colaborador{
    public LinkedList<Documento> listaDocumentos = new LinkedList<>();
    public Funcionario() {
    }

    public Funcionario(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(ID, nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }
    public void cadastrar(Documento documento){
        this.listaDocumentos.addFirst(documento);
    }
    public void tramitar(Supervisor supervisor){
        Documento documento = listaDocumentos.getLast();
        System.out.println(documento);
        supervisor.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void listarDocumentos(){
        System.out.println("Lista de documentos Cadastrados por funcionário");
        listaDocumentos.forEach(
                documento -> System.out.println("ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
    }
}
