package DAO;

import models.Reserva;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;

import singleton.SingletonConnection;

public class ReservaDAO {
    public void cadastrarReserva(Reserva reserva){
        String sql = "INSERT INTO reservas (ID_CLIENTE, ID_QUARTO, DATA_CHECKIN, DATA_CHECKOUT) VALUES (?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setString(1, reserva.getCliente().getCPF());
            ps.setInt(2, reserva.getQuarto().getCodigoQuarto());
            ps.setDate(3, new Date(reserva.getDataCheckin().getTime()));
            ps.setDate(4, new Date(reserva.getDataCheckout().getTime()));

            ps.execute();
            ps.close();
            System.out.println("Reserva cadastrada com sucesso");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
