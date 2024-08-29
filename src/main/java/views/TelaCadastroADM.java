package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroADM extends JanelaPadrao{
    private EspacoTexto usuario = new EspacoTexto();
    private EspacoSenha senha = new EspacoSenha();
    private EspacoSenha confirmarSenha = new EspacoSenha();
    private Botao cadastrar = new Botao(false);



    public TelaCadastroADM(){
        objetos();
        ouvintes();
        invisivel();
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
        int a = 529, c = 260,d = 49;

        usuario.setBounds(a,317,c,d);
        senha.setBounds(a,407,c,d);
        confirmarSenha.setBounds(a,497,c,d);
        cadastrar.setBounds(529,573,220,64);
        add(usuario);
        add(senha);
        add(confirmarSenha);
        add(cadastrar);
    }

    public static void main(String[] args) {
        new TelaCadastroADM();
    }
}
