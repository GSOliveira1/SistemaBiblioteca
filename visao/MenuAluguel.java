package visao;

import java.util.Scanner;

import modelo.Aluguel;
import modelo.ItemAluguel;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;

public class MenuAluguel {
	
	public static void menuAluguel(Scanner sc, BancoDeDados bd) {
		int opcao = 0;
		
		do {
			System.out.println("---------- MENU ALUGUEL ----------");
			System.out.println("1- Criar Aluguel");
			System.out.println("2- Remover Aluguel");
			System.out.println("3- Alterar Aluguel pelo ID");
			System.out.println("4- Pesquisar Aluguel pelo ID");
			System.out.println("5- Listar todos os Alugueis");
			System.out.println("0- Voltar ao Menu Principal");
			
			opcao = sc.nextInt();
			sc.nextLine();	// Limpa o buffer de entrada;
			
			switch (opcao) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				System.out.println("Lista de Alugueis: ");
				System.out.println(bd.getAlugueis().toString());
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				System.out.println("Opcao invalida.");
				break;
			}
		} while (opcao != 0);
	}

}
