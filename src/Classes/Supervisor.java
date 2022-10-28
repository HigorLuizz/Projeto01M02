package Classes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Supervisor extends Colaborador{
    public LinkedList<Documento> listaDocumentos = new LinkedList<>();

    public Supervisor() {
    }

    public Supervisor(Float ID, String nome, String sobrenome, String dataDeNascimento, String CPF, String nomeRua, String numeroRua) {
        super(ID, nome, sobrenome, dataDeNascimento, CPF, nomeRua, numeroRua);
    }
    public void analisar(){
        if(listaDocumentos.size() == 0){
            System.out.println("Não há documentos para analisar");
        }else {
            Documento documento = listaDocumentos.getLast();
            System.out.println("ID: "+documento.getID()+"/ "+
                    "ID do criador: "+documento.getIDcriador()+"/ "+
                    "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                    "Link: "+documento.getLink()+"/ "+
                    "Ativo?: "+documento.getEstado());
        }

    }
    public void recusar(Funcionario funcionario){
        Documento documento = listaDocumentos.getLast();
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        documento.setData(data+' '+hora);
        funcionario.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void aprovar(Gerente gerente){
        Documento documento = listaDocumentos.getLast();
        Date dataHoraAtual = new Date();
        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
        documento.setData(data+' '+hora);
        gerente.listaDocumentos.addFirst(documento);
        listaDocumentos.removeLast();
    }
    public void listarDocumentos(){
        System.out.println("Lista de documentos para aprovar/reprovar");
        listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
    }
    public void listarDocumentosFuncionario(Funcionario funcionario){
        System.out.println("Lista de documentos pendentes de envio ao supervisor");
        funcionario.listaDocumentos.forEach(
                documento -> System.out.println("Data da última tramitação: "+documento.getData()+"/ "+
                        "ID: "+documento.getID()+"/ "+
                        "ID do criador: "+documento.getIDcriador()+"/ "+
                        "ID do responsável: "+documento.getIDresponsavel()+"/ "+
                        "Link: "+documento.getLink()+"/ "+
                        "Ativo?: "+documento.getEstado())

        );
    }

}
