package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaADM extends JFrame {
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
        rootFrame.setSize(500, 190);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        servicos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Servicos x = new Servicos("admin");
                rootFrame.dispose();
            }
        });
        gerenciarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteCRUD x = new ClienteCRUD("admin");
                rootFrame.dispose();
            }
        });
        gerenciarFuncionatios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FuncionarioCRUD x = new FuncionarioCRUD();
                rootFrame.dispose();
            }
        });
        gerenciarProcedimentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaGerenciarProcedimentos s = new TelaGerenciarProcedimentos("admin");
                rootFrame.dispose();
            }
        });
        gerenciarAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GerenciarAnimais s = new GerenciarAnimais("admin");
                rootFrame.dispose();
            }
        });
        inprimirRelatorios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaRelatorios s = new TelaRelatorios();
                rootFrame.dispose();
            }
        });
    }

}
