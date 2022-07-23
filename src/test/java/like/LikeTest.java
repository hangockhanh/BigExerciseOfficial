package like;

import org.junit.Test;

import login.LoginRequest;
import logout.LogoutRequest;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import lib.RandomString;

public class LikeTest {
    String random = RandomString.getAlphaNumericString("0123456789", 4) ;
    @Test
    public void normalTest() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest(random, access_token);
        int code = likerequest.getCode();
        String message = likerequest.getMessage();
        assertEquals("code should be 1000", 1000, code);
        assertEquals("message should be OK", "OK", message);
        boolean is_liked = likerequest.getLikeStatus();
        LikeRequest likerequest1 = new LikeRequest(random, access_token);
        boolean is_liked1 = likerequest1.getLikeStatus();
        assertEquals("status should be change", !is_liked, is_liked1);
    }

    // login -> like -> logout -> login -> like -> status change
    @Test
    public void checkMaintainStatus() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest(random, access_token);
        boolean is_liked = likerequest.getLikeStatus();
        LogoutRequest logoutrequest = new LogoutRequest(access_token);
        LoginRequest loginrequest1 = new LoginRequest("ha@gmail.com", "khanh");
        String access_token1 = loginrequest1.getAccess_token();
        LikeRequest likerequest1 = new LikeRequest(random, access_token1);
        boolean is_liked1 = likerequest.getLikeStatus();
        assertNotEquals("status should be change", !is_liked, is_liked1);
        
    }

    //login -> like -> like -> change status
    @Test
    public void changeStatus() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest(random, access_token);
        boolean is_liked = likerequest.getLikeStatus();
        LikeRequest likerequest1 = new LikeRequest(random, access_token);
        boolean is_liked1 = likerequest1.getLikeStatus();
        assertEquals("status should be change", !is_liked, is_liked1);
    }

    // user_id trả về khi like có trùng với user_id trả về khi login không
    @Test
    public void checkUser_id() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest(random, access_token);
        int user_id_login = loginrequest.getUser_id();
        int user_id_like = likerequest.getUser_id();
        assertEquals("status should be change", user_id_login, user_id_like);
    }

    //ID không nên là số âm
    @Test
    public void negativeID() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest("-123", access_token);
        int code = likerequest.getCode();
        assertNotEquals("code should not be 1000", 1000, code);
    }

    //Khong the like auction chua duoc tao, thoi diem nay moi den hon 2000
    @Test
    public void likeNotExistAuction() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        LikeRequest likerequest = new LikeRequest("50000", access_token);
        int code = likerequest.getCode();
        assertNotEquals("code should not be 1000", 1000, code);
    }
}
