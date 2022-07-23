package getslider;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class GetSliderTest {
    @Test
    public void slider() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();       
        GetSliderRequest slider = new GetSliderRequest(access_token);
        int code = slider.getCode();
        assertEquals("code should be 1000", 1000, code);
    }
}
