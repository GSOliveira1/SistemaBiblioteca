package persistencia;

public class BancoDeDados {
	
	private Persistente estudantes;
	private Persistente livros;
	private Persistente alugueis;

	public BancoDeDados() {
		estudantes = new Persistente();
		livros = new Persistente();
		alugueis = new Persistente();
	}

	public Persistente getEstudantes() {
		return estudantes;
	}

	public Persistente getLivros() {
		return livros;
	}

	public Persistente getAlugueis() {
		return alugueis;
	}	
	
}
