package bid;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import login.LoginRequest;
import org.junit.Test;
//import logout.LogoutRequest;

public class CreatebidsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("If the auction has end, code should be 1008.");
        CreatebidsRequest createbidsrequest = new CreatebidsRequest(987654321,5, access_token,1753);
        int code = createbidsrequest.getCode();
        assertEquals(1008,code);
        System.out.println("Success!");
    }
    @Test
    public void test02() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("If the bid is lower than the highest price, code should be 1001.");
        CreatebidsRequest createbidsrequest = new CreatebidsRequest(900,1, access_token,1);
        int code = createbidsrequest.getCode();
        assertEquals(1001,code);
        System.out.println("Success!");
    }
    @Test
    public void test03() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("If the bid is valid, code should be 1000.");
        CreatebidsRequest createbidsrequest = new CreatebidsRequest(987987654,123456789, access_token,231);
        int code = createbidsrequest.getCode();
        assertEquals(1000,code);
        System.out.println("Success!");
    }
   /*  @Test// không thể trả về 1004
    public void test04() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        // String access_token = loginrequest.getAccess_token();
        // LogoutRequest logoutRequest = new LogoutRequest(access_token);
        System.out.println("If logout, code should be 1004.");
        CreatebidsRequest createbidsrequest = new CreatebidsRequest(123456789,123, "",231);
        int code = createbidsrequest.getCode();
        assertEquals(1000,code);
        System.out.println("Success!");
    }*/ 
}