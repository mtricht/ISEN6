package startup;

import java.awt.BorderLayout;
import java.awt.DisplayMode;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rsa.RSA;
import view.FullScreen;

public class TerminalApp extends JFrame{
	
	private static final long serialVersionUID = 2502662043151826952L;
	public static void main(String[] args) {
		new TerminalApp();
	}
	public TerminalApp()
	{
		/*FullScreen f = new FullScreen();
		DisplayMode dm = new DisplayMode(1366, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		
		//f.setFullScreen(dm, this);

		JPanel panel = new JPanel(new BorderLayout());
		Screen sc = new Screen();
		panel.add(sc);
		setContentPane(panel);
		pack();
		sc.start();
		setLocationRelativeTo(null);
		setVisible(true);*/
		RSA.loadPrivateKey(new byte[]{}, new char[]{});
	}

}
