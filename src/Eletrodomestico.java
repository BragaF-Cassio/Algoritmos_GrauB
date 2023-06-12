package trabalho;


	
	public class Eletrodomestico extends Produto{
		private String eficienciaEnergetica;

		public Eletrodomestico(String nome, String descricao, String marca, String cor, String categoria, double valor, int quantidade, int anoDeLancamento, String eficienciaEnergetica, long codigo) {
			super(nome, descricao, marca, cor, categoria, valor, quantidade, codigo);
			this.eficienciaEnergetica = eficienciaEnergetica;
		}

		public String getEficienciaEnergetica() {
			return eficienciaEnergetica;
		}

		public void setEficienciaEnergetica(String eficienciaEnergetica) {
			this.eficienciaEnergetica = eficienciaEnergetica;
		}

		@Override
		public String toString() {
			return "Eletrodomestico:" + 
					" Eficiencia Energetica=" + eficienciaEnergetica +
					", nome='" + nome + '\'' +
	                ", descricao='" + descricao + '\'' +
	                ", marca='" + marca + '\'' +
	                ", cor='" + cor + '\'' +
	                ", categoria='" + categoria + '\'' +
	                ", valor=" + valor +
	                ", quantidade=" + quantidade +
	                ",  codigo=" + codigo +
	                '}';
		}
		
		

	}


