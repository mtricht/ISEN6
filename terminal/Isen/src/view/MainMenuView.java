package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuView extends JPanel implements ActionListener{
	
	public MainMenuView()
	{
		JButton yo = new JButton("Test");
		yo.addActionListener(this);
		add(yo);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("test");
	}
}
