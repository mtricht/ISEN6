package isen;

/**
 *
 * @author Michael
 */

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.smartcardio.*;

import sun.misc.BASE64Decoder;

import com.sun.xml.internal.messaging.saaj.util.Base64;

public class RfidTool extends Thread {
    
    final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
    private RfidApplet rfidApplet;
    protected boolean write;
    
    public RfidTool(RfidApplet rfidApplet) {
       this.rfidApplet = rfidApplet;
    }
    
    public void run() {
        while(true) {
            try {
                TerminalFactory factory = TerminalFactory.getInstance("PC/SC", null);
                List<CardTerminal> terminals = factory.terminals().list();
                if (terminals.isEmpty()) {
                    // Wait 1 second.
                    Thread.sleep(1000);
                } else {
                    // Assume there's only one NFC/RFID reader.
                    CardTerminal terminal = terminals.get(0);
                    this.listenCard(terminal);
                    break;
                }
            } catch (NoSuchAlgorithmException|CardException|InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
    
    public void listenCard(CardTerminal terminal) throws CardException {
        // Keep looping looking for cards until the application is closed
        CommandAPDU command;
        ResponseAPDU response;
        byte[] byteArray;
        while(true)
        {
            rfidApplet.statusButton.setLabel("Waiting for a card.");
            rfidApplet.statusButton.setEnabled(false);
            terminal.waitForCardPresent( 0 );
            try {
                Card card = terminal.connect("*");
                CardChannel channel = card.getBasicChannel();
                
                // We can now write to the card.
                if (!rfidApplet.statusButton.getLabel().equals("Write to card.")) {
                    rfidApplet.statusButton.setLabel("Write to card.");
                    rfidApplet.statusButton.setEnabled(true);
                }
                
                // Write as soon as we're told to!
                if (write) {
                    // Store the UUID so we know to what card we wrote the private key to.
                    command = new CommandAPDU(rfidApplet.rfidAdapter.getSerialNumber());
                    response = channel.transmit(command);
                    byteArray = response.getBytes();
                    String uuid = ( bytesToHex( byteArray ) );
                    
                    // Load the authentication key to 0x00.
                    command = new CommandAPDU(rfidApplet.rfidAdapter.loadAuthenticationKey());
                    channel.transmit(command);
                    
                    // See how many blocks we need to use.
                    BASE64Decoder decoder = new BASE64Decoder();
                    byte[] key = decoder.decodeBuffer(rfidApplet.getParameter("key"));
                    int blocksNeeded = (int) key.length/16;
                    if ((key.length % 16) > 0)
                    	blocksNeeded += 1;

                    // Write the key away.
                    for (int i = 0; i < blocksNeeded; i++) {
                    	byte[] message = new byte[16];
                    	int y = 0;
                    	for (int x = (i * 16); x < ((i * 16) + 16); x++) {
                    		if (x >= key.length) {
                    			message[y] = (byte) 0x00;
                    		} else {
                    			message[y] = key[x];
                    		}
                    		y++;
                    	}
                    	command = new CommandAPDU(rfidApplet.rfidAdapter.writeBlock((byte) i, message));
                    	channel.transmit(command);
                    }
                    
                    // We're done!
                    rfidApplet.done(uuid);
                    break;
                }
                
                Thread.sleep(1000);
            } catch (CardException|InterruptedException|IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
    
}
