import Classes.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner scannerFloat = new Scanner(System.in);

        Scanner scannerString = new Scanner(System.in);
        Funcionario funcionario01 = new Funcionario("João","Analista","de Jesus","20/09/1995","09785493109","Rua das Amelias","185");
        Supervisor supervisor01 = new Supervisor("Nestor","Supervisor","Amaral","20/10/1982","09594648548","Rua dos Macacos","159");
        Gerente gerente01 = new Gerente("Leonardo","Gerente","Batista","15/09/1975","09289484544","Rua das Abelhas","123");
        gerente01.todosColaboradores.add(funcionario01);
        gerente01.todosColaboradores.add(supervisor01);
        gerente01.todosColaboradores.add(gerente01);


        do {
            System.out.println("Bem vindo ao DEVinDocs!!");
            System.out.println("Por favor, identifique-se, digite: \n" +
                    "1 - Funcionário\n" +
                    "2 - Supervisor\n" +
                    "3 - Gerente\n");
            Integer identidade = scanner.nextInt();
            do {
                if(identidade == 1){
                    System.out.println("O que deseja fazer?\n" +
                            "1 - Criar um novo documento\n" +
                            "2 - Enviar o documento mais antigo para o supervisor\n" +
                            "3 - Ver lista de documentos criados e pendentes de envio\n" +
                            "4 - Sair");
                    Integer acaoFuncionario = scanner.nextInt();
                    if(acaoFuncionario == 1){
                        System.out.println("Digite o link do documento:");
                        String link = scannerString.nextLine();
                        Date dataHoraAtual = new Date();
                        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                        Documento doc1 = new Documento(data+' '+hora,funcionario01.getID(),funcionario01.getID(),link);
                        funcionario01.cadastrar(doc1);
                    }else if(acaoFuncionario == 2 && funcionario01.listaDocumentos.size() != 0){
                        funcionario01.tramitar(supervisor01);
                    }else if(acaoFuncionario == 2 && funcionario01.listaDocumentos.size() == 0){
                        System.out.println("Não há documentos para enviar ao supervisor");
                    }else if(acaoFuncionario == 3){
                        funcionario01.listarDocumentos();
                        if (funcionario01.listaDocumentos.size() == 0){
                            System.out.println("Não há documentos pendentes de envio ao supervisor");
                        }
                    }else{
                        break;
                    }
                }else if(identidade == 2){
                    System.out.println("O que deseja fazer?\n" +
                            "1 - Analisar primeiro documento da lista\n" +
                            "2 - Ver lista de documentos para analisar\n" +
                            "3 - Ver lista de documentos pendentes de envio ao supervisor\n" +
                            "4 - Sair");
                    Integer acaoSupervisor = scanner.nextInt();
                    if(acaoSupervisor == 1 && supervisor01.listaDocumentos.size() != 0){
                        supervisor01.analisar();
                        System.out.println("1 - Aprovar\n" +
                                "2 - Reprovar");
                        Integer analise = scanner.nextInt();
                        if (analise == 1){
                            supervisor01.aprovar(gerente01);
                        }else if(analise == 2){
                            supervisor01.recusar(funcionario01);
                        }
                    }else if(acaoSupervisor == 1 && supervisor01.listaDocumentos.size() == 0){
                        System.out.println("Não há documentos para analisar");
                    } else if(acaoSupervisor == 2){
                        supervisor01.listarDocumentos();
                        if (supervisor01.listaDocumentos.size() == 0){
                            System.out.println("Não há documentos pendentes de de análise");
                        }
                    }else if(acaoSupervisor == 3){
                        supervisor01.listarDocumentosFuncionario(funcionario01);
                    }else {
                        break;
                    }
                }else {
                    System.out.println("O que deseja fazer?\n" +
                            "1 - Arquivar primeiro documento da lista\n" +
                            "2 - Ver lista de documentos para arquivar\n" +
                            "3 - Ver lista de documentos Arquivados\n" +
                            "4 - Desarquivar algum documento\n" +
                            "5 - Ver lista de documentos pendentes de envio ao supervisor\n" +
                            "6 - Ver lista de documentos pendentes de análise\n" +
                            "7 - Ver lista de todos documentos cadastrados no sistema\n" +
                            "8 - Listar todos Colaboradores\n" +
                            "9 - Sair");
                    Integer acaoGerente = scanner.nextInt();
                    if(acaoGerente == 1 && gerente01.listaDocumentos.size() != 0){
                        gerente01.arquivar();
                    }else if(acaoGerente == 1 && gerente01.listaDocumentos.size() == 0){
                        System.out.println("Não há documentos para arquivar");
                    }else if(acaoGerente == 2){
                        gerente01.listarDocumentosParaArquivar();
                        if(gerente01.listaDocumentos.size() == 0){
                            System.out.println("Não há documentos para arquivar");
                        }
                    }else if(acaoGerente == 3){
                        gerente01.listarDocumentosArquivados();
                        if(gerente01.documentosArquivados.size() == 0){
                            System.out.println("Não há documentos arquivados");
                        }
                    }else if(acaoGerente == 4 && gerente01.documentosArquivados.size() != 0){
                        gerente01.listarDocumentosArquivados();
                        System.out.println("Digite o ID do documento que quer desarquivar");
                        Integer id = scannerFloat.nextInt();

                        System.out.println("Para quem quer enviar esse documento?\n" +
                                "1 - Supervisor\n" +
                                "2 - Funcionário");
                        Integer reenvio = scannerFloat.nextInt();

                        if(reenvio == 1){
                            gerente01.desarquivar(id,supervisor01);
                        }else if(reenvio == 2 ){
                            gerente01.desarquivar(id, funcionario01);
                        }

                    }else if(acaoGerente == 4 && gerente01.documentosArquivados.size() == 0){
                        System.out.println("Não há documentos arquivados");
                    }else if(acaoGerente == 5){
                        gerente01.listarDocumentosFuncionario(funcionario01);
                        if(funcionario01.listaDocumentos.size() == 0){
                            System.out.println("Não há documentos pendentes de envio ao supervisor");
                        }
                    }else if(acaoGerente == 6){
                        gerente01.listarDocumentosSupervisor(supervisor01);
                        if(supervisor01.listaDocumentos.size() == 0){
                            System.out.println("Não há documentos pendentes de análise");
                        }
                    }else if(acaoGerente == 7){
                        gerente01.listarTodosDocumentos(funcionario01, supervisor01);
                    }else if(acaoGerente == 8){
                        gerente01.listarColaboradores();
                    }else {
                        break;
                    }
                }
            }while ("r" != "s");

        }while("r" != "s");


    }
}