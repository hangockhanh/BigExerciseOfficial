package auction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import lib.API;



public class InfoAuction {
    public static InfoAuctionClass rp;
    private static HttpURLConnection connection;
    public InfoAuction(int auctionId,String token) throws  IOException{

        StringBuilder content = new StringBuilder();

        URL url = new URL(API.base+"auctions/info/"+ auctionId);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            System.out.println(content);
            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(content.toString(), InfoAuctionClass.class);

            in.close();
        } finally {
            connection.disconnect();
        }

    }
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }
    public Data6 getData(){
        return rp.data;
    }

}