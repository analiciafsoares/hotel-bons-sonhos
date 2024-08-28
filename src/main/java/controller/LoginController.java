package controller;

import dao.ClienteDAO;
import dto.ClienteDTO;
import models.Cliente;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;

public class LoginController {
    public static ClienteDTO verificarLogin(String email, String senha){
        ArrayList<Cliente> clientes = new ClienteDAO().listarClientes();
        for (Cliente c: clientes){
            if (c.getEmail().equals(email) && c.getSenha().equals(senha)){
                return new ModelMapper().map(c, ClienteDTO.class);
            }
        }
        return null;
    }
}

