package visao;

import java.util.Scanner;

import modelo.Livro;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;

public class MenuLivro {
	
	public static void menuLivros(Scanner sc, BancoDeDados bd) {
		int opcao = 0;
		
		do {
			System.out.println("---------- MENU LIVROS ----------");
			System.out.println("1- Adicionar Livro");
			System.out.println("2- Remover Livro");
			System.out.println("3- Alterar Livro pelo ID");
			System.out.println("4- Pesquisar Livro pelo ID");
			System.out.println("5- Listar todos os Livros");
			System.out.println("0- Voltar ao Menu Principal");
			
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch(opcao) {
			case 1:
				System.out.println("Informe os dados do livro");
				System.out.println("Nome: ");
				String nomeLivro = sc.nextLine();
				System.out.println("Autor: ");
				String autorLivro = sc.nextLine();
				System.out.println("ID: ");
				int idLivro = sc.nextInt();
				Livro livro = new Livro(nomeLivro, autorLivro, idLivro);
				bd.getLivros().adicionar(livro);
				System.out.println("Livro adicionado.");
				break;
			case 2:
				try {
					System.out.println("Informe o ID do Livro a ser removido: ");
					int idRemocao = sc.nextInt();
					bd.getLivros().remover(idRemocao);
					System.out.println("Livro removido.");
					break;
				} catch (IDInvalido e) {
					System.out.println("Erro: ID invalido. ");
					break;
				}
			case 3:
				try {
					System.out.println("Informe o ID do Livro a ser alterado: ");
					int idAltera = sc.nextInt();
					sc.nextLine();
					
					Livro livroParaAlterar = (Livro) bd.getLivros().buscarPorID(idAltera);
					
					System.out.println("Novo nome: ");
					String novoNome = sc.nextLine();
					if (!novoNome.trim().isEmpty()) {
						livroParaAlterar.setNome(novoNome);
						System.out.println("Nome alterado.");
					}
					System.out.println("Novo autor");
					String novoAutor = sc.nextLine();
					if (!novoAutor.trim().isEmpty()) {
						livroParaAlterar.setAutor(novoAutor);
						System.out.println("Autor alterado.");
					
					}
					break;
				} catch (IDInvalido e) {
					System.out.println("Erro: Id invalido.");
				}
			case 4:
				try {
					System.out.println("Informe o ID do Livro: ");
					int idBusca = sc.nextInt();
					System.out.println(bd.getLivros().buscarPorID(idBusca));
					break;
				} catch (IDInvalido e) {
					System.out.println("Erro: id invalido.");
					break;
				}
			case 5:
				System.out.println("Lista de Livros: ");
				System.out.println(bd.getLivros().toString());
				break;
			case 0:
				System.out.println("Voltando ao menu principal.");
				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		} while (opcao != 0);
	}

}
