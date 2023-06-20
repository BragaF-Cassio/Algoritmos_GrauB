package Trabalho;

public class Item {
    Produto produto;
    int quantidade;

    public Item(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int adicionaQuantidade(int quant){
        if (quant > 0) {
            this.quantidade += quant;
        } else {
            System.out.println("Você deve adicionar uma quantidade positiva de itens!");
        }
        return this.quantidade;
    }

    public int removeQuantidade(int quant) {
        if (quant > this.quantidade) {
            this.quantidade = 0;
        }else if (quant > 0) {
            this.quantidade -= quant;
        } else {
            System.out.println("Você deve adicionar uma quantidade positiva de itens!");
        }
        return this.quantidade;
    }

    public int limpaQuantidade(){
        this.quantidade = 0;
        return this.quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Item{" +
                "produto=" + produto.toString() +
                ", quantidade=" + quantidade +
                '}';
    }
}
