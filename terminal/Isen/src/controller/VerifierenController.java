package controller;


import java.awt.event.MouseEvent;

import startup.Screen;
import util.TouchButton;
import view.AppView;
import view.EndTransactionView;
import view.VerifierenView;

public class VerifierenController extends AppController{

	VerifierenView verifierenView;
	
	public VerifierenController(AppView appView)
	{
		verifierenView = (VerifierenView) appView;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : verifierenView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(tb.name.equals("Ok"))
					{
						Screen.appView = new EndTransactionView();
						Screen.appController = new EndTransactionController(Screen.appView,"false");
						verifierenView.active = false;
					}
					
					
				}
			}
	}
	}
}
