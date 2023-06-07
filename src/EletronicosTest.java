package Package_Test_Case;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EletronicosTest {

	@Test
	final void testToString() {
		
		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.

		Eletronicos a = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
				"Ht Micron", "Azul", "Capacitores", 9.99, 3, 2009); 
        String expected = "Eletronicos{" +
                "anoDeLancamento=" + 2009 +
                ", nome='" + "Capacitor 20A" + '\'' +
                ", descricao='" + "Capacitor com 20A" + '\'' +
                ", marca='" + "Ht Micron" + '\'' +
                ", cor='" + "Azul" + '\'' +
                ", categoria='" + "Capacitores" + '\'' +
                ", valor=" + 9.99 +
                ", quantidade=" + 3 +
                '}';
        assertEquals(expected, a.toString());
	}

	@Test
	final void testEletronicos() {
		
		//Esse teste foi feito para ver se o construtor Eletronicos() funciona com todos os argumentos.
		
		Eletronicos s = new Eletronicos("Capacitor 20A", "Capacitor com 20A", 
				"Ht Micron", "Azul", "Capacitores", 9.99, 3, 2009);  
		
		
		 assertEquals("Capacitor 20A", s.nome);
		 assertEquals("Capacitor com 20A", s.descricao);
		 assertEquals("Ht Micron", s.marca);
		 assertEquals("Azul", s.cor);
		 assertEquals("Capacitores", s.categoria);
		 assertEquals(9.99, s.valor);
		 assertEquals(3, s.quantidade);
		 assertEquals(2009, s.getAnoDeLancamento());
		 
		 
	}

	@Test
	final void testGetAnoDeLancamento() {
		
		//Esse teste foi feito para ver se o getAnoDeLancamento() pega o ano colocado no argumento do construtor.
		
		Eletronicos e = new Eletronicos(null, null, null, null, null, 0, 0, 2020); // Nesse caso, o ano é 2020. 
		
		
		
		
		assertEquals(2020, e.getAnoDeLancamento()); 
	}

	@Test
	final void testSetAnoDeLancamento() {
		
		//Esse teste foi feito para ver se o setAnoDeLancamento() atribui o ano na Classe Eletronicos.
        
		Eletronicos e = new Eletronicos(null, null, null, null, null, 0, 0, 0);  
		  
		 e.setAnoDeLancamento(2021); // Nesse caso, o ano é 2021.
		
		assertEquals(2021, e.getAnoDeLancamento());
	}

}
