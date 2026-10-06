package modelo;


public class Estudante{
	private String nome;
	private int matricula;
	private int periodo;
	
	public Estudante(){

	}

	public Estudante(String nome, int matricula, int periodo) {
		this.nome = nome;
		this.matricula = matricula;
		this.periodo = periodo;
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

	public int getPeriodo(){
		return periodo;
	}

	public void setPeriodo(int periodo){
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return "Estudante [nome=" + nome + 
				", matricula=" + matricula +  
				", periodo=" + periodo + "]";
	}
	
}
