package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import util.TouchButton;

public class InstellingenView extends AppView{

	public boolean active = true;
	public void render(Graphics2D g)
	{
		if(active)
		{
			g.setFont(new Font("Monospaced",Font.PLAIN,20));
			g.setColor(Color.WHITE);
			g.drawString("Scan Pas...", 100,100);
		}
	}
}
