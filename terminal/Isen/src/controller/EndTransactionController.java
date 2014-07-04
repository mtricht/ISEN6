package controller;

import java.awt.event.MouseEvent;

import startup.Screen;
import util.TouchButton;
import view.AppView;
import view.EndTransactionView;
import view.PriceView;

public class EndTransactionController extends AppController{

	EndTransactionView endTransactionView;

	public EndTransactionController(AppView appView,String succeed)
	{
		endTransactionView = (EndTransactionView) appView;
		endTransactionView.setSucceed(succeed);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : endTransactionView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(tb.name.equals("Ok"))
					{
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						endTransactionView.active = false;
					}
					
				}
			}
		}
	}
}
