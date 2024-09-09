package views.telasCliente;

import views.JanelaPadrao;
import views.ObjetosTelas.Botao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.QuartoController;
import dto.QuartoDTO;

public class InformacoesQuarto extends JanelaPadrao {
    private Botao anterior = new Botao(false);
    private Botao reservar = new Botao(false);
    private Botao proximo = new Botao(false);
    
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
        
        add(anterior);
        add(reservar);
        add(proximo);
    }

    private void exibirQuartoAtual() {
        QuartoDTO quarto = quartos.get(indiceAtual);
        // falta os campos para preencher mas a lógica já está funcionando
    }

    public static void main(String[] args) {
        new InformacoesQuarto();
    }
}
