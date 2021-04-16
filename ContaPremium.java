import java.util.List;
import java.util.Random;

public class ContaPremium extends ContaBancaria {
	
	private boolean ehPremium = true;
		

	public ContaPremium() {
		super();
	}

	public ContaPremium(Cliente titular, int numeroConta, double saldo, int extrato) {
		super(titular, numeroConta, saldo, extrato);
	}

	public ContaPremium(boolean ehPremium) {
		super();
		this.ehPremium = ehPremium;
	}

	public boolean isEhPremium() {
		return ehPremium;
	}

	public void setEhPremium(boolean ehPremium) {
		this.ehPremium = ehPremium;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(List<ContaBancaria> contas, int numeroConta) {
		for(int i = 0; i < contas.size(); i++) {
			if(numeroConta == this.numeroConta) {
				Random random = new Random();
				int novoNum = random.nextInt(10000);
				setNumeroConta(contas, novoNum);
			}
		}			
		this.numeroConta = numeroConta;
	}
}
