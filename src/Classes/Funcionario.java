package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class Funcionario extends Colaborador{

    public LinkedList<Documento> listaDocumentos = new LinkedList<>();
    public Funcionario() {
    }

    public Funcionario(String nome, String cargo, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(nome, cargo, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }

    public void cadastrar(Documento documento){
        this.listaDocumentos.addFirst(documento);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Documento cadastrado com sucesso!");
        System.out.println("----------------------------------------------------------------");
    }
    public void tramitar(Supervisor supervisor){
        Documento documento = listaDocumentos.getLast();
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        documento.setData(data+' '+hora);
        supervisor.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Documento enviado ao supervisor para análise!");
        System.out.println("----------------------------------------------------------------");
    }
    public void listarDocumentos(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de documentos Cadastrados por funcionário");
        listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
        System.out.println("----------------------------------------------------------------");
    }
}
