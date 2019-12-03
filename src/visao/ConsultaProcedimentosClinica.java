package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultaProcedimentosClinica extends JFrame {
    JFrame frame;
    private JPanel TablePanel1;
    private JTable table1;
    private JButton fecharButton;
    private JScrollPane sc;


    public ConsultaProcedimentosClinica() {
        frame = new JFrame("ConsultaProcedimentosClinica");
        frame.setContentPane(TablePanel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


//        data representa a lista de consultas e procedimentos
//        DefaultTableModel model = new DefaultTableModel(data, columnNames);
//        table1.setModel(model);

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        });
    }

}
