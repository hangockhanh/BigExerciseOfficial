package lib;
public class API{
    public static String base = "https://auctions-app-2.herokuapp.com/api/";
    public static String login = base + "login";
    public static String logout = base + "logout";
    public static String categories = base + "categories";
    public static String brands = base + "brands";
    public static String chat = base + "chat";
    public static String create_chat = base + "chat/conversations/" ;
    public static String create_chat_fix = base + "chat/conversation/" ;    
    public static String contact = base + "contactUs";
    public static String like = base + "updateLike/";
    public static String totallikes = base + "totalLikes/";public static String getnews = base + "news";
    public static String readnew = base + "news/read/";
    public static String getnotifications = base + "notifications";
    public static String readnotifications = base + "notifications/read/";
    public static String createbid = base + "bids/create/";
    public static String getlistbids =  base + "bids/";
    public static String signup = base + "signup";
    public static String edit_account = base + "edit";
    public static String change_password = base + "changepass";
    public static String info = base + "info";
    public static String slider = base + "slider";
    public static String search = base + "search";
    public static String createitem = base + "items/create/";
}
