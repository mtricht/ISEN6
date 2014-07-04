package util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;

public class RSA {
	
	public static boolean isPassphrase(byte[] encryptedPrivateKey, char[] passphrase)
	{
		try {
			@SuppressWarnings("unused")
			PKCS8Key pkcs8 = new PKCS8Key(encryptedPrivateKey, passphrase);
		} catch (BadPaddingException e) {
			// Means passphrase is wrong!
			return false;
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	@SuppressWarnings("unused")
	public static PrivateKey getPrivateKey(byte[] encryptedPrivateKey, char[] passphrase)
	{
		try {
			PKCS8Key pkcs8 = new PKCS8Key(encryptedPrivateKey, passphrase);
			byte[] decrypted = pkcs8.getDecryptedBytes();
		    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec( decrypted );
		    return pkcs8.getPrivateKey();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String signMessage(PrivateKey privateKey, String message)
	{
		try {
			Signature signal = Signature.getInstance("SHA1withRSA");
			signal.initSign(privateKey);
			
			// Encrypt with SHA1
			MessageDigest cript = MessageDigest.getInstance("SHA-1");
			cript.update(message.getBytes("utf8"));
			
			byte[] messageArray = cript.digest();
			
			signal.update(messageArray);

			return base64Encode(new String(signal.sign()));
		} catch (InvalidKeyException|NoSuchAlgorithmException|SignatureException|UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "Error.";
	}
	
	public static String decryptMessage(PrivateKey privateKey, String encrypted)
	{
		try {
	        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			return new String(cipher.doFinal(encrypted.getBytes()));    
		} catch (InvalidKeyException|NoSuchAlgorithmException|NoSuchProviderException|
				NoSuchPaddingException|IllegalBlockSizeException|BadPaddingException e) {
			e.printStackTrace();
		} 
		return "Error.";
	}
	
	public static String base64Decode(String encoded)
	{
		String response = null;
		try {
			response = new String(Base64.decodeBase64(encoded), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	public static String base64Encode(String message)
	{
		String response = null;
		try {
			response = new String(Base64.encodeBase64(message.getBytes()), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return response;
	}

}
