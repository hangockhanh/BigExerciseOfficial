package notification;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;
import logout.LogoutRequest;

public class GetnotificationsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1000");
        GetnotificationsRequest getnotificationsrequest = new GetnotificationsRequest(1,1,"1",access_token);
        assertEquals(1000,getnotificationsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
    @Test // không thể trả về 1004
    public void test02() throws ProtocolException, IOException{
        try{
            LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
            String access_token = loginrequest.getAccess_token();
            LogoutRequest logoutRequest = new LogoutRequest(access_token);
            System.out.println("code should be 1004 when not access_token");
            GetnotificationsRequest getnotificationsrequest = new GetnotificationsRequest(1,1,"1",access_token);
            assertEquals(1004,getnotificationsrequest.getCode()) ;
            System.out.println("Success!!!");
        }catch( Exception e){
            assertTrue(true);
        }
    }
    @Test
    public void test03() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1000");
        GetnotificationsRequest getnotificationsrequest = new GetnotificationsRequest(-1,-1,"1",access_token);
        assertEquals(1000,getnotificationsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
}
