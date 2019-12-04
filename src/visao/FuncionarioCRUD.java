package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncionarioCRUD {

    private JFrame frame;
    private JButton voltarButton;
    private JButton removerFuncionarioButton;
    private JButton alterarFuncionarioButton;
    private JButton adicionarFuncionarioButton;
    private JTextField tfcpf;
    private JComboBox addpermbox;
    private JButton irButton;
    private JButton irButton2;
    private JPanel alt_panel;
    private JPanel remove_error;
    private JTextField tf_alt_cpf;
    private JPanel alt_error;
    private JPanel alt_error_2;
    private JTextField tfnome;
    private JTextField tfendereco;
    private JTextField tfcidade;
    private JTextField tfestado;
    private JTextField tftelres;
    private JTextField tfrelcel;
    private JTextField tfemail;
    private JTextField tfdatacont;
    private JTextField tf_alt_endereco;
    private JTextField tf_alt_nome;
    private JTextField tf_alt_cidade;
    private JTextField tf_alt_estado;
    private JTextField tf_alt_telres;
    private JTextField tf_alt_telcel;
    private JTextField tf_alt_email;
    private JTextField tf_alt_datacon;
    private JComboBox altpermbox;
    private JTextField tf_rem_cpf;
    private JTextField tf_rem_nome;
    private JTextField tf_rem_endereco;
    private JTextField tf_rem_cidade;
    private JTextField tf_rem_estado;
    private JTextField tf_remove_telres;
    private JTextField tf_rem_telcel;
    private JTextField tf_remove_email;
    private JTextField tf_remove_datacon;
    private JComboBox rempermbox;
    private JPanel remove_error_2;
    private JPanel mainPanel;
    private JPanel remove_panel;

    public FuncionarioCRUD() {
        frame = new JFrame("RaçaCRUD");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 600);

        //Definoções
        alt_panel.setVisible(false);
        alt_error.setVisible(false);
        alt_error_2.setVisible(false);
        remove_panel.setVisible(false);
        remove_error.setVisible(false);
        remove_error_2.setVisible(false);

        //botoes

        adicionarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        alterarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TelaADM ta = new TelaADM();
                frame.dispose();
            }
        });
        irButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        irButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo


            }
        });
    }
}
