package visao;

import visao.Funcionario;

import javax.swing.*;

public class TesteLeonardo {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Funcionario f = new Funcionario();

            }
        });

    }
}
