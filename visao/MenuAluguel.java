package visao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Aluguel;
import modelo.Estudante;
import modelo.ItemAluguel;
import modelo.Livro;
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
				try {
					System.out.println("Informe o ID do Estudante para criar Aluguel: ");
					int idEstudante = sc.nextInt();
					sc.nextLine();
					Estudante estudante = (Estudante)bd.getEstudantes().buscarPorID(idEstudante);
					
					System.out.println("Quantos livros o estudante vai alugar?");
					int qtdLivros = sc.nextInt();
					sc.nextLine();
					
					ArrayList<ItemAluguel> itens = new ArrayList<>();
					
					for (int i=0; i<qtdLivros; i++) {
						System.out.println("Informe o ID do Livro " + i+1);
						int idLivro = sc.nextInt();
						sc.nextLine();
						Livro livro = (Livro) bd.getLivros().buscarPorID(idLivro);
						ItemAluguel item = new ItemAluguel(idLivro, livro, null);
						itens.add(item);
					}
					
					Aluguel aluguel = new Aluguel(idEstudante, estudante, itens);
					bd.getAlugueis().adicionar(aluguel);
					System.out.println("Aluguel criado com sucesso");
					
				} catch (IDInvalido e) {
					System.out.println("Erro: ID Invalido.");
				} catch (Exception e2) {
					System.out.println("Erro ao criar o aluguel: " + e2.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Informe o ID do Aluguel a ser removido:");
					int idAluguel = sc.nextInt();
					sc.nextLine();
					bd.getAlugueis().remover(idAluguel);
					System.out.println("Aluguel removido com sucesso.");
				} catch (IDInvalido e) {
					System.out.println("Erro: ID Invalido.");
				}
				break;
			case 3:
				try {
					System.out.println("Informe o ID do Aluguel a ser alterado: ");
					int idAluguel = sc.nextInt();
					sc.nextLine();
					
					Aluguel aluguel = (Aluguel) bd.getAlugueis().buscarPorID(idAluguel);
					System.out.println("Livros nesse aluguel: ");
					for (ItemAluguel item : aluguel.getItens()) {
						System.out.println(item.getId() + " - " + item.getLivro().getNome() + " | Devolvido: " + (item.getDataDevolucao() != null));
					}
					
					System.out.println("Informe o ID do Livro a ser devolvido: ");
					int idItem = sc.nextInt();
					sc.nextLine();
					
					for (ItemAluguel item : aluguel.getItens()) {
						if (item.getId() == idItem) {
							item.setDataDevolucao(LocalDate.now());
							System.out.println("Livro removido com sucesso.");
							break;
						}
					}
					
					bd.getAlugueis().alterar(idItem, aluguel);
					
				} catch (IDInvalido e) {
					System.out.println("Erro: ID Invalido");
				}
				break;
			case 4:
				try {
					System.out.println("Informe o ID do Aluguel que deseja buscar:");
					int idAluguel = sc.nextInt();
					sc.nextLine();
					
					Aluguel aluguel = (Aluguel)bd.getAlugueis().buscarPorID(idAluguel);
					System.out.println(aluguel);
					
				} catch (IDInvalido e) {
					System.out.println("Erro: ID Invalido.");
				}
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
