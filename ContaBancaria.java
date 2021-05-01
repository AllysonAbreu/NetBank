import java.util.List;
import java.util.Random;
import java.util.Scanner;

public abstract class ContaBancaria implements IncDnc {
		
		private Cliente titular;
		static int agencia;
		protected int numeroConta;
		private double saldo;
		private int extrato;
							
		public ContaBancaria() {
			super();
		}
				
		public ContaBancaria(Cliente titular, int numeroConta, double saldo, int extrato) {
			super();
			this.titular = titular;
			this.numeroConta = numeroConta;
			this.saldo = saldo;
			this.extrato = extrato;
		}
		public Cliente getTitular() {
			return titular;
		}

		public void setTitular(Cliente titular) {
			this.titular = titular;
		}

		static int getAgencia() {
			return agencia;
		}
		
		public int getNumeroConta() {
			return numeroConta;
		}

		public abstract void setNumeroConta(List<ContaBancaria> contas, int numeroConta);

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
		
		public abstract void imprimaDados(Cliente titular);
					
		public abstract boolean verSaldo(double valor);				
}
