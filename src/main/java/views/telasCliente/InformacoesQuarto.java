package views.telasCliente;

import views.JanelaPadrao;
import views.ObjetosTelas.Botao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.QuartoController;
import dto.QuartoDTO;
import views.ObjetosTelas.TextosTelas;

public class InformacoesQuarto extends JanelaPadrao {
    private Botao anterior = new Botao(false);
    private Botao reservar = new Botao(false);
    private Botao proximo = new Botao(false);
    private TextosTelas codigo = new TextosTelas();
    private TextosTelas diaria = new TextosTelas();
    private TextosTelas capacidade = new TextosTelas();
    private TextosTelas numero = new TextosTelas();
    private TextosTelas andar = new TextosTelas();
    private TextosTelas tipo = new TextosTelas();


    
    private ArrayList<QuartoDTO> quartos;
    private int indiceAtual = 0;

    public InformacoesQuarto() {
        quartos = QuartoController.listarQuartos(); 
        objetos();
        ouvintes();
        fundo("Informações de Quartos");
        exibirQuartoAtual();
    }

    private void ouvintes() {
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceAtual > 0) {
                    indiceAtual--; 
                    exibirQuartoAtual(); 
                }
            }
        });

        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceAtual < quartos.size() - 1) {
                    indiceAtual++; 
                    exibirQuartoAtual(); 
                }
            }
        });

        reservar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void objetos() {
        int b = 499, c = 163, d = 76;
        anterior.setBounds(517, b, c, d);
        reservar.setBounds(724, b, c, d);
        proximo.setBounds(932, b, c, d);
        codigo.setBounds(726,208,33,35);
        diaria.setBounds(662,282,91,35);
        capacidade.setBounds(767,356,30,35);
        numero.setBounds(1022,208,30,35);
        andar.setBounds(994,282,30,35);
        tipo.setBounds(978,356,80,35);
        add(codigo);
        add(diaria);
        add(capacidade);
        add(numero);
        add(andar);
        add(tipo);
        add(anterior);
        add(reservar);
        add(proximo);
    }

    private void exibirQuartoAtual() {
        QuartoDTO quarto = quartos.get(indiceAtual);
        codigo.setText(String.valueOf(quarto.getCodigoQuarto()));
        diaria.setText(String.valueOf(quarto.getPrecoDiaria()));
        capacidade.setText(String.valueOf(quarto.getCapacidadeMaxima()));
        numero.setText(String.valueOf(quarto.getNumero()));
        andar.setText(String.valueOf(quarto.getAndar()));
        tipo.setText(String.valueOf(quarto.getTipo()));
        repaint();
    }

    public static void main(String[] args) {
        new InformacoesQuarto();
    }
}
