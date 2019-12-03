package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RaçaCRUD extends JFrame {

    private JFrame frame;
    private JPanel mainPanel;
    private JButton removerRaçaButton;
    private JButton alterarRaçaButton;
    private JTextField tfcod_raca;
    private JTextField tfalt_cod;
    private JTextField tfrem_cod;
    private JButton voltarButton;
    private JPanel removePanel;
    private JPanel altPanel;
    private JButton ir_altButton;
    private JButton ir_removeButton;
    private JTextArea tfalt_desc;
    private JTextArea tfrem_desc;
    private JPanel alt_error;
    private JPanel remove_error;
    private JTextArea tfdesc_raca;
    private JButton adicionarRaçaButton;

    public RaçaCRUD(String caller) {
        frame = new JFrame("RaçaCRUD");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 500);

        //Definoções
        altPanel.setVisible(false);
        removePanel.setVisible(false);
        alt_error.setVisible(false);
        remove_error.setVisible(false);
        tfrem_desc.setEditable(false);

        //BOTÕES
        //retorna a tela Gerenciar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GerenciarAnimais g = new GerenciarAnimais(caller);
                frame.dispose();
            }
        });
        //busca raça para remoção
        ir_removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!removePanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 75);
                removePanel.setVisible(true);
            }
        });
        //busca raca para alteração
        ir_altButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!altPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 75);
                altPanel.setVisible(true);
            }
        });

        adicionarRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo
            }
        });

        alterarRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo
            }
        });

        removerRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo
            }
        });
    }

}
