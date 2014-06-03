/**
 *
 * @author Michael
 */

import java.applet.*;
import java.awt.Button;
import java.awt.event.*;

public class RfidTool extends Applet implements ActionListener {
    
    private Button writeButton;
    
    public void init() {
        writeButton = new Button("Write key to RFID tag.");
        add(writeButton);
        writeButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

    }
    
}
