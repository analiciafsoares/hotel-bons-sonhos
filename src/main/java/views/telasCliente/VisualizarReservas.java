package views.telasCliente;

import dto.ReservaDTO;
import views.JanelaPadrao;
import views.ObjetosTelas.Botao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.ReservaController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VisualizarReservas extends JanelaPadrao {
    private String CPF;
    private Botao detalhar = new Botao(false);
    private Botao cancelar = new Botao(false);
    private Botao voltarMenu = new Botao(false);
    private DefaultTableModel modelo;
    private JTable tabela;
    private JScrollPane painelTabela;

    public VisualizarReservas(String CPF){
        this.CPF = CPF;
        objetos();
        ouvintes();
        tabela();
        fundo("VisualizarReservas");
    }

    private void ouvintes() {
        detalhar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        voltarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarMenu(CPF);
            }
        });
    }

//Tabela para mostrar os quartos do cliente, falta pegar as reservas, e também configurar as linhas

    public void tabela() {
        ArrayList<ReservaDTO> reservas = ReservaController.resgatarReservasDeClientes(CPF);
        modelo  = new DefaultTableModel();
        modelo.addColumn("ID reserva");
        modelo.addColumn("Tipo de quarto");
        modelo.addColumn("Checkin");
        modelo.addColumn("Checkout");
        modelo.addColumn("Preço Total");
        for(ReservaDTO reserva: reservas) {
            Object[] linha = new Object[5];
            linha[0] = reserva.getId();
            linha[1] = reserva.getQuarto().getTipo();
            linha[2] = reserva.getDataCheckin();
            linha[3] = reserva.getDataCheckout();
            linha[4] = reserva.getPrecoTotal();
            modelo.addRow(linha);
        }
        tabela = new JTable(modelo);
        painelTabela = new JScrollPane(tabela);
        painelTabela.setBounds(0,215,1280,288);
        add(painelTabela);
        repaint();
    }

    private void objetos() {
        detalhar.setBounds(324,559,262,87);
        cancelar.setBounds(708,559,262,87);
        voltarMenu.setBounds(1140,80,105,40);
        add(cancelar);
        add(detalhar);
        add(voltarMenu);
    }
}
