package views;

import views.ObjetosTelas.Botao;
import views.ObjetosTelas.EspacoSenha;
import views.ObjetosTelas.EspacoTexto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarQuartoPainel extends PainelPadrao{
    private EspacoTexto numero = new EspacoTexto();
    private EspacoTexto categoria = new EspacoTexto();
    private EspacoTexto andar = new EspacoTexto();
    private EspacoTexto precoDiaria = new EspacoTexto();
    private Botao adicionar = new Botao(false);

    public AdicionarQuartoPainel(){
        objetos();
        ouvinte();
        fundo("Adicionar quarto");
    }

    private void ouvinte() {
        adicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void objetos() {
        int a = 363, c = 345,d = 57;
        numero.setBounds(a,196,c,d);
        categoria.setBounds(a,290,c,d);
        andar.setBounds(a,384,c,d);
        precoDiaria.setBounds(a,479,c,d);
        adicionar.setBounds(409,565,252,72);
        add(numero);
        add(categoria);
        add(andar);
        add(precoDiaria);
        add(adicionar);
    }
}
