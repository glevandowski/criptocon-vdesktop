package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Levandowski e Mitkus
 */
public class BankConnect {

    private static final String URL = "jdbc:mysql://localhost/criptocon";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException se) {
            throw new SQLException("Erro ao conectar ao banco de dados! " + se.getMessage());
        }
        return connection;
    }
}
