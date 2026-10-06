package persistencia;

import modelo.Livro;
import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void salvar(Livro l);
    Optional<Livro> buscarPorID(int id);
    List<Livro> listarTodos();
    void atualizar(Livro l);
    void excluir(int id);
}
