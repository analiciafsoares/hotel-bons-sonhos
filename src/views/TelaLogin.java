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
        objetos();
        ouvintes();
        fundo("login");
    }

    private void ouvintes() {
        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


            }
        });

        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void objetos() {
        botao.setBounds(520,530,241,69);
        usuario.setBounds(491,235,297,49);
        senha.setBounds(491,323,297,49);
        cadastrar.setBounds(676,377,106,39);
        add(botao);
        add(usuario);
        add(senha);
        add(cadastrar);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
