package rsa;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.spec.PKCS8EncodedKeySpec;

import javax.crypto.BadPaddingException;

import org.apache.commons.ssl.PKCS8Key;

import sun.misc.BASE64Decoder;

public class RSA {
	
	public static boolean isPassphrase(byte[] encryptedPrivateKey, char[] passphrase)
	{
		try {
			PKCS8Key pkcs8 = new PKCS8Key(encryptedPrivateKey, passphrase);
		} catch (BadPaddingException e) {
			// Means passphrase is wrong!
			return false;
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void loadPrivateKey(byte[] encryptedPrivateKey, char[] passphrase)
	{
		String privKey = "MIIBpjBABgkqhkiG9w0BBQ0wMzAbBgkqhkiG9w0BBQwwDgQI6c/Gyck+j7oCAggAMBQGCCqGSIb3DQMHBAjqwPpvKHFfqASCAWAOBLmTAD0LE4xfCvtnnVhv1DU2XHw3JGABiznBh/lpmnH0ffo1CNPb8YR/24nKr4isOj7SMnQG0/TMipXIFOupWIcXJrrzXn6QcZMxRA+gAIkSKFgXltM54tiFyzbxYHwb+20NnMX5bSJpFPZvAJOoTDxrvVGDpLV2K+xEqHavR1E/P7wCkX+J7yRAx193yiLfbFXMbvecEb5D7ywftS/jc8IwbgFOk7Jrqv92HILtDxZ3GX2TI90LuZE7gSdTGxVA0WpfEckxP/pVLyzOBUOW2M64XQBvhTV07Vr5ZWhRz60M+CnBNIUDqBhlJw/Chi/Gm7y4ac0nmJfiNxeQ7KXb1ANo/z2K6yKluR8P9dGWmsFw9RbFAIHmkksxVLfUjdVwUWMlIJMznJ5wrHGLBXmAKbowUeUzGB1SeixzGDZ/GX+42m450solDdiYKjtbXiNZgas1J4x9lKyeDYGloqhd";
		String pass = "8C53";
		passphrase = pass.toCharArray();
		BASE64Decoder decoder = new BASE64Decoder();
        try {
			encryptedPrivateKey = decoder.decodeBuffer(privKey);
		} catch (IOException e) {
			e.printStackTrace();
		}
        System.out.println(isPassphrase(encryptedPrivateKey, passphrase));
//        byte[] decrypted = pkcs8.getDecryptedBytes();
//	    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec( decrypted );
	}

}
