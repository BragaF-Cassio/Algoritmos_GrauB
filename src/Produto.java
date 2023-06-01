public abstract class Produto {
    protected String nome, descricao, marca, cor, categoria;
    protected double valor;
    protected int quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(String nome, String descricao, double valor, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public Produto(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.marca = marca;
        this.cor = cor;
        this.categoria = categoria;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", cor='" + cor + '\'' +
                ", categoria='" + categoria + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }

    public void mostrarInformacoes(){
        System.out.println(this.toString());
    }
}
