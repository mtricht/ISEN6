package util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

public class API {
	
	public static String sendRequest(String url, JSONObject json) { 
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
		    HttpPost request = new HttpPost(url);
		    StringEntity params = new StringEntity(json.toString());
		    request.addHeader("content-type", "application/x-www-form-urlencoded");
		    request.setEntity(params);
		    CloseableHttpResponse response = httpClient.execute(request);
		    // Handle response JSON here and return state.
		    response.getEntity();
		    response.close();
			httpClient.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
	
	public void test()
	{
		JSONObject json = new JSONObject();
		json.put("someKey", "someValue"); 
		sendRequest("http://localhost/server/api/v1/wallet/test/", json);
	}

}
