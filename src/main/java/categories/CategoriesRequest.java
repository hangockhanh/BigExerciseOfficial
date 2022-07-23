package categories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.google.gson.Gson;

import lib.API;

public class CategoriesRequest {
    public CategoriesClass categories;
	public CategoriesRequest() throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.categories);
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
	        categories = g.fromJson(content.toString(), CategoriesClass.class);
	    }finally{
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return categories.code;
	}
	public String getMessage(){
		return categories.message;
	}
	int getNumberOfCate(){
		return categories.data.length;
	}
	int[] getCategories_id(){
		int[] array = new int[categories.data.length];
		for (int i = 0; i < categories.data.length; i++){
			array[i] = categories.data[i].category_id;
		}
		return array;
	}
	String[] getNames(){
		String[] names = new String[categories.data.length];
		for (int i = 0; i < categories.data.length; i++){
			names[i] = categories.data[i].name;
		}
		return names;
	}
}
