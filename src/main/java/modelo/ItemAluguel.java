package modelo;

import java.time.LocalDate;

public class ItemAluguel {
	private int id;
	private Livro livro;
	private LocalDate dataDevolucao;
	
	public ItemAluguel(int id, Livro livro, LocalDate dataDevolucao) {
		this.id = id;
		this.livro = livro;
		this.dataDevolucao = dataDevolucao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
}
