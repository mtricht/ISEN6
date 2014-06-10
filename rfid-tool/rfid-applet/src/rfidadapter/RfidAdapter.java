package rfidadapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public abstract class RfidAdapter {
    
    public abstract byte[] getSerialNumber();
    public abstract byte[] loadAuthenticationKey();
    public abstract byte[] authenticateBlock(byte block);
    public abstract byte[] writeBlock(byte block, byte[] message);
    public abstract byte[] readBlock(byte block);
    
}
