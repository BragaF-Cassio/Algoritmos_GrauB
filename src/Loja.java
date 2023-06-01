package Application;

import Entities.Eletronicos;
import Entities.Empresa;
import Entities.Produto;

import java.util.Locale;
import java.util.Scanner;

public class Loja {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //O que tem aqui é só de teste mesmo, dps tem que fazer menu e tals, mas so caso alguem queira testar pra ver como que fiz ali a classe empresa e tal
        //Criando a loja
        Empresa empresa = new Empresa("Amazon");
        //Criando produtos de teste
        Produto mouse = new Eletronicos("Mouse gamer", "Mouse para jogos", "Corsair", "Cinza", "Gamer", 49.99,  2020);
        Produto carregadorIphone = new Eletronicos("Carregador de Iphone", "Carregador homologado Apple", "Apple", "Branco", "Carregador", 89.99,  2022);
        Produto samsungA10 = new Eletronicos("Celular Samsung A10", "Celular ótimo custo benefício", "Samsung", "Preto", "Celulares", 1200.00,  2019);
        Produto notebook = new Eletronicos("Notebook Acer Aspire II", "Notebook para dia a dia", "Acer", "Prata", "Notebook", 3999.99,  2019);

        empresa.addProdutoEstoque(mouse, 4);
//        empresa.addProdutoEstoque(carregadorIphone, 2);
//        empresa.addProdutoEstoque(samsungA10, 1);
//        empresa.addProdutoEstoque(notebook, 2);
//        System.out.println(empresa.toString());
//        System.out.println();
        System.out.println("Agora, vamos adicionar itens ao carrinho");
        System.out.println();
        empresa.addProdutoCarrinho(mouse, 2);
//        empresa.addProdutoCarrinho(carregadorIphone, 2);
//        empresa.addProdutoCarrinho(notebook, 3);

    }

}
