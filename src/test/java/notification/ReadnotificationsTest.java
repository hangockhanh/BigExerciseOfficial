package notification;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class ReadnotificationsTest {
    @Test
    public void test01() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        System.out.println("code should be 1006");
        ReadnotificationsRequest readnotifications = new ReadnotificationsRequest(10, access_token);
        assertEquals(1006,readnotifications.getCode()) ;
        System.out.println("Success!!!");
    }
}