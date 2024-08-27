import singleton.SingletonConnection;

import java.sql.Connection;

public class App {
    public static void main (String[] args) {
        Connection conn = SingletonConnection.getCon();
    }
}