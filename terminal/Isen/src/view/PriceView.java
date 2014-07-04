package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import util.TouchButton;

public class PriceView extends AppView
{
	
	String bedrag = "";
	public List<TouchButton> buttons;
	String s;
	
	public boolean active = true;
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
	
			//active = !active;
			 
		}
		
	}
	
	public void setBedrag(String bedrag)
	{
		this.bedrag = bedrag;
	}

}
	

