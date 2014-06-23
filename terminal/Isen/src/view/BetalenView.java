package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class BetalenView extends JFrame implements ActionListener{
	JButton one,two,three,four,five,a,b,c,d,e,menu,backspace,accept,empty;
	JTextField pinVeld;
	String passwordVeld = new String("");
	String password = new String("");
	
	public BetalenView()
	{
		setVisible(true);
		
		setSize(320,240);
		setTitle("Pincode invoeren");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(5,2));
		
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		a = new JButton("A");
		b = new JButton("B");
		c = new JButton("C");
		d = new JButton("D");
		e = new JButton("E");
		menu = new JButton("Menu");
		backspace = new JButton("Delete");
		accept = new JButton("Accept");
		pinVeld = new JTextField("");
		empty = new JButton("");
		
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		menu.addActionListener(this);
		backspace.addActionListener(this);
		accept.addActionListener(this);
		empty.setEnabled(false);
		
		add(one);
		add(two);
		add(three);
		add(four);
		add(five);
		add(a);
		add(b);
		add(c);
		add(d);
		add(empty);
		add(e);
		add(backspace);
		add(menu);
		add(pinVeld);
		add(accept);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == one)
		{
			passwordVeld += "*";
			password += "1";
		}
		if(e.getSource() == two)
		{
			passwordVeld += "*";
			password += "2";
		}
		if(e.getSource() == three)
		{
			passwordVeld += "*";
			password += "3";
		}
		if(e.getSource() == four)
		{
			passwordVeld += "*";
			password += "4";
		}
		if(e.getSource() == five)
		{
			passwordVeld += "*";
			password += "5";
		}
		if(e.getSource() == a)
		{
			passwordVeld += "*";
			password += "a";
		}
		if(e.getSource() == b)
		{
			passwordVeld += "*";
			password += "b";
		}
		if(e.getSource() == c)
		{
			passwordVeld += "*";
			password += "c";
		}
		if(e.getSource() == d)
		{
			passwordVeld += "*";
			password += "d";
		}
		if(e.getSource() == e)
		{
			passwordVeld += "*";
			password += "e";
		}
		if(e.getSource() == menu)
		{
			setVisible(false);
			new MainMenuView();
		}
		if(e.getSource() == backspace)
		{
			try
			{
				passwordVeld = passwordVeld.substring(0, passwordVeld.length()-1);
				password = password.substring(0, passwordVeld.length()-1);
			}
			catch(StringIndexOutOfBoundsException f){}
		}
		if(e.getSource() == accept)
		{
			setVisible(false);
			new AcceptView();	
		}
		pinVeld.setText(passwordVeld);
		System.out.println(password);
	}
	
	
	
	
}
