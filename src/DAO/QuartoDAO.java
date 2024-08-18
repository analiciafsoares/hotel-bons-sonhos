package DAO;

import models.Quarto;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import singleton.SingletonConnection;

public class QuartoDAO {
    public void cadastrarQuarto(Quarto quarto){
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
}