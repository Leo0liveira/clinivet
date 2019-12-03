package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaRelatorios extends JFrame {
    private JPanel rootPanel;
    private JButton relatorioAnimais;
    private JButton relatorioConsultas;
    private JFrame rootFrame;

    public TelaRelatorios() {
        rootFrame = new JFrame("Relatórios");
        rootFrame.setContentPane(rootPanel);
        rootFrame.pack();
        rootFrame.setVisible(true);
        rootFrame.setSize(500, 150);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        relatorioAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        relatorioConsultas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
