package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Servicos extends JFrame {

    private JFrame frameServico;
    private JButton IMPRIMIRRELATÓRIODERAÇASButton;
    private JButton AGENDARPROCEDIMENTOButton;
    private JPanel servicePanel;
    private JButton AGENDARCONSULTAButton;
    private JButton VOLTARButton;
    private JTextField textField1;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField2;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JButton IMPRIMIRRELATÓRIODOANIMALButton;
    private JButton IMPRIMIRRELATÓRIODECONSULTASButton;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    public Servicos(String s) {

        frameServico = new JFrame("Serviços");
        frameServico.setContentPane(servicePanel);
        frameServico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameServico.pack();
        frameServico.setVisible(true);
        frameServico.setSize(400, 810);
        comboBox1.addItem("Dinheiro");
        comboBox1.addItem("Cheque");
        comboBox1.addItem("Cartão de Crédito");
        comboBox1.addItem("Cartão de Débito");
        comboBox2.addItem("Dinheiro");
        comboBox2.addItem("Cheque");
        comboBox2.addItem("Cartão de Crédito");
        comboBox2.addItem("Cartão de Débito");


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        VOLTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(s == "admin") {
                    TelaADM t = new TelaADM();
                }else {
                    TelaFuncionario fun = new TelaFuncionario();
                }
                frameServico.dispose();
            }
        });
        IMPRIMIRRELATÓRIODECONSULTASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RelatorioConsultaProcedimentosClinica c = new RelatorioConsultaProcedimentosClinica();
            }
        });
        IMPRIMIRRELATÓRIODOANIMALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RelatorioConsultasPorAnimal c = new RelatorioConsultasPorAnimal();
            }
        });
        IMPRIMIRRELATÓRIODERAÇASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RelatorioPorRaca r = new RelatorioPorRaca();
            }
        });
    }

}
