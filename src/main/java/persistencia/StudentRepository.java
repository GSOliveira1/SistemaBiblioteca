package persistencia;

import modelo.Estudante;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void salvar(Estudante e);
    Optional<Estudante> buscarPorID(int id);
    List<Estudante> listarTodos();
    void atualizar(Estudante e);
    void excluir(int id);
}
