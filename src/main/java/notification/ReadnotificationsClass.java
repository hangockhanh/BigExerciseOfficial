package notification;

public class ReadnotificationsClass {
    public int code;
    public String message;
    public Data1 data;
}
class Data1 {
    public String is_read;
    public String auction_id;
    public String type;
    public auction auctions;
    public cateinfo category;
    public item items;
    public String total_not_read;
    public String total;
}
class auction {
    public String title;
    public String start_date;
    public String end_date;
    public String status;
    public String update_at;
    public String reason;
}
class cateinfo {
    public String name;
}
class item {
    public String name;
    public String brand;
    public String series;
    public String description;
    public String starting_price;
    public String mainImage;
    public String images;
}
