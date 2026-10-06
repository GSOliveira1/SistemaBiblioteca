package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.Livro;

public class BookDatabase implements BookRepository {
    
    @Override
    public void salvar(Livro l){
        String sql = "INSERT INTO livro (idLivro, nome, autor) VALUES (?, ?, ?)";
        try(Connection conn = ConnectionFactory.geConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                ps.setInt(1, l.getId());
                ps.setString(2, l.getNome());
                ps.setString(3, l.getAutor());
                ps.executeUpdate();

                // Recupera o ID gerado pelo SERIAL
                try(ResultSet keys = ps.getGeneratedKeys()){
                    if (keys.next()){
                        l.setId(keys.getInt(1));
                    }
                }
            } catch(SQLException e){
                throw new RuntimeException("Erro ao salvar livro", e);
            }
    }

    @Override
    public Optional<Livro> buscarPorID(int id) {
        String sql = "SELECT idLivro, nome, autor FROM livro WHERE idLivro = ?";
        try(Connection conn = ConnectionFactory.geConnection();
            PreparedStatement ps = conn.prepareStatement(sql)){
                ps.setInt(1, id);
                try(ResultSet rs = ps.executeQuery()){
                    if (rs.next()){
                        return Optional.of(mapear(rs));
                    }
                    return Optional.empty();
                }
            } catch (SQLException e){
                throw new RuntimeException("Erro ao buscar livro por id", e);
            }
    }

    @Override
    public List<Livro> listarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atualizar(Livro l) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        
    }
    
    private Livro mapear(ResultSet rs) throws SQLException {
        Livro l = new Livro();
        l.setId(rs.getInt("id"));
        l.setNome(rs.getString("nome"));
        l.setAutor(rs.getString("autor"));
        return l;
    }
    
}
