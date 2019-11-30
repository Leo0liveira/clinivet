package visao;

import modelo.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Funcionario extends JFrame {

    private JFrame frameFunc;
    private JButton serviçosButton;
    private JButton gerenciarAnimaisButton;
    private JButton gerenciarProcedimentosButton;
    private JButton gerenciarClientesButton;
    private JPanel mainPanel;

    public Funcionario() {
        frameFunc = new JFrame("Tela Funcionario");
        frameFunc.setContentPane(mainPanel);
        frameFunc.pack();
        frameFunc.setVisible(true);
        frameFunc.setSize(300, 180);
        frameFunc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        gerenciarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Cliente a = new Cliente();
                frameFunc.dispose();
            }
        });

        serviçosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Serviços a = new Serviços();
                frameFunc.dispose();
            }
        });

        gerenciarAnimaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GerenciarAnimais g = new GerenciarAnimais();
                frameFunc.dispose();
            }
        });

        gerenciarProcedimentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                /*GerenciarProcedimentos p = new GerenciarProcedimentos();
                frameFunc.dispose();*/
            }
        });
    }

}
