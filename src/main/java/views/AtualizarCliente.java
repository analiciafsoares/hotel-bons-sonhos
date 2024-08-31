package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoTexto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarCliente extends PainelPadrao{
    private EspacoTexto nome = new EspacoTexto();
    private EspacoTexto email = new EspacoTexto();
    private EspacoTexto senha = new EspacoTexto();
    private EspacoTexto telefone = new EspacoTexto();
    private EspacoTexto cpf = new EspacoTexto();
    private EspacoTexto pesquisar = new EspacoTexto();
    private Botao atualizar = new Botao(false);
    private Botao limpar = new Botao(false);
    private Botao lupa = new Botao(false);



    public AtualizarCliente(){
        objetos();
        ouvintes();
        fundo("atualizarCliente");
    }

    private void ouvintes() {
        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nome.setText("");
                email.setText("");
                senha.setText("");
                telefone.setText("");
                cpf.setText("");

            }
        });
        lupa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }


    private void objetos() {
        int a = 193,c = 299,d = 50;
        nome.setBounds(a,173,c,d);
        email.setBounds(a,253,c,d);
        senha.setBounds(a,333,c,d);
        telefone.setBounds(635,173,c,d);
        cpf.setBounds(635,253,c,d);
        pesquisar.setBounds(158,80,812,63);
        atualizar.setBounds(192,510,296,85);
        limpar.setBounds(584,510,296,85);
        lupa.setBounds(101,83,56,56);
        add(nome);
        add(email);
        add(senha);
        add(telefone);
        add(cpf);
        add(pesquisar);
        add(atualizar);
        add(limpar);
        add(lupa);
    }
}
