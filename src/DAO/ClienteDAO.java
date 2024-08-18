package DAO;

import models.Cliente;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import singleton.SingletonConnection;

public class ClienteDAO {
    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (NOME, EMAIL, TELEFONE, CPF) VALUES (?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getCPF());

            ps.execute();
            ps.close();
            System.out.println("Cliente cadastrado com sucesso");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
