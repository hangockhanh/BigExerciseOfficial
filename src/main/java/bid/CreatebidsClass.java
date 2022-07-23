package bid;

public class CreatebidsClass {
    public int code;
    public String message;
    public Data data;
}
class Data {
    public String user_id;
    public String auction_id;
    public String price;
    public String update_at;
    public String total;
    public bid[] bids;
}
class bid {
    public String user_id;
    public String auction_id;
    public String price;
    public String update_at;
    public String total;
}
