import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContaBancaria {
		
		private Cliente titular;
		static int agencia;
		protected int numeroConta;
		private double saldo;
		protected int extrato;
		
					
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
		
		public void imprimaDados(Cliente titular) {			
			System.out.println("Titular: "+titular.getNome()+";\n"+"CPF: "+titular.getCpf() 
			+ ";\n" + "Profissão: "+titular.getProfissao()+";\n" + "Salário R$: "+titular.getSalario()+";\n"+
			"Número da Conta:"+getNumeroConta()+";\n"+"Número da Agência:"+ContaBancaria.getAgencia()+".");
		}
		
		public static void deposita(List<ContaBancaria> contas) {
			
			Scanner entradaValor = new Scanner(System.in);
			Scanner entradaValidar = new Scanner(System.in);
			
			int cont = contas.size();
        	String validar;
        	double valor;
			
			Interface.INSERIR_DEPOSITO();
			valor = entradaValor.nextDouble();
			Interface.INSIRA_CPF();
			validar = entradaValidar.nextLine();
			
			for(int i = 0; i < contas.size(); i++) {
				ContaBancaria cc = contas.get(i);
				if(cc.getTitular().getCpf().equals(validar)) {
					cc.setSaldo(valor);
					System.out.println("\nHá na conta: R$ " + cc.getSaldo());
					break;        					
				} 
				cont--;
			}	
			if(cont == 0) {        							
				Interface.CPF_INEXISTENTE();
			}     			    			        			
		}	
		
		public boolean verSaldo(double valor) {
			if (this.saldo >= valor) {
				return true;
			} 
			return false;
		}
		
		public double incrementa (double valor) {
			this.saldo += valor;
			return this.saldo;
			
		}
		
		public double decrementa (double valor) {
			this.saldo -= valor;
			return this.saldo;
		}
		
		public static void saca(List<ContaBancaria> contas) {
			
			Scanner entradaValor = new Scanner(System.in);
			Scanner entradaValidar = new Scanner(System.in);
			
			int cont = contas.size();
        	String validar;
        	double valor;
			
			Interface.INSERIR_SAQUE();
			valor = entradaValor.nextDouble();
			Interface.INSIRA_CPF();
			validar = entradaValidar.nextLine();
			
			for(int i = 0; i < contas.size(); i++) {
				ContaBancaria cc = contas.get(i);
				if(cc.getTitular().getCpf().equals(validar)) {
					boolean retorno = cc.verSaldo(valor);
					if (retorno == true) {
						cc.decrementa(valor);
						Interface.CONFIRMACAO_SAQUE();
						System.out.println("Fora sacado o valor de R$ "+valor+".");
						System.out.println("Há na conta: R$ " + cc.getSaldo() + ".\n");
						break;
					} else {
						Interface.NEGATIVA_SAQUE();
						System.out.println("Há na conta: R$ " + cc.getSaldo() + ".\n");
						break;
					}					
				}
				cont--;
			}	
			if(cont == 0) {        							
				Interface.CPF_INEXISTENTE();
			}
		}
		
		public static void tranfere(List<ContaBancaria> contas) {
			
			Scanner entradaValor = new Scanner(System.in);
			Scanner entradaValidar = new Scanner(System.in);
			Scanner entradaTransferencia = new Scanner(System.in);
			
			int cont = contas.size();
        	String validar;
        	double valor;
			String transferencia;
			        			
			Interface.VALOR_TRANSFERENCIA();
			valor = entradaValor.nextDouble();
			Interface.CPF_VALIDAR_TRANSFERENCIA();
			validar = entradaValidar.nextLine();
			Interface.CPF_CONTA_PARA_TRANSFERIR();
			transferencia = entradaTransferencia.nextLine();
			
			for(int i = 0; i < contas.size(); i++) {
				ContaBancaria cc = contas.get(i);
				if(cc.getTitular().getCpf().equals(validar)) {
					double statusQuo = cc.getSaldo();
					boolean retorno = cc.verSaldo(valor);
					if (retorno == true) {
						cc.decrementa(valor);
						Interface.VALOR_DISPONIVEL_TRANSFERENCIA();
						
						for(int j = 0; j < contas.size(); j++) {
							ContaBancaria cc2 = contas.get(j);
							if(cc2.getTitular().getCpf().equals(transferencia)) {
								cc2.incrementa(valor);
							}
						}
					} else {
						Interface.VALOR_INDISPONIVEL_TRANSFERENCIA();
						cc.setSaldo(statusQuo);
					}
				}
			}
		}
		
		public static void verExtrato(List<ContaBancaria> contas) {
			
			Scanner entradaValidar = new Scanner(System.in);
			
			int cont = contas.size();
			String validar;
			
			Interface.VER_EXTRATO();
			validar = entradaValidar.nextLine();
			
			for(int i = 0; i < contas.size(); i++) {
				ContaBancaria cc = contas.get(i);
				if(cc.getExtrato()> 0) {
					if(cc.getTitular().getCpf().equals(validar)) {
						System.out.println("Há na conta: R$ " + cc.getSaldo() + "\n");
						int controle = cc.getExtrato();
						controle--;
						cc.setExtrato(controle);
						break;
					}
					cont--;
				} else {
					Interface.LIMITE_DE_VERIFICACAO();
				}
			}	
			if(cont == 0) {        							
				Interface.CPF_INEXISTENTE();
			}	    	
		}
}
