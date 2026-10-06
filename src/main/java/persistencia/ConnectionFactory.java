package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:postgresql://localhost:5432/Databases/Livraria";
    private static final String USER = "postgres";
    private static final String PASSWORD = "database22";

    public static Connection geConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
