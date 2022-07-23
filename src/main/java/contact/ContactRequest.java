package contact;

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

public class ContactRequest {
    public ContactClass contact;
	public ContactRequest(String name, String phone, String email, String content, String report_type) throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.contact);
	    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

	    connection.setRequestMethod("POST");
	    Map<String, String> params = new HashMap<>();
	    params.put("email", email);
	    params.put("name", name);
        params.put("phone", phone);
        params.put("email", email);
        params.put("content", content);
        params.put("report_type", report_type);

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

	        StringBuilder content1;

	        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	        String line;
	        content1 = new StringBuilder();
	            while ((line = in.readLine()) != null) {
	                content1.append(line);
	                content1.append(System.lineSeparator());
	            }
	        }
			System.out.println(content1);
	        
	        Gson g = new Gson(); 
	        contact = g.fromJson(content1.toString(), ContactClass.class);
	    } finally {
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return contact.code;
	}
	public String getMessage(){
		return contact.message;
	}
    public String getName(){
        return contact.data.name;
    }
    public String getPhone(){
        return contact.data.phone;
    }
    public String getEmail(){
        return contact.data.email;
    }
    public String getContent(){
        return contact.data.content;
    }
    public String getRepor_type(){
        return contact.data.report_type;
    }
}
