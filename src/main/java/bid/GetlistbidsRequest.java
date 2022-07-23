package bid;

import java.io.BufferedReader;
//import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;

import com.google.gson.Gson;
import lib.API;

public class GetlistbidsRequest {
    public GetlistbidsClass getlistbids;
	public GetlistbidsRequest(int index, int count, String access_token, int auctionId) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.getlistbids+ auctionId+ "?index=" + index + "&count=" + count);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" +access_token);
	    try{

	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                //content.append(System.lineSeparator());
	            }
	        }
	         System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        getlistbids = g.fromJson(content.toString(), GetlistbidsClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return getlistbids.code;
	}
	public String getMessage(){
		return getlistbids.message;
	}
	public Data1 getData(){
		return getlistbids.data;
	}


}
