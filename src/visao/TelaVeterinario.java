package visao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaVeterinario extends JFrame{
    private static JFrame frame;
    private JPanel veterinarioPanel;
    private JButton btnConsultarAnimais;

    public TelaVeterinario(String title){
        super(title);
        frame = new JFrame("veterinario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(veterinarioPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,180);
        frame.setLocationRelativeTo(null);
        btnConsultarAnimais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame consulta = new TelaConsultarAnimais("consulte");
                frame.dispose();
           //     consulta.setVisible(true);


            }

        });
    }

  public static void main (String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,
          InstantiationException, IllegalAccessException {
       JFrame f = new TelaVeterinario("Veterinário");
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
   //   f.setVisible(false);

   }
}
