import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;

import builder.ReservaBuilder;
import models.Reserva;
import singleton.SingletonConnection;

public class App {
    public static void main (String[] args) {
        Connection conn = SingletonConnection.getCon();

    }
}
