import java.util.InputMismatchException;
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
		
		try {
			int opcao = sc.nextInt();
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
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro: digite um numero para escolher uma opcao.");
			sc.nextLine();
		} catch (IDInvalido e2) {
			System.out.println("Erro: id invalido");
		}

	}

}
