package tests;

import Trabalho.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EletrodomesticoTest {

	@Test
	final void testToString() {
		
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Eletrodomestico a = new Eletrodomestico("Ventilador", "Ventilador com Repelente", 
				"Phillips", "Preto", "Ventiladores", 20.99, 3, "Grau B", 312331); 
        String esperado = "{Nome='" + "Ventilador" + '\'' +
                ", Valor=" + 20.99 +
                ", Descrição='" + "Ventilador com Repelente" + '\'' +
                ", Eficiência Energética=" + "Grau B" +
                ", Marca='" + "Phillips" + '\'' +
                ", Cor='" + "Preto" + '\'' +
                ", Categoria='" + "Ventiladores" + '\'' +
                ", Quantidade=" + 3 +
                ", Código=" + 312331 +
                '}';
        assertEquals(esperado, a.toString());
        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
        
        
	}

	@Test
	final void testEletrodomestico() {
		
		//Esse teste foi feito para ver se o construtor Eletrodomestico() funciona com todos os argumentos.
		
		Eletrodomestico s = new Eletrodomestico("Ventilador", "Ventilador com Repelente", 
				"Phillips", "Preto", "Ventiladores", 20.99, 3, "Grau B", 312331);   
		
		
		 assertEquals("Ventilador", s.getNome());
		 assertEquals("Ventilador com Repelente", s.getDescricao());
		 assertEquals("Phillips", s.getMarca());
		 assertEquals("Preto", s.getCor());
		 assertEquals("Ventiladores", s.getCategoria());
		 assertEquals(20.99, s.getValor());
		 assertEquals(3, s.getQuantidade());
		 assertEquals(312331, s.getCodigo());
		 assertEquals("Grau B", s.getEficienciaEnergetica());
		 
         assertEquals(true,(s.getNome() instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.getDescricao() instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.getCategoria() instanceof String) ); //Testar se a categoria é uma string .
		 
		  assertEquals(true,(s.getMarca() instanceof String) ); //Testar se a marca é uma string .
		 
          assertEquals(true,(s.getCor() instanceof String) ); //Testar se o cor é uma string .
		 
          assertEquals(true,(s.getEficienciaEnergetica() instanceof String) ); //Testar se a Eficiencia Energetica é uma string .
          
          
          
		 
		 assertTrue(s.getValor() > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.getQuantidade() < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.getQuantidade() < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.getCodigo(), Long.toString(s.getCodigo()) ); //Testar se o codigo nao é uma String .
		 
		 
	}

	@Test
	final void testGetEficienciaEnergetica() {
		
		//Esse teste foi feito para ver se o getEficienciaEnergetica() pega o grau colocado no argumento do construtor.
		
		Eletrodomestico e = new Eletrodomestico(null, null, null, null, null, 0, 0, "Grau B", 0);   // Nesse caso, o grau é B. 
		
		
		
		
		assertEquals("Grau B", e.getEficienciaEnergetica());
		
	    assertEquals(true,(e.getEficienciaEnergetica() instanceof String) ); //Testar se a Eficiencia Energetica é uma string.
		
		
	}

	
	@Test
	final void testSetEficienciaEnergetica() {
		
		//Esse teste foi feito para ver se o setEficienciaEnergetica() atribui o ano na Classe Eletrodomestico.
        
		Eletrodomestico e = new Eletrodomestico(null, null, null, null, null, 0, 0, null, 0);  
		  
		 e.setEficienciaEnergetica("Grau B"); // Nesse caso, o grau é Grau B.
		
		assertEquals("Grau B", e.getEficienciaEnergetica());
		
		assertEquals(true,(e.getEficienciaEnergetica() instanceof String) ); //Testar se a Eficiencia Energetica é uma string.
	}

}
