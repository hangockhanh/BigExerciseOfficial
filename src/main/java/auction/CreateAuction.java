package  auction;
import com.google.gson.Gson;
import lib.API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class CreateAuction {
    private static HttpURLConnection connection;

    public static CreateAuctionClass rp;
    int rpCode;

    public CreateAuction(int category_id, String start_date, String end_date, String title_ni, String accessToken) {
        String line;
        BufferedReader reader;
        StringBuffer respondContent = new StringBuffer();

        // Connect and parse Json
        /// api/auctions/edit/{auctionId}
        try {
            URL url = new URL(API.base + "auctions/create");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer" + accessToken);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String data = "{\n \"category_id\": \"" + category_id + "\"" + "    ,\n  \"start_date\": \"" + start_date
                    + "\"" + "    ,\n  \"end_date\": \"" + end_date + "\"" + "    ,\n  \"title_ni\": \"" + title_ni
                    + "\"" + "\n}";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);
            OutputStream stream = connection.getOutputStream();
            stream.write(out);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                respondContent.append(line);
            }
            System.out.println(respondContent);

            // Parse JSON
            Gson g = new Gson();
            rp = g.fromJson(respondContent.toString(), CreateAuctionClass.class);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }

    }

    public int getCode() {
        return rp.code;
    }

    public String getMessage() {
        return rp.message;
    }
    public int getHttpCode() {
        return rpCode;
    }
    public Data getData() {
        return rp.data;
    }
    public String getAuctionId() {
        return rp.data.auction_id;
    }
}