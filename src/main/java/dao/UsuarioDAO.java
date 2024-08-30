package dao;

import dto.AdmDTO;
import dto.ClienteDTO;
import dto.UsuarioDTO;
import utils.mapper.Mapper;
import models.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    public void cadastrarUsuario(UsuarioDTO dto, boolean isAdmin) throws SQLException {
        Usuario entity = Mapper.parseObject(dto, Usuario.class);

        String sql = "INSERT INTO usuarios (nome, email, telefone, CPF, senha, isAdmin) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getTelefone());
            ps.setString(4, entity.getCPF());
            ps.setString(5, entity.getSenha());
            ps.setBoolean(6, isAdmin);
            ps.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso");
        }
    }

    public ArrayList<UsuarioDTO> listarTodosUsuarios() {
        String sql = "SELECT CPF, nome, email, telefone, senha, isAdmin FROM usuarios";
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();

        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UsuarioDTO usuario;
                if (rs.getBoolean("isAdmin")) {
                    usuario = new AdmDTO(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("CPF"),
                            rs.getString("telefone"),
                            rs.getString("senha")
                    );
                } else {
                    usuario = new ClienteDTO(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("CPF"),
                            rs.getString("telefone"),
                            rs.getString("senha")
                    );
                }
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public ArrayList<UsuarioDTO> listarUsuarios(boolean apenasClientes) {
        String sql = "SELECT CPF, nome, email, telefone, senha FROM usuarios WHERE isAdmin = ?";
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();

        try (Connection con = SingletonConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, !apenasClientes); 
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UsuarioDTO usuario = new UsuarioDTO(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("CPF"),
                            rs.getString("telefone"),
                            rs.getString("senha"),
                            !apenasClientes 
                    );
                    usuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    public UsuarioDTO recuperarUsuario(String cpf) throws SQLException {
        String sql = "SELECT CPF, nome, email, telefone, senha, isAdmin FROM usuarios WHERE CPF = ?";
        UsuarioDTO usuario = null;

        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new UsuarioDTO(
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("CPF"),
                            rs.getString("telefone"),
                            rs.getString("senha"),
                            rs.getBoolean("isAdmin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean atualizarUsuario(UsuarioDTO usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ?, telefone = ?, senha = ?, isAdmin = ? WHERE CPF = ?";
        Usuario entity = Mapper.parseObject(usuario, Usuario.class);

        try (PreparedStatement ps = SingletonConnection.getCon().prepareStatement(sql)) {
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getTelefone());
            ps.setString(4, entity.getSenha());
            ps.setBoolean(5, entity.isAdmin());
            ps.setString(6, entity.getCPF());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void removerUsuario(String cpf) {
        String checkSql = "SELECT COUNT(*) FROM reservas WHERE id_cliente = ?";
        String deleteSql = "DELETE FROM usuarios WHERE CPF = ? AND isAdmin = FALSE";

        try (PreparedStatement checkPs = SingletonConnection.getCon().prepareStatement(checkSql)) {
            checkPs.setString(1, cpf);
            try (ResultSet rs = checkPs.executeQuery()) {
                if (rs.next() && rs.getInt(1) == 0) {
                    try (PreparedStatement deletePs = SingletonConnection.getCon().prepareStatement(deleteSql)) {
                        deletePs.setString(1, cpf);
                        deletePs.executeUpdate();
                        System.out.println("Usuário removido com sucesso");
                    }
                } else {
                    System.out.println("Não é possível remover o usuário");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
