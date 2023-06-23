package Trabalho;
public class Eletrodomestico extends Produto{
    private String eficienciaEnergetica;
    public static int contList = 0;

    public Eletrodomestico(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade, String eficienciaEnergetica, long codigo) {
        super(nome, descricao, marca, cor, categoria, valor, quantidade, codigo);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public Eletrodomestico(Eletrodomestico outro){
        super(outro);
    }

    public String getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }

    public void setEficienciaEnergetica(String eficienciaEnergetica) {
        this.eficienciaEnergetica = eficienciaEnergetica;
    }
    
    @Override
    public String toString() {
    	
    	contList++; // Contagem para Listar
        return " \n" + contList  +
                
                ", nome = " + nome + '\'' +
                ", descricao = " + descricao + '\'' +
                ", Eficiencia Energetica = " + eficienciaEnergetica +
                ", marca = " + marca + '\'' +
                ", cor = " + cor + '\'' +
                ", categoria = " + categoria + '\'' +
                ", valor = " + valor +
                ", quantidade = " + quantidade +
                ",  codigo = " + codigo +
                "\n";
    }



}


