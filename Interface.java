import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Interface {

	public static void main(String[] args) {
		System.out.println("================================================================================================");
		System.out.println("======================================BEM VINDO AO NETBANK======================================");
		System.out.println("================================================================================================");
				
		List<ContaBancaria> contas = new ArrayList<ContaBancaria>();		
		boolean fim = false;
		
		do{
			Scanner entradaMenu = new Scanner(System.in);
			int menu;
			int cont = 0;
        	
        	System.out.println("\nDigite:\n(1)Para criar uma conta;\n(0)Para encerrar;");
        	menu = entradaMenu.nextInt();
        	
        	if (menu == 1) {
        		Cliente cliente = new Cliente();
    			Scanner criarConta = new Scanner(System.in);
    			
    			String nome;
    			String documento;
    			String profissao;
    				
    			System.out.println("Insira seu nome:");
    			cliente.nome = (nome = criarConta.nextLine());
    					
    			System.out.println("Insira o número do seu CPF:");
    			cliente.cpf = (documento = criarConta.nextLine());
    			
    			System.out.println("Insira a sua profissão:");
    			cliente.profissao = (profissao = criarConta.nextLine());
    			
    			System.out.println("Titular: " + cliente.nome + ";\n" + "CPF: " + cliente.cpf 
    					+ ";\n" + "Profissão: " + cliente.profissao+".");
    			
    			ContaBancaria conta = new ContaBancaria();
    			conta.titular = cliente;
    			contas.add(conta);
    			/*System.out.println(conta.titular.nome);
    			System.out.println(contas.size());
    			System.out.println("\n");*/
        	} else {
        		fim = true;
        	} 	
        }while(!fim);
		
		/*for(int i = 0; i < contas.size(); i++) {
			ContaBancaria cc = contas.get(i);
			System.out.println(cc.titular.nome);
		}*/
		
		System.out.println("\n");
		System.out.println("================================================================================================");
		System.out.println("==============================Inicializando o menu de operações=================================");
		System.out.println("================================================================================================");
		System.out.println("\n");
		
		do{
			Scanner entradaMenu = new Scanner(System.in);
			Scanner entradaValor = new Scanner(System.in);
			Scanner entradaValidar = new Scanner(System.in);
        	int menu;
        	int cont = contas.size();
        	String validar;
        	double valor;
        
        	System.out.println("Digite:\n(1)Para depositar;\n(2)Para sacar;\n(3)Para tranferir;"
        			+ "\n(4)Verificar saldo;\n(0)Para encerrar;");
        	menu = entradaMenu.nextInt();
             
        
        	switch(menu) {
        	
        		case 1:
        			System.out.println("\nInsira o valor a ser depositado:");
        			valor = entradaValor.nextDouble();
        			System.out.println("Insira o número do seu CPF para validar o depósto:");
        			validar = entradaValidar.nextLine();
        			
        			for(int i = 0; i < contas.size(); i++) {
        				ContaBancaria cc = contas.get(i);
        				if(cc.titular.cpf.equals(validar)) {
        					cc.deposita(valor);
        					System.out.println("\nHá na conta: R$ " + cc.saldo);
        					break;        					
        				} 
        				cont--;
        			}	
        			if(cont == 0) {        							
        				System.out.println("\nCPF não consta em nosso banco de dados. Tente novamente.\n");
        			}     			    			        			
        			break;
        			
        		case 2:
        			System.out.println("\nInsira o valor a ser sacado:");
        			valor = entradaValor.nextDouble();
        			System.out.println("Insira o número do seu CPF para validar o saque:");
        			validar = entradaValidar.nextLine();
        			
        			for(int i = 0; i < contas.size(); i++) {
        				ContaBancaria cc = contas.get(i);
        				if(cc.titular.cpf.equals(validar)) {
        					double statusQuo = cc.saldo; //para evitar, por enquanto, que a conta fique com saldo negativo;
        					boolean retorno = cc.saca(valor);
        					if (retorno == true) {
        						System.out.println("\nValor sacado com sucesso.");
        						System.out.println("Há na conta: R$ " + cc.saldo);
        					} else {
        						System.out.println("\nValor impossível de ser sacado.");
        						cc.saldo = statusQuo;
        						System.out.println("\nHá na conta: R$ " + cc.saldo);
        					}
        				}
        			}        			
        			break;
        			
        		case 3:
        			Scanner entradaTransferencia = new Scanner(System.in);
        			String transferencia;
        			        			
        			System.out.println("\nInsira o valor a ser transferido:");
        			valor = entradaValor.nextDouble();
        			System.out.println("Insira seu CPF para validar a transferência:");
        			validar = entradaValidar.nextLine();
        			System.out.println("Insira o CPF da conta que será transferido o valor:");
        			transferencia = entradaTransferencia.nextLine();
        			
        			for(int i = 0; i < contas.size(); i++) {
        				ContaBancaria cc = contas.get(i);
        				if(cc.titular.cpf.equals(validar)) {
        					double statusQuo = cc.saldo;
        					boolean retorno = cc.saca(valor);
        					if (retorno == true) {
        						System.out.println("\nValor disponível para transferência.");
        						
        						for(int j = 0; j < contas.size(); j++) {
        							ContaBancaria cc2 = contas.get(j);
        							if(cc2.titular.cpf.equals(transferencia)) {
        								cc2.deposita(valor);
        							}
        						}
        					} else {
        						System.out.println("\nValor impossível de ser transferido.");
        						cc.saldo = statusQuo;
        					}
        				}
        			}
        			
        			break;
        			
        		case 4:
        			System.out.println("Insira o número do seu CPF para verificar o saldo em conta:");
        			validar = entradaValidar.nextLine();
        			
        			for(int i = 0; i < contas.size(); i++) {
        				ContaBancaria cc = contas.get(i);
        				if(cc.titular.cpf.equals(validar)) {
        					System.out.println("\nHá na conta: R$ " + cc.saldo);
        					break;
        				}
        				cont--;
        			}
        			if(cont == 0) {        							
        				System.out.println("\nCPF não consta em nosso banco de dados. Tente novamente.\n");
        			}	    			        			
        			break;
        			
        		case 0:
        			fim = false;
        			break;
        		
        		default:
        			System.out.println("\nNão há a opção escolhida neste menu.\n");
        	}
    	}while(fim);
		
		System.out.println("\n");
		System.out.println("================================================================================================");
		System.out.println("================================OBRIGADO POR UTILIZAR NOSSOS SERVIÇOS===========================");
		System.out.println("================================================================================================");
	}
}		