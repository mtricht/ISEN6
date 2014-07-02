package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import util.TouchButton;

public class PinView extends AppView
{
	public List<TouchButton> buttons;
	public boolean active = true;
	String pin = "";

	public PinView()
	{
		buttons = Arrays.asList( 
				new TouchButton(new Point(0,0),"<-"),
				new TouchButton(new Point(0,120),""),
				new TouchButton(new Point(0,160), ""),
				new TouchButton(new Point(0,199), ""),
				new TouchButton(new Point(40,120),"1"),
				new TouchButton(new Point(40,160), "7"),
				new TouchButton(new Point(40,199), "C"),
				new TouchButton(new Point(80,120),"2"),
			    new TouchButton(new Point(80,160),  "8"),
				new TouchButton(new Point(80,199), "D"),
				new TouchButton(new Point(120,120),"3"),
				new TouchButton(new Point(120,160), "9"),
				new TouchButton(new Point(120,199), "E"),
				new TouchButton(new Point(160,120),"4"),
				new TouchButton(new Point(160,160), "0"),
				new TouchButton(new Point(160,199), "F"),
				new TouchButton(new Point(200,120),"5"),
				new TouchButton(new Point(200,160), "A"),
				new TouchButton(new Point(200,199), ""),
				new TouchButton(new Point(240,120),"6"),
			    new TouchButton(new Point(240,160), "B"),
			    new TouchButton(new Point(240,199), "<"),
			    new TouchButton(new Point(280,120),""),
				new TouchButton(new Point(280,160), ""),
				new TouchButton(new Point(280,199), "Ok")
				
				
				
		);
	}
	public void render(Graphics2D g)
	{
		if(active){
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
			g.drawString("Pin:", 90, 80);
			g.setColor(Color.WHITE);
			
			String sicrit = "";
			for(int x=0; x<pin.length(); x++)
				sicrit += "X";
			g.drawString(sicrit, 150, 80);
			
	
			//active = !active;
			 
		}
	}
	
	public void setPin(String pin)
	{
		this.pin = pin;
	}
}
