/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RfidReader;

/**
 *
 * @author Michael
 */
public class ACR122UA9Reader extends RfidReader {

    public byte[] getSerialNumber() {
        return new byte[]{(byte)0xFF,(byte)0xCA,(byte)0x00,(byte)0x00,(byte)0x04};
    }

    public byte[] getCardContent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public byte[] setCardContent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
