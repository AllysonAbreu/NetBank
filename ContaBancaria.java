import java.util.List;
import java.util.Random;

public class ContaBancaria {
		
		private Cliente titular;
		private int agencia;
		private int numeroConta;
		private double saldo;
		private int extrato;
		
					
		public ContaBancaria() {
			super();
		}
				
		public ContaBancaria(Cliente titular, int agencia, int numeroConta, double saldo, int extrato) {
			super();
			this.titular = titular;
			this.agencia = agencia;
			this.numeroConta = numeroConta;
			this.saldo = saldo;
			this.extrato = extrato;
		}

		
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

		public Cliente getTitular() {
			return titular;
		}

		public void setTitular(Cliente titular) {
			this.titular = titular;
		}

		public int getAgencia() {
			return agencia;
		}

		public void setAgencia(int agencia) {
			this.agencia = agencia;
		}

		public int getNumeroConta() {
			return numeroConta;
		}

		public void setNumeroConta(List<ContaBancaria> contas, int numeroConta) {
			for(int i = 0; i < contas.size(); i++) {
				if(numeroConta == this.numeroConta) {
					Random random = new Random();
					int novoNum = random.nextInt(1000);
					setNumeroConta(contas, novoNum);
				}
			}			
			this.numeroConta = numeroConta;
		}

		public double getSaldo() {
			return saldo;
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public int getExtrato() {
			return extrato;
		}

		public void setExtrato(int extrato) {
			this.extrato = extrato;
		}
		
	}