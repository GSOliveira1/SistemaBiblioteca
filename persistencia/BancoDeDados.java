package persistencia;

public class BancoDeDados {
	
	private Persistente estudantes;
	private Persistente livros;
	private Persistente alugueis;

	public BancoDeDados() {
		
	}

	public Persistente getEstudantes() {
		return estudantes;
	}

	public void setEstudantes(Persistente estudantes) {
		this.estudantes = estudantes;
	}

	public Persistente getLivros() {
		return livros;
	}

	public void setLivros(Persistente livros) {
		this.livros = livros;
	}

	public Persistente getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(Persistente alugueis) {
		this.alugueis = alugueis;
	}
	
	
}
