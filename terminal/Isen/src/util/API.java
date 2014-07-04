package util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

import startup.Screen;

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

	public static void makeTransaction(String to, String from,
			String bedrag) {
		// JSON object
		JSONObject data = new JSONObject();
		data.put("account_id", "1");
		data.put("amount", Float.parseFloat("0.00000000000000000001"));
		data.put("receiving_address", to);
		JSONObject json = new JSONObject();
		json.put("data", data);
		json.put("signature", RSA.signMessage(Screen.privateKey, data.toString()));
		// Send it.
		JSONObject response = new JSONObject(sendRequest("http://145.101.80.197/server/api/v1/wallet/movetransaction", json));
		System.out.println(response.get("transaction_id"));
	}

}
