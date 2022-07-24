package auction;

public class GetListAuctionClass {
        public int code;
        public String message;
        public Data5 data;
}
class Data5{
    public Auction1[] auctions;
    public User user_info;
    public String type;
    public String category;
    public String total;
}

class Auction1{
    public String auction_id;
    public String selling_user_id;
    public String title;
    public String start_date;
    public String end_date;
    public String statusId;
    public String status;
    public Category2 category;
}
class Category2{
    public String name;
    public String image;
    public String type;
}
class User{
    public String name;
    public String avatar;
    public String phone;
    public String email;
    public String role;
    public String address;
}
