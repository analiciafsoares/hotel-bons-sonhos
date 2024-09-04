package controller;

import dao.UsuarioDAO;
import dto.AdmDTO;
import dto.ClienteDTO;
import dto.UsuarioDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioController {
    public static UsuarioDTO verificarLogin(UsuarioDTO dto) {
        ArrayList<UsuarioDTO> usuarios = new UsuarioDAO().listarTodosUsuarios();
        
        for (UsuarioDTO u : usuarios) {
            if (u.getEmail().equals(dto.getEmail()) && u.getSenha().equals(dto.getSenha())) {
                return u;
            }
        }
        return null;
    }

    public static ClienteDTO cadastrarCliente(ClienteDTO c) {
        try {
            new UsuarioDAO().cadastrarUsuario(c, false);
        } catch (SQLException e) {
            c = null;
            System.out.println(e.getMessage());
        }
        return c;
    }

    public static AdmDTO cadastrarAdmin(AdmDTO a) {
        try {
            new UsuarioDAO().cadastrarUsuario(a, false);
        } catch (SQLException e) {
            a = null;
            System.out.println(e.getMessage());
        }
        return a;
    }

    public static boolean verificarUsuarios() {
        return new UsuarioDAO().listarTodosUsuarios().size() > 0;
    }

    public static UsuarioDTO resgatarCliente(String cpf) {
        UsuarioDTO cliente;
        cliente = new UsuarioDAO().recuperarUsuario(cpf);

        return cliente;
    }

    public static boolean atualizarCliente(UsuarioDTO cliente) {
        return new UsuarioDAO().atualizarUsuario(cliente);
    }

    public static String removerCliente(String cpf) {
        return new UsuarioDAO().removerUsuario(cpf);
    }

}

