package modelo;

import java.util.ArrayList;

public class Estudante extends Entidade {
	private String nome;
	private int matricula;
	private ArrayList<Aluguel> alugueis;
	
	public Estudante(String nome, int matricula) {
		super(matricula);
		this.nome = nome;
		this.matricula = matricula;
		this.alugueis = new ArrayList<>();
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
	
	public ArrayList<Aluguel> getAlugueis(){
		return alugueis;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
