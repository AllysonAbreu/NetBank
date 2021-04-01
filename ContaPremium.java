
public class ContaPremium extends ContaBancaria {
	
	private boolean ehPremium = true;
	
	

	public ContaPremium() {
		super();
	}

	public ContaPremium(Cliente titular, int agencia, int numeroConta, double saldo, int extrato) {
		super(titular, agencia, numeroConta, saldo, extrato);
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
	
	
	
	
	
	
	

}
