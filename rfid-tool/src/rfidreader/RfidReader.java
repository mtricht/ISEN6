package rfidreader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public abstract class RfidReader {
    
    public abstract byte[] getSerialNumber();
    public abstract byte[] getCardContent();
    public abstract byte[] setCardContent();
    
}
