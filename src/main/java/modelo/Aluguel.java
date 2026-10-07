package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Aluguel {
	private int id;
	private LocalDate dataAluguel;
	private Estudante estudante;
	private ArrayList<ItemAluguel> itens;
	
	
	public Aluguel(int id, Estudante estudante, ArrayList<ItemAluguel> itens) {
		this.id = id;
		this.dataAluguel = LocalDate.now();
		this.estudante = estudante;
		this.itens = itens;
	}

	public int getId(){
		return this.id;
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
	
	public void adicionarItem(ItemAluguel item) {
		this.itens.add(item);
	}
	
	public void removerItem(ItemAluguel item) {
		this.itens.remove(item.getId());
	}
	
}
