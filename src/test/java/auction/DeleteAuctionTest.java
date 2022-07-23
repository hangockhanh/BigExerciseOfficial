package auction;

import java.net.ProtocolException;
import java.io.IOException;
// import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import login.LoginRequest;


public class DeleteAuctionTest {
    @Test
    // auctionId ko the bi xoa
    public void unit_test1() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        DeleteAuction deleteAuction = new DeleteAuction(21,loginRequest.getAccess_token());
        int code = deleteAuction.getCode();
        Assert.assertEquals(1006,code);
        Assert.assertEquals("\u524a\u9664\u3067\u304d\u307e\u305b\u3093\u3002", deleteAuction.getMessage());
    }
    @Test
    // true params
    public void unit_test2() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        DeleteAuction deleteAuction = new DeleteAuction(2160,loginRequest.getAccess_token());
        int code = deleteAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", deleteAuction.getMessage());
    }

}