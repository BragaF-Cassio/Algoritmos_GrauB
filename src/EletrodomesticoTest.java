package Package_Test_Case;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EletrodomesticoTest {

	@Test
	final void testToString() {

		//Esse teste foi feito para ver se o ToString() imprime os resultados da Classe de forma adequada.
		//Importante! Precisa acrescentar ao toString() da Classe Eletrodomestico o anoDeLancamento para poder testar.

		Eletrodomestico a = new Eletrodomestico("Ventilador turbo max 2000", "Ventilador com turbo e repelente", 
				"Philips", "Preto", "Eletrodomestico", 49.99, 4, 2021, "Grau A"); 
        String expected = "Eletrodomestico:" + 
				" Eficiencia Energetica=" + "Grau A" +
				", nome='" + "Ventilador turbo max 2000" + '\'' +
                ", descricao='" + "Ventilador com turbo e repelente" + '\'' +
                ", marca='" + "Philips" + '\'' +
                ", cor='" + "Preto" + '\'' +
                ", categoria='" + "Eletrodomestico" + '\'' +
                ", valor=" + 49.99 +
                ", quantidade=" + 4 +
                '}';
        assertEquals(expected, a.toString());
	}

	@Test
	final void testEletrodomestico() {
		
		//Esse teste foi feito para ver se o construtor Eletrodomestico() funciona com todos os argumentos.
		
		//Importante! Precisa acrescentar ao Eletrodomestico() o anoDeLancamento para poder testar.
		
		Eletrodomestico s = new Eletrodomestico("Ventilador turbo max 2000", "Ventilador com turbo e repelente", 
				"Philips", "Preto", "Eletrodomestico", 49.99, 4, 2021, "Grau A"); 
				
				
				 assertEquals("Ventilador turbo max 2000", s.nome);
				 assertEquals("Ventilador com turbo e repelente", s.descricao);
				 assertEquals("Philips", s.marca);
				 assertEquals("Preto", s.cor);
				 assertEquals("Eletrodomestico", s.categoria);
				 assertEquals(49.99, s.valor);
				 assertEquals(4, s.quantidade);
				 assertEquals("Grau A", s.getEficienciaEnergetica());
	}

	@Test
	final void testGetEficienciaEnergetica() {
    /* 
    * Esse teste foi feito para ver se o getGetEficienciaEnergetica() 
    * pega o Grau de Eficiencia Energetica colocado no argumento do construtor.    
		
    */
		
		Eletrodomestico e = new Eletrodomestico(null, null, null, null, null, 0, 0, 0, "Grau B"); 
		// Nesse caso, a Eficiencia Energetica é Grau B. 
		
		
		
		
		assertEquals("Grau B", e.getEficienciaEnergetica()); 
	}

	@Test
	final void testSetEficienciaEnergetica() {
		/* 
		 * Esse teste foi feito para ver se o setEficienciaEnergetica() 
		 * atribui o grau de Eficiencia Energetica na Classe Eletrodomestico.
		 */
        
		Eletrodomestico e = new Eletrodomestico(null, null, null, null, null, 0, 0, 0, null);  
				  
				 e.setEficienciaEnergetica("Grau C"); // Nesse caso, a Eficiencia Energetica é Grau C.
				
				assertEquals("Grau C", e.getEficienciaEnergetica());
	}

}
