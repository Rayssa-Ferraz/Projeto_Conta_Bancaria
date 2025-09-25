package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;


public class Menu {
	
	private static final Scanner leia = new Scanner(System.in);
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {
				
		int opcao;
		
		criarContasTeste();
		
		while (true) {

			System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + Cores.ANSI_BLACK_BACKGROUND + "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                LUMINA BANK                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);
			
		try {
			opcao = leia.nextInt();
			leia.nextLine();
		}catch(InputMismatchException e) {	
			opcao = -1;
			System.out.println("\nDigite um número inteiro entre 0 e 8");
			leia.nextLine();
			
		}
			if(opcao == 0) {
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\nLumina Bank - Onde seu dinheiro brilha mais!");
				
				sobre();
				
				leia.close();
				
				System.exit(0);
				
			}
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Criar Conta\n\n");
					
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Listar todas as Contas\n\n");
					
					listarContas();
					
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Consultar dados da Conta - por número\n\n");
					
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Atualizar dados da Conta\n\n");
					
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Apagar a Conta\n\n");
					
					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Saque\n\n");
					
					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Depósito\n\n");
					
					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Transferência entre Contas\n\n");
					
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOpção Inválida!\n");
					keyPress();
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println("  ");
		System.out.println("  ");
		System.out.println(Cores.TEXT_CYAN_BRIGHT + "\n******************************************************");
		System.out.println(Cores.TEXT_CYAN_BRIGHT + "Projeto Desenvolvido por:                             ");
		System.out.println(Cores.TEXT_CYAN_BRIGHT + "Rayssa Ferraz - rayssa_nana@hotmail.com               ");
		System.out.println(Cores.TEXT_CYAN_BRIGHT + "github.com/Rayssa-Ferraz                              ");
		System.out.println(Cores.TEXT_CYAN_BRIGHT + "******************************************************");
	}
	
	public static void keyPress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
		leia.nextLine();
	}
	
	private static void criarContasTeste() {
		contaController.cadastrar(new ContaCorrente(1, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaCorrente(1, 456, 2, "MArcia Condarco", 1000000.00f, 10));
	}
	
	private static void listarContas() {
		contaController.listarTodas();
	}
}
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	