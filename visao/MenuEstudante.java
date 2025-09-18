package visao;

import java.util.Scanner;

import modelo.Estudante;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;


public class MenuEstudante {
	
	public static void menuEstudantes(Scanner sc, BancoDeDados bd){
		int opcao = 0;
		
		do {
			System.out.println("---------- MENU ESTUDANTES ----------");
			System.out.println("1- Adicionar Estudante");
			System.out.println("2- Remover Estudante");
			System.out.println("3- Alterar Estudante pelo ID");
			System.out.println("4- Pesquisar Estudante pelo ID");
			System.out.println("5- Listar todos os Estudantes");
			System.out.println("0- Voltar ao Menu Principal");
			
			opcao = sc.nextInt();
			sc.nextLine();	// Limpa o buffer de entrada;
			
			switch (opcao) {
			case 1:
				System.out.println("Informe os dados do estudante: ");
				System.out.println("Nome: ");
				String nome = sc.nextLine();
				System.out.println("Matricula: ");
				int matricula = sc.nextInt();
				Estudante estudante = new Estudante(nome, matricula);
				bd.getEstudantes().adicionar(estudante);
				System.out.println("Estudante adicionado.");
				break;
			case 2:
				try {
					System.out.println("Informe o ID do Estudante a ser removido: ");
					int id = sc.nextInt();
					bd.getEstudantes().remover(id);
					System.out.println("Estudante removido.");
					break;
				} catch(IDInvalido e) {
					System.out.println("Erro: id invalido.");
					break;
				}
			case 3:
				try {
					System.out.println("Informe o ID do Estudante a ser alterado: ");
					int idAltera = sc.nextInt();
					System.out.println("Informe os novos dados: ");
					System.out.println("Nome: ");
					String novoNome = sc.nextLine();
					System.out.println("Matricula: ");
					int novaMatricula = sc.nextInt();
					Estudante novoEstudante = new Estudante(novoNome, novaMatricula);
					bd.getEstudantes().alterar(idAltera, novoEstudante);
					break;	
				} catch(IDInvalido e) {
					System.out.println("Erro: id invalido.");
					break;
				}
			case 4:
				try {
					System.out.println("Informe o ID do Estudante: ");
					int idBusca = sc.nextInt();
					System.out.println(bd.getEstudantes().buscarPorID(idBusca));
					break;
				} catch(IDInvalido e) {
					System.out.println("Erro: id invalido.");
					break;
				}
			case 5:
				System.out.println("Lista de Estudantes: ");
				System.out.println(bd.getEstudantes().toString());
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
