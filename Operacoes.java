import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Operacoes extends ContaBancaria implements IncDnc{
	
	public void setNumeroConta(List<ContaBancaria> contas, int numeroConta) {
		for(int i = 0; i < contas.size(); i++) {
			if(numeroConta == super.getNumeroConta()) {
				Random random = new Random();
				int novoNum = random.nextInt(1000);
				this.setNumeroConta(contas, novoNum);
			}
		}	
	}
		
	public void imprimaDados(Cliente titular) {			
		System.out.println("Titular: "+titular.getNome()+";\n"+"CPF: "+titular.getCpf() 
		+ ";\n" + "Profiss�o: "+titular.getProfissao()+";\n" + "Sal�rio R$: "+titular.getSalario()+";\n"+
		"N�mero da Conta:"+getNumeroConta()+";\n"+"N�mero da Ag�ncia:"+ContaBancaria.getAgencia()+".");
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
				System.out.println("\nH� na conta: R$ " + cc.getSaldo());
				break;        					
			} 
			cont--;
		}	
		if(cont == 0) {        							
			Interface.CPF_INEXISTENTE();
		}     			    			        			
	}	
	
	@Override
	public boolean verSaldo(double valor) {
		if (super.getSaldo() >= valor) {
			return true;
		} 
		return false;
	}
	
	@Override
	public double incrementa (double valor) {
		double saldo = super.getSaldo();
		saldo  += valor;
		super.setSaldo(saldo);
		return super.getSaldo();		
	}
	
	@Override
	public double decrementa (double valor) {
		double saldo = super.getSaldo(); 
		saldo -= valor;
		super.setSaldo(saldo);
		return super.getSaldo();
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
					System.out.println("H� na conta: R$ " + cc.getSaldo() + ".\n");
					break;
				} else {
					Interface.NEGATIVA_SAQUE();
					System.out.println("H� na conta: R$ " + cc.getSaldo() + ".\n");
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
					System.out.println("H� na conta: R$ " + cc.getSaldo() + "\n");
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
