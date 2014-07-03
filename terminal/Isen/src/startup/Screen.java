package startup;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferStrategy;

import view.AppView;
import view.PriceView;
import controller.AppController;
import controller.PriceController;

public class Screen extends Canvas implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener {

	
	public static final int 	SCREEN_WIDTH = 320;
	public static final int 	SCREEN_HEIGHT = 240;
	public static String bedrag;
	
	private int 				fps;
	private int					counter;
	private long 				msStart;


	public Screen()
	{
		setIgnoreRepaint(true);
		setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setMinimumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setMaximumSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		setBackground(Color.black);
		setFocusable(true);
		requestFocus();
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
	}
	public static AppView appView;
	public static AppController appController;
	public void start()
	{
		Thread thread = new Thread(this);
		thread.start();
		
		appView = new PriceView();
		appController = new PriceController(appView);
	}

	public void update()
	{
		if(msStart == 0)
			msStart = System.currentTimeMillis();

		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(2);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		render(g);
		g.dispose();
		bs.show();

		counter++;
		if(System.currentTimeMillis() - msStart >= 1000){
			msStart = 0;
			fps = counter;
			counter = 0;
		}
	}

	private void render(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,  0, SCREEN_WIDTH, SCREEN_HEIGHT);
		appView.render(g);
		//level.render(g);


			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(fps), SCREEN_WIDTH-20, 10);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				//Thread.sleep is niet zo betrouwbaar maar dat maakt in early stages nog niet zo veel uit
				Thread.sleep(1000/60);
			}
			catch(InterruptedException e) {}

			//Altijd logic voor renders doen
			update();



			//** Heb dit helemaal gecomment
			//if(input.getKeyPressed()) handleInput();
			//if(input.getKeyReleased()) interruptInput();
			//input.clear();
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		appController.mouseClicked(e);
	}

}
