package dao;

import models.Cliente;
import singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (NOME, EMAIL, TELEFONE, CPF, SENHA) VALUES (?,?,?,?,?)";
        PreparedStatement ps = null;

        try {
            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getCPF());
            ps.setString(5, cliente.getSenha()); // Adiciona a senha

            ps.execute();
            ps.close();
            System.out.println("Cliente cadastrado com sucesso");
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Cliente> listarClientes() {
        String sql = "SELECT cpf, nome, email, telefone, senha FROM clientes";
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSenha(rs.getString("senha"));
        
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public Cliente recuperarCliente(String cpf) {
        String sql = "SELECT cpf, nome, email, telefone, senha FROM clientes WHERE cpf = ?";
        Cliente cliente = null;
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) { 
                cliente = new Cliente();
                cliente.setCPF(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setSenha(rs.getString("senha")); // Recupera a senha
            }
    
        } catch(SQLException e){
            e.printStackTrace();
        }
    
        return cliente;
    }

    public boolean atualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, senha = ? WHERE cpf = ?";
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getSenha()); // Atualiza a senha
            ps.setString(5, cliente.getCPF());
            
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return false;
    }

    public void removerCliente(String cpf) {
        String checkSql = "SELECT COUNT(*) FROM reservas WHERE id_cliente = ?";
        String deleteSql = "DELETE FROM clientes WHERE cpf = ?";
        
        try (PreparedStatement checkPs = SingletonConnection.getCon().prepareStatement(checkSql)) {
            checkPs.setString(1, cpf);
            ResultSet rs = checkPs.executeQuery();
            if (rs.next() && rs.getInt(1) == 0) {
                try (PreparedStatement deletePs = SingletonConnection.getCon().prepareStatement(deleteSql)) {
                    deletePs.setString(1, cpf);
                    deletePs.executeUpdate();
                    System.out.println("Cliente removido com sucesso");
                }
            } else {
                System.out.println("Não é possível remover o cliente, pois existem reservas associadas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
