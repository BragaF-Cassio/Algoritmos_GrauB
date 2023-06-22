package Trabalho;
public class Livros extends Produto {
    private String autor;
    private String editora;
    private String genero;
    private String formato;
    public static int contList = 0;

    public Livros(String nome, String descricao, double valor, int quantidade, long codigo, String autor, String editora, String genero, String formato) {
        super(nome, descricao, valor, quantidade, codigo);
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.formato = formato;
    }

    public Livros(Livros outro) {
        super(outro);
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    

    @Override
    public String toString() {
    	
    	contList++; // Contagem para Listar
        return " \n" + contList + ") " +
                "nome: " + nome +
                "Autor: " + autor +
                "editora: " + editora +
                "genero: " + genero +
                "formato: " + formato +
                ", descricao:'" + descricao + '\'' +
                ", valor:" + valor +
                ", quantidade = " + quantidade +
                "\n";
    }
}
