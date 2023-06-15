package trabalho;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EletrodomesticoTest {

	@Test
	final void testToString() {
		
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Eletrodomestico a = new Eletrodomestico("Ventilador", "Ventilador com Repelente", 
				"Phillips", "Preto", "Ventiladores", 20.99, 3, "Grau B", 312331); 
        String esperado = "Eletrodomestico:" + 
				" Eficiencia Energetica=" + "Grau B" +
				", nome='" + "Ventilador" + '\'' +
                ", descricao='" + "Ventilador com Repelente" + '\'' +
                ", marca='" + "Phillips" + '\'' +
                ", cor='" + "Preto" + '\'' +
                ", categoria='" + "Ventiladores" + '\'' +
                ", valor=" + 20.99 +
                ", quantidade=" + 3 +
                ",  codigo=" + 312331 +
                '}';
        assertEquals(esperado, a.toString());
        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
        
        
	}

	@Test
	final void testEletrodomestico() {
		
		//Esse teste foi feito para ver se o construtor Eletrodomestico() funciona com todos os argumentos.
		
		Eletrodomestico s = new Eletrodomestico("Ventilador", "Ventilador com Repelente", 
				"Phillips", "Preto", "Ventiladores", 20.99, 3, "Grau B", 312331);   
		
		
		 assertEquals("Ventilador", s.nome);
		 assertEquals("Ventilador com Repelente", s.descricao);
		 assertEquals("Phillips", s.marca);
		 assertEquals("Preto", s.cor);
		 assertEquals("Ventiladores", s.categoria);
		 assertEquals(20.99, s.valor);
		 assertEquals(3, s.quantidade);
		 assertEquals(312331, s.codigo);
		 assertEquals("Grau B", s.getEficienciaEnergetica());
		 
         assertEquals(true,(s.nome instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.descricao instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.categoria instanceof String) ); //Testar se a categoria é uma string .
		 
		  assertEquals(true,(s.marca instanceof String) ); //Testar se a marca é uma string .
		 
          assertEquals(true,(s.cor instanceof String) ); //Testar se o cor é uma string .
		 
          assertEquals(true,(s.getEficienciaEnergetica() instanceof String) ); //Testar se a Eficiencia Energetica é uma string .
          
          
          
		 
		 assertTrue(s.valor > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.quantidade < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.quantidade < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.codigo , Long.toString(s.codigo) ); //Testar se o codigo nao é uma String .
		 
		 
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
