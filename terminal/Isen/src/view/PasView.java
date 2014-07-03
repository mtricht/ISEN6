package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import util.TouchButton;

public class PasView extends AppView{

	public List<TouchButton> buttons;
	public boolean active = true;
	
	public PasView()
	{
		buttons = Arrays.asList( 
			new TouchButton(new Point(0,0),"<-")
		);
	}
	
	public void render(Graphics2D g)
	{
		if(active)
		{
			for(TouchButton p : buttons)
			{
				g.setColor(Color.WHITE);
				g.fillRect(p.location.x, p.location.y, 40, 40);
				g.setColor(Color.BLUE);
				g.drawRect(p.location.x, p.location.y, 40, 40);
				g.setFont(new Font("Monospaced",Font.PLAIN,20));
				g.drawString(p.name, p.location.x+15, p.location.y+25);
			}
			
			g.drawString("Scan Pas...", 100,100);
		}
	}
}
