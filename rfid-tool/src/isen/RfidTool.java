package isen;

/**
 *
 * @author Michael
 */

import RfidReader.*;
import java.applet.*;
import java.awt.Button;
import java.awt.event.*;

public class RfidTool extends Applet implements ActionListener {
    
    private RfidReader rfidReader;
    
    private Button writeButton;
    
    public void init() {
        // We'll be using the ACR122U-A9 NFC USB Reader for this project.
        rfidReader = new ACR122UA9Reader();
        
        writeButton = new Button("Write key to RFID tag.");
        add(writeButton);
        writeButton.addActionListener(this); 
    }

    public void actionPerformed(ActionEvent e) {

    }
    
}
