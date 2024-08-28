package controller;

import dao.ClienteDAO;
import dto.ClienteDTO;
import mapper.Mapper;
import models.Cliente;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;

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

}

