package visao;

import javax.swing.*;

public class teste {
	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				TelaFuncionario t = new TelaFuncionario();
			}
		});
	}
}
