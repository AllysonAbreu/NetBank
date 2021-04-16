import java.util.Scanner;

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
	
	public void cadastro(Cliente cliente) {
		Scanner criarConta = new Scanner(System.in);
		
		System.out.print("Insira seu nome:");
		cliente.setNome(criarConta.nextLine());
		
		System.out.print("Insira o número do seu CPF:");
		cliente.setCpf(criarConta.nextLine());
		
		System.out.print("Insira a sua profissão:");
		cliente.setProfissao(criarConta.nextLine());
		
		System.out.print("Informe seus rendimentos mensais:");
		cliente.setSalario(criarConta.nextDouble());
	}
	
}