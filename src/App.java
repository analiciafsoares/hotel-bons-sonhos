import java.sql.Connection;
import singleton.SingletonConnection;

public class App {
    public static void main (String[] args) {
        Connection conn = SingletonConnection.getCon();
    }
}
