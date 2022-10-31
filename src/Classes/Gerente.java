package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Objects;

public class Gerente extends Colaborador{
    public LinkedList<Documento> listaDocumentos = new LinkedList<>();
    public LinkedList<Documento> documentosArquivados = new LinkedList<>();
    public LinkedList<Colaborador> todosColaboradores = new LinkedList<>();

    public Gerente() {
    }

    public Gerente(String nome, String cargo, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(nome, cargo, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }

    public void arquivar(){
        Documento documento = listaDocumentos.getLast();
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        documento.setData(data+' '+hora);
        documento.setEstado(false);
        documentosArquivados.addFirst(documento);
        listaDocumentos.removeLast();
        System.out.println("----------------------------------------------------------------");
        System.out.println("Documento arquivado com sucesso!");
        System.out.println("----------------------------------------------------------------");
    }
    public void desarquivar(Integer id, Funcionario funcionario){
        for(Documento documento: documentosArquivados){
            if (Objects.equals(documento.getID(), id)){
                Date dataHoraAtual = new Date();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                documento.setData(data+' '+hora);
                documento.setEstado(true);
                funcionario.cadastrar(documento);
                documentosArquivados.remove(documento);
                System.out.println("----------------------------------------------------------------");
                System.out.println("Documento desarquivado com sucesso!");
                System.out.println("----------------------------------------------------------------");
            }
        }
    }
    public void desarquivar(Integer id, Supervisor supervisor){
        for(Documento documento: documentosArquivados){
            if (Objects.equals(documento.getID(), id)){
                Date dataHoraAtual = new Date();
                String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                documento.setData(data+' '+hora);
                documento.setEstado(true);
                supervisor.listaDocumentos.addFirst(documento);
                documentosArquivados.remove(documento);
                System.out.println("----------------------------------------------------------------");
                System.out.println("Documento desarquivado com sucesso!");
                System.out.println("----------------------------------------------------------------");
            }
        }
    }
    public void listarDocumentosParaArquivar(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de documentos para arquivar");
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
    public void listarDocumentosArquivados(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de documentos arquivados");
        documentosArquivados.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())
        );
        System.out.println("Total de documentos arquivados: "+documentosArquivados.size());
        System.out.println("----------------------------------------------------------------");
    }
    public void listarDocumentosFuncionario(Funcionario funcionario){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de documentos pendentes de envio ao supervisor");
        funcionario.listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
        System.out.println("----------------------------------------------------------------");
    }
    public void listarDocumentosSupervisor(Supervisor supervisor){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de documentos pendentes de análise");
        supervisor.listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
        System.out.println("----------------------------------------------------------------");
    }
    public void listarTodosDocumentos(Funcionario funcionario, Supervisor supervisor){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de todos documentos cadastrados no sistema");
        listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())
        );
        documentosArquivados.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())
        );
        funcionario.listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
        supervisor.listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
        System.out.println("----------------------------------------------------------------");

    }
    public void listarColaboradores(){
        System.out.println("----------------------------------------------------------------");
        System.out.println("Lista de todos os colaboradores: ");
        todosColaboradores.forEach(
                colaborador -> System.out.println("Nome completo: "+colaborador.getNome()+" "+colaborador.getSobrenome()+"/ "+
                        "Cargo: "+colaborador.getCargo()+"/ "+
                        "ID: "+colaborador.getID()+"/ "+
                        "Data de nascimento: "+colaborador.getDataDeNascimento()+"/ "+
                        "Cpf: "+colaborador.getCPF()+"/ "+
                        "Endereço: "+colaborador.getNomeRua()+" nº "+colaborador.getNumeroRua())

        );
        System.out.println("----------------------------------------------------------------");
    }
}
