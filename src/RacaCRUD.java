package visao;

import controle.ControleRaca;
import modelo.Raca;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RacaCRUD extends JFrame {

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
    private JPanel alt_error_2;
    private JPanel remove_error_2;
    private JLabel add_error;

    public RacaCRUD(String caller) {

        ControleRaca cr = new ControleRaca();

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
        alt_error_2.setVisible(false);
        remove_error.setVisible(false);
        remove_error_2.setVisible(false);
        tfrem_desc.setEditable(false);
        add_error.setVisible(false);

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
                if (cr.buscaRaca(Integer.parseInt(tfrem_cod.getText())) == null) {
                    remove_error.setVisible(true);
                    return;
                } else {
                    Raca r = cr.buscaRaca(Integer.parseInt(tfrem_cod.getText()));
                    tfrem_cod.setText(Integer.toString(r.getID()));
                    tfrem_desc.setText(r.getDescricao());

                    if (!removePanel.isVisible())
                        frame.setSize(frame.getWidth(), frame.getHeight() + 75);
                    removePanel.setVisible(true);
                }
            }
        });
        //busca raca para alteração
        ir_altButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(cr.buscaRaca(Integer.parseInt(tfalt_cod.getText())) == null){
                    alt_error.setVisible(true);
                    return;
                }else{
                    Raca r = cr.buscaRaca(Integer.parseInt(tfalt_cod.getText()));
                    tfalt_cod.setText(Integer.toString(r.getID()));
                    tfalt_desc.setText(r.getDescricao());

                    if (!altPanel.isVisible())
                        frame.setSize(frame.getWidth(), frame.getHeight() + 75);
                    altPanel.setVisible(true);
                }

                if (!altPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 75);
                altPanel.setVisible(true);
            }
        });

        adicionarRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!cr.adicionaRaca(tfdesc_raca.getText()))
                    add_error.setVisible(true);
            }
        });

        alterarRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!cr.alteraRaca(Integer.parseInt(tfalt_cod.getText()), tfalt_desc.getText()))
                    alt_error_2.setVisible(true);
            }
        });

        removerRaçaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!cr.removeRaca(Integer.parseInt(tfrem_cod.getText()))){
                    remove_error_2.setVisible(true);
                }

            }
        });
    }

}
