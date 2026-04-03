package br.com.joaquim.agropecuaria.app;

import br.com.joaquim.agropecuaria.repository.AgropecuariaRepository;
import br.com.joaquim.agropecuaria.service.AgropecuariaService;

import java.util.Scanner;

public class Agropecuaria {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        AgropecuariaRepository agroRepo = new AgropecuariaRepository();
        AgropecuariaService agroService = new AgropecuariaService(agroRepo);
        int escolha;

        do{
            System.out.println("\n|-----------------------------------------|");
            System.out.println("| 1 - Cadastrar produto                   |");
            System.out.println("| 2 - Listar produtos                     |");
            System.out.println("| 3 - Editar produtos                     |");
            System.out.println("| 4 - Excluir produto                     |");
            System.out.println("| 5 - Adicionar/Comprar estoque           |");
            System.out.println("| 6 - Registrar venda                     |");
            System.out.println("| 7 - Salvar venda ou produtos em um .txt |");
            System.out.println("| 8 - Importar dados de um arquivo .txt   |");
            System.out.println("| 9 - Sair                                |");
            System.out.println("|-----------------------------------------|\n");
            escolha = scan.nextInt();

            switch (escolha){
                case 1:
                    cadastrarProdutos(scan, agroService);
                    break;

                case 2:
                    listarProdutos(agroService);
                    break;

                case 3:
                    editarProduto(scan, agroService);
                    break;

                case 4:
                    excluirProduto(scan, agroService);
                    break;

                case 5:
                    aumentarEstoque(scan, agroService);
                    break;

                case 6:
                    registrarVenda(); //a fazer
                    break;

                case 7:
                    salvarArquivoTxT(); //a fazer
                    break;

                case 8:
                    importarDadosArquivoTxt(); //a fazer
                    break;
                case 9:
                    //sairDoSistema(); para confirmar se realmente deseja sair, mas como fazer isso???...
                    System.out.println("Saindo do sistema. . .\n");
                    break;

                default:
                    System.out.println("\nInvalido, tente novamente. . .");
            }
        }while(escolha != 9);
    }

    private static void cadastrarProdutos(Scanner Scan, AgropecuariaService AgroService){
        Scan.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nomeProd = Scan.nextLine();
        System.out.println("Digite o valor do produto: ");
        double valorProd = Scan.nextDouble();
        System.out.println("Digite a quantidade em estoque: ");
        int quantEstoque = Scan.nextInt();

        AgroService.cadastrarProduto(nomeProd, valorProd, quantEstoque);
    }

    private static void listarProdutos(AgropecuariaService AgroService){
        AgroService.listarProdutos();
    }

    private static void editarProduto(Scanner Scan, AgropecuariaService AgroService){
        System.out.println("Deseja editar o nome ou preço do produto?");
        System.out.println("1 - Nome\n2 - Valor\n");
        int escolhaEditar = Scan.nextInt();

        if(escolhaEditar == 1){
            System.out.println("Digite o ID do produto a ser alterado: ");
            int idProd = Scan.nextInt();
            Scan.nextLine();
            System.out.println("Digite o novo nome: ");
            String novoNome = Scan.nextLine();

            AgroService.editarProdutoNome(idProd, novoNome);
        }
        else if (escolhaEditar == 2) {
            System.out.println("Digite o ID do produto a ser alterado: ");
            int idProd = Scan.nextInt();
            System.out.println("Digite o novo valor: ");
            double novoValor = Scan.nextDouble();

            AgroService.editarProdutoPreco(idProd, novoValor);
        }
        else{
            System.out.println("Escolha incorreta. . .\n");
        }
    }

    private static void excluirProduto(Scanner Scan, AgropecuariaService AgroService){
        System.out.println("Deseja excluir um produto?");
        System.out.println("1 - Sim\n2 - Não\n");
        int escolha = Scan.nextInt();

        if(escolha == 1){
            System.out.println("Digite o ID do produto: ");
            int idProdutoExcluir = Scan.nextInt();
            AgroService.excluirProduto(idProdutoExcluir);
        }
        else{
            System.out.println("Abordando exclusão de um produto. . .\n");
        }
    }

    private static void aumentarEstoque(Scanner Scan, AgropecuariaService AgroService){
        System.out.println("Qual produto você comprou/adicionou estoque? Digite o ID abaixo: ");
        int idProdutoEstoque = Scan.nextInt();
        Scan.nextLine();
        System.out.println("Digite a quantidade de novo estoque: ");
        int novoQuantiEstoque = Scan.nextInt();

        AgroService.aumentarEstoque(idProdutoEstoque, novoQuantiEstoque);
    }

    private static void registrarVenda(){

    }

    private static void salvarArquivoTxT(){

    }

    private static void importarDadosArquivoTxt(){

    }
}