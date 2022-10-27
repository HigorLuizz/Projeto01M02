import Classes.*;

public class Main {
    public static void main(String[] args) {
        Colaborador colab = new Colaborador();
        Funcionario func = new Funcionario();
        Documento doc = new Documento(func.getID(),func.getID(),"shauhsuahsuahas");
        Documento doc2 = new Documento(func.getID(),func.getID(),"hehehehee");
        Documento doc3 = new Documento(func.getID(),func.getID(),"hahahahaha");
        Supervisor sup = new Supervisor();
        Gerente gerente = new Gerente();

        func.cadastrar(doc);
        func.cadastrar(doc2);
        func.cadastrar(doc3);
        func.listarDocumentos();
        func.tramitar(sup);
        func.tramitar(sup);
        func.listarDocumentos();

        sup.listarDocumentos();
        sup.aprovar(gerente);

        sup.aprovar(gerente);
        gerente.arquivar();
        gerente.arquivar();

        gerente.listarDocumentosArquivados();
        gerente.desarquivar(doc.getID(),func);
        func.listarDocumentos();
        gerente.listarDocumentosArquivados();


    }
}