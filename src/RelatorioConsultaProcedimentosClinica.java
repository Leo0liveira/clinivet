package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RelatorioConsultaProcedimentosClinica extends JFrame {
    JFrame frame;
    private JPanel TablePanel1;
    private JTable table1;
    private JButton fecharButton;
    private JScrollPane sc;


    public RelatorioConsultaProcedimentosClinica() {
        frame = new JFrame("ConsultaProcedimentosClinica");
        frame.setContentPane(TablePanel1);
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
