package modelo;

public class Livro{
	private int id;
	private String nome;
	private String autor;

	public Livro(){

	}
	
	public Livro(int id, String nome, String autor) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	@Override
	public String toString() {
		return "ID: " + this.id + "Nome: " + this.nome + ", Autor: " + this.autor;
	}
}
