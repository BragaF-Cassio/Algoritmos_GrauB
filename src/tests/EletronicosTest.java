package tests;

import Trabalho.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;


class EletronicosTest {

	int anoAtual = LocalDateTime.now().getYear(); //Pegar ano atual.
	
	@Test
	final void testToString() {
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Eletronicos a = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
				"Ht Micron", "Azul", "Capacitores", 9.99, 3, 312331, 2009); 
        String esperado = "Eletronicos{" +
                "anoDeLancamento=" + 2009 +
                ", nome='" + "Capacitor 20A" + '\'' +
                ", descricao='" + "Capacitor com 20A" + '\'' +
                ", marca='" + "Ht Micron" + '\'' +
                ", cor='" + "Azul" + '\'' +
                ", categoria='" + "Capacitores" + '\'' +
                ", valor=" + 9.99 +
                ", quantidade=" + 3 +
                '}';
        assertEquals(esperado, a.toString());
        assertEquals(true,(esperado instanceof String) ); //Testar se o valor esperado é uma string .
        
        
	}

	@Test
	final void testEletronicos() {
		
		//Esse teste foi feito para ver se o construtor Eletronicos() funciona com todos os argumentos.
		
		Eletronicos s = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
				"Ht Micron", "Azul", "Capacitores", 9.99, 3, 312331, 2009);  
		
		
		 assertEquals("Capacitor 20A", s.getNome());
		 assertEquals("Capacitor com 20A", s.getDescricao());
		 assertEquals("Ht Micron", s.getMarca());
		 assertEquals("Azul", s.getCor());
		 assertEquals("Capacitores", s.getCategoria());
		 assertEquals(9.99, s.getValor());
		 assertEquals(3, s.getQuantidade());
		 assertEquals(312331, s.getCodigo());
		 assertEquals(2009, s.getAnoDeLancamento());
		 
         assertEquals(true,(s.getNome() instanceof String) );  //Testar se o nome é uma string .
		 
		 assertEquals(true,(s.getDescricao() instanceof String) );  //Testar se a descricao é uma string .
		 
          assertEquals(true,(s.getCategoria() instanceof String) ); //Testar se a categoria é uma string .
		 
		  assertEquals(true,(s.getMarca() instanceof String) ); //Testar se a marca é uma string .
		 
          assertEquals(true,(s.getCor() instanceof String) ); //Testar se o cor é uma string .
		 
          
          
          
		 
		 assertTrue(s.getAnoDeLancamento() <= anoAtual); //Testar se anoDeLancamento é menor ou igual ao ano atual.
		 
		 assertTrue(s.getValor() > 0 ); //Testar se o preço é maior que zero .
		 
		 assertFalse(s.getQuantidade() < 0 ); //Testar se a quantidade é maior que zero ou igual a zero.
		 
		 assertTrue(s.getQuantidade() < 2147483647 ); //Testar se a quantidade é menor que o valor que quebra o int.
		 
		 assertNotEquals(s.getCodigo(), Long.toString(s.getCodigo()) ); //Testar se o codigo nao é uma String .
		 
		 
	}

	@Test
	final void testGetAnoDeLancamento() {
		
		//Esse teste foi feito para ver se o getAnoDeLancamento() pega o ano colocado no argumento do construtor.
		
		Eletronicos e = new Eletronicos(null, null, null, null, null, 0, 0, 0, 2020); // Nesse caso, o ano é 2020. 
		
		
		
		
		assertEquals(2020, e.getAnoDeLancamento());
		
		assertTrue(e.getAnoDeLancamento() <= anoAtual); //Testar se anoDeLancamento é menor ou igual ao ano atual.
		
		
	}

	
	@Test
	final void testSetAnoDeLancamento() {
		
		//Esse teste foi feito para ver se o setAnoDeLancamento() atribui o ano na Classe Eletronicos.
        
		Eletronicos e = new Eletronicos(null, null, null, null, null, 0, 0, 0, 0);  
		  
		 e.setAnoDeLancamento(2021); // Nesse caso, o ano é 2021.
		
		assertEquals(2021, e.getAnoDeLancamento());
		
		assertNotEquals(e.getAnoDeLancamento() , Integer.toString(e.getAnoDeLancamento()) ); //Testar se o ano nao é uma String .
	}

}
