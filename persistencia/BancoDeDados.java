package persistencia;

import modelo.Aluguel;
import modelo.Estudante;
import modelo.Livro;

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
