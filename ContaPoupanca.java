import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ContaPoupanca extends ContaBancaria implements IncDnc {

	public ContaPoupanca() {
		super();
	}		
	
	@Override
	public void setNumeroConta(List<ContaBancaria> contas, int numeroConta) {
		for(int i = 0; i < contas.size(); i++) {
			if(numeroConta == this.numeroConta) {
				Random random = new Random();
				int novoNum = random.nextInt(1000);
				this.setNumeroConta(contas, novoNum);
			}
		}	
		this.numeroConta = numeroConta;
	}
	
	@Override
	public void imprimaDados(Cliente titular) {			
		System.out.println("Titular: "+titular.getNome()+";\n"+"CPF: "+titular.getCpf() 
		+ ";\n" + "Profissão: "+titular.getProfissao()+";\n" + "Salário R$: "+titular.getSalario()+";\n"+
		"Número da Conta:"+getNumeroConta()+";\n"+"Número da Agência:"+ContaBancaria.getAgencia()+".");
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
		
}
