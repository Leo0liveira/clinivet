package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaADM  extends JFrame{
    private JPanel rootPanel;
    private JButton servicos;
    private JButton gerenciarCliente;
    private JButton gerenciarAnimais;
    private JButton gerenciarProcedimentos;
    private JButton inprimirRelatorios;
    private JButton gerenciarFuncionatios;
    private JFrame rootFrame;


    public TelaADM() {
        rootFrame = new JFrame("Administrador");
        rootFrame.setContentPane(rootPanel);
        rootFrame.pack();
        rootFrame.setVisible(true);
        rootFrame.setSize(500,190);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        servicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gerenciarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gerenciarFuncionatios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gerenciarProcedimentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        gerenciarAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        inprimirRelatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
