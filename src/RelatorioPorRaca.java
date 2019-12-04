package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelatorioPorRaca {

    private JFrame frame;
    private JButton fecharButton;
    private JTable table1;
    private JPanel tablePanel1;
    private JScrollPane sc;

    public RelatorioPorRaca() {
        frame = new JFrame("ConsultaProcedimentosClinica");
        frame.setContentPane(tablePanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        Object [][] data = {
                {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
                {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
                {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
        };

        String[] columnNames = {"Nome", "Telefone", "Email"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }
}
