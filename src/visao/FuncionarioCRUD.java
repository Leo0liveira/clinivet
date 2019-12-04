package visao;

import controle.ControleFuncionario;
import modelo.Funcionario;

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
    private Funcionario f;
    private ControleFuncionario cf;
    private int matricula;
    private JTextField tfaddsenha;
    private JTextField tfaltsenha;
    private JTextField tfremsenha;

    public FuncionarioCRUD() {
        frame = new JFrame("RaçaCRUD");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 600);
        cf = new ControleFuncionario();

        //Definoções
        alt_panel.setVisible(false);
        alt_error.setVisible(false);
        alt_error_2.setVisible(false);
        remove_panel.setVisible(false);
        remove_error.setVisible(false);
        remove_error_2.setVisible(false);

        addpermbox.addItem("Funcionário");
        addpermbox.addItem("Veterinário");
        addpermbox.addItem("Administrador");
        altpermbox.addItem("Funcionário");
        altpermbox.addItem("Veterinário");
        altpermbox.addItem("Administrador");
        rempermbox.addItem("Funcionário");
        rempermbox.addItem("Veterinário");
        rempermbox.addItem("Administrador");

        //botoes

        adicionarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (verificaCampos(tfnome.getText(), tfcidade.getText(), tfcpf.getText(), tfdatacont.getText(), tfendereco.getText(), tfestado.getText(), tftelres.getText(), tfrelcel.getText(), tfemail.getText())) {
                    if (cf.adicionaFuncionario(tfnome.getText(), tfendereco.getText(), tfcidade.getText(), tfestado.getText(), tftelres.getText(), tfrelcel.getText(), tfemail.getText(), tfdatacont.getText(), tfcpf.getText(), addpermbox.getActionCommand(), tfaddsenha.getText())) {
                        JOptionPane.showMessageDialog(mainPanel, "Funcionário Adicionado com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(mainPanel, "Não foi possivel cadastrar o funcionário, por favor reveja os campos e tente novamente");
                    }
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "informações faltando, por favor reveja os campos e tente novamente");
                }
            }
        });
        alterarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                alt_panel.setVisible(false);
                alt_error_2.setVisible(false);
                if (verificaCampos(tf_alt_cidade.getText(), tf_alt_cpf.getText(), tf_alt_datacon.getText(), tf_alt_email.getText(), tf_alt_endereco.getText(), tf_alt_estado.getText(), tf_alt_nome.getText(), tf_alt_telcel.getText(), tf_alt_telres.getText())) {
                    if (cf.alteraFuncionario(matricula, tf_alt_nome.getText(), tf_alt_endereco.getText(), tf_alt_cidade.getText(), tf_alt_estado.getText(), tf_alt_telres.getText(), tf_alt_telcel.getText(), tf_alt_email.getText(), tf_alt_datacon.getText(), tf_alt_cpf.getText(), altpermbox.getActionCommand())) {
                        JOptionPane.showMessageDialog(mainPanel, "Alteração realizada com sucesso");
                    } else {
                        alt_error_2.setVisible(true);
                    }
                } else {
                    alt_error_2.setVisible(true);
                }
            }
        });
        removerFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                remove_error_2.setVisible(false);
                if (cf.removeFuncionario(matricula)){
                    JOptionPane.showMessageDialog(mainPanel, "Remoção realizada com sucesso");
                    altpermbox.setSelectedItem(f.getTipo_permissao());
                } else{
                    remove_error_2.setVisible(true);
                }
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
                alt_error.setVisible(false);
                matricula = Integer.parseInt(tf_alt_cpf.getText());
                f = cf.buscaFuncionario(matricula);
                if (f != null) {
                    tf_alt_cidade.setText(f.getCidade());
                    tf_alt_cpf.setText(f.getCpf());
                    tf_alt_datacon.setText(f.getData_contratacao());
                    tf_alt_email.setText(f.getEmail());
                    tf_alt_endereco.setText(f.getEndereco());
                    tf_alt_estado.setText(f.getEstado());
                    tf_alt_nome.setText(f.getNome());
                    tf_alt_telres.setText(f.getTelefone_residencial());
                    tf_alt_telcel.setText(f.getTelefone_celular());

                    if(f.getTipo_permissao() == "funcionario")
                        altpermbox.setSelectedItem("Funcionário");
                    if(f.getTipo_permissao() == "veterinario")
                        altpermbox.setSelectedItem("Veterinário");
                    if(f.getTipo_permissao() == "administrador")
                        altpermbox.setSelectedItem("Administrador");
                    if(!alt_panel.isVisible()){
                        alt_panel.setVisible(true);
                        frame.setSize(frame.getWidth(), frame.getHeight() + 180);
                    }

                } else {
                    alt_error.setVisible(true);
                }
            }
        });
        irButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                matricula = Integer.parseInt(tf_rem_cpf.getText());
                f = cf.buscaFuncionario(matricula);
                if (f == null) {
                    if(!alt_panel.isVisible()){
                        frame.setSize(frame.getWidth(), frame.getHeight() + 220);
                    }
                } else {

                    remove_panel.setVisible(true);
                    tf_rem_cidade.setText(f.getCidade());
                    tf_rem_cpf.setText(f.getCpf());
                    tf_remove_datacon.setText(f.getData_contratacao());
                    tf_remove_email.setText(f.getEmail());
                    tf_rem_endereco.setText(f.getEndereco());
                    tf_rem_estado.setText(f.getEstado());
                    tf_rem_nome.setText(f.getNome());
                    tf_remove_telres.setText(f.getTelefone_residencial());
                    tf_rem_telcel.setText(f.getTelefone_celular());

                    if(f.getTipo_permissao() == "funcionario")
                        altpermbox.setSelectedItem("Funcionário");
                    if(f.getTipo_permissao() == "veterinario")
                        altpermbox.setSelectedItem("Veterinário");
                    if(f.getTipo_permissao() == "administrador")
                        altpermbox.setSelectedItem("Administrador");
                }
            }
        });
    }

    private boolean verificaCampos(String campo1, String campo2, String campo3, String campo4, String campo5, String campo6, String campo7, String campo8, String campo9) {
        if (campo1 == null || campo2 == null || campo3 == null || campo4 == null || campo5 == null || campo6 == null || campo7 == null || campo8 == null || campo9 == null) {
            return false;
        }
        return true;
    }
}