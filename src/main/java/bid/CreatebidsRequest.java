package bid;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import lib.API;

public class CreatebidsRequest {
    public CreatebidsClass createbids;
	public CreatebidsRequest(int price, int bid_last_id, String access_token, int auction_id) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.createbid + auction_id);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + access_token);
	    Map<String, Integer> params = new HashMap<>();
	    params.put("price", price);
	    params.put("bid_last_id", bid_last_id);

	    StringBuilder postData = new StringBuilder();
	    for (Map.Entry<String, Integer> param : params.entrySet()) {
	        if (postData.length() != 0) {
	            postData.append('&');
	        }
	        postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	        postData.append('=');
	        postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
	    }

	    byte[] postDataBytes = postData.toString().getBytes("UTF-8");
	    connection.setDoOutput(true);
	    try (DataOutputStream writer = new DataOutputStream(connection.getOutputStream())) {
	        writer.write(postDataBytes);
	        writer.flush();
	        writer.close();

	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	         System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        createbids = g.fromJson(content.toString(), CreatebidsClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return createbids.code;
	}
	public String getMessage(){
		return createbids.message;
	}
	public Data getData(){
		return createbids.data;
	}
}




