package chat;

import login.LoginRequest;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import lib.API;
public class CreateChatTest {
    @Test
    public void normalTest() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token();
        try{
            CreateChatRequest createchat = new CreateChatRequest(access_token, API.create_chat, "8");
            int code = createchat.getCode();
            assertEquals("code should be 1000", 1000, code);
        } catch (IOException e){
            assertFalse("404 not found", true);
        }
    }

    //user_receive_id khong the la so am
    @Test
    public void negativeID() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token(); 
        CreateChatRequest createchat = new CreateChatRequest(access_token, API.create_chat_fix, "-8");
        int code = createchat.getCode();
        assertNotEquals("code should not be 1000", 1000, code);
    }

    //user_receive_id tra ve khong dung, hoac phai co co che bao loi
    @Test
    public void notSameID() throws ProtocolException, IOException{
        LoginRequest loginrequest = new LoginRequest("ha@gmail.com", "khanh");
        String access_token = loginrequest.getAccess_token(); 
        CreateChatRequest createchat = new CreateChatRequest(access_token, API.create_chat_fix, "78");
        int user_receive_id = createchat.getUser_receive_id();
        assertEquals("ID should be same", 78, user_receive_id);
    }
}
