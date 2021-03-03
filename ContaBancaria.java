	
	public class ContaBancaria {
		Cliente titular;
		int agencia = 001;
		int numeroConta;
		double saldo;
	
		public void deposita(double valor) {
			this.saldo += valor;
		}
		
		public boolean saca(double valor) {
			if (this.saldo >= valor) {
				this.saldo -= valor;
				return true;
			} 
			return false;
			
		}
		
		public boolean tranfere(double valor, ContaBancaria destino) {
			if(this.saldo >= valor) {
				this.saldo -= valor;
				destino.deposita(valor);
				return true;
			}
			return false;
		}
		
	}
