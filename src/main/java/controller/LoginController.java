package controller;

import dao.ClienteDAO;
import dto.ClienteDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {


    public static ClienteDTO verificarLogin(ClienteDTO dto){
        ArrayList<ClienteDTO> clientes = new ClienteDAO().listarClientes();
        for (ClienteDTO c: clientes){
            if (c.getEmail().equals(dto.getEmail()) && c.getSenha().equals(dto.getSenha())){
                return c;
            }
        }
        return null;
    }

    public static ClienteDTO cadastrarCliente(ClienteDTO c) {
        try {
            new ClienteDAO().cadastrarCliente(c);
        } catch (SQLException e) {
            c = null;
            System.out.println(e.getMessage());
        }
        return c;
    }

}

