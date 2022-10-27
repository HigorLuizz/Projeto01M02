package Classes;
import java.util.LinkedList;

public class Gerente extends Colaborador{
    public LinkedList<Documento> listaDocumentos = new LinkedList<>();
    public LinkedList<Documento> documentosArquivados = new LinkedList<>();

    public Gerente() {
    }

    public Gerente(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(ID, nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }
    public void arquivar(){
        Documento documento = listaDocumentos.getLast();
        documento.setEstado(false);
        documentosArquivados.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void desarquivar(Integer id, Funcionario funcionario){
        documentosArquivados.forEach(
                documento -> {
                    if (documento.getID()==id){
                        documento.setEstado(true);
                        funcionario.cadastrar(documento);
                        documentosArquivados.remove(documento);
                    }else{
                        System.out.println("ID diferente");
                    }
                }
        );
    }
    public void desarquivar(Integer id, Supervisor supervisor){
        documentosArquivados.forEach(
                documento -> {
                    if (documento.getID().equals(id)){
                        documento.setEstado(true);
                        supervisor.listaDocumentos.addFirst(documento);
                        documentosArquivados.remove(documento);

                    }
                }
        );
    }
    public void listarDocumentosParaArquivar(){
        System.out.println("Lista de documentos para arquivar");
        listaDocumentos.forEach(
                documento -> System.out.println("ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())
        );
    }
    public void listarDocumentosArquivados(){
        System.out.println("Lista de documentos arquivados");
        documentosArquivados.forEach(
                documento -> System.out.println("ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())
        );
    }
}
