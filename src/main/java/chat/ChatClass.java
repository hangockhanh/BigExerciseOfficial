package chat;

public class ChatClass {
    int code;
    String message;
    Chat_Info data;
}
class Chat_Info{
    Chat[] chat;
}
class Chat{
    String chat_id;
    String user_send_id;
    String user_receive_id;
    User_Info user_receive_info;
    String[] members;
}
class User_Info{
    String user_id;
    String name;
    String avatar;
    String role;
}
