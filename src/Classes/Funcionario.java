package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        documento.setData(data+' '+hora);
        supervisor.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void listarDocumentos(){
        System.out.println("Lista de documentos Cadastrados por funcionário");
        listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
    }
}
