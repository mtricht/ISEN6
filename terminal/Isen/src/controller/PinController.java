package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.RSA;
import util.RfidReader;
import util.TouchButton;
import view.AcceptatieView;
import view.AppView;
import view.PinView;
import view.PriceView;

public class PinController extends AppController{

	PinView pinView;
	public String pin = new String();
	
	public PinController(AppView appView)
	{
		pinView = (PinView) appView;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : pinView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(!tb.name.equals("Ok") && !tb.name.equals("<")){
						pin += tb.name;
						pinView.setPin(pin);
					}
					if(tb.name.equals("<") && !pin.equals(""))
					{
						pin = pin.substring(0, pin.length() -1);
						pinView.setPin(pin);
					}
					if(tb.name.equals("Ok"))
					{
						if (checkPin()) {
							Screen.appView = new AcceptatieView();
							Screen.appController = new AcceptatieController(Screen.appView);
							pinView.active = false;
						} else {
							if (pinView.getTries() == 1) {
								// This was our last change :(
								Screen.appView = new PriceView();
								Screen.appController = new PriceController(Screen.appView);
							} else {
								pinView.addTry();
								pin = "";
								pinView.setPin(pin);
							}
						}
					}
					if(tb.name.equals("<-"))
					{
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						pinView.active = false; 
					}
				}
			}
		}
	}

	private boolean checkPin()
	{	
		return RSA.isPassphrase(RfidReader.privateKey, pin.toCharArray());
	}
}
