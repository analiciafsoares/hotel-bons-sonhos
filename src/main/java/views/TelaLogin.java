package views;

import controller.LoginController;
import dto.ClienteDTO;
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
                ClienteDTO c = LoginController.verificarLogin(usuario.getText(), new String(senha.getPassword()).trim());
                if (c != null){
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + c.getNome() + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Email e/ou senha incorretos!");
                }

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
        usuario.setBounds(502,235,277,49);
        senha.setBounds(502,323,277,49);
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
