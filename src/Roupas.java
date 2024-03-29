package Trabalho;
public class Roupas extends Produto{
    private String tamanho, tecido;

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTecido() {
        return tecido;
    }

    public void setTecido(String tecido) {
        this.tecido = tecido;
    }

    public Roupas(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade, long codigo, String tamanho, String tecido) {
        super(nome, descricao, marca, cor, categoria, valor, quantidade, codigo);
        this.tamanho = tamanho;
        this.tecido = tecido;
    }

    public Roupas(Roupas outro){
        super(outro);
    }

    @Override
    public String toString() {
        return "Roupas{" +
                "tamanho='" + tamanho + '\'' +
                ", tecido='" + tecido + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", codigo=" + codigo +
                '}';
    }
}
