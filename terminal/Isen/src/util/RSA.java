package util;

import java.io.IOException;
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

import sun.misc.BASE64Decoder;

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
	
	public static void test()
	{
		String privKey = "MIIBpjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQI6c/Gyck+j7oCAggAMBQGCCqGSIb3DQMHBAjqwPpvKHFfqASCAWAOBLmTAD0LE4xfCvtnnVhv1DU2XHw3JGABiznBh/lpmnH0ffo1CNPb8YR/24nKr4isOj7SMnQG0/TMipXIFOupWIcXJrrzXn6QcZMxRA+gAIkSKFgXltM54tiFyzbxYHwb+20NnMX5bSJpFPZvAJOoTDxrvVGDpLV2K+xEqHavR1E/P7wCkX+J7yRAx193yiLfbFXMbvecEb5D7ywftS/jc8IwbgFOk7Jrqv92HILtDxZ3GX2TI90LuZE7gSdTGxVA0WpfEckxP/pVLyzOBUOW2M64XQBvhTV07Vr5ZWhRz60M+CnBNIUDqBhlJw/Chi/Gm7y4ac0nmJfiNxeQ7KXb1ANo/z2K6yKluR8P9dGWmsFw9RbFAIHmkksxVLfUjdVwUWMlIJMznJ5wrHGLBXmAKbowUeUzGB1SeixzGDZ/GX+42m450solDdiYKjtbXiNZgas1J4x9lKyeDYGloqhd";
		String pass = "8C53";
		char[] passphrase = pass.toCharArray();
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] encryptedPrivateKey = null;
        try {
			encryptedPrivateKey = decoder.decodeBuffer(privKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(signMessage(getPrivateKey(encryptedPrivateKey, passphrase), "Test"));
        System.out.println(isPassphrase(encryptedPrivateKey, passphrase));
	}

}
