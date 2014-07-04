package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.TouchButton;
import view.AppView;
import view.PasView;
import view.PriceView;

public class PriceController extends AppController {

	PriceView priceView;
	public String bedrag = new String();
	
	public PriceController(AppView appView)
	{
		priceView = (PriceView) appView;
	}

	public void mouseClicked(MouseEvent e) 
	{
		for(TouchButton tb : priceView.buttons)
		{
			if(tb.name.equals(",") && bedrag.length() == 0)
				return;
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(!tb.name.equals("Ok") && !tb.name.equals("<")){
						bedrag += tb.name;
						priceView.setBedrag(bedrag);
					}
					if(tb.name.equals("<") && !bedrag.equals(""))
					{
						bedrag = bedrag.substring(0, bedrag.length() -1);
						priceView.setBedrag(bedrag);
					}
					if(tb.name.equals("Ok"))
					{
						Screen.appView = new PasView();
						Screen.appController = new PasController(Screen.appView);
						Screen.bedrag = bedrag;
						priceView.active = false;
					}
				}
			}
		}
	}
}