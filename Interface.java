
public final class Interface {
	
	public static final void CABECALHO() {
		System.out.println("================================================================================================");
		System.out.println("======================================BEM VINDO AO NETBANK======================================");
		System.out.println("================================================================================================");
	}
	
	public static final void CABECALHO_OPERACOES() {
		System.out.println("\n");
		System.out.println("================================================================================================");
		System.out.println("==============================Inicializando o menu de opera��es=================================");
		System.out.println("================================================================================================");
		System.out.println("\n");
	}
	
	public static final void RODAPE() {
		System.out.println("\n");
		System.out.println("================================================================================================");
		System.out.println("================================OBRIGADO POR UTILIZAR NOSSOS SERVI�OS===========================");
		System.out.println("================================================================================================");
	}
	
	public static final void PRIMEIRO_MENU() {
		System.out.println("\nDigite:\n(1)Para criar uma conta;\n(0)Para encerrar.");
	}
	
	public static final void SEGUNDO_MENU() {
		System.out.println("Digite:\n(1)Para depositar;\n(2)Para sacar;\n(3)Para tranferir;\n(4)Verificar saldo;\n(0)Para encerrar;");
	}
	
	public static final void INSIRA_CPF() {
		System.out.print("Insira o n�mero do seu CPF para validar a opera��o:");
	}
	
	public static final void CPF_INEXISTENTE() {
		System.out.println("\nCPF n�o consta em nosso banco de dados. Tente novamente.\n");
	}
	
	public static final void SEM_OPCAO() {
		System.out.println("\nN�o h� a op��o escolhida neste menu.\n");
	}
	
	public static final void LIMITE_DE_VERIFICACAO() {
		System.out.println("Limite de verifica��o de saldo excedido. Por favor, procure uma de nossas ag�ncias para progredir sua conta para o nosso servi�o Premium.");
	}
	
	public static final void CONFIRMACAO_SAQUE() {
		System.out.println("\nValor sacado com sucesso.");
	}
	
	public static final void NEGATIVA_SAQUE() {
		System.out.println("\nValor imposs�vel para ser sacado.");
	}
	
	public static final void INSERIR_DEPOSITO() {
		System.out.print("\nInsira o valor a ser depositado:");
	}
	
	public static final void INSERIR_SAQUE() {
		System.out.println("\nInsira o valor a ser sacado:");
	}
	
	public static final void VER_EXTRATO() {
		System.out.print("Insira o n�mero do seu CPF para verificar o saldo em conta:");
	}
	
	public static final void VALOR_TRANSFERENCIA() {
		System.out.print("\nInsira o valor a ser transferido:");
	}
	
	public static final void CPF_VALIDAR_TRANSFERENCIA() {
		System.out.print("Insira seu CPF para validar a transfer�ncia:");
	}
	
	public static final void CPF_CONTA_PARA_TRANSFERIR() {
		System.out.print("Insira o CPF da conta para a qual ser� transferido o valor:");
	}
	
	public static final void VALOR_DISPONIVEL_TRANSFERENCIA() {
		System.out.println("\nValor dispon�vel para transfer�ncia.\n");
	}
	
	public static final void VALOR_INDISPONIVEL_TRANSFERENCIA() {
		System.out.println("\nValor imposs�vel de ser transferido.\n");
	}
		
	public static final double VALOR = 6000.0;
}
