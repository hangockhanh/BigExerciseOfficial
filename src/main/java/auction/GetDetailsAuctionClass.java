package auction;

public class GetDetailsAuctionClass {
    public int code;
    public String message;
    public Data4 data;
}
class Data4{
    public Auction auctions;
    public Category category;
    public Items items;
    public Selling_user selling_user;
    public String max_bid;
    public Buying_user buying_user;
    public String like;
}
class Auction {
    public String auction_id;
    public String title;
    public String start_date;
    public String end_date;
    public String statusId;
    public String status; 
}
class Category {
    public String name;
    public String image;
    public String type;
}
class Items {
    public String item_id;
    public String name;
    public String buying_user_id;
    public String brand;
    public String series;
    public String description;
    public String starting_price;
    public String selling_info;
    public String mainImange;
    public String[] images;
}
class Selling_user{
    public String selling_user_id;
    public String selling_user_name;
    public String selling_user_avatar;
}
class Buying_user{
    public String buying_user_id;
    public String buying_user_name;
    public String buying_user_phone;
    public String buying_user_address;
}