package auction;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

import login.LoginRequest;

public class GetDetailsAuctionTest {
    @Test
    // no token
    public void unit_test1() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetDetailsAuction getDetails = new GetDetailsAuction(2,null);
        assertEquals("code should be 1000", 1000, getDetails.getCode());
    }
    @Test
    // statusId and token
    public void unit_test2() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetDetailsAuction getDetails = new GetDetailsAuction(2,loginRequest.getAccess_token());
        assertEquals("code should be 1000", 1000, getDetails.getCode());
    }
    @Test
    // 1<= statusId <= 3
    public void unit_test3() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetDetailsAuction getDetails = new GetDetailsAuction(3,loginRequest.getAccess_token());
        assertEquals("code should be 1000", 1000, getDetails.getCode());
    }
}
