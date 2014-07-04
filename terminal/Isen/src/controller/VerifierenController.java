package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.API;
import util.RfidReader;
import util.TouchButton;
import view.AppView;
import view.PriceView;
import view.VerifierenView;

public class VerifierenController extends AppController{

	VerifierenView verifierenView;
	
	public VerifierenController(AppView appView)
	{
		verifierenView = (VerifierenView) appView;
		// Start talking to the server.
		String to = Screen.readProperties.getProperty("account");
		if (to.equals("")) {
			verifierenView.done = true;
		} else {
			API.makeTransaction(to, RfidReader.accountId, Screen.bedrag);
		}
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
						// Reset stuff.
						Screen.privateKey = null;
						Screen.bedrag = null;
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						verifierenView.active = false;
					}
				}
			}
		}
	}
}
