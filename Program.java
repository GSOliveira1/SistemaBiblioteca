import java.util.Scanner;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;
import visao.*;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BancoDeDados bd = new BancoDeDados();
		
		System.out.println("---------- MENU PRINCIPAL ----------");
		System.out.println("1- Gerenciar Estudantes");
		System.out.println("2- Gerenciar Livros");
		System.out.println("3- Gerenciar Alugueis");
		System.out.println("4- Fechar Programa");
		int opcao = sc.nextInt();
		
		while (opcao != 4) {
			try {
				switch(opcao) {
				case 1:
					MenuEstudante.menuEstudantes(sc, bd);
					break;
				case 2:
					//menuLivros(sc, bd);
					break;
				case 3:
					//menuAlugueis(sc, bd);
					break;
				case 4:
					System.out.println("Encerrando o programa.");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Opcao invalida.");
					break;
				}
			} catch (IDInvalido e) {
				System.out.println("Erro: ID invalido.");
				sc.nextLine();
			}
		}	

	}

}
