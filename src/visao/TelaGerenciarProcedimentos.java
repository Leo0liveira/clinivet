import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaGerenciarProcedimentos extends JFrame{
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

    public TelaGerenciarProcedimentos(String title) {
        super(title);
        frame = new JFrame("Gerenciar procedimentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(gerenciarProcPanel);
        alterarPanel.setVisible(false);
        removerPanel.setVisible(false);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(550,800);
        frame.setLocationRelativeTo(null);

        btnIr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                alterarPanel.setVisible(true);
            }
        });
        btnIr2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removerPanel.setVisible(true);
            }
        });
    }
    public static void main (String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        JFrame frame = new TelaGerenciarProcedimentos("Gerenciar procedimentos");
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        //  frame.setVisible(true);
    }


}
