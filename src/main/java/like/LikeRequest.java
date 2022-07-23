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

public class LikeRequest {
    public LikeClass like;
	public LikeRequest(String random, String token) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.like + random);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
		connection.setRequestProperty("Authorization", "Bearer" + token);

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
            like = g.fromJson(content.toString(), LikeClass.class);
	    }finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return like.code;
	}
	public String getMessage(){
		return like.message;
	}
	public int getUser_id(){
		return like.data.user_id;
	}
    public String getAuction_id(){
        return like.data.auction_id;
    }
    public boolean getLikeStatus(){
		return like.data.is_liked;
	} 
}
