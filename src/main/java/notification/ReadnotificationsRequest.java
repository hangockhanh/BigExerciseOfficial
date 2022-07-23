package notification;

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

public class ReadnotificationsRequest {
    public static ReadnotificationsClass readnotifications;
	public static HttpURLConnection connection;
	public  ReadnotificationsRequest(int auctionDenyId, String access_token) throws MalformedURLException,ProtocolException, IOException {
		try{
	    URL url = new URL(API.readnotifications + auctionDenyId);
	    connection = (HttpURLConnection) url.openConnection();
	
	    connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" + access_token);

	        StringBuilder content;
	        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        String line;
	        content = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                //content.append(System.lineSeparator());
	            
	        }
	         System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        readnotifications = g.fromJson(content.toString(), ReadnotificationsClass.class);
			in.close();
	    } catch(Exception ex) {
			ex.printStackTrace();
		} finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return readnotifications.code;
	}
	public String getMessage(){
		return readnotifications.message;
    }

}
