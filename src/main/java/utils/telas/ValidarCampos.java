package utils.telas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
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

    public static boolean verificarSenhas(JPasswordField senha, JPasswordField confirmarSenha) {
        String senhaString = String.valueOf(senha.getPassword());
        String confirmar = String.valueOf(confirmarSenha.getPassword());
        
        return senhaString.equals(confirmar);
    }

    public static boolean isEmailValido(JTextField campo) {
        String email = campo.getText().trim();
        
        // Expressão regular para validar o e-mail
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
}
