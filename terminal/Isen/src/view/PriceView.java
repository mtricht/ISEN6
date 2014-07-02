package view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import properties.ReadProperties;
import startup.Screen;
import util.TouchButton;

public class PriceView extends AppView
{
	
	JButton one, two, three, four, five,
			six, seven, eight, nine, zero, comma, backspace, menu, betalen;
	String bedrag = "";
	JTextField bedragDisplay;
	ReadProperties readProperties = new ReadProperties();
	
	boolean active = true;
	public PriceView()
	{
		buttons = Arrays.asList(
				new TouchButton(new Point(0,160), ""),
				new TouchButton(new Point(0,199), ""),
				new TouchButton(new Point(40,160), "0"),
				new TouchButton(new Point(40,199), "6"),
			    new TouchButton(new Point(80,160),  "1"),
				new TouchButton(new Point(80,199), "7"),
				new TouchButton(new Point(120,160), "2"),
				new TouchButton(new Point(120,199), "8"),
				new TouchButton(new Point(160,160), "3"),
				new TouchButton(new Point(160,199), "9"),
				new TouchButton(new Point(200,160), "4"),
				new TouchButton(new Point(200,199), ","),
			    new TouchButton(new Point(240,160), "5"),
			    new TouchButton(new Point(240,199), "<"),
				new TouchButton(new Point(280,160), ""),
				new TouchButton(new Point(280,199), "Ok")
				
				
		);
		s = "Bedrag Invoeren";

	}
	public List<TouchButton> buttons;
	
	String s;
	public void render(Graphics2D g)
	{
		if(active){
			//Screen.appView = new derpview();
			g.setColor(Color.WHITE);
			for(TouchButton p : buttons)
			{
				g.setColor(Color.WHITE);
				g.fillRect(p.location.x, p.location.y, 40, 40);
				g.setColor(Color.BLUE);
				g.drawRect(p.location.x, p.location.y, 40, 40);
				g.setFont(new Font("Monospaced",Font.PLAIN,20));
				g.drawString(p.name, p.location.x+15, p.location.y+25);
			}
			
			g.setColor(Color.WHITE);
			g.drawString(bedrag, 100, 100);
			g.drawString(s, 90, 80);
			g.setColor(Color.BLUE);
		/*	
			g.drawString("0", 55, 185);
			g.drawString("1", 95, 185);
			g.drawString("2", 135, 185);
			g.drawString("3", 175, 185);
			g.drawString("4", 215, 185);
			g.drawString("5", 255, 185);
			g.drawString("6", 55, 225);
			g.drawString("7", 95, 225);
			g.drawString("8", 135, 225);
			g.drawString("9", 175, 225);
			g.drawString(",", 215, 225);
			g.drawString("Ok", 250, 225);
			//active = !active;
			 * 
			 */
		}
		
	}
	
	public void setBedrag(String bedrag)
	{
		this.bedrag = bedrag;
	}

}
	
	//public void gotoInstellingen()
	//{
		/*if(bedragDisplay.getText().equals( readProperties.getPropertiesPin()))
		{
			setVisible(false);
			new SettingsView();
		}*/
	 //}
	
	/*@Override
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
}*/
