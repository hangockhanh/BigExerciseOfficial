package auction;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

import login.LoginRequest;

public class GetListAuctionTest{
    @Test
    // type and token
    // loi: hien thi ca nhung phien dau gia dang cho duyet
    public void unit_test0() throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(4, "", "1", "",2,2, loginRequest.getAccess_token());
        assertEquals("code should be 1000", 1000, getlist.getCode());
    }
    @Test
    // type only
    // loi: type = 6 van tra ve ket qua
    public void unit_test1()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "6", "", 2, 2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // no params
    public void unit_test2()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "", "", 2, 2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // category_id only
    public void unit_test3()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "", "2", 2, 2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // category_id and token
    public void unit_test4()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "", "2", 2, 2, loginRequest.getAccess_token());
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // user_id and token
    public void unit_test5()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "2", "", "", 2, 2, loginRequest.getAccess_token());
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    // khong tra ve ket qua nao neu chi nhap vao user_id ma khong nhap token

    @Test
    // status_Id ko ton tai 
    // loi: van tra ve ket qua 
    public void unit_test6()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(8, "", "", "", 2, 2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // index < 0
    // loi: van tra ve ket qua
    public void unit_test7()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "", "", -2, 2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
    @Test
    // count < 0 
    //loi: van tra ve ket qua
    public void unit_test8()throws ProtocolException, IOException{
        LoginRequest loginRequest = new LoginRequest("ha@gmail.com", "khanh");
        GetListAuction getlist = new GetListAuction(1, "", "", "", -2, -2, null);
        assertEquals("code should be 1000",1000,getlist.getCode());
    }
}
  
