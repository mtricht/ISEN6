package util;

import java.io.IOException;
import java.security.PrivateKey;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import sun.misc.BASE64Decoder;

public class API {
	
	public static String sendRequest(String url, JSONObject json) { 
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		CloseableHttpResponse response = null;
		String responseBody = null;
		try {
		    HttpPost request = new HttpPost(url);
		    StringEntity params = new StringEntity(json.toString());
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    response = httpClient.execute(request);
		    responseBody = EntityUtils.toString(response.getEntity());
		    response.close();
			httpClient.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return responseBody;
	}
	
	public static void test()
	{
		// RSA stuff
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
		PrivateKey privateKey = RSA.getPrivateKey(encryptedPrivateKey, passphrase);
		
		// JSON stuff
		JSONObject data = new JSONObject();
		data.put("account_id", "33D5F90F9000");
		JSONObject json = new JSONObject();
		json.put("data", data);
		json.put("signature", RSA.signMessage(privateKey, data.toString()));
		System.out.println(sendRequest("http://localhost/server/api/v1/wallet/test", json));
	}

}
