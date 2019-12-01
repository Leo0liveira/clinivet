import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaConsultarAnimais extends JFrame {
    private static JFrame frame;
    private JPanel consultarAnimaisPanel;
    private JLabel lblAnimal;
    private JLabel lblVeterinario;
    private JLabel lblData;
    private JLabel lblHorario;
    private JTextField txtIdAnimal;
    private JTextField txtIdVeterinário;
    private JTextField txtData;
    private JTextField txtHorario;
    private JLabel lblTipo;
    private JTextField textField1;
    private JButton btnSalvar;
    private JButton btnVoltar;

    public TelaConsultarAnimais(String title) {
        super(title);
        frame = new JFrame("Consultar animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(consultarAnimaisPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,180);
        frame.setLocationRelativeTo(null);


        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame f = new TelaVeterinario("Veterinário");
                frame.dispose();
            }
        });
    }
    public static void main (String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
            InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame frame = new TelaConsultarAnimais("Consultar animais");
        //  frame.setVisible(true);
    }


}
