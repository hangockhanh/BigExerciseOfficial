package chat;

import login.LoginRequest;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class ChatTest {
    @Test
    public void login_ed() throws ProtocolException, IOException{
        try{
            LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
            String access_token = loginrequest.getAccess_token();
            ChatRequest chatrequest = new ChatRequest(access_token);
            int code = chatrequest.getCode();
            String message = chatrequest.getMessage();
            assertEquals("code should be 1000", 1000, code);
            assertEquals("message should be OK", "OK", message);
        } catch (IOException e){
            assertFalse("HTTP respond code: 500", true);
        }
    }
}
