package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPadrao extends JFrame {
    private JButton fechar = new JButton();

    public JanelaPadrao(){
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(1920,1080);
        setVisible(true);
    }

    private void ouvinte() {
        fechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void objeto(int a,int b,int c, int d) {
        fechar.setBounds(a,b,c,d);
        add(fechar);
        ouvinte();
    }

    public void fundo(String foto) {
        ImageIcon imagem = new ImageIcon("imagens/"+foto+".png");
        JLabel label = new JLabel();
        label.setIcon(imagem);
        label.setBounds(0,0,getWidth(),getHeight());
        add(label);
        repaint();
    }
}
