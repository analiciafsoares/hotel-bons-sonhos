package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection conn;

    static {
        try {
            String USUARIO = System.getenv("USUARIO");
            String SENHA = System.getenv("SENHA");

            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", USUARIO, SENHA);

            System.out.println("Conectado");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Connection getCon() {
        return conn;
    }
}

