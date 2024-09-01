package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.LoginController;
import dto.AdmDTO;

public class TelaCadastroADM extends JanelaPadrao{
    private EspacoTexto usuario = new EspacoTexto();
    private EspacoSenha senha = new EspacoSenha();
    private EspacoSenha confirmarSenha = new EspacoSenha();
    private Botao cadastrar = new Botao(false);

    public TelaCadastroADM(){
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

                if (!verificarSenhas(pegarSenha, pegarConfirmarSenha)) {
                    JOptionPane.showMessageDialog(null, "Os campos senha e confirmar senha devem ser iguais!");
                    return;
                }

                String cpf = JOptionPane.showInputDialog("Digite seu cpf:");

                AdmDTO dto = new AdmDTO(null, pegarUsuario, cpf, null, pegarSenha);
                AdmDTO adm = LoginController.cadastrarAdmin(dto);
                if (adm != null) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + adm.getNome() + "! Você foi cadastrado com sucesso");
                    new TelaMenuADM();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar administrador!");
                }

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
