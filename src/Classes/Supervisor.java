package Classes;

import java.util.LinkedList;

public class Supervisor extends Colaborador{
    public LinkedList<Documento> listaDocumentos = new LinkedList<>();

    public Supervisor() {
    }

    public Supervisor(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(ID, nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }
    public void analisar(){
        Documento documento = listaDocumentos.getLast();
        System.out.println("ID: "+documento.getID()+"/ "+
                "ID do criador: "+documento.getIDcriador()+"/ "+
                "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                "Link: "+documento.getLink()+"/ "+
                "Ativo?: "+documento.getEstado());
    }
    public void recusar(Funcionario funcionario){
        Documento documento = listaDocumentos.getLast();
        funcionario.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void aprovar(Gerente gerente){
        Documento documento = listaDocumentos.getLast();
        gerente.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void listarDocumentos(){
        System.out.println("Lista de documentos para aprovar/reprovar");
        listaDocumentos.forEach(
                documento -> System.out.println("ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
    }

}
