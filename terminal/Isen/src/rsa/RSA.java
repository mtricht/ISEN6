package rsa;

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

import sun.misc.BASE64Decoder;

public class RSA {
	
	public static boolean decryptPrivateKey(byte[] encryptedPrivateKey, char[] passphrase)
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
        // Nu echt.
		try {
			EncryptedPrivateKeyInfo ePKInfo = new EncryptedPrivateKeyInfo(encryptedPrivateKey);
	        Cipher cipher = Cipher.getInstance(ePKInfo.getAlgName());
	        PBEKeySpec pbeKeySpec = new PBEKeySpec(passphrase);
	        // Now create the Key from the PBEKeySpec
	        SecretKeyFactory skFac = SecretKeyFactory.getInstance(ePKInfo
	                .getAlgName());
	        Key pbeKey = skFac.generateSecret(pbeKeySpec);
	        // Extract the iteration count and the salt
	        AlgorithmParameters algParams = ePKInfo.getAlgParameters();
	        cipher.init(Cipher.DECRYPT_MODE, pbeKey, algParams);
	        // Decrypt the encryped private key into a PKCS8EncodedKeySpec
	        KeySpec pkcs8KeySpec = ePKInfo.getKeySpec(cipher);
	        // Now retrieve the RSA Public and private keys by using an
	        // RSA keyfactory.
	        KeyFactory rsaKeyFac = KeyFactory.getInstance("RSA");
	        // First get the private key
	        RSAPrivateCrtKey rsaPriv = (RSAPrivateCrtKey) rsaKeyFac.generatePrivate(pkcs8KeySpec);
	        // Now derive the RSA public key from the private key
	        RSAPublicKeySpec rsaPubKeySpec = new RSAPublicKeySpec(rsaPriv.getModulus(), rsaPriv.getPublicExponent());
	        RSAPublicKey rsaPubKey = (RSAPublicKey) rsaKeyFac.generatePublic(rsaPubKeySpec);
		} catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException | InvalidKeyException | InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}

}
