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
import java.security.PrivateKey;

import properties.ReadProperties;
import view.AppView;
import view.PriceView;
import controller.AppController;
import controller.PriceController;

public class Screen extends Canvas implements Runnable, MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 4504764096520976728L;
	public static final int 	SCREEN_WIDTH = 320;
	public static final int 	SCREEN_HEIGHT = 240;
	public static String bedrag;
	public static ReadProperties readProperties;
	
	private int 				fps;
	private int					counter;
	private long 				msStart;
	
	public static AppView appView;
	public static AppController appController;
	public static PrivateKey privateKey;

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
	
	public void start()
	{
		Thread thread = new Thread(this);
		thread.start();
		
		readProperties = new ReadProperties();
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
		g.setColor(Color.WHITE);
		g.drawString(Integer.toString(fps), SCREEN_WIDTH - 20, 10);
	}

	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000/60);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			update();
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {
		appController.mouseClicked(e);
	}

}
