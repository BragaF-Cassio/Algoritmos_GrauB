package trabalho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoupasTest {
	 
	@Test
	final void testToString() {
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Roupas a = new Roupas("Camisa Polo", "Camisa com gola", 
				"Polo", "Azul", "Camisa", 29.99, 3, 312331, "M", "Algodao"); 
        String esperado = "Roupas{" +
                "tamanho='" + "M" + '\'' +
                ", tecido='" + "Algodao" + '\'' +
                ", nome='" + "Camisa Polo" + '\'' +
                ", descricao='" + "Camisa com gola" + '\'' +
                ", marca='" + "Polo" + '\'' +
                ", cor='" + "Azul" + '\'' +
                ", categoria='" + "Camisa" + '\'' +
                ", valor=" + 29.99 +
                ", quantidade=" + 3 +
                ", codigo=" + 312331 +
                '}';
        assertEquals(esperado, a.toString());
        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
        
        
	}

	@Test
	final void testRoupas() {
		
		//Esse teste foi feito para ver se o construtor Roupas() funciona com todos os argumentos.
		
		Roupas s = new Roupas("Camisa Polo", "Camisa com gola", 
				"Polo", "Azul", "Camisa", 29.99, 3, 312331, "M", "Algodao");  
		
		
		 assertEquals("Camisa Polo", s.nome);
		 assertEquals("Camisa com gola", s.descricao);
		 assertEquals("Polo", s.marca);
		 assertEquals("Azul", s.cor);
		 assertEquals("Camisa", s.categoria);
		 assertEquals(29.99, s.valor);
		 assertEquals(3, s.quantidade);
		 assertEquals(312331, s.codigo);
		 assertEquals("M", s.getTamanho());
		 assertEquals("Algodao", s.getTecido());
		 
		
		 
         assertEquals(true,(s.nome instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.descricao instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.categoria instanceof String) ); //Testar se a categoria é uma string .
		 
		  assertEquals(true,(s.marca instanceof String) ); //Testar se a marca é uma string .
		 
          assertEquals(true,(s.cor instanceof String) ); //Testar se o cor é uma string .
		 
          assertEquals(true,(s.getTamanho() instanceof String) ); //Testar se o Tamanho é uma string .
 		 
          assertEquals(true,(s.getTecido() instanceof String) ); //Testar se o Tecido é uma string .
          
          
		 
		 
		 assertTrue(s.valor > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.quantidade < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.quantidade < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.codigo , Long.toString(s.codigo) ); //Testar se o codigo nao é uma String .
		 
		 
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
