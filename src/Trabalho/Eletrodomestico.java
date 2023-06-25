package Trabalho;

public class Eletrodomestico extends Produto{
    private String eficienciaEnergetica;

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
        return  "{Nome='" + nome + '\'' +
                ", Valor=" + valor +
                ", Descrição='" + descricao + '\'' +
                ", Eficiência Energética=" + eficienciaEnergetica +
                ", Marca='" + marca + '\'' +
                ", Cor='" + cor + '\'' +
                ", Categoria='" + categoria + '\'' +
                ", Quantidade=" + quantidade +
                ", Código=" + codigo +
                '}';
    }



}


