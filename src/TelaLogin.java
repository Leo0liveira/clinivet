package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
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
                //Funcionario f = autentica (textField1.getText(), passwordField1.getPassword());

                //TODO remover aspas do f.getNome()
                JOptionPane.showMessageDialog(rootFrame, "ola, " + "f.getNome()" + " seja Bem Vindo");
            }
        });
    }

}
