package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
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
			System.out.println("            9 - Procurar pelo Títular da Conta       ");
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
					cadastrarConta();
					
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Listar todas as Contas\n\n");
					
					listarContas();
					
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Consultar dados da Conta - por número\n\n");
					procurarContaPorNumero();
					
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Atualizar dados da Conta\n\n");
					
					atualizarConta();
					
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Apagar a Conta\n\n");
					deletarConta();
					
					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Saque\n\n");
					
					sacar();
					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Depósito\n\n");
					
					depositar();
					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Transferência entre Contas\n\n");
					
					transferir();
					keyPress();
					break;
				case 9:
					System.out.println(Cores.TEXT_CYAN_BRIGHT + "Procurar pelo Titular da Conta\n\n");
					
					listarPorTitular();
					
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
		contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 456, 2, "Marcia Condarco", 1000000.00f, 10));
	}
	
	private static void listarContas() {
		contaController.listarTodas();
		
	}
	
	private static void cadastrarConta() {
		
		System.out.print("Digite o número da Agência: ");
		int agencia = leia.nextInt();
		
		System.out.print("Digite o nome do Titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.print("Digite o Tipo da Conta (1 - CC | 2 - CP): ");
		int tipo = leia.nextInt();
		
		System.out.print("Digite o Saldo inicial: ");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 ->{
			System.out.print("Digite o Limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 ->{
			System.out.print("Digite o dia do Aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));

		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
		}
	}
	
	private static void procurarContaPorNumero() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		contaController.procurarPorNumero(numero);
	}
	
	private static void deletarConta() {
		
		System.out.print("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		Conta conta = contaController.buscarNaCollection(numero);
		
		if(conta != null) {
			
			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();
			
			if(confirmacao.equalsIgnoreCase("S")){
			contaController.deletar(numero);
		}else {
			System.out.println("\nOperação cancelada!");
		}
		
		}else {
			System.out.printf("\nA conta numero %d não foi encontrada!", numero);
		
		
		}
			
		
		}
	 private static void atualizarConta() {
		 System.out.print("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();
			
			Conta conta = contaController.buscarNaCollection(numero);
			
			if(conta != null) {
				
				int agencia = conta.getAgencia();
				String titular = conta.getTitular();
				int tipo = conta.getTipo();
				float saldo = conta.getSaldo();
				
				System.out.printf("A Agência atual: %d\nNova Agência (Pressione ENTER para manter a agência atual): ", agencia);
				String entrada = leia.nextLine();
				agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada);
				
								
				System.out.printf("O nome do Titular atual: %s\n Novo Titular (Pressione ENTER para manter o nome do Titular atual): ", titular);
				entrada = leia.nextLine();
				titular = entrada.isEmpty() ? titular : entrada;

								
				System.out.printf("O Saldo atual é %.2f\nNovo Saldo (Pressione ENTER para manter o saldo atual): ", saldo);
				entrada = leia.nextLine();
				saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
				
				switch(tipo) {
				case 1 ->{
					float limite = ((ContaCorrente) conta).getLimite();
					
					System.out.printf("O Limite atual é %.2f\nNovo Limite (Pressione ENTER para manter o limite atual: ", limite);
					entrada = leia.nextLine();
					limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
					contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
				}
				case 2 ->{
					int aniversario = ((ContaPoupanca)conta).getAniversario();
					
					System.out.printf("O Aniversário atual é %d\nNovo Aniversário (Pressione ENTER para manter o aniversário atual): ", aniversario);
					entrada = leia.nextLine();
					aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
					contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));

				}
				default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
				}
				
			}else {
				System.out.printf("\nA conta numero %d não foi encontrada!", numero);
			}
	}
	 
	 private static void sacar() {
		 
		 System.out.print("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();
			
			System.out.print("Digite o valor do saque: ");
			float valor = leia.nextFloat();
			leia.nextLine();
			
			contaController.sacar(numero,  valor);
		 
	 }
	 
	 private static void depositar() {
		 
		 System.out.print("Digite o número da conta: ");
			int numero = leia.nextInt();
			leia.nextLine();
			
			System.out.print("Digite o valor do depósito: ");
			float valor = leia.nextFloat();
			leia.nextLine();
			
			contaController.depositar(numero,  valor);
		 
	 }
	 
	 private static void transferir() {
		 
		 System.out.print("Digite o número da conta de origem: ");
			int numeroOrigem = leia.nextInt();
			leia.nextLine();
			
			System.out.print("Digite o número da conta de destino: ");
			int numeroDestino = leia.nextInt();
			leia.nextLine();
			
			System.out.print("Digite o número da Transferência: ");
			float valor = leia.nextFloat();
			leia.nextLine();
			
			contaController.transferir(numeroOrigem, numeroDestino, valor);
		 
	 }
	 
	 private static void listarPorTitular() {
		 
		 System.out.print("Digite o nome do títular da conta: ");
		 String titular = leia.nextLine();
			
			contaController.listarPorTitular(titular);
		}
	 }

		
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	