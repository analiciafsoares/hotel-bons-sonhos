package views;

import controller.UsuarioController;
import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoTexto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RemoverCliente extends PainelPadrao{
    private EspacoTexto cpf = new EspacoTexto();
    private Botao remover = new Botao(false);

    public RemoverCliente(){
        ouvintes();
        objetos();
    }

    private void ouvintes() {
        remover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpfCliente = cpf.getText();
                String resposta = UsuarioController.removerCliente(cpfCliente);

                if (resposta.equals("Usuário removido com sucesso")) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, resposta, "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void objetos() {
        int a = 373, c = 324, d = 50;
        cpf.setBounds(a,238,c,d);
        remover.setBounds(409,547,252,71);
        add(cpf);
        add(remover);
    }
}
