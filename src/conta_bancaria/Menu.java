package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {
		Scanner leia = new Scanner(System.in);
		
		int opcao;

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
			

			opcao = leia.nextInt();
			
			if(opcao == 0) {
				System.out.println(Cores.TEXT_CYAN_BOLD_BRIGHT + "\nLumina Bank - Onde seu dinheiro brilha mais!");
				
				sobre();
				
				leia.close();
				
				System.exit(0);
				
			}
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Criar Conta\n\n");

					break;
				case 2:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Listar todas as Contas\n\n");

					break;
				case 3:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Consultar dados da Conta - por número\n\n");

					break;
				case 4:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Atualizar dados da Conta\n\n");

					break;
				case 5:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Apagar a Conta\n\n");

					break;
				case 6:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Saque\n\n");

					break;
				case 7:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Depósito\n\n");

					break;
				case 8:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Transferência entre Contas\n\n");

					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\nOpção Inválida!\n");
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
}
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	