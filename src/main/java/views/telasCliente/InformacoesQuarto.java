package views.telasCliente;

import views.JanelaPadrao;
import views.ObjetosTelas.Botao;
import views.TelaLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformacoesQuarto extends JanelaPadrao {
    private Botao anterior = new Botao(false);
    private Botao reservar = new Botao(false);
    private Botao proximo = new Botao(false);

    public InformacoesQuarto(){
        objetos();
        ouvintes();
        fundo("informações de quartos");
    }

    private void ouvintes() {
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void objetos() {
        int b = 499, c = 163, d = 76;
        anterior.setBounds(517,b,c,d);
        reservar.setBounds(724,b,c,d);
        proximo.setBounds(932,b,c,d);
        add(anterior);
        add(reservar);
        add(proximo);
    }

    public static void main(String[] args) {
        new InformacoesQuarto();
    }
}
