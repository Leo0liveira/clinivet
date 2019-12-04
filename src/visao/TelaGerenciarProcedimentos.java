  
package visao;

import controle.ControleAnimal;
import dao.NaoEncontradoExeception;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

public class TelaGerenciarProcedimentos extends JFrame {
    private static JFrame frame;
    private JPanel gerenciarProcPanel;
    private JLabel lblAddProcedimento;
    private JLabel lblCodigo;
    private JTextField txtCodigo;
    private JLabel lblDescricao;
    private JTextField txtDescricao;
    private JLabel lblPreco;
    private JTextField txtPreco;
    private JButton ADICIONARPROCEDIMENTOButton;
    private JTextField txtCodigoAlterar;
    private JButton btnIr;
    private JTextField txtNovoCodigo;
    private JTextField txtNovaDescricao;
    private JTextField txtNovoPreco;
    private JButton btnAlterar;
    private JButton btnIr2;
    private JButton btnRemover;
    private JButton btnVoltar;
    private JLabel lblRemoverProcedimento;
    private JLabel lblCodigoAlterar;
    private JPanel alterarPanel;
    private JTextField txtRemover;
    private JTextField txtCodigoRemovido;
    private JTextField txtDescricaoRemovida;
    private JTextField txtPrecoRemovido;
    private JPanel removerPanel;

    public TelaGerenciarProcedimentos(String s) {
      ControleProcedimento p = new ControleProcedimento()

        frame = new JFrame("Gerenciar procedimentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(gerenciarProcPanel);
        alterarPanel.setVisible(false);
        removerPanel.setVisible(false);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(550, 320);
        frame.setLocationRelativeTo(null);

        btnIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                    try {
                    if (p.buscaProcedimento(Integer.parseInt(txtCodigoAlterar.getText())) != null) {
                        alt_error.setVisible(true);
                        return;
                    }

                } catch (NaoEncontradoExeception naoEncontradoExeception) {
                    naoEncontradoExeception.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (!alterarPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 70);
                    alterarPanel.setVisible(true);

            }
        });
        btnIr2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (p.busProcedimento(Integer.parseInt(txtRemover.getText())) != null) {
                        remove_error.setVisible(true);
                        return;
                    }

                } catch (NaoEncontradoExeception naoEncontradoExeception) {
                    naoEncontradoExeception.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                if (!removerPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 100);
                removerPanel.setVisible(true);
            }
        });
        btnVoltar.addActionListener(new ActionListener() {
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
        ADICIONARPROCEDIMENTOButton.addActionListener(new ActionListener(){
              @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    p.adcionaProcedimento(txtCodigo.getText(), txtDescricao.getText(), txtPreco.getText())
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        btnAlterar.addActionListener(new ActionListener(){
              @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (p.alteraProcedimento(
                            Integer.parseInt(txtNovoCodigo.getText()),
                            txtNovaDescricao.getText(),
                            txtNovoPreco.getText()) {

                        return;
                    }else{
                        alt_error_2.setVisible(true);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        btnRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (!p.removeProcedimento(Integer.parseInt(txtRemover.getText()))) {
                        remove_error_2.setVisible(true);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
