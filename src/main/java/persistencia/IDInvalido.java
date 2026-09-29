package persistencia;

public class IDInvalido extends Exception {
	private static final long serialVersionUID = 1149241039409861914L;
	
	public IDInvalido() {
		super("Erro: ID Invalido.");
	}
	
	@Override
	public String toString() {
		return "Erro: ID Invalido.";
	}
}
