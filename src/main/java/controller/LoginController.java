package controller;

import dao.UsuarioDAO;
import dto.UsuarioDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginController {


    public static UsuarioDTO verificarLogin(UsuarioDTO dto) {
        ArrayList<UsuarioDTO> usuarios = new UsuarioDAO().listarTodosUsuarios();
        
        for (UsuarioDTO u : usuarios) {
            if (u.getEmail().equals(dto.getEmail()) && u.getSenha().equals(dto.getSenha())) {
                return u;
            }
        }
        return null;
    }

    public static UsuarioDTO cadastrarCliente(UsuarioDTO c) {
        try {
            new UsuarioDAO().cadastrarUsuario(c, false);
        } catch (SQLException e) {
            c = null;
            System.out.println(e.getMessage());
        }
        return c;
    }

}

