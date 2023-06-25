package tests;

import Trabalho.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class LivrosTest {

	@Test
	final void testToString() {
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

				Livros a = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 
						9.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico"); 
		        String esperado = "Livros{" +
		                "Autor: " + "Julio Verne" +
		                "editora= " + "Penguin Books" +
		                "genero= " + "Aventura" +
		                "formato= " + "Livro Fisico" +
		                ", nome='" + "A Volta ao Mundo em 80 dias" + '\'' +
		                ", descricao='" + "O livro é sobre um homem que percorre o mundo em 80 dias" + '\'' +
		                ", valor=" + 9.99 +
		                ", quantidade=" +  3 +
		                '}';
		        assertEquals(esperado, a.toString());
		        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
	}

	@Test
	final void testLivros() {

		Double valor ;
		//Esse teste foi feito para ver se o construtor Livros() funciona com todos os argumentos.
		
		Livros s = new Livros("A Volta ao Mundo em 80 dias", "O livro é sobre um homem que percorre o mundo em 80 dias", 
				9.99 , 3, 121323,   "Julio Verne", "Penguin Books", "Aventura", "Livro Fisico"); 
		
		
		 assertEquals("A Volta ao Mundo em 80 dias", s.getNome());
		 assertEquals("O livro é sobre um homem que percorre o mundo em 80 dias", s.getDescricao());
		 assertEquals(9.99, s.getValor());
		 assertEquals(3, s.getQuantidade());
		 assertEquals(121323, s.getCodigo());
		 assertEquals("Julio Verne", s.getAutor());
		 assertEquals("Penguin Books", s.getEditora());
		 assertEquals("Aventura", s.getGenero());
		 assertEquals("Livro Fisico", s.getFormato());
		 
		 assertEquals(true,(s.getNome() instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.getDescricao() instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.getAutor() instanceof String) ); //Testar se o autor é uma string .
		 
		  assertEquals(true,(s.getEditora() instanceof String) ); //Testar se a editora é uma string .
		 
          assertEquals(true,(s.getGenero() instanceof String) ); //Testar se o genero é uma string .
		 
		 assertEquals(true,(s.getFormato() instanceof String) ); //Testar se o formato é uma string .
		 
		 
		 assertTrue(s.getValor() > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.getQuantidade() < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.getQuantidade() < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.getCodigo(), Long.toString(s.getCodigo()) ); //Testar se o codigo nao é uma String .
		 
		 
		 
	}

	@Test
	final void testGetAutor() {

		//Esse teste foi feito para ver se o getAutor() pega o autor colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, 0, 0, 0, "Agatha Cristi", null, null, null); 
		// Nesse caso, a autora é Agatha Cristi. 
		
		
		
		
		assertEquals("Agatha Cristi", e.getAutor()); //Testar se o getAutor() está certo. .
		assertEquals(true,(e.getAutor() instanceof String) ); //Testar se o autor é uma string .
		
		
		
	}

	@Test
	final void testSetAutor() {

		//Esse teste foi feito para ver se o setAutor() atribui o autor na Classe Livros.
        
		Livros t = new Livros(null, null, 0, 0, 0, null, null, null, null);  
		  
		 
		t.setAutor("Agatha Cristi"); // Nesse caso, a autora é a Agatha Cristi.
		
		
		assertEquals("Agatha Cristi", t.getAutor()); //Testar se o setAutor() está certo. 
		
		assertEquals(true,(t.getAutor() instanceof String) ); //Testar se o autor é uma string .
	}

	@Test
	final void testGetEditora() {

		//Esse teste foi feito para ver se o getEditora() pega a editora colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, 0, 0, 0, null, "Bookman", null, null); 
		// Nesse caso, a editora é Bookman. 
		
		
		
		
		assertEquals("Bookman", e.getEditora()); //Testar se o getEditora() está certo.
		
		assertEquals(true,(e.getEditora() instanceof String) ); //Testar se o getEditora() está certo.
	}

	@Test
	final void testSetEditora() {
		
		
		//Esse teste foi feito para ver se o setEditora() atribui a editora na Classe Livros.
        
				Livros t = new Livros(null, null, 0, 0, 0, null, null, null, null);  
				  
				 
				t.setEditora("Bookman"); // Nesse caso, a editora é a Bookman.
				
				
				assertEquals("Bookman", t.getEditora());
				
				assertEquals(true,(t.getEditora() instanceof String) );
	}

	@Test
	final void testGetGenero() {

		//Esse teste foi feito para ver se o getGenero() pega o genero colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, 0, 0, 0, null, null, "Suspense", null); 
		// Nesse caso, o genero é suspense. 
		
		
		
		
		assertEquals("Suspense", e.getGenero());
		
		assertEquals(true,(e.getGenero() instanceof String) );
	}

	@Test
	final void testSetGenero() {
		
		//Esse teste foi feito para ver se o setGenero() atribui o genero na Classe Livros.
        
				Livros t = new Livros(null, null, 0, 0, 0, null, null, null, null);  
				  
				 
				t.setGenero("Suspense"); // Nesse caso, o genero é suspense.
				
				
				assertEquals("Suspense", t.getGenero());
				
				assertEquals(true,(t.getGenero() instanceof String) );
	}

	@Test
	final void testGetFormato() {

		//Esse teste foi feito para ver se o getFormato() pega o formato colocado no argumento do construtor.
		
		Livros e = new Livros(null, null, 0, 0, 0, null, null, null, "PDF"); 
		// Nesse caso, o formato é PDF. 
		
		
		
		
		assertEquals("PDF", e.getFormato());
		
		assertEquals(true,(e.getFormato() instanceof String) );
	}

	@Test
	final void testSetFormato() {

		//Esse teste foi feito para ver se o setGenero() atribui o genero na Classe Livros.
        
				Livros t = new Livros(null, null, 0, 0, 0, null, null, null, null);  
				  
				 
				t.setFormato("PDF"); // Nesse caso, o formato é PDF.
				
				
				assertEquals("PDF", t.getFormato());
				
				assertEquals(true,(t.getFormato() instanceof String) );
	}

}