package utils.telas;

import javax.swing.JTextField;

public class ValidarCampos {
    public static boolean isVazio(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText() == null || campo.getText().trim().isEmpty()) {
                return true; 
            }
        }
        return false; 
    }    

    public static boolean verificarSenhas(String senha, String confirmarSenha) {
        return senha.equals(confirmarSenha);
    }
}
