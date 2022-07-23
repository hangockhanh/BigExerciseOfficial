package like;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import lib.API;
public class TotalLikesRequest {
    public TotalLikesClass totallike;
	public TotalLikesRequest(String auction_id) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.totallikes + auction_id);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("GET");
	    
        StringBuilder content;
	    try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content = new StringBuilder();
            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
			System.out.println(content);
            Gson g = new Gson(); 
	        totallike = g.fromJson(content.toString(), TotalLikesClass.class);
	    }finally{
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return totallike.code;
	}
	public String getMessage(){
		return totallike.message;
	}
	public String getAuction_id(){
		return totallike.data.auction_id;
	}
	public String getTotal_liked(){
        return totallike.data.total_liked;
    }
}
