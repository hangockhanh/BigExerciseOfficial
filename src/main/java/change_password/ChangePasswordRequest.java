package change_password;

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

public class ChangePasswordRequest {
    public ChangePasswordClass change_password;
	public ChangePasswordRequest(String access_token, String old_pass, String new_pass, String re_pass) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.change_password);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Authorization", "Bearer" + access_token);
	    Map<String, String> params = new HashMap<>();
	    params.put("old_pass", old_pass);
	    params.put("new_pass", new_pass);
	    params.put("re_pass", re_pass);


	    StringBuilder postData = new StringBuilder();
	    for (Map.Entry<String, String> param : params.entrySet()) {
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
	        change_password = g.fromJson(content.toString(), ChangePasswordClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return change_password.code;
	}
	public String getMessage(){
		return change_password.message;
	}
}
