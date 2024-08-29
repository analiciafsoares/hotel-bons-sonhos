package dao;

import dto.ClienteDTO;
import mapper.Mapper;
import models.Cliente;
import singleton.SingletonConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    public void cadastrarCliente(ClienteDTO dto) throws SQLException{
        Cliente entity = Mapper.parseObject(dto, Cliente.class);

        String sql = "INSERT INTO clientes (NOME, EMAIL, TELEFONE, CPF, SENHA) VALUES (?,?,?,?,?)";
        PreparedStatement ps = null;

            ps = SingletonConnection.getCon().prepareStatement(sql);
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getTelefone());
            ps.setString(4, entity.getCPF());
            ps.setString(5, entity.getSenha()); 

            ps.execute();
            ps.close();
            System.out.println("Cliente cadastrado com sucesso");
    }

    public ArrayList<ClienteDTO> listarClientes() {
        String sql = "SELECT cpf, nome, email, telefone, senha FROM clientes";

        ArrayList<ClienteDTO> clientes = new ArrayList<>();

        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ClienteDTO cliente = new ClienteDTO(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("senha"));
        
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public ClienteDTO recuperarCliente(String cpf) throws SQLException{
        String sql = "SELECT cpf, nome, email, telefone, senha FROM clientes WHERE cpf = ?";
        ClienteDTO cliente = null;
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) { 
                cliente = new ClienteDTO(rs.getString("nome"), rs.getString("email"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("senha"));
            }
    
        } catch(SQLException e){
            e.printStackTrace();
        }
    
        return cliente;
    }

    public boolean atualizarCliente(ClienteDTO cliente) {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, senha = ? WHERE cpf = ?";

        Cliente entity = Mapper.parseObject(cliente, Cliente.class);
    
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getTelefone());
            ps.setString(4, entity.getSenha()); // Atualiza a senha
            ps.setString(5, entity.getCPF());
            
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
