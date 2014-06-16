package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuView extends JFrame implements ActionListener{
	
	JButton betaling, instellingen;
	public MainMenuView()
	{
		setSize(320,240);
		
		setTitle("Terminal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		setLayout(null);
		
		betaling = new JButton("Betaling");
		instellingen = new JButton("Instellingen");

		betaling.addActionListener(this);
		instellingen.addActionListener(this);
		
	
		betaling.setBounds(100,100,100,20);
		instellingen.setBounds(50,50,100,20);
		
		add(betaling);
		add(instellingen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == betaling)
		{
			setVisible(false);
			new PriceView();
		}
		if(e.getSource() == instellingen)
		{
			setVisible(false);
			new SettingsView();
		}
	}
}
