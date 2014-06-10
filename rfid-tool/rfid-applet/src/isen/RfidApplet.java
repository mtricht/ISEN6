/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package isen;

import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import rfidadapter.ACR122UA9Adapter;
import rfidadapter.RfidAdapter;

/**
 *
 * @author Michael
 */
public class RfidApplet extends Applet implements ActionListener {
    
	private static final long serialVersionUID = 3340283239215528889L;
	protected Button statusButton;
	protected RfidAdapter rfidAdapter;
	private RfidTool rfidTool;

   public void init() {
		// We'll be using the ACR122U-A9 NFC USB Reader for this project.
		rfidAdapter = new ACR122UA9Adapter();
		rfidTool = new RfidTool(this);
		
		// The button that will hold the text.
		statusButton = new Button("Waiting for RFID terminal.");
		statusButton.setEnabled(false);
		add(statusButton);
		statusButton.addActionListener(this);
		if (this.getParameter("key") == null) {
			statusButton.setLabel("Missing key parameter.");
		}
    }
    
    public void start() {
        // Start listening to a potential RFID terminal.
        if (this.getParameter("key") != null) {
            rfidTool.start();
        }
    }
    
    public void actionPerformed(ActionEvent e) {
        // Button press.
        if(e.getSource() == statusButton) {
            rfidTool.write = true;
        }
    }

    public void done(String uuid) {
    	try {
    		getAppletContext().showDocument(new URL("http://www.google.com/?uuid=" + uuid));
	   }
	   catch (MalformedURLException ex) {
	    	ex.getMessage();
	   }
    }
    
}
