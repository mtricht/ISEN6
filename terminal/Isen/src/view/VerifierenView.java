package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;

import util.TouchButton;

public class VerifierenView extends AppView {
	
	public List<TouchButton> buttons;
	public boolean active = true;
	public boolean done = false;
	public boolean succesful = false;

	public VerifierenView()
	{
		buttons = Arrays.asList( 
				new TouchButton(new Point(0,0),"Ok"));
		
	}

	public void render(Graphics2D g)
	{
		if(active){
			g.setColor(Color.WHITE);
			if (done) {
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
				g.drawString("Succesvol overgemaakt.", 80, 100);
			} else {
				g.setColor(Color.WHITE);
				g.drawString("Verifieren...", 80, 100);
			}
		}
	}
}
