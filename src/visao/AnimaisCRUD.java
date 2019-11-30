package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AnimaisCRUD extends JFrame {

    private JFrame frame;
    private JPanel mainPanel;
    JScrollPane scrollPane;
    private JButton adicionarAnimalButton;
    private JButton alterarAnimalButton;
    private JButton removerAnimalButton;
    private JTextField tfcod_animal;
    private JTextField tfnome_animal;
    private JButton irButton;
    private JPanel altPanel;
    private JTextField tfalt_nome_animal;
    private JTextField tfalt_sexo_animal;
    private JButton voltarButton;
    private JTextField tfnasc_animal;
    private JTextField tfespecie_animal;
    private JTextField tfraca_animal;
    private JTextField tfsexo_animal;
    private JPanel removePanel;
    private JButton ir_removeButton;
    private JPanel alt_error;
    private JPanel remove_error;
    private JTextField tfrem_nome_animal;
    private JTextField tfcor_animal;
    private JTextField tfalt_cod_animal;
    private JTextField tfalt_prop_animal;
    private JTextField tfalt_nasc_animal;
    private JTextField tfalt_especie_animal;
    private JTextField tfalt_raca_animal;
    private JTextField tfalt_cor_animal;
    private JTextField tfrem_cod_animal;
    private JTextField tfrem_prop_animal;
    private JTextField tfrem_nasc_animal;
    private JTextField tfrem_especie_animal;
    private JTextField tfrem_raca_animal;
    private JTextField tfrem_sexo_animal;
    private JTextField tfrem_cor_animal;
    private JTextField tfprop_animal;
    private JButton ir_altButton;

    public AnimaisCRUD() {

        frame = new JFrame("AnimaisCRUD");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 500);

        //Definições
        altPanel.setVisible(false);
        removePanel.setVisible(false);
        alt_error.setVisible(false);
        remove_error.setVisible(false);
        tfrem_nome_animal.setEditable(false);
        tfrem_prop_animal.setEditable(false);
        tfrem_nasc_animal.setEditable(false);
        tfrem_especie_animal.setEditable(false);
        tfrem_raca_animal.setEditable(false);
        tfrem_sexo_animal.setEditable(false);
        tfrem_cor_animal.setEditable(false);

        //BOTÕES

        //busca um animal para alteração
        irButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo busca

                if (!altPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 200);
                altPanel.setVisible(true);
                alt_error.setVisible(true);
            }
        });
        //retorna a tela Gerenciar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GerenciarAnimais g = new GerenciarAnimais();
                frame.dispose();
            }
        });

        //busca um animal para remoção
        ir_removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo busca

                if (!removePanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 200);
                removePanel.setVisible(true);
            }
        });

        adicionarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo add
            }
        });

        alterarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo alt
            }
        });

        removerAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo remove
            }
        });
    }
}
