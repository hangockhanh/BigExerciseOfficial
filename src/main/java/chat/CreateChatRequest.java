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

public class CreateChatRequest {
    public CreateChatClass createchat;
	public CreateChatRequest(String access_token, String URL, String random) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(URL + random);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + access_token);

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
            createchat = g.fromJson(content.toString(), CreateChatClass.class);
	    }finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return createchat.code;
	}
	public String getMessage(){
		return createchat.message;
	}
	public int getUser_receive_id(){
		return createchat.data.user_receive_id;
	}
    public int getUser_send_id(){
		return createchat.data.user_send_id;
	}
}
 