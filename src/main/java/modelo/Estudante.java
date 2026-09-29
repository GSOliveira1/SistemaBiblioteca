package modelo;


public class Estudante extends Entidade {
	private String nome;
	private int matricula;
	
	public Estudante(String nome, int matricula) {
		super(matricula);
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + 
				", matricula=" + matricula +  
				", id=" + id + "]";
	}
	
	
}
