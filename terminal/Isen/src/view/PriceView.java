package view;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PriceView extends JFrame{
	
	public PriceView()
	{
		setVisible(true);
		
		setSize(320,240);
		setTitle("Prijs invoeren");
		
		repaint();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("ÿoyoyo");
		add(button);
	}
	
	public void draw(Graphics g)
	{
		g.setFont(null);
		g.drawString("Hello world", 0,0);
	}

}
