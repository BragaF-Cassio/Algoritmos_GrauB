import Trabalho.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import javax.sound.sampled.Port;
import javax.swing.*;

public class LojaGrafica {
    static Empresa empresa = null;
    static ImageIcon icon = new ImageIcon("images/Icone-Loja-Comercio5.png");
    static ImageIcon iconCarrinho = new ImageIcon("images/carrinho.png");
    static String filePath = "file.dat";
    
    public static void main(String[] args) {
        String nomeUsuario = "";
        String pergunta, resposta;
        int opcoes;
        int retVal;
        boolean sair = false;

        Locale.setDefault(Locale.US);

        //Recebe input do nome do usuário
        do {
            nomeUsuario =  JOptionPane.showInputDialog("Digite o nome do cliente:");
            if (nomeUsuario == null){
                retVal = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Alerta!", JOptionPane.YES_NO_OPTION);
                if (retVal == 0){
                    return;
                }
            }
        } while (nomeUsuario == null || nomeUsuario.isEmpty());

        empresa = (Empresa) ManipularObjetos.restaurar(filePath);

        if (empresa == null) {
            //Recebe input do nome da empresa
            do {
                resposta = JOptionPane.showInputDialog("Digite o nome da empresa:");
                if (resposta == null) {
                    retVal = JOptionPane.showConfirmDialog(null, "Deseja sair?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if (retVal == 0) {
                        return;
                    }
                }
            } while (resposta == null || resposta.isEmpty());

            //Criando a loja
            empresa = new Empresa(resposta);
            testeAdicionaProdutosAoEstoque();
        }

        //Apresentação do programa
        JOptionPane.showMessageDialog(null, nomeUsuario + ", seja bem-vindo a loja " + empresa.getNomeEmpresa() + "!", empresa.getNomeEmpresa(), 
        		JOptionPane.INFORMATION_MESSAGE, icon);

        //Início das rotinas
        do {
            pergunta = "1) Modificar estoque\n" +
                    "2) Comprar produtos";
            opcoes = coletaRetornoUsuario(pergunta, "Sair", 2);
            System.out.println();

            switch (opcoes){
                case 0:
                    sair = true;
                    break;

                case 1:
                   int cadastro = cadastrarProdutos();
                   if(cadastro != 0) {
                       JOptionPane.showMessageDialog(null, "Cadastro realizado!\n " + "Total de Itens Cadastrados: " + cadastro, empresa.getNomeEmpresa(),
                               JOptionPane.INFORMATION_MESSAGE);
                   }
                   break;

                case 2:
                   double compra = comprarProdutos();
                   if (compra != 0) {
                       JOptionPane.showMessageDialog(null, "Checkout realizado!\n " + "Valor gasto na compra: " + String.format("R$%.2f", compra), empresa.getNomeEmpresa(),
                               JOptionPane.INFORMATION_MESSAGE);
                   }
                    break;

                default:
                	JOptionPane.showMessageDialog(null, "Opção inválida!", empresa.getNomeEmpresa(), 
                     		JOptionPane.ERROR_MESSAGE);
            }

        } while (sair == false);
        
        JOptionPane.showMessageDialog(null, nomeUsuario + ", obrigado por utilizar nossos serviços!", empresa.getNomeEmpresa(), 
        		JOptionPane.INFORMATION_MESSAGE, icon);

        ManipularObjetos.salvar(empresa, filePath);
    }

