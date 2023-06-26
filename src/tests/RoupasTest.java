package tests;

import Trabalho.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoupasTest {
	 
	@Test
	final void testToString() {
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Roupas a = new Roupas("Camisa Polo", "Camisa com gola", 
				"Polo", "Azul", "Camisa", 29.99, 3, 312331, "M", "Algodao"); 
        String esperado = "{Nome='" + "Camisa Polo" + '\'' +
                ", Valor=" + 29.99 +
                ", Tamanho='" + "M" + '\'' +
                ", Tecido='" + "Algodao" + '\'' +
                ", Descricao='" + "Camisa com gola" + '\'' +
                ", Marca='" + "Polo" + '\'' +
                ", Cor='" + "Azul" + '\'' +
                ", Categoria='" + "Camisa" + '\'' +
                ", Quantidade=" + 3 +
                ", Codigo=" + 312331 +
                '}';
        assertEquals(esperado, a.toString());
        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
        
        
	}

	@Test
	final void testRoupas() {
		
		//Esse teste foi feito para ver se o construtor Roupas() funciona com todos os argumentos.
		
		Roupas s = new Roupas("Camisa Polo", "Camisa com gola", 
				"Polo", "Azul", "Camisa", 29.99, 3, 312331, "M", "Algodao");  
		
		
		 assertEquals("Camisa Polo", s.getNome());
		 assertEquals("Camisa com gola", s.getDescricao());
		 assertEquals("Polo", s.getMarca());
		 assertEquals("Azul", s.getCor());
		 assertEquals("Camisa", s.getCategoria());
		 assertEquals(29.99, s.getValor());
		 assertEquals(3, s.getQuantidade());
		 assertEquals(312331, s.getCodigo());
		 assertEquals("M", s.getTamanho());
		 assertEquals("Algodao", s.getTecido());
		 
		
		 
         assertEquals(true,(s.getNome() instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.getDescricao() instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.getCategoria() instanceof String) ); //Testar se a categoria é uma string .
		 
		  assertEquals(true,(s.getMarca() instanceof String) ); //Testar se a marca é uma string .
		 
          assertEquals(true,(s.getCor() instanceof String) ); //Testar se o cor é uma string .
		 
          assertEquals(true,(s.getTamanho() instanceof String) ); //Testar se o Tamanho é uma string .
 		 
          assertEquals(true,(s.getTecido() instanceof String) ); //Testar se o Tecido é uma string .
          
          
		 
		 
		 assertTrue(s.getValor() > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.getQuantidade() < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.getQuantidade() < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.getCodigo(), Long.toString(s.getCodigo()) ); //Testar se o codigo nao é uma String .
		 
		 
	}

	@Test
	final void testGetTamanho() {
		
		//Esse teste foi feito para ver se o getTamanho() pega o tamanho colocado no argumento do construtor.
		
		Roupas e = new Roupas(null, null, null, null, null, 0, 0, 0, "M", null); // Nesse caso, o tamanho é M. 
		
		
		
		
		assertEquals("M", e.getTamanho());
		assertEquals(true,(e.getTamanho() instanceof String) ); //Testar se o Tamanho é uma string .
		
		
		
		
	}

	
	@Test
	final void testSetTamanho() {
		
		//Esse teste foi feito para ver se o setTamanho() atribui o tamanho na Classe Roupas.
        
		Roupas e = new Roupas(null, null, null, null, null, 0, 0, 0, null, null);  
		  
		 e.setTamanho("M"); // Nesse caso, o Tamanho é M.
		
		assertEquals("M", e.getTamanho());
		
		assertEquals(true,(e.getTamanho() instanceof String) ); //Testar se o Tamanho é uma string .
	}
	
	@Test
	final void testGetTecido() {
		
		//Esse teste foi feito para ver se o getTecido() pega o tamanho colocado no argumento do construtor.
		
		Roupas e = new Roupas(null, null, null, null, null, 0, 0, 0, null, "Algodao"); // Nesse caso, o tecido é Algodao. 
		
		
		
		
		assertEquals("Algodao", e.getTecido());
		assertEquals(true,(e.getTecido() instanceof String) ); //Testar se o Tecido é uma string .
		
		
		
		
	}

	
	@Test
	final void testSetTecido() {
		
		//Esse teste foi feito para ver se o setTecido() atribui o ano na Classe Roupas.
        
		Roupas e = new Roupas(null, null, null, null, null, 0, 0, 0, null, null);  
		  
		 e.setTecido("Algodao"); // Nesse caso, o Tecido é Algodao.
		
		assertEquals("Algodao", e.getTecido());
		
		assertEquals(true,(e.getTecido() instanceof String) ); //Testar se o Tecido é uma string .
	}
	
	
	

}
