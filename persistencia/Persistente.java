package persistencia;

import java.util.ArrayList;

import modelo.Entidade;

public class Persistente {
	private ArrayList<Entidade> entidades;
	
	public Persistente() {
		entidades = new ArrayList<>();
	}
	
	public void adicionar(Entidade e) {
		this.entidades.add(e);
	}
	
	public void remover(int id)  throws IDInvalido {
		Entidade aux = buscarPorID(id);
		int indiceRemocao = entidades.indexOf(aux);
		if (indiceRemocao == -1) {	// Entity not found.
			return;
		}
		entidades.remove(indiceRemocao);
	}
	
	public void alterar(int id, Entidade e) throws IDInvalido {
		int idParaAlterar = e.getId();
		
		for (int i = 0; i < entidades.size(); i++) {
			Entidade aux = entidades.get(i);
			if (idParaAlterar == aux.getId()) {
				entidades.set(i, e);
			}
		}
		
	}
	
	public Entidade buscarPorID(int id) throws IDInvalido {
		for (int i = 0; i < entidades.size(); i++) {
			Entidade aux = entidades.get(i);
			if (aux.getId() == id) {
				return aux;
			}
		}
		throw new IDInvalido();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (entidades.isEmpty()) {
			return "Nenhuma entidade.";
		}
		for (Entidade entidade : entidades) {
			sb.append(entidade.toString()).append("\n");
		}
		return sb.toString();
	}
}
