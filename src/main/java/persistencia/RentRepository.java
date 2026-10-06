package persistencia;

import modelo.Aluguel;
import java.util.List;
import java.util.Optional;

public interface RentRepository {
    void salvar(Aluguel al);
    Optional<Aluguel> buscarPorID(int id);
    List<Aluguel> listarTodos();
    void atualizar(Aluguel al);
    void excluir(int id);
}