    public static double comprarProdutos(){
        ArrayList<Produto> tmpEstoque = null;
        List<Item> tmpCarrinho = null;
        String pergunta;
        int opcoes;
        int indiceProduto;
        int quantidade;
        String listVal;
        String showInfo;

        do {
            pergunta = "1) Comprar Eletrônico\n" +
                    "2) Comprar Eletrodoméstico\n" +
                    "3) Comprar Livro\n" +
                    "4) Comprar Roupa\n" +
                    "5) Remover Item do Carrinho\n" +
                    "6) Listar Itens do Carrinho";
            opcoes = coletaRetornoUsuario(pergunta, "Finalizar compras", 6);
           // System.out.println();
            showInfo = "";
            tmpEstoque = null;
            tmpCarrinho = null;

            switch (opcoes){
                case 0:
                    break;

                case 1:
                    tmpEstoque = empresa.listarEletronicosEstoque();
                    listVal = listOptions(tmpEstoque);
                    /*JOptionPane.showMessageDialog(null, " Eletronicos:\n" + listVal, empresa.getNomeEmpresa(),
                    		JOptionPane.INFORMATION_MESSAGE, icon);*/
                    showInfo = "Eletronicos:\n" + listVal + "\n\n";
                    break;

                case 2:
                    tmpEstoque = empresa.listarEletrodomesticosEstoque();
                    listVal = listOptions(tmpEstoque);
                    /*JOptionPane.showMessageDialog(null, " Eletrodomestico:\n" + listVal, empresa.getNomeEmpresa(),
                    		JOptionPane.INFORMATION_MESSAGE, icon);*/
                    showInfo = "Eletrodomestico:\n" + listVal + "\n\n";
                    break;

                case 3:
                    tmpEstoque = empresa.listarLivrosEstoque();
                    listVal = listOptions(tmpEstoque);
                    /*JOptionPane.showMessageDialog(null, " Livros:\n" + listVal, empresa.getNomeEmpresa(),
                    		JOptionPane.INFORMATION_MESSAGE, icon);*/
                    showInfo = "Livros:\n" + listVal + "\n\n";
                    break;

                case 4:
                    tmpEstoque = empresa.listarRoupasEstoque();
                    listVal = listOptions(tmpEstoque);
                    /*JOptionPane.showMessageDialog(null, " Roupas:\n" + listVal, empresa.getNomeEmpresa(),
                    		JOptionPane.INFORMATION_MESSAGE, icon);*/
                    showInfo = "Roupas:\n" + listVal + "\n\n";
                    break;

                case 5:
                    tmpCarrinho = empresa.listarItensCarrinho();
                    listVal = listOptions(tmpCarrinho);
                    /*JOptionPane.showMessageDialog(null, " Carrinho:\n" + listVal, empresa.getNomeEmpresa(),
                    		JOptionPane.INFORMATION_MESSAGE, iconCarrinho);*/
                    showInfo = "Carrinho:\n" + listVal + "\n\n";
                    break;

                case 6:
                	JOptionPane.showMessageDialog(null,"Carrinho do cliente: \n" + empresa.visualizarCarrinho(), empresa.getNomeEmpresa(), 
                    		JOptionPane.INFORMATION_MESSAGE, iconCarrinho);
                    break;

                default:
                	 JOptionPane.showMessageDialog(null, "Opção inválida!", empresa.getNomeEmpresa(), 
                      		JOptionPane.ERROR_MESSAGE);
            }

            if(opcoes == 5){
                if(tmpCarrinho != null) {
                    indiceProduto = coletaRetornoUsuario(showInfo + "Digite o numero de uma das opções anteriores, ou 0 para Cancelar:", "", tmpCarrinho.size());
                    indiceProduto--;
                    if (indiceProduto >= 0) {
                        quantidade = coletaInteiroComProtecao("Insira a quantidade do produto que se deseja remover do carrinho (0 - " +
                                String.format("%d):", tmpCarrinho.get(indiceProduto).getQuantidade()), 0, tmpCarrinho.get(indiceProduto).getQuantidade());

                        if (quantidade > 0) {
                            empresa.removeProdutoCarrinho(tmpCarrinho.get(indiceProduto).getProduto(), quantidade);
                        }
                    }
                }
            } else if(tmpEstoque != null && opcoes != 6) {
                if (opcoes >= 1 && opcoes <= 4) {
                    indiceProduto = coletaRetornoUsuario(showInfo + "Digite o numero de uma das opções anteriores, ou 0 para Cancelar:", "", tmpEstoque.size(), iconCarrinho);
                    indiceProduto--;
                    if (indiceProduto >= 0) {
                        quantidade = coletaInteiroComProtecao("Insira a quantidade do produto que se deseja adicionar ao carrinho (0 - " +
                                String.format("%d):", tmpEstoque.get(indiceProduto).getQuantidade()), 0, tmpEstoque.get(indiceProduto).getQuantidade());

                        if (quantidade > 0) {
                            empresa.addProdutoCarrinho(tmpEstoque.get(indiceProduto), quantidade);
                        }
                    }
                }
            }

        } while (opcoes != 0);

        return empresa.finalizarCompra();
    }

