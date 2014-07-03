package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.TouchButton;
import view.AcceptatieView;
import view.AppView;
import view.PriceView;
import view.VerifierenView;

public class AcceptatieController extends AppController{
	AcceptatieView acceptatieView;

	public AcceptatieController(AppView appView)
	{
		acceptatieView = (AcceptatieView) appView;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : acceptatieView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(tb.name.equals("Nee"))
					{
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						acceptatieView.active = false;
					}
					if(tb.name.equals("Ja"))
					{
						Screen.appView = new VerifierenView();
						Screen.appController = new VerifierenController(Screen.appView);
						acceptatieView.active = false; 
					}
					
				}
			}
	}
	}
}
