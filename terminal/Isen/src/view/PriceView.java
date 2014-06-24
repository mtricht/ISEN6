package view;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import properties.ReadProperties;

public class PriceView extends JFrame implements ActionListener{
	
	JButton one, two, three, four, five,
			six, seven, eight, nine, zero, comma, backspace, menu, betalen;
	String bedrag = "";
	JTextField bedragDisplay;
	ReadProperties readProperties = new ReadProperties();
	
	
	public PriceView()
	{
		
		
		setSize(320, 240);
		setTitle("Prijs invoeren");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(5, 2));
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		comma = new JButton(",");
		bedragDisplay = new JTextField("");
		backspace = new JButton("Delete");
		menu = new JButton("Menu");
		betalen = new JButton("Betalen");
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		zero.addActionListener(this);
		comma.addActionListener(this);
		backspace.addActionListener(this);
		menu.addActionListener(this);
		betalen.addActionListener(this);
		
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(six);
		add(seven);
		add(eight);
		add(nine);
		add(comma);
		add(zero);
		add(backspace);
		add(menu);
		add(bedragDisplay);
		add(betalen);
		setVisible(true);
	}
	
	public void gotoInstellingen()
	{
		if(bedragDisplay.getText().equals( readProperties.getPropertiesPin()))
		{
			setVisible(false);
			new SettingsView();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		bedrag = String.valueOf(bedragDisplay.getText());
		bedragDisplay.setText(bedrag + ((JButton) e.getSource()).getText());
		if(e.getSource() == backspace)
		{
			try
			{
				bedragDisplay.setText(bedrag.substring(0, bedrag.length() -1));
			}
			catch(StringIndexOutOfBoundsException f){}
		}
		if(e.getSource() == menu)
		{
			setVisible(false);
			new MainMenuView();
		}
		if(e.getSource() == betalen)
		{
			setVisible(false);
			new BetalenView();
		}
		gotoInstellingen();
	}
}
