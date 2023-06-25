package Trabalho;

public class Eletronicos extends Produto {
    private int anoDeLancamento;

    public Eletronicos(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade, long codigo, int anoDeLancamento) {
        super(nome, descricao, marca, cor, categoria, valor, quantidade, codigo);
        this.anoDeLancamento = anoDeLancamento;
    }

    public Eletronicos(Eletronicos outro){
        super(outro);
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "{Nome='" + nome + '\'' +
                ", Valor=" + valor +
                ", Descrição='" + descricao + '\'' +
                ", Ano De Lancamento=" + anoDeLancamento +
                ", Marca='" + marca + '\'' +
                ", Cor='" + cor + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Quantidade=" + quantidade +
                '}';
    }
}
