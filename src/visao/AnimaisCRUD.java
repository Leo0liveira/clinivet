package visao;

import controle.ControleAnimal;
import dao.NaoEncontradoExeception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class AnimaisCRUD extends JFrame {

    private JFrame frame;
    private JPanel mainPanel;
    JScrollPane scrollPane;
    private JButton adicionarAnimalButton;
    private JButton alterarAnimalButton;
    private JButton removerAnimalButton;
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
    private JPanel alt_error_2;
    private JLabel remove_error_2;
    private JButton ir_altButton;

    public AnimaisCRUD(String caller) {

        ControleAnimal ca = new ControleAnimal();

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
        alt_error_2.setVisible(false);
        remove_error_2.setVisible(false);
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
                    if (ca.buscaAnimal(Integer.parseInt(tfalt_cod_animal.getText())) != null) {
                        alt_error.setVisible(true);
                        return;
                    }

                if (!altPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 200);
                altPanel.setVisible(true);
            }
        });
        //retorna a tela Gerenciar
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GerenciarAnimais g = new GerenciarAnimais(caller);
                frame.dispose();
            }
        });
        //busca um animal para remoção
        ir_removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (ca.buscaAnimal(Integer.parseInt(tfalt_cod_animal.getText())) != null) {
                        remove_error.setVisible(true);
                        return;
                    }

                if (!removePanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 200);
                removePanel.setVisible(true);
            }
        });

        adicionarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    ca.adicionaAnimal(
                            tfnome_animal.getText(),
                            Integer.parseInt(tfprop_animal.getText()),
                            tfnasc_animal.getText(),
                            Integer.parseInt(tfespecie_animal.getText()),
                            Integer.parseInt(tfraca_animal.getText()),
                            tfsexo_animal.getText(),
                            tfcor_animal.getText()
                    );
            }
        });

        alterarAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (ca.alteraAnimal(
                            Integer.parseInt(tfalt_cod_animal.getText()),
                            tfnome_animal.getText(),
                            Integer.parseInt(tfprop_animal.getText()),
                            tfnasc_animal.getText(),
                            Integer.parseInt(tfespecie_animal.getText()),
                            Integer.parseInt(tfraca_animal.getText()),
                            tfsexo_animal.getText(),
                            tfcor_animal.getText())) {

                        return;
                    }else{
                        alt_error_2.setVisible(true);
                    }
            }
        });

        removerAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    if (!ca.removeAnimal(Integer.parseInt(tfrem_cod_animal.getText()))) {
                        remove_error_2.setVisible(true);
                    }
            }
        });

    }
}
