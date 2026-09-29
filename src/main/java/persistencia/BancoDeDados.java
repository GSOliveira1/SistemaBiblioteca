package src.main.java.persistencia;

import src.main.java.modelo.Aluguel;
import src.main.java.modelo.Estudante;
import src.main.java.modelo.Livro;

public class BancoDeDados {
	
	private Persistente<Estudante> estudantes;
	private Persistente<Livro> livros;
	private Persistente<Aluguel> alugueis;

	public BancoDeDados() {
		estudantes = new Persistente<Estudante>();
		livros = new Persistente<Livro>();
		alugueis = new Persistente<Aluguel>();
	}

	public Persistente<Estudante> getEstudantes() {
		return estudantes;
	}

	public Persistente<Livro> getLivros() {
		return livros;
	}

	public Persistente<Aluguel> getAlugueis() {
		return alugueis;
	}	
	
}
