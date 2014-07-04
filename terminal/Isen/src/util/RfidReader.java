package util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.smartcardio.TerminalFactory;

import rfidadapter.ACR122UA9Adapter;
import rfidadapter.RfidAdapter;
import controller.PasController;

public class RfidReader extends Thread {
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static byte[] privateKey;
	public static String accountId;
	public static boolean done = false;
	public RfidAdapter rfidAdapter;
	private PasController pasController;
	
	public void run() {
		rfidAdapter = new ACR122UA9Adapter();
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
                ex.printStackTrace();
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
            terminal.waitForCardPresent(0);
            try {
                Card card = terminal.connect("*");
                CardChannel channel = card.getBasicChannel();
                // Get UUID.
                command = new CommandAPDU(rfidAdapter.getSerialNumber());
                response = channel.transmit(command);
                byteArray = response.getBytes();
                accountId = ( bytesToHex( byteArray ) );

                // How many blocks do we need?
                command = new CommandAPDU(rfidAdapter.authenticateBlock((byte) 1));
            	response = channel.transmit(command);
            	byteArray = response.getBytes();
                command = new CommandAPDU(rfidAdapter.readBlock((byte) 1));
                response = channel.transmit(command);
                byteArray = response.getBytes();
                byte[] number = new byte[]{byteArray[0], byteArray[1], byteArray[2], byteArray[3]};
                int blocksToRead = ByteBuffer.wrap(number).order(ByteOrder.BIG_ENDIAN).getInt();

                // Read private key.
                byte[] message = null;
                int currentBlock = 2;
                for (int i = 0; i < blocksToRead; i++) {
                	// Every 4 blocks is a trail block and we should NOT write it and thus skip it.
                	if (((currentBlock + 1) % 4) == 0)
                		currentBlock++;
                	// Authenticate
                	command = new CommandAPDU(rfidAdapter.authenticateBlock((byte) currentBlock));
                	channel.transmit(command);
                	// Read block
                	command = new CommandAPDU(rfidAdapter.readBlock((byte) currentBlock));
                	response = channel.transmit(command);
                	byteArray = Arrays.copyOfRange(response.getBytes(), 0, 16);
                	if (message == null) {
                		message = byteArray;
                	} else {
                		// Merge byte arrays.
	                	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                    try {
	                        outputStream.write(message);
	                        outputStream.write(byteArray);
	                    } catch (IOException ex) {
	                        System.out.println(ex);
	                    }
	                    message = (byte[]) outputStream.toByteArray();
                	}
                	currentBlock++;
                }
                privateKey = message;
                break;
            } catch (CardException|ArrayIndexOutOfBoundsException ex) {
                ex.printStackTrace();
            }
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        pasController.done();
    }
    
    public String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        int v;
        for ( int j = 0; j < bytes.length; j++ ) {
            v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

	public void setController(PasController pasController)
	{
		this.pasController = pasController;
	}
}