package DAO;

import models.*;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

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

    public ArrayList<Reserva> listarReservas() {
        String sql = "SELECT id, id_cliente, id_quarto, data_checkin, data_checkout FROM reservas";
        ArrayList<Reserva> reservas = new ArrayList<>();
    
        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
    
            while (rs.next()) {
                Reserva reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                
                Cliente cliente = new ClienteDAO().recuperarCliente(rs.getString("id_cliente"));
                Quarto quarto = new QuartoDAO().recuperarQuarto(rs.getInt("id_quarto"));
                
                reserva.setCliente(cliente);
                reserva.setQuarto(quarto);
                
                reserva.setDataCheckin(rs.getDate("data_checkin"));
                reserva.setDataCheckout(rs.getDate("data_checkout"));
                
                reservas.add(reserva);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return reservas;
    }    

    public Reserva recuperarReserva(int id) {
        String sql = "SELECT id, id_cliente, id_quarto, data_checkin, data_checkout FROM reservas WHERE id = ?";
        Reserva reserva = null;
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) { 
                reserva = new Reserva();
                reserva.setId(rs.getInt("id"));
                
                Cliente cliente = new ClienteDAO().recuperarCliente(rs.getString("id_cliente"));
                Quarto quarto = new QuartoDAO().recuperarQuarto(rs.getInt("id_quarto"));
                
                reserva.setCliente(cliente);
                reserva.setQuarto(quarto);
                
                reserva.setDataCheckin(rs.getDate("data_checkin"));
                reserva.setDataCheckout(rs.getDate("data_checkout"));
            }
    
        } catch(SQLException e){
            e.printStackTrace();
        }
    
        return reserva;
    }

    public boolean atualizarReserva(Reserva reserva) {
        String sql = "UPDATE reservas SET id_cliente = ?, id_quarto = ?, data_checkin = ?, data_checkout = ? WHERE id = ?";
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, reserva.getCliente().getCPF());
            ps.setInt(2, reserva.getQuarto().getCodigoQuarto());
            ps.setDate(3, new java.sql.Date(reserva.getDataCheckin().getTime()));
            ps.setDate(4, new java.sql.Date(reserva.getDataCheckout().getTime()));
            ps.setInt(5, reserva.getId());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return false;
    }
    

    public void removerReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";
        PreparedStatement ps = null;

        try {
            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            System.out.println("Reserva removida com sucesso");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
