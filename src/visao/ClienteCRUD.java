package visao;

import controle.ControleCliente;
import modelo.Cliente;

import javax.swing.*;
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
    private JLabel errormsg1;
    private JPanel searchPanel1;
    private JLabel searchmsg1;
    private JPanel incluePanel;
    private JLabel incluemsg;
    private JPanel searchPanel2;
    private JLabel searchmsg2;
    private JLabel errormsg2;
    private JPanel error2;


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

        ControleCliente cc = new ControleCliente();

        IRButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (cc.busca(campoCPF.getText()) != null) {
                    Cliente c = cc.busca(campoCPF.getText());
                    campoALTnome.setText(c.getNome());
                    campoALTendereco.setText(c.getEndereco());
                    campoALTcidade.setText(c.getCidade());
                    campoALTestado.setText(c.getEstado());
                    campoALTtelefone.setText(c.getTelefone());
                    campoALTdocumento.setText(c.getDocumento());
                    campoALTemail.setText(c.getEmail());
                }

                if (!alteraPanel.isVisible())
                    frameCliente.setSize(frameCliente.getWidth(), frameCliente.getHeight() + 150);
                alteraPanel.setVisible(true);
                searchPanel1.setVisible(false);
            }
        });
        IRButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (cc.busca(campoCPF.getText()) != null) {
                    Cliente c = cc.busca(campoCPF.getText());
                    campoREMOVEnome.setText(c.getNome());
                    campoREMOVEendereco.setText(c.getEndereco());
                    campoREMOVEcidade.setText(c.getCidade());
                    campoREMOVEestado.setText(c.getEstado());
                    campoREMOVEtelefone.setText(c.getTelefone());
                    campoREMOVEdocumento.setText(c.getDocumento());
                    campoREMOVEemail.setText(c.getEmail());
                }

                if (!removePanel.isVisible())
                    frameCliente.setSize(frameCliente.getWidth(), frameCliente.getHeight() + 160);

                searchPanel2.setVisible(false);
                removePanel.setVisible(true);
            }
        });
        VOLTARButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (caller == "admin") {
                    TelaADM t = new TelaADM();
                } else {
                    TelaFuncionario fun = new TelaFuncionario();
                }
                frameCliente.dispose();
            }
        });
        INCLUIRCLIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!cc.IncluiCliente(
                        campoCPF.getText(),
                        campoNome.getText(),
                        campoEndereco.getText(),
                        campoCidade.getText(),
                        campoEstado.getText(),
                        campoTelefone.getText(),
                        campoDocumento.getText(),
                        campoEMAIL.getText()))

                    incluePanel.setVisible(true);

            }
        });
        ALTERARCLIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!cc.AlteraCliente(
                        campoCPF.getText(),
                        campoNome.getText(),
                        campoEndereco.getText(),
                        campoCidade.getText(),
                        campoEstado.getText(),
                        campoTelefone.getText(),
                        campoDocumento.getText(),
                        campoEMAIL.getText()))

                    errorPanel1.setVisible(true);
            }
        });
        REMOVERCLIENTEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!cc.RemoveCliente(campoCPF.getText()))
                    error2.setVisible(true);
            }
        });
    }
}
