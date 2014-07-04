package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import startup.Screen;
import util.TouchButton;

public class AcceptatieView extends AppView{

	public List<TouchButton> buttons;
	public boolean active = true;
	
	public AcceptatieView()
	{
		buttons = Arrays.asList( 
				new TouchButton(new Point(0, 199),"Nee"),
				new TouchButton(new Point(160, 199),"Ja")
				);
		for (TouchButton b: buttons) {
			b.xSize = 160;
		}
	}
	
	public void render(Graphics2D g)
	{
		if(active){
			g.setColor(Color.WHITE);
			for(TouchButton p : buttons)
			{
				g.setColor(Color.WHITE);
				g.fillRect(p.location.x, p.location.y, 160, 40);
				g.setColor(Color.BLUE);
				g.drawRect(p.location.x, p.location.y, 160, 40);
				g.setFont(new Font("Monospaced",Font.PLAIN,20));
				g.drawString(p.name, p.location.x+15, p.location.y+25);
			}
			
			g.setColor(Color.WHITE);
			g.drawString(Screen.bedrag, 80, 80);
			g.drawString("BTC Akkoord?", 80, 120);
			
		}
	}
}
