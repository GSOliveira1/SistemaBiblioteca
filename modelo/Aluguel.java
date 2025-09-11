package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluguel extends Entidade {
	private LocalDate dataAluguel;
	private Estudante estudante;
	private ArrayList<ItemAluguel> itens;
	
	
	public Aluguel(int id, LocalDate dataAluguel, Estudante estudante) {
		super(id);
		this.dataAluguel = dataAluguel;
		this.estudante = estudante;
		itens = new ArrayList<>();
		dataAluguel = LocalDate.now();
	}

	public LocalDate getDataAluguel() {
		return dataAluguel;
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public ArrayList<ItemAluguel> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemAluguel> itens) {
		this.itens = itens;
	}
	
	public void adicionarItem(ItemAluguel item) {
		this.itens.add(item);
	}
	
	public void removerItem(ItemAluguel item) {
		this.itens.remove(item.getId());
	}
	
}
