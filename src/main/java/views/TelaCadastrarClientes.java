package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import controller.UsuarioController;
import dto.ClienteDTO;

public class TelaCadastrarClientes extends JanelaPadrao{
    private EspacoTexto nome = new EspacoTexto();
    private EspacoTexto CPF = new EspacoTexto();
    private EspacoTexto email = new EspacoTexto();
    private EspacoTexto telefone = new EspacoTexto();
    private EspacoSenha senha = new EspacoSenha();
    private EspacoSenha confirmarSenha = new EspacoSenha();
    private Botao cadastrar = new Botao(false);



    public TelaCadastrarClientes(){
        objetos();
        ouvintes();
        fundo("Cadastro cliente");
    }

    @Override
    public void fundo(String foto) {
        super.fundo(foto);
    }

    private void objetos() {
        int a = 463, c = 378,d = 36;

        nome.setBounds(a,206,c,d);
        CPF.setBounds(a,274,c,d);
        email.setBounds(a,343,c,d);
        telefone.setBounds(a,411,c,d);
        senha.setBounds(a,479,c,d);
        confirmarSenha.setBounds(a,546,c,d);
        cadastrar.setBounds(529,573,220,64);
        add(nome);
        add(senha);
        add(confirmarSenha);
        add(cadastrar);
        add(CPF);
        add(email);
        add(telefone);
    }

    private void ouvintes() {
        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pegarNome = nome.getText();
                String pegarSenha = String.valueOf(senha.getPassword());
                String pegarConfirmarSenha = String.valueOf(confirmarSenha.getPassword());
                String cpf = CPF.getText();
                String pegarEmail = email.getText();
                String pegarTelefone = telefone.getText();

                if (!verificarSenhas(pegarSenha, pegarConfirmarSenha)) {
                    JOptionPane.showMessageDialog(null, "Os campos senha e confirmar senha devem ser iguais!");
                    return;
                }


                ClienteDTO dto = new ClienteDTO(pegarNome, pegarEmail, cpf, pegarTelefone, pegarSenha);
                ClienteDTO cliente = UsuarioController.cadastrarCliente(dto);
                if (cliente != null) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo, " + cliente.getNome() + "! Você foi cadastrado com sucesso");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar cliente!");
                }
            }
        });

    }

    public static void main(String[] args) {
        new TelaCadastrarClientes();
    }
}
