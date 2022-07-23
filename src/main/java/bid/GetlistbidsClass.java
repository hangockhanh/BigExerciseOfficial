package bid;

public class GetlistbidsClass {
    public int code;
    public String message;
    public Data1 data;
}
class Data1 {
    public bid1[] bids;
    public String total;
}
class bid1 {
    public String user_name;
    public String user_avatar;
    public String price;
    public String update_at;
}
