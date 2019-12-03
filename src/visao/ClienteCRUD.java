package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteCRUD extends JFrame {

    private JFrame frameCliente;

    private JPanel clientPanel;
    private JButton REMOVERCLIENTEButton;
    private JButton ALTERARCLIENTEButton;
    private JButton INCLUIRCLIENTEButton;
    private JTextField campoCPF;
    private JTextField campoNome;
    private JTextField campoEndereco;
    private JTextField campoCidade;
    private JTextField campoEstado;
    private JTextField campoTelefone;
    private JTextField campoDocumento;
    private JTextField campoEMAIL;
    private JButton IRButton;
    private JButton IRButton1;
    private JTextField campoALTestado;
    private JPanel alteraPanel;
    private JTextField campoALTtelefone;
    private JTextField campoALTdocumento;
    private JTextField campoALTemail;
    private JTextField campoALTnome;
    private JTextField campoALTcidade;
    private JTextField campoALTendereco;
    private JButton VOLTARButton;
    private JTextField campoALTcpf;
    private JTextField campoREMOVEcpf;
    private JPanel removePanel;
    private JTextField campoREMOVEnome;
    private JTextField campoREMOVEendereco;
    private JTextField campoREMOVEcidade;
    private JTextField campoREMOVEestado;
    private JTextField campoREMOVEtelefone;
    private JTextField campoREMOVEdocumento;
    private JTextField campoREMOVEemail;
    private JPanel errorPanel1;
    private JLabel errorPanel2;


    public ClienteCRUD(String caller) {
        frameCliente = new JFrame("Cliente");
        frameCliente.setContentPane(clientPanel);
        frameCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCliente.pack();
        frameCliente.setVisible(true);
        frameCliente.setSize(400, 550);

        alteraPanel.setVisible(false);
        removePanel.setVisible(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        campoREMOVEnome.setEditable(false);
        campoREMOVEcidade.setEditable(false);
        campoREMOVEendereco.setEditable(false);
        campoREMOVEtelefone.setEditable(false);
        campoREMOVEestado.setEditable(false);
        campoREMOVEdocumento.setEditable(false);
        campoREMOVEemail.setEditable(false);

        IRButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!alteraPanel.isVisible())
                    frameCliente.setSize(frameCliente.getWidth(), frameCliente.getHeight() + 150);
                alteraPanel.setVisible(true);
                errorPanel1.setVisible(false);
            }
        });
        IRButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!removePanel.isVisible())
                    frameCliente.setSize(frameCliente.getWidth(), frameCliente.getHeight() + 160);

                errorPanel2.setVisible(false);
                removePanel.setVisible(true);
            }
        });
        VOLTARButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(caller == "admin") {
                    TelaADM t = new TelaADM();
                }else {
                    TelaFuncionario fun = new TelaFuncionario();
                }
                frameCliente.dispose();
            }
        });
        INCLUIRCLIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                campoCPF.getText();
                campoNome.getText();
                campoEndereco.getText();
                campoCidade.getText();
                campoEstado.getText();
                campoTelefone.getText();
                campoDocumento.getText();
                campoEMAIL.getText();
                JOptionPane.showMessageDialog(frameCliente, "Cliente Incluso.");
            }
        });
    }
}
