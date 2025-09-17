package visao;

import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Estudante;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;


public class MenuEstudante {
	
	public static void menuEstudantes(Scanner sc, BancoDeDados bd) throws IDInvalido {
		System.out.println("---------- MENU ESTUDANTES ----------");
		System.out.println("1- Adicionar Estudante");
		System.out.println("2- Remover Estudante");
		System.out.println("3- Alterar Estudante pelo ID");
		System.out.println("4- Pesquisar Estudante pelo ID");
		System.out.println("5- Listar todos os Estudantes");
		System.out.println("0- Voltar ao Menu Principal");
		
		int opcao = sc.nextInt();
		
		try {
			switch (opcao) {
			case 1:
				System.out.println("Informe os dados do estudante: ");
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Matricula: ");
				int matricula = sc.nextInt();
				Estudante estudante = new Estudante(nome, matricula);
				bd.getEstudantes().adicionar(estudante);
				break;
			case 2:
				System.out.println("Informe o ID do Estudante a ser removido: ");
				int id = sc.nextInt();
				bd.getEstudantes().remover(id);
				break;
			case 3:
				System.out.println("Informe o ID do Estudante a ser alterado: ");
				break;
			case 4:
				System.out.println("Informe o ID do Estudante: ");
				int idBusca = sc.nextInt();
				bd.getEstudantes().buscarPorID(idBusca);
				break;
			case 5:
				System.out.println("Lista de Estudantes: ");
				bd.getEstudantes().toString();
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				return;
			default:
				System.out.println("Opcao invalida.");
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro: input invalido. Tente novamente.");
			sc.nextLine();
		}
				
	}
}
