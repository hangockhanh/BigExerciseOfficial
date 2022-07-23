package change_password;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class Change_PasswordTest {
    /* @Test
    public void true_pass() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp2388");
        String access_token = request.getAccess_token();
        ChangePasswordRequest changepass = new ChangePasswordRequest(access_token, "giangcvp2388", "giangcvp", "giangcvp");
        int code = changepass.getCode();
        assertEquals("code should be 1000", 1000, code);
    } */

    @Test
    public void fail_pass() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        ChangePasswordRequest changepass = new ChangePasswordRequest(access_token, "giangcvp", "giangcvp11", "giangcvp1");
        int code = changepass.getCode();
        String message  = changepass.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "old_pass: &new_pass: &re_pass: 7003", message);
    }

}
