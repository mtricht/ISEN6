package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;

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
		
	
		betaling.setBounds(100,50,100,50);
		instellingen.setBounds(100,100,100,50);
		
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
