package news;
import java.util.List;
public class GetnewsClass {
    public int code;
    public String message;
    public Data data;
}
class Data{
    public List<News> news;
    public String total;
}
class News{
    public String user;
    public String new_id;
    public String title;
    public String content;
    public String update_at;
    public String is_read;
}