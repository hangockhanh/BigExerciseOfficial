package news;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class ReadnewsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1000 when valid input");
        ReadnewsRequest readnewsrequest = new ReadnewsRequest(1, access_token);
        assertEquals(1000,readnewsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
    @Test
    public void test02() throws ProtocolException, IOException{
        System.out.println("code should be 1000 even access_token is null");
        ReadnewsRequest readnewsrequest = new ReadnewsRequest(1, "");
        assertEquals(1000,readnewsrequest.getCode()) ;
        System.out.println("Success!!!");
    }
}
