package news;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;
public class GetnewsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1000 when valid input.");
        GetnewsRequest getnewsrequest = new GetnewsRequest(3,5,access_token);
        assertEquals(1000,getnewsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
    @Test // vẫn chạy được với access_token = null;
    public void test02() throws ProtocolException, IOException{
        /*LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();*/
        System.out.println("code should be 1000 even access_token is null.");
        GetnewsRequest getnewsrequest = new GetnewsRequest(3,5,"");
        assertEquals(1000,getnewsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
}
