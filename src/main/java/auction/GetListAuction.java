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
public class GetListAuction  {
        public GetListAuctionClass getListAuction;
        public GetListAuction(int statusId, String user_id,String type, String category_id, int index, int count, String token) 
        throws MalformedURLException, ProtocolException, IOException {
    
            
                URL url = new URL(API.base + "auctions/" 
            	    + statusId 
            		+ "?index=" + index 
            		+ "&count=" + count
            		+ "&user_id=" + user_id
            		+ "&type=" + type
            		+ "&category_id=" + category_id
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
                getListAuction = g.fromJson(content.toString(), GetListAuctionClass.class);
            } finally {
                connection.disconnect();
            }
        }   
        public int getCode(){
            return getListAuction.code;
        }
        public String getMessage(){
            return getListAuction.message;
        }
        public Data5 getData(){
            return getListAuction.data;
        }
    }    

