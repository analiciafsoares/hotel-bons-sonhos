package dao;

import dto.QuartoDTO;
import utils.mapper.Mapper;
import models.quarto.Quarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuartoDAO {
    public void cadastrarQuarto(QuartoDTO quarto){
        Quarto entity = Mapper.parseObject(quarto, Quarto.class);

        String sql = "INSERT INTO quartos (ID, TIPO, PRECO_DIARIA, NUMERO, ANDAR) VALUES (?,?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setString(1, String.valueOf(quarto.getCodigoQuarto()));
            ps.setString(2, quarto.getTipo());
            ps.setString(3, String.valueOf(quarto.getPrecoDiaria()));
            ps.setString(4, String.valueOf(quarto.getNumero()));
            ps.setString(5, String.valueOf(quarto.getAndar()));

            ps.execute();
            ps.close();
            System.out.println("Quarto cadastrado com sucesso");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<QuartoDTO> listarQuartos() {
        String sql = "SELECT id, tipo, preco_diaria, numero, andar FROM quartos";
        ArrayList<QuartoDTO> quartos = new ArrayList<>();

        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                QuartoDTO quarto = new QuartoDTO();
                quarto.setCodigoQuarto(rs.getInt("id"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setPrecoDiaria(rs.getDouble("preco_diaria"));
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
               
                quartos.add(quarto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quartos;
    }

    public QuartoDTO recuperarQuarto(int id) {
        String sql = "SELECT id, tipo, preco_diaria, numero, andar FROM quartos WHERE id = ?";
        QuartoDTO quarto = null;
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) { 
                quarto = new QuartoDTO();
                quarto.setCodigoQuarto(rs.getInt("id"));
                quarto.setTipo(rs.getString("tipo"));
                quarto.setPrecoDiaria(rs.getDouble("preco_diaria"));
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
            }
    
        } catch(SQLException e){
            e.printStackTrace();
        }
    
        return quarto;
    }

    public boolean atualizarQuarto(QuartoDTO quarto) {
        Quarto entity = Mapper.parseObject(quarto, Quarto.class);

        String sql = "UPDATE quartos SET tipo = ?, preco_diaria = ?, numero = ?, andar = ? WHERE id = ?";
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, quarto.getTipo());
            ps.setDouble(2, quarto.getPrecoDiaria());
            ps.setInt(3, quarto.getNumero());
            ps.setInt(4, quarto.getAndar());
            ps.setInt(5, quarto.getCodigoQuarto());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return false;
    }
    

    public void removerQuarto(int id) {
        String checkSql = "SELECT COUNT(*) FROM reservas WHERE id_quarto = ?";
        String deleteSql = "DELETE FROM quartos WHERE id = ?";
        
        try (PreparedStatement checkPs = SingletonConnection.getCon().prepareStatement(checkSql)) {
            checkPs.setInt(1, id);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                try (PreparedStatement deletePs = SingletonConnection.getCon().prepareStatement(deleteSql)) {
                    deletePs.setInt(1, id);
                    deletePs.executeUpdate();
                    System.out.println("Quarto removido com sucesso");
                }
            } else {
                System.out.println("Não é possível remover o quarto, pois existem reservas associadas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}