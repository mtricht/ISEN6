package controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import rfidadapter.RfidReader;
import rsa.RSA;
import startup.Screen;
import util.TouchButton;
import view.AcceptatieView;
import view.AppView;
import view.PinView;
import view.PriceView;

public class PinController extends AppController{

	PinView pinView;
	public String pin = new String();
	
	public PinController(AppView appView)
	{
		pinView = (PinView) appView;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(TouchButton tb : pinView.buttons)
		{
			if(!tb.name.equals("") && e.getX() > tb.location.x && e.getX() < tb.location.x + tb.xSize )
			{
				if(e.getY() > tb.location.y && e.getY() < tb.location.y + tb.ySize){
					if(!tb.name.equals("Ok") && !tb.name.equals("<")){
						pin += tb.name;
						pinView.setPin(pin);
					}
					if(tb.name.equals("<") && !pin.equals(""))
					{
						pin = pin.substring(0, pin.length() -1);
						pinView.setPin(pin);
					}
					if(tb.name.equals("Ok"))
					{
						if (checkPin()) {
							Screen.appView = new AcceptatieView();
							Screen.appController = new AcceptatieController(Screen.appView);
							pinView.active = false;
						} else {
							// TODO: Error weergeven ergens.
						}
					}
					if(tb.name.equals("<-"))
					{
						Screen.appView = new PriceView();
						Screen.appController = new PriceController(Screen.appView);
						pinView.active = false; 
					}
				}
			}
		}
	}

	private boolean checkPin()
	{	
		RSA.loadPrivateKey(RfidReader.privateKey, pin.toCharArray());
		return false;
	}
}
