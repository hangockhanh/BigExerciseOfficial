package search;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

import login.LoginRequest;

public class SearchTest {
    @Test
    public void type1_search() throws ProtocolException, IOException{
        LoginRequest login = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = login.getAccess_token();
        SearchRequest request = new SearchRequest(access_token, "1", "5000");
        int code = request.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void type2_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "2", "20");
        int code = inforequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void type3_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "3", "2022");
        int code = inforequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void type4_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "4", "Túi");
        int code = inforequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }

    @Test
    public void notype_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "", "20");
        int code = inforequest.getCode();
        assertEquals("code should be 9998", 9998, code);
    }

    @Test
    public void randomtype_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "abc123", "20");
        int code = inforequest.getCode();
        assertEquals("code should be 9998", 9998, code);
    }

    @Test
    public void nokey_search() throws ProtocolException, IOException{
        LoginRequest request = new LoginRequest("giang.dq204542@sis.hust.edu.vn", "giangcvp");
        String access_token = request.getAccess_token();
        SearchRequest inforequest = new SearchRequest(access_token, "4", "");
        int code = inforequest.getCode();
        assertEquals("code should be 9998", 9998, code);
    }
}
