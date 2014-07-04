package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class BetalenView extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2250278509813832874L;
	JButton one, two, three, four, five,
		a, b, c, d, e, menu, backspace,
		accept, empty;
	JPasswordField pinVeld;
	
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
		pinVeld = new JPasswordField("");
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

	public void actionPerformed(ActionEvent e) {
		String password = String.valueOf(pinVeld.getPassword());
		pinVeld.setText(password + ((JButton) e.getSource()).getText());
		if(e.getSource() == menu)
		{
			setVisible(false);
		}
		if(e.getSource() == backspace)
		{
			try
			{
				pinVeld.setText(password.substring(0, password.length()-1));
			}
			catch(StringIndexOutOfBoundsException f){}
		}
		if(e.getSource() == accept)
		{
			setVisible(false);	
		}
	}
	
	
	
	
}
