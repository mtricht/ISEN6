/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rfidadapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *
 * @author Michael
 */
public class ACR122UA9Adapter extends RfidAdapter {

    public byte[] getSerialNumber() {
        return new byte[]{(byte) 0xFF, (byte) 0xCA, (byte) 0x00,
            (byte) 0x00, (byte) 0x04};
    }

    public byte[] loadAuthenticationKey() {
        return new byte[]{(byte) 0xFF, (byte) 0x82, (byte) 0x00,
            (byte) 0x00, (byte) 0x06, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
            (byte) 0xFF, (byte) 0xFF };
    }

    public byte[] authenticateBlock(byte block) {
        return new byte[]{(byte) 0xFF, (byte) 0x86, (byte) 0x00,
            (byte) 0x00, (byte) 0x05, (byte) 0x01,
            (byte) 0x00, block, (byte) 0x60,
            (byte) 0x00};
    }

    public byte[] writeBlock(byte block, byte[] message) {
        byte[] prefix = new byte[]{(byte) 0xFF, (byte) 0xD6, (byte) 0x00,
            block, (byte) 0x16};
        // Merge byte[] prefix and byte[] message
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
        try {
            outputStream.write(prefix);
            outputStream.write(message);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return (byte[]) outputStream.toByteArray();
    }
    
    public byte[] readBlock(byte block) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
