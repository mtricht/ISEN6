package startup;

import java.awt.BorderLayout;
import java.awt.DisplayMode;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.FullScreen;

public class TerminalApp extends JFrame{

	
	public static void main(String[] args) {
		new TerminalApp();
	}
	public TerminalApp()
	{
		FullScreen f = new FullScreen();
		DisplayMode dm=new DisplayMode(1366, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		
		f.setFullScreen(dm, this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//setIconImage();

		JPanel panel = new JPanel(new BorderLayout());
		Screen sc = new Screen();
		panel.add(sc);
		setContentPane(panel);
		pack();
		sc.start();

		setLocationRelativeTo(null);
		
		
		setVisible(true);
		
		
			
		
		
		//new PriceView();
	}

}
