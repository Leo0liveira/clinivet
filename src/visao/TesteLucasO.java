package visao;

import javax.swing.*;

public class TesteLucasO {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GerenciarAnimais g = new GerenciarAnimais();
            }
        });
    }
}
