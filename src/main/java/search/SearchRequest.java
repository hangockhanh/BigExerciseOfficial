package search;

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

//import javax.xml.transform.Templates;

import com.google.gson.Gson;
import lib.API;

public class SearchRequest {
    public SearchClass search;
	public SearchRequest(String access_token, String type, String key) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.search + "?type=" + type + "&key=" + key);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("GET");
		connection.setRequestProperty("Authorization", "Bearer" + access_token);
	    try {
	        StringBuilder content;

	        try (BufferedReader in = new BufferedReader(
	                new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content.append(line);
	                content.append(System.lineSeparator());
	            }
	        }
	        // System.out.println(content.toString());
	        
	        Gson g = new Gson(); 
	        search = g.fromJson(content.toString(), SearchClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return search.code;
	}
	public String getMessage(){
		return search.message;
	}
}
