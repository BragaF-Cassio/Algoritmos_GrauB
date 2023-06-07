package Entities.empresa;

public class Eletronicos extends Produto {
    private int anoDeLancamento;

    public Eletronicos(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade, long codigo, int anoDeLancamento) {
        super(nome, descricao, marca, cor, categoria, valor, quantidade, codigo);
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public String toString() {
        return "Eletronicos{" +
                "anoDeLancamento=" + anoDeLancamento +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
