package modelo;

public class Livro extends Entidade {
	private String nome;
	private String autor;
	
	public Livro(String nome, String autor, int id) {
		super(id);
		this.nome = nome;
		this.autor = autor;
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
		return "Nome: " + this.nome + ", Autor: " + this.autor + 
				super.toString();
	}
}
