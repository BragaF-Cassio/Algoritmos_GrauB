package Entities.empresa;

public class Livros extends Produto {
    private String autor;
    private String editora;
    private String genero;
    private String formato;

    public Livros(String nome, String descricao, double valor, int quantidade, long codigo, String autor, String editora, String genero, String formato) {
        super(nome, descricao, valor, quantidade, codigo);
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.formato = formato;
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
        return "Livros{" +
                "Autor: " + autor +
                "editora= " + editora +
                "genero= " + genero +
                "formato= " + formato +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}