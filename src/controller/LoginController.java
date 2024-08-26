package controller;

import java.util.ArrayList;

import dao.ClienteDAO;
import dto.ClienteDTO;
import models.Cliente;

public class LoginController {
    public static ClienteDTO verificarLogin(String email, String senha){
        ArrayList<Cliente> clientes = new ClienteDAO().listarClientes();
        for (Cliente c: clientes){
            if (c.getEmail().equals(email) && c.getSenha().equals(senha)){
                return new ClienteDTO(c.getNome(), c.getEmail(), c.getTelefone());
            }
        }
        return null;
    }
}

