package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import controle.ControleAutenticacao;
import modelo.Funcionario;
import visao.interfaces.*;

public class TelaLogin extends JFrame {
    private JFrame rootFrame;
    private JPanel rootPanel;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton button1;

    public TelaLogin() {
        rootFrame = new JFrame("login");
        rootFrame.setContentPane(rootPanel);
        rootFrame.pack();
        rootFrame.setVisible(true);
        rootFrame.setSize(500, 190);
        rootFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO substituir nome da classe do controler
                ControleAutenticacao ca = new ControleAutenticacao();
                Funcionario f = ca.autentica (textField1.getText(), passwordField1.getPassword());


                if (f.getClass().getTypeName() == "modelo.Administrador"){
                    TelaADM telaADM = new TelaADM();
                    JOptionPane.showMessageDialog(rootFrame, "olá, " + f.getNome() + " seja Bem Vindo");
                    rootFrame.dispose();
                } else if (f.getClass().getTypeName() == "modelo.Funcionario"){
                    TelaFuncionario tf = new TelaFuncionario();
                    JOptionPane.showMessageDialog(rootFrame, "olá, " + f.getNome() + " seja Bem Vindo");
                    rootFrame.dispose();
                } else if (f.getClass().getTypeName() == "modelo.Veterinario"){
                    TelaVeterinario tv = new TelaVeterinario("Veterinário");
                    JOptionPane.showMessageDialog(rootFrame, "olá, " + f.getNome() + " seja Bem Vindo");
                    rootFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "erro ao efetura login, por favor temte novamente");
                }


            }
        });
    }

}