    public static String listOptions(ArrayList<Produto> prods){
        int quant = 1;
        String tmpRet = "";

        if (prods != null) {
            for (Produto p : prods) {
                tmpRet += String.format("%d) ", quant) + p.toString() + "\n";
                quant++;
            }
        }
        return tmpRet;
    }

    public static String listOptions(List<Item> prods){
        int quant = 1;
        String tmpRet = "";

        if (prods != null) {
            for (Item i : prods) {
                tmpRet += String.format("%d) ", quant) + i.toString() + "\n";
                quant++;
            }
        }
        return tmpRet;
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
                    "4) Cadastrar Roupa\n" +
                    "5) Remover Item do Estoque";
            opcoes = coletaRetornoUsuario(pergunta, "Voltar ao menu anterior", 5);

            tmpProduto = null;
            eletrodomestico = null;
            eletronico = null;
            livro = null;
            roupa = null;

            switch (opcoes){
                case 0:
                    break;

                case 1:
                    codigo = coletaLongComProtecao("Digite o código do produto:", 0, Long.MAX_VALUE);
                    
                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Eletronicos){
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto da categoria de Eletrônicos.", empresa.getNomeEmpresa(), 
                              		JOptionPane.WARNING_MESSAGE);
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                eletronico = (Eletronicos) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                eletronico.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto de outro tipo! Insira outro código.", empresa.getNomeEmpresa(), 
                              		JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } else {
                    	
                    	nome = JOptionPane.showInputDialog(null, "Insira o nome do produto: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                       
                       

                    	descricao = JOptionPane.showInputDialog(null, "Insira a descrição: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	marca = JOptionPane.showInputDialog(null, "Insira a marca: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	cor = JOptionPane.showInputDialog(null, "Insira a cor: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	categoria = JOptionPane.showInputDialog(null, "Insira a categoria: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);

                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                        anoDeLancamento = coletaInteiroComProtecao("Insira o ano de lançamento (1800 - 2024)", 1800, 2024);

                        eletronico = new Eletronicos(nome, descricao, marca, cor, categoria, valor, quantidade, codigo, anoDeLancamento);
                        empresa.addProdutoEstoque(eletronico, quantidade);
                        itensCadastrados++;
                    }

                    break;

                case 2:
                    codigo = coletaLongComProtecao("Digite o código do produto:", 0, Long.MAX_VALUE);

                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Eletrodomestico){
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto da categoria de Eletrodoméstico.", empresa.getNomeEmpresa(), 
                              		JOptionPane.WARNING_MESSAGE);
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                eletrodomestico = (Eletrodomestico) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                eletrodomestico.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto de outro tipo! Insira outro código.", empresa.getNomeEmpresa(), 
                              		JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } else {
                    	nome = JOptionPane.showInputDialog(null, "Insira o nome do produto: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                       
                       

                    	descricao = JOptionPane.showInputDialog(null, "Insira a descrição: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	marca = JOptionPane.showInputDialog(null, "Insira a marca: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	cor = JOptionPane.showInputDialog(null, "Insira a cor: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);


                    	eficienciaEnergetica = JOptionPane.showInputDialog(null, "Insira a eficiência energética (A, B, C, ...): " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	categoria = JOptionPane.showInputDialog(null, "Insira a categoria: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);

                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        eletrodomestico = new Eletrodomestico(nome, descricao, marca, cor, categoria, valor, quantidade, eficienciaEnergetica, codigo);
                        empresa.addProdutoEstoque(eletrodomestico, quantidade);
                        itensCadastrados++;
                    }
                    break;

                case 3:
                    codigo = coletaLongComProtecao("Digite o código do produto:", 0, Long.MAX_VALUE);

                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Livros){
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto da categoria de Livro.", empresa.getNomeEmpresa(), 
                              		JOptionPane.WARNING_MESSAGE);
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                livro = (Livros) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                livro.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto de outro tipo! Insira outro código.", empresa.getNomeEmpresa(), 
                              		JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } else {
                    	nome = JOptionPane.showInputDialog(null, "Insira o nome do produto: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                    	descricao = JOptionPane.showInputDialog(null, "Insira a descrição: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);
                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        autor = JOptionPane.showInputDialog(null, "Insira o(a) autor(a): " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                      

                        editora = JOptionPane.showInputDialog(null, "Insira a editora: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                       

                        genero = JOptionPane.showInputDialog(null, "Insira o gênero: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                        formato = JOptionPane.showInputDialog(null, "Insira o formato (físico, digital): " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                       

                        //anoDeLancamento = coletaInteiroComProtecao("Insira o ano de lançamento (1800 - 2024)", 1800, 2024);

                        livro = new Livros(nome, descricao, valor, quantidade, codigo, autor, editora, genero, formato);
                        empresa.addProdutoEstoque(livro, quantidade);
                        itensCadastrados++;
                    }
                    break;

                case 4:
                    codigo = coletaLongComProtecao("Digite o código do produto:", 0, Long.MAX_VALUE);

                    tmpProduto = empresa.retornaProdutoDoEstoqueComCodigo(codigo);
                    if (tmpProduto != null){
                        if (tmpProduto instanceof Roupas){
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto da categoria de Roupa.", empresa.getNomeEmpresa(), 
                              		JOptionPane.WARNING_MESSAGE);
                            if(fazPergunta("Deseja adicionar estoque ao produto?\n\n" + tmpProduto.toString() + "\n\n")){
                                roupa = (Roupas) tmpProduto;

                                quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);
                                roupa.adicionaQuantidade(quantidade);
                            } else{
                                break;
                            }
                        } else {
                        	JOptionPane.showMessageDialog(null, "Código de produto já está em uso por produto de outro tipo! Insira outro código.", empresa.getNomeEmpresa(), 
                              		JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    } else {
                    	nome = JOptionPane.showInputDialog(null, "Insira o nome do produto: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                       

                    	descricao = JOptionPane.showInputDialog(null, "Insira a descrição: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	marca = JOptionPane.showInputDialog(null, "Insira a marca: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                        

                    	cor = JOptionPane.showInputDialog(null, "Insira a cor: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                    	categoria = JOptionPane.showInputDialog(null, "Insira a categoria: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                    	
                    	tamanho = JOptionPane.showInputDialog(null, "Insira o tamanho: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);

                       

                    	tecido = JOptionPane.showInputDialog(null, "Insira o tecido: " , 
                                empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
                           		);
                       

                        valor = coletaDoubleComProtecao("Insira o valor (em R$):", 0, Double.MAX_VALUE);
                        quantidade = coletaInteiroComProtecao("Insira a quantidade a ser adicionada no estoque (0 - 9999)", 0, 9999);

                        roupa = new Roupas(nome, descricao, marca, cor, categoria, valor, quantidade, codigo, tamanho, tecido);
                        empresa.addProdutoEstoque(roupa, quantidade);
                        itensCadastrados++;
                    }
                    break;

                case 5:
                    String listVal, showInfo;
                    ArrayList<Produto> tmpEstoque;
                    int indiceProduto;

                    tmpEstoque = empresa.visualizarEstoque();
                    listVal = listOptions(tmpEstoque);

                    showInfo = "Estoque:\n" + listVal + "\n\n";
                    indiceProduto = coletaRetornoUsuario(showInfo + "Digite o numero de uma das opções acima, ou 0 para Cancelar:", "", tmpEstoque.size(), iconCarrinho);

                    if(indiceProduto > 0){
                        empresa.removerProdutoEstoque(tmpEstoque.get(indiceProduto-1), tmpEstoque.get(indiceProduto-1).getQuantidade());
                        JOptionPane.showMessageDialog(null, "Item " + indiceProduto + " removido!", empresa.getNomeEmpresa(),
                                JOptionPane.INFORMATION_MESSAGE);
                        itensCadastrados++;
                    }
                    break;

                default:
                	JOptionPane.showMessageDialog(null, "Opção inválida!", empresa.getNomeEmpresa(), 
                      		JOptionPane.ERROR_MESSAGE);
            }

        } while (opcoes != 0);
        return itensCadastrados;
    };

    //Faz uma pergunta ao usuário, e retorna true se a resposta for verdadeira, e false se for falsa
    public static boolean fazPergunta(String pergunta){
        String resposta;
        String d;

        do {
        	d = JOptionPane.showInputDialog(null, pergunta + "\nDigite S para Sim, ou N para não" , 
                    empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
               		);
            
            try{
                resposta = String.valueOf(d);
            } catch (Exception e){
            	JOptionPane.showMessageDialog(null, "Por favor, insira uma resposta válida!", empresa.getNomeEmpresa(), 
                 		JOptionPane.ERROR_MESSAGE);
                
                resposta = "";
            }

        } while(!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));

        //Retorna true se a resposta for "S", retorna false se for "N"
        return resposta.equalsIgnoreCase("s");
    }

    public static double coletaDoubleComProtecao(String pergunta, double valorMinimo, double valorMaximo){
        double tmpOpcao;
        String c;

        do {
        	c = JOptionPane.showInputDialog(null, pergunta, 
                    empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
               		);
            try{
                tmpOpcao = Double.valueOf(c);
                
            } catch (Exception e){
            	 JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", empresa.getNomeEmpresa(), 
                 		JOptionPane.ERROR_MESSAGE);
                
                tmpOpcao = valorMinimo-1;
            }

        } while(tmpOpcao < valorMinimo || tmpOpcao > valorMaximo);

        return tmpOpcao;
    }

    public static int coletaInteiroComProtecao(String pergunta, int valorMinimo, int valorMaximo){
        int tmpOpcao;
        String b;

        do {
           b =  JOptionPane.showInputDialog(null, pergunta, 
                   empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
           		);
            try{
                tmpOpcao = Integer.valueOf(b);
                
            } catch (Exception e){
            	JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", empresa.getNomeEmpresa(), 
                  		JOptionPane.ERROR_MESSAGE);
                
                tmpOpcao = valorMinimo-1;
            }

        } while(tmpOpcao < valorMinimo || tmpOpcao > valorMaximo);

        return tmpOpcao;
    }

    public static long coletaLongComProtecao(String pergunta, long valorMinimo, long valorMaximo){
        long tmpOpcao;
        String b;

        do {
            b =  JOptionPane.showInputDialog(null, pergunta,
                    empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE
            );
            try{
                tmpOpcao = Integer.valueOf(b);

            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", empresa.getNomeEmpresa(),
                        JOptionPane.ERROR_MESSAGE);

                tmpOpcao = valorMinimo-1;
            }

        } while(tmpOpcao < valorMinimo || tmpOpcao > valorMaximo);

        return tmpOpcao;
    }

    public static int coletaRetornoUsuario(String pergunta, String valorRetorno, int itens){
        return coletaRetornoUsuario(pergunta, valorRetorno, itens, null);
    }

    public static int coletaRetornoUsuario(String pergunta, String valorRetorno, int itens, ImageIcon icon){
        int tmpOpcao;
        String a;
        int retVal;

        do {
        	if ((valorRetorno.equals("")) == false) {
            
        		a = (String) JOptionPane.showInputDialog(null,  "Escolha uma das opções:\n" +
                                "0) " + valorRetorno + "\n" + pergunta,
                        empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE, icon, null, "");
           } else {
        	   a = JOptionPane.showInputDialog(null,  pergunta + valorRetorno , 
                       empresa.getNomeEmpresa(), JOptionPane.QUESTION_MESSAGE 
               		);
        	   }
            try{
                if(a != null) {
                    tmpOpcao = Integer.valueOf(a);
                } else {
                    retVal = JOptionPane.showConfirmDialog(null, "Selecionar a opção:\n" + valorRetorno + "?", "Alerta!", JOptionPane.YES_NO_OPTION);
                    if (retVal == 0){
                        tmpOpcao = 0;
                    } else {
                        tmpOpcao = -1;
                    }

                }
               
            } catch (Exception e){
            	 JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido!", empresa.getNomeEmpresa(), 
                  		JOptionPane.ERROR_MESSAGE);
                
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
