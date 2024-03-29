import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Teste {

	public static void main(String[] args) {
		
		Interface.CABECALHO();
				
		List<ContaBancaria> contas = new ArrayList<ContaBancaria>();
		Random random = new Random();
		boolean fimMenu = false;
		
		
		do{
			Scanner entradaMenu = new Scanner(System.in);
			int menu;
			        	
			Interface.PRIMEIRO_MENU();
        	menu = entradaMenu.nextInt();
        	
        	if (menu == 1) {
        		
        		double criarPremium = Interface.VALOR;        		       		
        		Cliente cliente = new Cliente();
        		ContaBancaria.agencia = 1337;
    			    			
    			cliente.cadastro(cliente);
    			   			 			
    			double comparar = cliente.getSalario();
    			if(comparar >= criarPremium) {
    				ContaBancaria conta = new ContaCorrente();
        			conta.setTitular(cliente);        			
        			conta.setNumeroConta(contas, random.nextInt(10000));
        			conta.imprimaDados(cliente);
        			conta.setExtrato(10);
        			contas.add(conta);        			
    			} else {
    				ContaBancaria conta = new ContaPoupanca();
    				conta.setTitular(cliente);        			
        			conta.setNumeroConta(contas, random.nextInt(1000));
        			conta.imprimaDados(cliente);
        			conta.setExtrato(5);
        			contas.add(conta);
    			}    		 			  			
        	} else {
        		fimMenu = true;
        	} 	
        }while(!fimMenu);
		
		if(contas.size() != 0) {	
		
			Interface.CABECALHO_OPERACOES();
			
			do{
				Scanner entradaMenu = new Scanner(System.in);
								
	        	int menu;
	        		        
	        	Interface.SEGUNDO_MENU();
	        	menu = entradaMenu.nextInt();
	            	        
	        	switch(menu) {
	        	
	        		case 1:
	        			Operacoes.deposita(contas);
	        			break;
	        			        		
	        		case 2:
	        			Operacoes.saca(contas);
	        			break;
	        			
	        		case 3:
	        			Operacoes.tranfere(contas);    			
	        			break;
	        			
	        		case 4:
	        			Operacoes.verExtrato(contas);		        			
	        			break;
	        			
	        		case 0:
	        			fimMenu = false;
	        			break;
	        		
				default:
					Interface.SEM_OPCAO();
	        	}
	    	}while(fimMenu);
			
			Interface.RODAPE();
			
		}else{		
			Interface.RODAPE();
		}
	}
}		
