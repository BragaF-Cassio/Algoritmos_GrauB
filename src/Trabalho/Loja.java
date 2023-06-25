package Trabalho;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Loja {

    static Scanner sc;
    static Empresa empresa;
    public static void main(String[] args) {
        String nomeUsuario = "";
        String pergunta, resposta;
        int opcoes;
        boolean sair = false;

        Locale.setDefault(Locale.US);
        sc = new Scanner(System.in);

        System.out.println("Digite o nome do cliente:");
        nomeUsuario = sc.nextLine();

        System.out.println("Digite o nome da empresa:");
        resposta = sc.nextLine();

        //Criando a loja
        empresa = new Empresa(resposta);
        testeAdicionaProdutosAoEstoque();

        //Apresentação do programa
        System.out.println(nomeUsuario + ", seja bem-vindo a loja " + empresa.getNomeEmpresa() + "!");

        //Início das rotinas
        do {
            pergunta = "1) Modificar estoque\n" +
                    "2) Comprar produtos";
            opcoes = coletaRetornoUsuario(pergunta, "0) Sair", 2);
            System.out.println();

            switch (opcoes){
                case 0:
                    sair = true;
                    break;

                case 1:
                    cadastrarProdutos();
                    break;

                case 2:
                    comprarProdutos();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (sair == false);
        System.out.println(nomeUsuario + ", obrigado por utilizar nossos serviços!");

        //funcaoTeste();
        sc.close();
    }

    public static double comprarProdutos(){
        ArrayList<Produto> tmpEstoque = null;
        ArrayList<Item> tmpCarrinho = null;
        String pergunta;
        int opcoes;
        int indiceProduto;
        int quantidade;

        do {
            pergunta = "1) Comprar Eletrônico\n" +
                    "2) Comprar Eletrodoméstico\n" +
                    "3) Comprar Livro\n" +
                    "4) Comprar Roupa\n" +
                    "5) Remover Item do Carrinho\n" +
                    "6) Listar Itens do Carrinho";
            opcoes = coletaRetornoUsuario(pergunta, "0) Finalizar compras", 6);
            System.out.println();

            switch (opcoes){
                case 0:
                    break;

                case 1:
                    tmpEstoque = empresa.listarEletronicosEstoque();
                    break;

                case 2:
                    tmpEstoque = empresa.listarEletrodomesticosEstoque();
                    break;

                case 3:
                    tmpEstoque = empresa.listarLivrosEstoque();
                    break;

                case 4:
                    tmpEstoque = empresa.listarRoupasEstoque();
                    break;

                case 5:
                    tmpEstoque = empresa.listarItensCarrinho(true);
                    break;

                case 6:
                    empresa.visualizarCarrinho();
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

            if(tmpEstoque != null && opcoes != 6) {
                if (opcoes >= 1 && opcoes <= 4) {
                    indiceProduto = coletaRetornoUsuario("Escolha uma das opções acima, ou 0 para Cancelar:", "", tmpEstoque.size());
                    indiceProduto--;
                    if (indiceProduto >= 0) {
                        quantidade = coletaInteiroComProtecao("Insira a quantidade do produto que se deseja adicionar ao carrinho (0 - " +
                                String.format("%d):", tmpEstoque.get(indiceProduto).getQuantidade()), 0, tmpEstoque.get(indiceProduto).getQuantidade());

                        if (quantidade > 0) {
                            empresa.addProdutoCarrinho(tmpEstoque.get(indiceProduto), quantidade);
                        }
                    }
                } else if (opcoes == 5) {
                    indiceProduto = coletaRetornoUsuario("Escolha uma das opções acima, ou 0 para Cancelar:", "", tmpEstoque.size());
                    indiceProduto--;
                    if (indiceProduto >= 0) {
                        quantidade = coletaInteiroComProtecao("Insira a quantidade do produto que se deseja remover do carrinho (0 - " +
                                String.format("%d):", tmpEstoque.get(indiceProduto).getQuantidade()), 0, tmpEstoque.get(indiceProduto).getQuantidade());

                        if (quantidade > 0) {
                            empresa.removeProdutoCarrinho(tmpEstoque.get(indiceProduto), quantidade);
                        }
                    }
                }
            }

        } while (opcoes != 0);

        return empresa.finalizarCompra();
    }

    public static int cadastrarProdutos(){
        String pergunta;
        int opcoes;
        int itensCadastrados = 0;
        String nome, descricao, marca, cor, categoria, autor, editora, genero, formato, tamanho, tecido, eficienciaEnergetica;
        double valor;
        int quantidade, anoDeLancamento;
        long codigo;
        Produto tmpProduto;

        Eletrodomestico eletrodomestico;
        Eletronicos eletronico;
        Livros livro;
        Roupas roupa;

        do {
            pergunta = "1) Cadastrar Eletrônico\n" +
                    "2) Cadastrar Eletrodoméstico\n" +
                    "3) Cadastrar Livro\n" +
                    "4) Cadastrar Roupa";
            opcoes = coletaRetornoUsuario(pergunta, "0) Voltar ao menu anterior", 4);
            switch (opcoes){
                case 0:
                    break;

                case 1:
                    System.out.println("Digite o código do produto:");
                    codigo = sc.nextLong();
                    sc.nextLine();
                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Eletronicos){
                            System.out.println("Código de produto já está em uso por produto da categoria de Eletrônicos.");
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                eletronico = (Eletronicos) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                eletronico.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                            System.out.println("Código de produto já está em uso por produto de outro tipo! Insira outro código.");
                            break;
                        }
                    } else {
                        System.out.println("Insira o nome do produto:");
                        nome = sc.nextLine();

                        System.out.println("Insira a descrição:");
                        descricao = sc.nextLine();

                        System.out.println("Insira a marca:");
                        marca = sc.nextLine();

                        System.out.println("Insira a cor:");
                        cor = sc.nextLine();

                        System.out.println("Insira a categoria:");
                        categoria = sc.nextLine();

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);

                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                        anoDeLancamento = coletaInteiroComProtecao("Insira o ano de lançamento (1800 - 2024)", 1800, 2024);

                        eletronico = new Eletronicos(nome, descricao, marca, cor, categoria, valor, quantidade, codigo, anoDeLancamento);
                        empresa.addProdutoEstoque(eletronico, quantidade);
                        itensCadastrados++;
                    }

                    break;

                case 2:
                    System.out.println("Digite o código do produto:");
                    codigo = sc.nextLong();
                    sc.nextLine();
                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Eletrodomestico){
                            System.out.println("Código de produto já está em uso por produto da categoria de Eletrodoméstico.");
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                eletrodomestico = (Eletrodomestico) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                eletrodomestico.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                            System.out.println("Código de produto já está em uso por produto de outro tipo! Insira outro código.");
                            break;
                        }
                    } else {
                        System.out.println("Insira o nome do produto:");
                        nome = sc.nextLine();

                        System.out.println("Insira a descrição:");
                        descricao = sc.nextLine();

                        System.out.println("Insira a marca:");
                        marca = sc.nextLine();

                        System.out.println("Insira a cor:");
                        cor = sc.nextLine();

                        System.out.println("Insira a eficiência energética (A, B, C, ...):");
                        eficienciaEnergetica = sc.nextLine();

                        System.out.println("Insira a categoria:");
                        categoria = sc.nextLine();

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);

                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        eletrodomestico = new Eletrodomestico(nome, descricao, marca, cor, categoria, valor, quantidade, eficienciaEnergetica, codigo);
                        empresa.addProdutoEstoque(eletrodomestico, quantidade);
                        itensCadastrados++;
                    }
                    break;

                case 3:
                    System.out.println("Digite o código do produto:");
                    codigo = sc.nextLong();
                    sc.nextLine();
                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Livros){
                            System.out.println("Código de produto já está em uso por produto da categoria de Livro.");
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                livro = (Livros) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                livro.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                            System.out.println("Código de produto já está em uso por produto de outro tipo! Insira outro código.");
                            break;
                        }
                    } else {
                        System.out.println("Insira o nome do produto:");
                        nome = sc.nextLine();

                        System.out.println("Insira a descrição:");
                        descricao = sc.nextLine();

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);
                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        System.out.println("Insira o(a) autor(a):");
                        autor = sc.nextLine();

                        System.out.println("Insira a editora:");
                        editora = sc.nextLine();

                        System.out.println("Insira o gênero:");
                        genero = sc.nextLine();

                        System.out.println("Insira o formato (físico, digital):");
                        formato = sc.nextLine();

                        //anoDeLancamento = coletaInteiroComProtecao("Insira o ano de lançamento (1800 - 2024)", 1800, 2024);

                        livro = new Livros(nome, descricao, valor, quantidade, codigo, autor, editora, genero, formato);
                        empresa.addProdutoEstoque(livro, quantidade);
                        itensCadastrados++;
                    }
                    break;

                case 4:
                    System.out.println("Digite o código do produto:");
                    codigo = sc.nextLong();
                    sc.nextLine();
                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Roupas){
                            System.out.println("Código de produto já está em uso por produto da categoria de Livro.");
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                roupa = (Roupas) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                roupa.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                            System.out.println("Código de produto já está em uso por produto de outro tipo! Insira outro código.");
                            break;
                        }
                    } else {
                        System.out.println("Insira o nome do produto:");
                        nome = sc.nextLine();

                        System.out.println("Insira a descrição:");
                        descricao = sc.nextLine();

                        System.out.println("Insira a marca:");
                        marca = sc.nextLine();

                        System.out.println("Insira a cor:");
                        cor = sc.nextLine();

                        System.out.println("Insira a categoria:");
                        categoria = sc.nextLine();

                        System.out.println("Insira o tamanho:");
                        tamanho = sc.nextLine();

                        System.out.println("Insira o tecido:");
                        tecido = sc.nextLine();

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);
                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        roupa = new Roupas(nome, descricao, marca, cor, categoria, valor, quantidade, codigo, tamanho, tecido);
                        empresa.addProdutoEstoque(roupa, quantidade);
                        itensCadastrados++;
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcoes != 0);
        return itensCadastrados;
    };

    //Faz uma pergunta ao usuário, e retorna true se a resposta for verdadeira, e false se for falsa
    public static boolean fazPergunta(String pergunta){
        String resposta;

        do {
            System.out.println(pergunta);
            System.out.println("Digite S para Sim, ou N para não");
            try{
                resposta = sc.nextLine();
            } catch (Exception e){
                System.out.println("Por favor, insira uma resposta válida!");
                resposta = "";
            }

        } while(!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));

        //Retorna true se a resposta for "S", retorna false se for "N"
        return resposta.equalsIgnoreCase("s");
    }

    public static double coletaDoubleComProtecao(String pergunta, double valorMinimo, double valorMaximo){
        double tmpOpcao;

        do {
            System.out.println(pergunta);
            try{
                tmpOpcao = sc.nextDouble();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Por favor, insira um valor válido!");
                sc.nextLine();
                tmpOpcao = valorMinimo-1;
            }

        } while(tmpOpcao < valorMinimo || tmpOpcao > valorMaximo);

        return tmpOpcao;
    }

    public static int coletaInteiroComProtecao(String pergunta, int valorMinimo, int valorMaximo){
        int tmpOpcao;

        do {
            System.out.println(pergunta);
            try{
                tmpOpcao = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Por favor, insira um valor válido!");
                sc.nextLine();
                tmpOpcao = valorMinimo-1;
            }

        } while(tmpOpcao < valorMinimo || tmpOpcao > valorMaximo);

        return tmpOpcao;
    }

    public static int coletaRetornoUsuario(String pergunta, String valorRetorno, int itens){
        int tmpOpcao;

        do {
            System.out.println("Escolha uma das opções:\n" +
                    valorRetorno);
            System.out.println(pergunta);
            try{
                tmpOpcao = sc.nextInt();
                sc.nextLine();
            } catch (Exception e){
                System.out.println("Por favor, insira um valor válido!");
                sc.nextLine();
                tmpOpcao = -1;
            }

        } while(tmpOpcao < 0 || tmpOpcao > itens);

        return tmpOpcao;
    }

    public static void testeAdicionaProdutosAoEstoque(){
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        Produto samsungA10 = new Eletronicos("Celular Samsung A10", "Celular ótimo custo benefício", "Samsung", "Preto", "Celulares", 1200.00, 0, 789,  2019);
        Produto notebook = new Eletronicos("Notebook Acer Aspire II", "Notebook para dia a dia", "Acer", "Prata", "Notebook", 3999.99, 0, 43210,  2019);

        empresa.addProdutoEstoque(mouse, 1, true);
        empresa.addProdutoEstoque(mouse, 5, true);
        empresa.addProdutoEstoque(carregadorIphone, 2);
        empresa.addProdutoEstoque(samsungA10, 1);
        empresa.addProdutoEstoque(notebook, 2);
    }

    public static void funcaoTeste() {
        //O que tem aqui é só de teste mesmo, dps tem que fazer menu e tals, mas so caso alguem queira testar pra ver como que fiz ali a classe empresa e tal

        //Criando produtos de teste
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,2, 123,  2020);
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99, 0, 456,  2022);
        Produto samsungA10 = new Eletronicos("Celular Samsung A10", "Celular ótimo custo benefício", "Samsung", "Preto", "Celulares", 1200.00, 0, 789,  2019);
        Produto notebook = new Eletronicos("Notebook Acer Aspire II", "Notebook para dia a dia", "Acer", "Prata", "Notebook", 3999.99, 0, 43210,  2019);

        empresa.addProdutoEstoque(mouse, 1, true);
        empresa.addProdutoEstoque(mouse, 5, true);
        empresa.visualizarEstoque();
        empresa.addProdutoEstoque(carregadorIphone, 2);
        empresa.addProdutoEstoque(samsungA10, 1);
        empresa.addProdutoEstoque(notebook, 2);

        System.out.println("Agora, vamos adicionar itens ao carrinho:");
        empresa.addProdutoCarrinho(mouse, 2);
        empresa.checkoutCarrinho();
        empresa.visualizarCarrinho();
        empresa.visualizarEstoque();

        empresa.addProdutoCarrinho(carregadorIphone, 2);
        empresa.addProdutoCarrinho(notebook, 3);
        empresa.finalizarCompra();
    }

}
