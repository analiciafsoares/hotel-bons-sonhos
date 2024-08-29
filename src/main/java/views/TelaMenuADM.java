package views;

import views.ObjetosTelas.Botao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenuADM extends JanelaPadrao{
    private Botao adicionarQuarto = new Botao(false);
    private Botao removerQuarto = new Botao(false);
    private Botao removerCliente = new Botao(false);
    private Botao atualizarCliente = new Botao(false);
    private Botao infomacoesCliente = new Botao(false);


    public TelaMenuADM(){
        objetos();
        ouvintes();
        invisivel();
        fundo("menu ADM");
    }

    private void ouvintes() {
        adicionarQuarto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invisivel();
                mostrar(getAdicionarQuarto());
            }
        });
        removerQuarto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invisivel();
                mostrar(getRemoverQuarto());
            }
        });
        removerCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invisivel();
                mostrar(getRemoverCliente());
            }
        });
        atualizarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invisivel();
                mostrar(getAtualizarCliente());
            }
        });
        infomacoesCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                invisivel();
                mostrar(getInformacoesCliente());
            }
        });
    }

    private void objetos() {
        int a = 19, c =175, d =53;
        adicionarQuarto.setBounds(a,269,c,d);
        removerQuarto.setBounds(a,338,c,d);
        removerCliente.setBounds(a,406,c,d);
        atualizarCliente.setBounds(a,474,c,d);
        infomacoesCliente.setBounds(a,542,c,64);
        add(adicionarQuarto);
        add(removerQuarto);
        add(removerCliente);
        add(atualizarCliente);
        add(infomacoesCliente);
    }

    public static void main(String[] args) {
        new TelaMenuADM();
    }
}
