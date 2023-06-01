package Entities;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nomeEmpresa;
    private List<Produto> carrinho = new ArrayList<>();
    private List<Produto> estoque = new ArrayList<>();

    public Empresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nomeEmpresa='" + nomeEmpresa + '\'' +
                ", carrinho=" + carrinho +
                ", estoque=" + estoque +
                '}';
    }

    public void addProdutoEstoque(Produto produto, int quantidade){
        for (int i=0; i<quantidade; i++){
            estoque.add(produto);
        }
        System.out.println(estoque);
    }

    public void removerProdutoEstoque(Produto produto, int quantidade) {
        int count = 0; // Contador para verificar o número de ocorrências do produto no estoque

        // Verifica a quantidade de ocorrências do produto no estoque
        for (Produto p : estoque) {
            if (p.equals(produto)) {
                count++;
            }
        }
        // Verifica se a quantidade no estoque é maior ou igual à quantidade desejada
        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                estoque.remove(produto);
            }
            System.out.println(estoque);
        } else {
            //da pra tipo, se o cara tentar tirar mais produtos do que tem ali no carrinho, so pegar e zerar aquele produto no estoque dele, ou exibir alguma msg, isso é detalhe, a gente pensa
            System.out.println("Tem apenas " + count + " " + produto.getNome() + " no estoque.");
        }
    }
    public void addProdutoCarrinho(Produto produto, int quantidade) {
        int count = 0; // Contador para verificar o número de ocorrências do produto no estoque

        // Verifica a quantidade de ocorrências do produto no estoque
        for (Produto p : estoque) {
            if (p.equals(produto)) {
                count++;
            }
        }

        // Verifica se a quantidade no estoque é maior ou igual à quantidade desejada
        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                carrinho.add(produto);
            }
            System.out.println(carrinho);
        } else {
            System.out.println("Quantidade insuficiente no estoque.");
        }
    }

    public void removerProdutoCarrinho(Produto produto, int quantidade){
        int count = 0; // Contador para verificar o número de ocorrências do produto no carrinho (para nao ser possivel ter 2 mouses no carrinho e querer tirar 3

        // Verifica a quantidade de ocorrências do produto no carrinho
        for (Produto p : carrinho) {
            if (p.equals(produto)) {
                count++;
            }
        }
        // Verifica se a quantidade no estoque é maior ou igual à quantidade desejada
        if (count >= quantidade) {
            for (int i = 0; i < quantidade; i++) {
                carrinho.remove(produto);
            }
            System.out.println(carrinho);
        } else {
            //da pra tipo, se o cara tentar tirar mais produtos do que tem ali no carrinho, so pegar e zerar aquele produto no carrinho dele, ou exibir alguma msg, isso é detalhe, a gente pensa
            System.out.println("Tem apenas " + count + " " + produto.getNome() + " no seu carrinho.");
        }
    }
}
