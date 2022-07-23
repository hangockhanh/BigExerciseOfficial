package brands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import com.google.gson.Gson;

import lib.API;

public class BrandsRequest {
    public BrandsClass brands;
	public BrandsRequest() throws MalformedURLException, ProtocolException, IOException {
	    URL url = new URL(API.brands);
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
	        brands = g.fromJson(content.toString(), BrandsClass.class);
	    }finally{
	        connection.disconnect();
	    }
	}   
	public int getCode(){
		return brands.code;
	}
	public String getMessage(){
		return brands.message;
	}
	int getNumberOfBrands(){
		return brands.data.brand.length;
	}
	int[] getBrands_id(){
		int[] array = new int[brands.data.brand.length];
		for (int i = 0; i < brands.data.brand.length; i++){
			array[i] = brands.data.brand[i].brand_id;
		}
		return array;
	}
	String[] getNames(){
		String[] names = new String[brands.data.brand.length];
		for (int i = 0; i < brands.data.brand.length; i++){
			names[i] =  brands.data.brand[i].name;
		}
		return names;
	}
}
