package like;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import lib.RandomString;
import login.LoginRequest;

public class TotalLikesTest {
    String auction_id = RandomString.getAlphaNumericString("123456789", 3);
    @Test
    public void normalTest() throws ProtocolException, IOException{
        TotalLikesRequest totallike = new TotalLikesRequest("1");
        int code = totallike.getCode();
        String message = totallike.getMessage();
        assertEquals("Code should be 1000", 1000, code);
        assertEquals("Message shoult be OK", "OK", message);
    }

    //total like phai tang khi like hoac giam khi bo like: can phai login
    @Test
    public void normalWork() throws ProtocolException, IOException{
        try{
            TotalLikesRequest totallike = new TotalLikesRequest("1");
            int total_liked = Integer.parseInt(totallike.getTotal_liked()) ;
            LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
            String token = loginrequest.getAccess_token();
            LikeRequest likerequest = new LikeRequest("1", token);
            TotalLikesRequest totallike1 = new TotalLikesRequest("1");
            int total_liked1 = Integer.parseInt(totallike1.getTotal_liked()) ;
            if (total_liked1 == total_liked + 1){
                LikeRequest likerequest2 = new LikeRequest("1", token);
                TotalLikesRequest totallike2 = new TotalLikesRequest("1");
                int total_liked2 = Integer.parseInt(totallike2.getTotal_liked()) ;
                assertEquals("Total like should decrease after unlike", total_liked1 - 1, total_liked2);
            }
            else{
                LikeRequest likerequest2 = new LikeRequest("1", token);
                TotalLikesRequest totallike2 = new TotalLikesRequest("1");
                int total_liked2 = Integer.parseInt(totallike2.getTotal_liked()) ;
                assertEquals("Total like should increase after like", total_liked1 + 1, total_liked2);
            }
        }catch(IOException e){};
    }
}
