package util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

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
		JSONObject data = new JSONObject();
		data.put("account_id", "12");
		JSONObject json = new JSONObject();
		json.put("data", data); 
		json.put("signature", "");
		System.out.println(sendRequest("http://localhost/server/api/v1/wallet/test", json));
	}

}
