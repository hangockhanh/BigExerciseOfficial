package info;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class InfoTest {
    @Test
    public void true_info() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        InfoRequest inforequest = new InfoRequest(access_token);
        int code = inforequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }
}
