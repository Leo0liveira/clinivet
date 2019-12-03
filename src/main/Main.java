package main;

import visao.TelaLogin;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e){}

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TelaLogin tl = new TelaLogin();
            }
        });
    }
}