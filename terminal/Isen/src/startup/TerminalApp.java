package startup;

import java.awt.BorderLayout;
import java.awt.DisplayMode;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.FullScreen;

public class TerminalApp {
	
	private static final long serialVersionUID = 2502662043151826952L;
	public static void main(String[] args) {
		//new TerminalApp();
		while(true) {
            try {
                TerminalFactory factory = TerminalFactory.getInstance("PC/SC", null);
                List<CardTerminal> terminals = factory.terminals().list();
                if (terminals.isEmpty()) {
                    // Wait 1 second.
                    Thread.sleep(1000);
                } else {
                    // Assume there's only one NFC/RFID reader.
                    //CardTerminal terminal = terminals.get(0);
                    System.out.println("Terminals length:" + terminals.size());
                    break;
                }
            } catch (NoSuchAlgorithmException|CardException|InterruptedException ex) {
                ex.printStackTrace();
            }
        }
	}
	/*public TerminalApp()
	{
		FullScreen f = new FullScreen();
		DisplayMode dm = new DisplayMode(1366, 768, 32, DisplayMode.REFRESH_RATE_UNKNOWN);
		
		f.setFullScreen(dm, this);

		JPanel panel = new JPanel(new BorderLayout());
		Screen sc = new Screen();
		panel.add(sc);
		setContentPane(panel);
		pack();
		sc.start();
		setLocationRelativeTo(null);
		setVisible(true);
		//RSA.test();
		//API.test();
	}*/

}
