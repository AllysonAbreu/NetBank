
public class Cliente {
	
	private String nome;
	private String cpf;
	private String profissao;
	private double salario;
	
	public Cliente(String nome, String cpf, String profissao, double salario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.profissao = profissao;
		this.salario = salario;
		
	}
	
	public Cliente() {
		super();
	}
	
	public String getNome() {
		return this.nome;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getProfissao() {
		return this.profissao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}