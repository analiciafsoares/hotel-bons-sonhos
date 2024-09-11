package views.telasCliente;

import dto.ClienteDTO;
import dto.QuartoDTO;
import views.JanelaPadrao;
import views.ObjetosTelas.Botao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarReservas extends JanelaPadrao {
    private ClienteDTO cliente;
    private JLabel identificarCliente = new JLabel();
    private Botao detalhar = new Botao(false);
    private Botao cancelar = new Botao(false);
    private Botao voltarMenu = new Botao(false);
    private DefaultTableModel modelo;
    private JTable tabela;
    private JScrollPane painelTabela;

    public VisualizarReservas(String CPF){
        objetos();
        ouvintes();
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
                voltarMenu(cliente.getCPF());
            }
        });
    }


//Tabela para mostrar os quartos do cliente, falta pegar as reservas, e também configurar as linhas


//    public void tabela() {
//        modelo  = new DefaultTableModel();
//        modelo.addColumn("Nome");
//        modelo.addColumn("Dia");
//        modelo.addColumn("Corte");
//        modelo.addColumn("Horario");
//        for(QuartoDTO quarto: ) {
//            Object[] linha = new Object[4];
//            linha[0] = quarto.getNome();
//            linha[1] = quarto.getDia();
//            linha[2] = quarto.getCorte();
//            modelo.addRow(linha);
//        }
//        tabela = new JTable(modelo);
//        painelTabela = new JScrollPane(tabela);
//        painelTabela.setBounds(0,215,1280,288);
//        add(painelTabela);
//        repaint();
//    }

    private void objetos() {
        detalhar.setBounds(324,559,262,87);
        cancelar.setBounds(708,559,262,87);
        voltarMenu.setBounds(1140,80,105,40);
        add(cancelar);
        add(detalhar);
        add(voltarMenu);
    }
}
