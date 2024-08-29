package controller;

import dao.ClienteDAO;
import dto.ClienteDTO;
import mapper.Mapper;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {


    public static ClienteDTO verificarLogin(String email, String senha){
        ArrayList<ClienteDTO> clientes = new ClienteDAO().listarClientes();
        for (ClienteDTO c: clientes){
            if (c.getEmail().equals(email) && c.getSenha().equals(senha)){
                return Mapper.parseObject(c, ClienteDTO.class);
            }
        }
        return null;
    }

    public static ClienteDTO cadastrarCliente(String nome, String email, String cpf, String telefone, String senha) {
        ClienteDTO c = new ClienteDTO(nome, email, cpf, telefone, senha);
        try {
            new ClienteDAO().cadastrarCliente(c);
        } catch (SQLException e) {
            c = null;
            System.out.println(e.getMessage());
        }
        return c;
    }

}

