package signup;

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

public class SignUpRequest {
    public SignUpClass signup;
	public SignUpRequest(String email, String password, String re_pass, String address, String name, String phone, String avatar) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.signup);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    Map<String, String> params = new HashMap<>();
	    params.put("email", email);
	    params.put("password", password);
	    params.put("re_pass", re_pass);
        params.put("address", address);
        params.put("name", name);
        params.put("phone", phone);
        params.put("avatar", avatar);

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
	        signup = g.fromJson(content.toString(), SignUpClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return signup.code;
	}
	public String getMessage(){
		return signup.message;
	}
}

