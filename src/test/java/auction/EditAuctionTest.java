package auction;

import java.net.ProtocolException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import login.LoginRequest;


public class EditAuctionTest {
    @Test
    // true params
    public void unit_test1() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        EditAuction editAuction = new EditAuction(2160,4,"2023/07/14 11:31","2024/07/21 11:31","abcdefghi",loginRequest.getAccess_token());
        int code = editAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", editAuction.getMessage());
    }
    @Test
    // no end_date, title_ni
    public void unit_test3() throws IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        EditAuction editAuction = new EditAuction(2160,4,"2023/07/14 11:31",null,null,loginRequest.getAccess_token());
        int code = editAuction.getCode();
        Assert.assertEquals(1001,code);
        Assert.assertEquals("category: &start_date: &end_date: 7008&title: ", editAuction.getMessage());
    }
    @Test
    // wrong auctionId: Id ko co quyen chinh sua
    public void unit_test4() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        EditAuction editAuction = new EditAuction(2,4,"2023/07/14 11:31","2024/07/21 11:31","abcdefghi",loginRequest.getAccess_token());
        int code = editAuction.getCode();
        Assert.assertEquals(1006,code);
        Assert.assertEquals("Không có quyền chỉnh sửa", editAuction.getMessage());
    }
    @Test
    // wrong auctionId: Id ko the chinh sua
    public void unit_test5() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        EditAuction editAuction = new EditAuction(21,4,"2023/07/14 11:31","2024/07/21 11:31","abcdefghi",loginRequest.getAccess_token());
        int code = editAuction.getCode();
        Assert.assertEquals(1005,code);
        Assert.assertEquals("Không thể chỉnh sửa", editAuction.getMessage());
    }
    @Test
    // loi: category_id ko ton tai van tra ve ket qua
    public void unit_test6() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        EditAuction editAuction = new EditAuction(2160,7,"2023/07/14 11:31","2024/07/21 11:31","abcdefghi",loginRequest.getAccess_token());
        int code = editAuction.getCode();
        Assert.assertEquals(1000,code);
        Assert.assertEquals("OK", editAuction.getMessage());
    }
}
