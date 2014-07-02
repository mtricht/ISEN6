package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.TouchButton;
import view.AppView;
import view.PasView;
import view.PinView;
import view.PriceView;

public class PasController extends AppController{
	
	PasView pasView;
	public PasController(AppView appView)
	{
		pasView = (PasView) appView;
	}
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : pasView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(tb.name.equals("Ok"))
					{
						Screen.appView = new PinView();
						Screen.appController = new PinController(Screen.appView);
						pasView.active = false;
					}
					if(tb.name.equals("<-"))
					{
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						pasView.active=false; 
					}
					
				}
			}
	}
	}
}
