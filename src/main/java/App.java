import dao.ClienteDAO;
import dto.ClienteDTO;
import singleton.SingletonConnection;

import java.sql.Connection;
import java.util.List;

public class App {
    public static void main (String[] args) {
        Connection conn = SingletonConnection.getCon();
    }
}