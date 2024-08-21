package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JanelaPadrao{
    private Botao botao = new Botao(false);
    private EspacoTexto usuario = new EspacoTexto();
    private EspacoSenha senha = new EspacoSenha();
    private Botao cadastrar = new Botao(false);

    public TelaLogin(){
        fechar(1294,133,34,75);
        objetos();
        ouvintes();
        fundo("login");
    }

    private void ouvintes() {
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, usuario.getText() + " " + senha.getText());

            }
        });

        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void objetos() {
        botao.setBounds(780,796,360,102);
        usuario.setBounds(745,355,430,70);
        senha.setBounds(745,489,430,70);
        cadastrar.setBounds(1027,575,136,36);
        add(botao);
        add(usuario);
        add(senha);
        add(cadastrar);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
