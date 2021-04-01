import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Interface {

	public static void main(String[] args) {
		
		System.out.println("================================================================================================");
		System.out.println("======================================BEM VINDO AO NETBANK======================================");
		System.out.println("================================================================================================");
				
		List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		Random random = new Random();
		boolean fimMenu = false;
		
		
		do{
			Scanner entradaMenu = new Scanner(System.in);
			int menu;
			        	
        	System.out.println("\nDigite:\n(1)Para criar uma conta;\n(0)Para encerrar.");
        	menu = entradaMenu.nextInt();
        	
        	if (menu == 1) {
        		
        		double criarPremium = 6000.0;        		       		
        		Cliente cliente = new Cliente();
    			Scanner criarConta = new Scanner(System.in);
    						
    			System.out.print("Insira seu nome:");
    			cliente.setNome(criarConta.nextLine());
    					
    			System.out.print("Insira o n�mero do seu CPF:");
    			cliente.setCpf(criarConta.nextLine());
    			
    			System.out.print("Insira a sua profiss�o:");
    			cliente.setProfissao(criarConta.nextLine());
    			
    			System.out.print("Informe seus rendimentos mensais:");
    			cliente.setSalario(criarConta.nextDouble());
    			 			
    			double comparar = cliente.getSalario();
    			if(comparar >= criarPremium) {
    				ContaPremium conta = new ContaPremium();
        			conta.setTitular(cliente);        			
        			conta.setNumeroConta(contas, random.nextInt(1000));
        			System.out.println("N�mero da Conta:" + conta.getNumeroConta());
        			conta.setAgencia(1337);
        			System.out.println("N�mero da Ag�ncia:" + conta.getAgencia());
        			contas.add(conta);
        			
    			} else {
    				ContaBancaria conta = new ContaBancaria();
    				conta.setTitular(cliente);        			
        			conta.setNumeroConta(contas, random.nextInt(1000));
        			System.out.println("N�mero da Conta:" + conta.getNumeroConta());
        			conta.setAgencia(1337);
        			System.out.println("N�mero da Ag�ncia:" + conta.getAgencia());
        			contas.add(conta);
    			}	
    			
    			System.out.println("Titular: " + cliente.getNome() + ";\n" + "CPF: " + cliente.getCpf() 
				+ ";\n" + "Profiss�o: " + cliente.getProfissao() + ";\n" + "Sal�rio R$: " + cliente.getSalario()+".");
			   			
        	} else {
        		fimMenu = true;
        	} 	
        }while(!fimMenu);
		
		if(contas.size() != 0) {	
		
			System.out.println("\n");
			System.out.println("================================================================================================");
			System.out.println("==============================Inicializando o menu de opera��es=================================");
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
	        			System.out.print("\nInsira o valor a ser depositado:");
	        			valor = entradaValor.nextDouble();
	        			System.out.print("Insira o n�mero do seu CPF para validar o dep�sto:");
	        			validar = entradaValidar.nextLine();
	        			
	        			for(int i = 0; i < contas.size(); i++) {
	        				ContaBancaria cc = contas.get(i);
	        				if(cc.getTitular().getCpf().equals(validar)) {
	        					cc.deposita(valor);
	        					System.out.println("\nH� na conta: R$ " + cc.getSaldo());
	        					break;        					
	        				} 
	        				cont--;
	        			}	
	        			if(cont == 0) {        							
	        				System.out.println("\nCPF n�o consta em nosso banco de dados. Tente novamente.\n");
	        			}     			    			        			
	        			break;
	        			
	        		case 2:
	        			System.out.print("\nInsira o valor a ser sacado:");
	        			valor = entradaValor.nextDouble();
	        			System.out.print("Insira o n�mero do seu CPF para validar o saque:");
	        			validar = entradaValidar.nextLine();
	        			
	        			for(int i = 0; i < contas.size(); i++) {
	        				ContaBancaria cc = contas.get(i);
	        				if(cc.getTitular().getCpf().equals(validar)) {
	        					double statusQuo = cc.getSaldo(); //para evitar, por enquanto, que a conta fique com saldo negativo;
	        					boolean retorno = cc.saca(valor);
	        					if (retorno == true) {
	        						System.out.println("\nValor sacado com sucesso.");
	        						System.out.println("H� na conta: R$ " + cc.getSaldo() + "\n");
	        					} else {
	        						System.out.println("\nValor imposs�vel para ser sacado.");
	        						cc.setSaldo(statusQuo);
	        						System.out.println("H� na conta: R$ " + cc.getSaldo() + "\n");
	        					}
	        				}
	        			}        			
	        			break;
	        			
	        		case 3:
	        			Scanner entradaTransferencia = new Scanner(System.in);
	        			String transferencia;
	        			        			
	        			System.out.print("\nInsira o valor a ser transferido:");
	        			valor = entradaValor.nextDouble();
	        			System.out.print("Insira seu CPF para validar a transfer�ncia:");
	        			validar = entradaValidar.nextLine();
	        			System.out.print("Insira o CPF da conta para a qual ser� transferido o valor:");
	        			transferencia = entradaTransferencia.nextLine();
	        			
	        			for(int i = 0; i < contas.size(); i++) {
	        				ContaBancaria cc = contas.get(i);
	        				if(cc.getTitular().getCpf().equals(validar)) {
	        					double statusQuo = cc.getSaldo();
	        					boolean retorno = cc.saca(valor);
	        					if (retorno == true) {
	        						System.out.println("\nValor dispon�vel para transfer�ncia.\n");
	        						
	        						for(int j = 0; j < contas.size(); j++) {
	        							ContaBancaria cc2 = contas.get(j);
	        							if(cc2.getTitular().getCpf().equals(transferencia)) {
	        								cc2.deposita(valor);
	        							}
	        						}
	        					} else {
	        						System.out.println("\nValor imposs�vel de ser transferido.\n");
	        						cc.setSaldo(statusQuo);
	        					}
	        				}
	        			}
	        			
	        			break;
	        			
	        		case 4:
	        			System.out.print("Insira o n�mero do seu CPF para verificar o saldo em conta:");
	        			validar = entradaValidar.nextLine();
	        			
	        			for(int i = 0; i < contas.size(); i++) {
	        				ContaBancaria cc = contas.get(i);
	        				if(cc.getTitular().getCpf().equals(validar)) {
	        					System.out.println("H� na conta: R$ " + cc.getSaldo() + "\n");
	        					break;
	        				}
	        				cont--;
	        			}
	        			if(cont == 0) {        							
	        				System.out.println("\nCPF n�o consta em nosso banco de dados. Tente novamente.\n");
	        			}	    			        			
	        			break;
	        			
	        		case 0:
	        			fimMenu = false;
	        			break;
	        		
				default:
	        			System.out.println("\nN�o h� a op��o escolhida neste menu.\n");
	        	}
	    	}while(fimMenu);
			
			System.out.println("\n");
			System.out.println("================================================================================================");
			System.out.println("================================OBRIGADO POR UTILIZAR NOSSOS SERVI�OS===========================");
			System.out.println("================================================================================================");
			
		}else{	
		
		System.out.println("\n");
		System.out.println("================================================================================================");
		System.out.println("================================OBRIGADO POR UTILIZAR NOSSOS SERVI�OS===========================");
		System.out.println("================================================================================================");
		}
	}
}		
