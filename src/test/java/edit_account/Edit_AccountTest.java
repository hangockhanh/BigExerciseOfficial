package edit_account;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import login.LoginRequest;

public class Edit_AccountTest {
    @Test
    public void true_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "giang.dq204542@sis.hust.edu.vn", "hanoi", "Giang", "0987777111", null);
        int code = edit.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void noname_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "giang.dq204542@sis.hust.edu.vn", "hanoi", "", "0987777111", null);
        int code = edit.getCode();
        String message = edit.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: 7000&phone: &address: &email:  &avatar: ", message);
    }

    @Test
    public void existedemail_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "viet123@gmail.com", "hanoi", "Việt", "0987777111", null);
        int code = edit.getCode();
        String message = edit.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: &address: &email: 7004 &avatar: ", message);
    }

    @Test
    public void failemail_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "giangn", "hanoi", "Huy", "0987777111", null);
        int code = edit.getCode();
        String message = edit.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: &address: &email: 7002 &avatar: ", message);
    }

    @Test
    public void noemail_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "", "hanoi", "Huy", "0987777111", null);
        int code = edit.getCode();
        String message = edit.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: &address: &email: 7000 &avatar: ", message);
    }

    @Test
    public void nophone_edit() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = loginrequest.getAccess_token();
        Edit_AccountRequest edit = new Edit_AccountRequest(access_token, "giang.dq204542@sis.hust.edu.vn", "hanoi", "Việt", "", null);
        int code = edit.getCode();
        String message = edit.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: 7000&address: &email:  &avatar: ", message);
    }
}
