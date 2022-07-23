package auction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import com.google.gson.Gson;
import lib.API;
import com.google.gson.JsonSyntaxException;


public class DeleteAuction {
    public static DeleteAuctionClass rp;
    private static HttpURLConnection connection;

    public DeleteAuction(int auctionId,String token) throws  IOException{

        StringBuilder requestContent = new StringBuilder();

        URL url = new URL(API.base+"comments/delete/"+auctionId);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Bearer" + token);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                requestContent.append(line);

            }
            System.out.println(requestContent);

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(requestContent.toString(), DeleteAuctionClass.class);
            in.close();
        }
        finally {
            connection.disconnect();
        }

    }
    public int getCode(){
        return rp.code;
    }
    public String getMessage(){
        return rp.message;
    }
    public Data2 getData(){
        return rp.data;
    }

}