package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                if (!alterarPanel.isVisible())
                    frame.setSize(frame.getWidth(), frame.getHeight() + 70);
                    alterarPanel.setVisible(true);

            }
        });
        btnIr2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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
    }

}
