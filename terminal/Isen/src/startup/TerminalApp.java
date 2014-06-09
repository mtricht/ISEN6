package startup;

import javax.swing.JFrame;

import view.MainMenuView;

public class TerminalApp extends JFrame{

	public TerminalApp()
	{
		setSize(320,240);
		setTitle("Terminal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MainMenuView mainmenuview = new MainMenuView();
		
		add(mainmenuview);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TerminalApp();
	}

}
