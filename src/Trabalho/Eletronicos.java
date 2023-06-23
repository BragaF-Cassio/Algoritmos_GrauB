package Trabalho;
public class Eletronicos extends Produto {
    private int anoDeLancamento;
    public static int contList = 0;

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
    	
    	contList++; // Contagem para Listar
    	
        return " \n" + contList + ") " +
                
                "nome = " + nome + '\'' +
                ", descricao = " + descricao + '\'' +
                ", anoDeLancamento = " + anoDeLancamento +
                ", marca = " + marca + '\'' +
                ", cor = " + cor + '\'' +
                ", categoria = " + categoria + '\'' +
                ", valor = " + valor +
                ", quantidade = " + quantidade +
                "\n";
    }
}
