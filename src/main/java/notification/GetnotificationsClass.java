package notification;
import java.util.List;
public class GetnotificationsClass {
    public int code;
    public String message;
    public Data data;
}
class Data {
    public List<deny> denys;
    public String total_not_read;
    public String total;
}
class deny {
    public String title;
    public String start_date;
    public String end_date;
    public String reason;
    public String auction_id;
    public String update_at;
    public String type;
    public String is_read;
}
