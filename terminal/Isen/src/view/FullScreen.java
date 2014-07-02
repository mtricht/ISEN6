package view;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FullScreen {
	GraphicsDevice vc;
	
	public FullScreen()
	{
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc=ge.getDefaultScreenDevice();
	}
	
	public void setFullScreen(DisplayMode dm, JFrame win){
		
		//Remove the Title Bar, Maximization , Minimization Button...
		win.setUndecorated(true); 
		
		// Can not be resized
		win.setResizable(false);
		
		//Make the win(JFrame) Full Screen
		vc.setFullScreenWindow(win);		
		
		 //check low-level display changes are supported for this graphics device.
		if(dm!=null && vc.isDisplayChangeSupported()){
				try{
						vc.setDisplayMode(dm);
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
		}
		}	
}
