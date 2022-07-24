package bid;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class GetlistbidsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1000 and message should be OK when valid input");
        GetlistbidsRequest getlistbidsrequest = new GetlistbidsRequest(123456,1, access_token,123);
        assertEquals(1000,getlistbidsrequest.getCode()) ;
        assertEquals("OK",getlistbidsrequest.getMessage());
        System.out.println("Success!!!");
    }
    @Test
    public void test02() throws ProtocolException, IOException{
        System.out.println("code should be 1000 and message should be OK even access_token is null.");
        GetlistbidsRequest getlistbidsrequest = new GetlistbidsRequest(21,3, "",123);
        assertEquals(1000,getlistbidsrequest.getCode()) ;
        assertEquals("OK",getlistbidsrequest.getMessage());
        System.out.println("Success!!!");
    }
    @Test // vẫn chạy được khi index và count có giá trị âm
    public void test03() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code shouldn't be 1000 and message shouldn't be OK if index or count is negative.");
        GetlistbidsRequest getlistbidsrequest = new GetlistbidsRequest(-5,-3,access_token,123);
        assertNotEquals(1000,getlistbidsrequest.getCode()) ;
        assertNotEquals("OK",getlistbidsrequest.getMessage());
        System.out.println("Success!!!");
    }
}