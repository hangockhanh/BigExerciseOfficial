package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import lib.API;

public class ChatRequest {
    public ChatClass chat;
	public ChatRequest(String access_token) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.chat);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" + access_token);

        StringBuilder content;

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            content = new StringBuilder();
            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            Gson g = new Gson(); 
            chat = g.fromJson(content.toString(), ChatClass.class);
	    }finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return chat.code;
	}
	public String getMessage(){
		return chat.message;
	}
}
