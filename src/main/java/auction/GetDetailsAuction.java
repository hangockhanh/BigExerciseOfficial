package auction;
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
public class GetDetailsAuction  {
        public GetDetailsAuctionClass getDetailsAuction;
        public GetDetailsAuction(int statusId, String token) 
        throws MalformedURLException, ProtocolException, IOException {
    
            
                URL url = new URL(API.base + "auctions/" +"detail/"
            	    + statusId 
            		);    
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Authorization", "Bearer"+token);
            try{
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
                System.out.println(content.toString());
                
                Gson g = new Gson(); 
                getDetailsAuction = g.fromJson(content.toString(), GetDetailsAuctionClass.class);
            } finally {
                connection.disconnect();
            }
        }   
        public int getCode(){
            return getDetailsAuction.code;
        }
        public String getMessage(){
            return getDetailsAuction.message;
        }
        public Data4 getData(){
            return getDetailsAuction.data;
        }
    }    

