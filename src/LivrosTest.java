package Package_Test_Case;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LivrosTest {

	@Test
	final void testToString() {
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

				Livros a = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 
						"Mercado Livre", "Azul", "Capa Dura", 9.99, 3,  "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico"); 
		        String expected = "Livros{" +
		                "Autor: " + "Julio Verne" +
		                "editora = " +  "Penguin Books" +
		                "genero = " + "Aventura" +
		                "formato = " + "Livro Fisico" +
		                ", nome = " + "A Volta ao Mundo em 80 dias" + '\'' +
		                ", descricao = " + "O livro é sobre um homem que percorre o mundo em 80 dias" + '\'' +
		                ", marca = " + "Mercado Livre" + '\'' +
		                ", cor = " + "Azul" + '\'' +
		                ", categoria = " + "Capa Dura" + '\'' +
		                ", valor = " + 9.99 +
		                ", quantidade = " + 3 +
		                '}';
		        assertEquals(expected, a.toString());
	}

	@Test
	final void testLivros() {

		//Esse teste foi feito para ver se o construtor Livros() funciona com todos os argumentos.
		
		Livros s = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 
				"Mercado Livre", "Azul", "Capa Dura", 9.99, 3,  "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico");  
		
		
		 assertEquals("A Volta ao Mundo em 80 dias", s.nome);
		 assertEquals("O livro é sobre um homem que percorre o mundo em 80 dias", s.descricao);
		 assertEquals("Mercado Livre", s.marca);
		 assertEquals("Azul", s.cor);
		 assertEquals("Capa Dura", s.categoria);
		 assertEquals(9.99, s.valor);
		 assertEquals(3, s.quantidade);
		 assertEquals("Julio Verne", s.getAutor());
		 assertEquals("Penguin Books", s.getEditora());
		 assertEquals("Aventura", s.getGenero());
		 assertEquals("Livro Fisico", s.getFormato());
		 
		 
	}

	@Test
	final void testGetAutor() {

		//Esse teste foi feito para ver se o getAutor() pega o autor colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, null, null, null, 0, 0, "Agatha Cristi", null, null, null); 
		// Nesse caso, a autora é Agatha Cristi. 
		
		
		
		
		assertEquals("Agatha Cristi", e.getAutor());
	}

	@Test
	final void testSetAutor() {

		//Esse teste foi feito para ver se o setAutor() atribui o autor na Classe Livros.
        
		Livros t = new Livros(null, null, null, null, null, 0, 0, null, null, null, null);  
		  
		 
		t.setAutor("Agatha Cristi"); // Nesse caso, a autora é a Agatha Cristi.
		
		
		assertEquals("Agatha Cristi", t.getAutor());
	}

	@Test
	final void testGetEditora() {

		//Esse teste foi feito para ver se o getEditora() pega a editora colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, null, null, null, 0, 0, null , "Bookman", null, null); 
		// Nesse caso, a editora é Bookman. 
		
		
		
		
		assertEquals("Bookman", e.getEditora());
	}

	@Test
	final void testSetEditora() {
		
		
		//Esse teste foi feito para ver se o setEditora() atribui a editora na Classe Livros.
        
				Livros t = new Livros(null, null, null, null, null, 0, 0, null, null, null, null);  
				  
				 
				t.setEditora("Bookman"); // Nesse caso, a editora é a Bookman.
				
				
				assertEquals("Bookman", t.getEditora());
	}

	@Test
	final void testGetGenero() {

		//Esse teste foi feito para ver se o getGenero() pega o genero colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, null, null, null, 0, 0, null , null, "Suspense", null); 
		// Nesse caso, o genero é suspense. 
		
		
		
		
		assertEquals("Suspense", e.getGenero());
	}

	@Test
	final void testSetGenero() {
		
		//Esse teste foi feito para ver se o setGenero() atribui o genero na Classe Livros.
        
				Livros t = new Livros(null, null, null, null, null, 0, 0, null, null, null, null);  
				  
				 
				t.setGenero("Suspense"); // Nesse caso, o genero é suspense.
				
				
				assertEquals("Suspense", t.getGenero());
	}

	@Test
	final void testGetFormato() {

		//Esse teste foi feito para ver se o getFormato() pega o formato colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, null, null, null, 0, 0, null , null , null, "PDF"); 
		// Nesse caso, o formato é PDF. 
		
		
		
		
		assertEquals("PDF", e.getFormato());
	}

	@Test
	final void testSetFormato() {

		//Esse teste foi feito para ver se o setGenero() atribui o genero na Classe Livros.
        
				Livros t = new Livros(null, null, null, null, null, 0, 0, null, null, null, null);  
				  
				 
				t.setFormato("PDF"); // Nesse caso, o formato é PDF.
				
				
				assertEquals("PDF", t.getFormato());
	}

}
