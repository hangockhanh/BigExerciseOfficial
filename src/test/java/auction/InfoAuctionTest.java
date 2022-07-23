package auction;

import java.net.ProtocolException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import login.LoginRequest;

public class InfoAuctionTest {
    @Test
    // true params
    public void unit_test1() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        InfoAuction infoAuction = new InfoAuction(2084,loginRequest.getAccess_token());
        int code = infoAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", infoAuction.getMessage());
    }
    @Test
    // auctionId ko do user tao
    public void unit_test2() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        InfoAuction infoAuction = new InfoAuction(21,loginRequest.getAccess_token());
        int code = infoAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", infoAuction.getMessage());
    }
}
