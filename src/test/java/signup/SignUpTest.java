package signup;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class SignUpTest {
    @Test
    public void true_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("viet23@gmail.com", "viet...", "viet...", "VP", "Việt", "0532446712", "");
        int code = signuprequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void same_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("viet123@gmail.com", "viet123", "viet123", "VP", "Việt", "0532", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: &address: &email: 7004&password: &re_pass:  &avatar: ", message);
    }

    @Test
    public void failpass_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("viet155@gmail.com", "viet123", "viet", "VP", "Việt", "0544432", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: &address: &email: &password: &re_pass: 7003 &avatar: ", message);
    }

    @Test
    public void fail_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("viet@gmal.com", "viet", "viet", "VPZ", "Việt", "099932", null);
        int code = signuprequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void noname_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("vietc@gmail.com", "viet", "viet", null, "", "098732", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: 7000&phone: &address: &email: &password: &re_pass:  &avatar: ", message);
    }

    @Test
    public void nophone_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("vietc@gmail.com", "viet", "viet", "VP", "Huy", "", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: 7000&address: &email: &password: &re_pass:  &avatar: ", message);
    }

    @Test
    public void failphone_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("vietc@gmail.com", "viet", "viet", "VP", "Huy", "ciotepoz", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: The phone format is invalid.&address: &email: &password: &re_pass:  &avatar: ", message);
    }

    @Test
    public void longphone_account() throws ProtocolException, IOException{
        SignUpRequest signuprequest = new SignUpRequest("viet@ail.com", "viet", "viet", "VP", "Huy", "0988727299999999999999999999999999999999999999999999999999999999999999", null);
        int code = signuprequest.getCode();
        String message = signuprequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message", "name: &phone: 7013&address: &email: &password: &re_pass:  &avatar: ", message);
    }

}
