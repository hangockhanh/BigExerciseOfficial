package auction;

import java.net.ProtocolException;
import java.io.IOException;
// import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import login.LoginRequest;


public class CreateAuctionTest {
    @Test
    // true params
    public void unit_test1() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        CreateAuction createAuction = new CreateAuction(1,"2023/07/14 11:31","2024/07/21 11:31","hiep12345",loginRequest.getAccess_token());
        int code = createAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", createAuction.getMessage());
    }
    @Test
    // start_date muon hon end_date
    public void unit_test2() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        CreateAuction createAuction = new CreateAuction(6,"2023/07/14 11:31","2022/10/21 11:31","hiep1",loginRequest.getAccess_token());
        int code = createAuction.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("category: &start_date: &end_date: 7010&title: ", createAuction.getMessage());
    }
    @Test
    // title_ni da ton tai
    public void unit_test3() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        CreateAuction createAuction = new CreateAuction(1,"2024/07/14 11:31","2024/07/21 11:31","abcdef",loginRequest.getAccess_token());
        int code = createAuction.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("category: &start_date: &end_date: &title: 7005", createAuction.getMessage());
    }
    // category_id ko ton tai
    // loi : category_id = 6 van tra ve ket qua
    @Test
    public void unit_test() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        CreateAuction createAuction = new CreateAuction(6,"2024/07/14 11:31","2024/07/21 11:31","abcdefghgghh",loginRequest.getAccess_token());
        int code = createAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", createAuction.getMessage());
    }
}
