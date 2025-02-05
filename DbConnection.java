import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import io.github.cdimascio.dotenv.Dotenv;

public class DbConnection {
    static Dotenv dotenv = Dotenv.load();
    private static final String url = dotenv.get("DB_URL");
    private static final String userName = dotenv.get("DB_USER");
    private static final String password = dotenv.get("DB_PASSWORD");

    public static Connection getConection() throws SQLException {
        return DriverManager.getConnection(url,userName,password);
    }
}
