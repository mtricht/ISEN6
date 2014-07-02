package controller;

import java.awt.event.MouseEvent;

import util.TouchButton;
import view.AppView;
import view.PriceView;

public class PriceController extends AppController{

	PriceView priceView;
	public String bedrag = new String();
	public PriceController(AppView appView) {
		// TODO Auto-generated constructor stub
		priceView = (PriceView) appView;
	}

	public void mouseClicked(MouseEvent e) 
	{
		for(TouchButton tb : priceView.buttons)
		{
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
					
				}
			}
		}

	}
}