package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroADM extends JanelaPadrao{
    private EspacoTexto usuario = new EspacoTexto();
    private EspacoSenha senha = new EspacoSenha();
    private EspacoSenha confirmarSenha = new EspacoSenha();
    private Botao cadastrar = new Botao(false);



    public TelaCadastroADM(){
        fechar(1222,266,33,75);
        objetos();
        ouvintes();
        fundo("Cadastro Admin");
    }

    private void ouvintes() {
        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pegarUsuario = usuario.getText();
                String pegarSenha = String.valueOf(senha.getPassword());
                String pegarConfirmarSenha = String.valueOf(confirmarSenha.getPassword());


            }
        });
    }

    private void objetos() {
        usuario.setBounds(800,478,370,70);
        senha.setBounds(800,612,370,70);
        confirmarSenha.setBounds(800,746,370,70);
        cadastrar.setBounds(796,861,327,93);
        add(usuario);
        add(senha);
        add(confirmarSenha);
        add(cadastrar);
    }

    public static void main(String[] args) {
        new TelaCadastroADM();
    }
}
