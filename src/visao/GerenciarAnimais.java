package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciarAnimais extends JFrame {
    private static JFrame frame;
    private JButton gerenciarRaçasButton;
    private JButton gerenciarEspéciesButton;
    private JButton gerenciarAnimaisButton;
    private JPanel mainPanel;
    private JButton voltarButton;

    public GerenciarAnimais(String s) {
        frame = new JFrame("Animais, especies e raças");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300, 180);


        gerenciarAnimaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnimaisCRUD an = new AnimaisCRUD(s);
                frame.dispose();
            }
        });
        gerenciarEspéciesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                EspeciesCRUD es = new EspeciesCRUD(s);
                frame.dispose();
            }
        });
        gerenciarRaçasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                RaçaCRUD ra = new RaçaCRUD(s);
                frame.dispose();
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(s == "admin") {
                    TelaADM t = new TelaADM();
                }else {
                    TelaFuncionario fun = new TelaFuncionario();
                }
                frame.dispose();
            }

        });
    }

}
