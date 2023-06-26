package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Trabalho.*;


class ItemTest {

	@Test
	final void testToString() {

	//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.
            Produto p = new Livros(null, null, 0, 0, 0, null, null, null, null);
			Item a = new Item(p, 0); //Quantidade = 0.
	        String esperado = "Item{" +
	                "produto=" + p.toString() +
	                ", quantidade=" + 0 +
	                '}';
	        assertEquals(esperado, a.toString());
	        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .

}
	@Test
	final void testItem() {
		//Esse teste foi feito para ver se o construtor Item() funciona com todos os argumentos.
		
				Produto s = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
						"Ht Micron", "Azul", "Capacitores", 9.99, 3, 312331, 2009);  
				Item a = new Item(s, 0); //Quantidade = 0.
				
				 assertEquals("Capacitor 20A", a.getProduto().getNome());
				 assertEquals("Capacitor com 20A", a.getProduto().getDescricao());
				 assertEquals("Ht Micron", a.getProduto().getMarca());
				 assertEquals("Azul", a.getProduto().getCor());
				 assertEquals("Capacitores", a.getProduto().getCategoria());
				 assertEquals(9.99, a.getProduto().getValor());
				 assertEquals(3, a.getProduto().getQuantidade());
				 assertEquals(312331, a.getProduto().getCodigo());
				 assertEquals(0, a.getQuantidade());
				 
		         assertEquals(true,(a.getProduto().getNome() instanceof String) );  //Testar se o nome é uma string .
				 
				 assertEquals(true,(a.getProduto().getDescricao() instanceof String) );  //Testar se a descricao é uma string .
				 
		          assertEquals(true,(a.getProduto().getCategoria() instanceof String) ); //Testar se a categoria é uma string .
				 
				  assertEquals(true,(a.getProduto().getMarca() instanceof String) ); //Testar se a marca é uma string .
				 
		          assertEquals(true,(a.getProduto().getCor() instanceof String) ); //Testar se o cor é uma string .
				 
			}
	

	@Test
	final void testAdicionaQuantidade() {
		//Esse teste foi feito para ver se o adicionaQuantidade() adiciona a quantidade colocado no argumento do construtor.
		
		Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4.
   	
		//  A quantidade deve retornar  7, pois estou testando o segundo if da funcao,
		//	que diz que se o argumento for maior que 0 a quantidade sera removida. 
	       
		assertEquals(7, e.adicionaQuantidade(3)); //Adicionei 3: 4 + 3 = 7.
	}
	
	@Test
	final void testAdicionaQuantidade1else() {
		//Esse teste foi feito para ver se o adicionaQuantidade() adiciona a quantidade colocado no argumento do construtor.
		
		Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4.
   	
		//  A quantidade deve retornar a mesma esperado, 
		// pois estou testando o else da funcao que retorna o mesmo valor 
		// de antes caso o argumento for negativo.
	      
	       
	       assertEquals(4, e.adicionaQuantidade(-3)); //Adicionei -3.
	}

	@Test
	final void testRemoveQuantidade() {
		//Esse teste foi feito para ver se o removeQuantidade() remove a quantidade colocado no argumento do construtor.
		
				Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4.
		   	
				//  A quantidade deve retornar  1, pois estou testando o segundo if da funcao,
				//	que diz que se o argumento for maior que 0 a quantidade sera removida. 
			       assertEquals(1, e.removeQuantidade(3)); //Removi 3: 4 - 3 = 1.
			          
		     
	}
	
	

       @Test
   	final void testRemoveQuantidade1if() {
   		//Esse teste foi feito para ver se o removeQuantidade() remove a quantidade colocado no argumento do construtor.
   		
   				Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4.
   		   	
   			//  A quantidade deve retornar  0, pois estou testando o primeiro if da funcao,
   				//	que diz que se o argumento for maior que a quantidade a quantidade sera 0. 
   			       assertEquals(0, e.removeQuantidade(5)); //5 > 4
   			       
   			   
   		     
   	}
	@Test
	final void testLimpaQuantidade() {
		
		//Esse teste foi feito para ver se o limpaQuantidade() limpa a quantidade colocado no argumento do construtor.
		
		Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4.
		
       assertEquals(0, e.limpaQuantidade()); //  A quantidade deve retornar  0.
		
       assertNotEquals(e.limpaQuantidade() , Integer.toString(e.limpaQuantidade()) ); //Testar se nao retorna  uma String .
		
	}

	@Test
	final void testGetProduto() {
	//Esse teste foi feito para ver se o getProduto() pega o Produto colocado no argumento do construtor.
		
		Produto s = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
				"Ht Micron", "Azul", "Capacitores", 9.99, 3, 312331, 2009); 
		Item e = new Item(s, 0); // Nesse caso, o Produto é Eletronicos. 
		
		String esperado = "{Nome='" + "Capacitor 20A" + '\'' +
                ", Valor=" + 9.99 +
                ", Descrição='" + "Capacitor com 20A" + '\'' +
                ", Ano De Lancamento=" + 2009 +
                ", Marca='" + "Ht Micron" + '\'' +
                ", Cor='" + "Azul" + '\'' +
                ", Categoria='" + "Capacitores" + '\'' +
                ", Quantidade=" + 3 +
                '}';
		
		
		assertEquals(esperado, e.getProduto().toString());
		
		assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
		
	
	}

	@Test
	final void testGetQuantidade() {
	//Esse teste foi feito para ver se o getQuantidade() pega a quantidade colocado no argumento do construtor.
		
		Item e = new Item(null, 4); // Nesse caso, a quantidade  é 4. 
		
		
		
		assertEquals(4, e.getQuantidade());
		
		assertTrue(e.getQuantidade() >= 0); //Testar se quantidade é maior ou igual a 0.
		
		
	}

	
	
	
}
