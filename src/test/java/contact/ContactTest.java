package contact;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import lib.RandomString;

public class ContactTest {
    @Test
    public void normal_contact() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", "ha@gmail.com", "very good", "1");
        int code = contactrequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }
    @Test
    public void normal_contact_2() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", " ha@gmail.com ", "very good", "1");
        int code = contactrequest.getCode();
        assertEquals("code should be 1000", 1000, code);
    }
    @Test
    public void sameName_Phone_Email_Content_ReportType() throws ProtocolException, IOException{
        String name = RandomString.getAlphaNumericString("ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz", 20);
        String email = RandomString.getAlphaNumericString("ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz", 20) + "@gmail.com";
        String phone = RandomString.getAlphaNumericString("0123456789", 10);
        String content = RandomString.getAlphaNumericString("ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz",20);
        String report_type = RandomString.getAlphaNumericString("123", 1);
        ContactRequest contactrequest = new ContactRequest(name, phone, email, content, report_type);
        String name_rp = contactrequest.getName();
        String email_rp = contactrequest.getEmail();
        String phone_rp = contactrequest.getPhone();
        String report_rp = contactrequest.getRepor_type();
        assertEquals("name should be same", name , name_rp);
        assertEquals("email should be same", email, email_rp);
        assertEquals("phone should be same", phone, phone_rp);
        assertEquals("report_type should be same", report_type, report_rp);
    }
    @Test
    public void falseFormat_email_0() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", "hag.m@", "very good", "1");
        int code = contactrequest.getCode();
        String message = contactrequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message should be email 7002", "name: &phone: &email: 7002&content: &report_type: ", message);
    }
    @Test
    public void falseFormat_email_1() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", "ha@gmail(Ha Khanh)", "very good", "1");
        int code = contactrequest.getCode();
        String message = contactrequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message should be email 7002", "name: &phone: &email: 7002&content: &report_type: ", message);
    }
    @Test
    public void falseFormat_email_2() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", "ha@mail", "very good", "1");
        int code = contactrequest.getCode();
        String message = contactrequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message should be email 7002", "name: &phone: &email: 7002&content: &report_type: ", message);
    }
    @Test
    public void falseFormat_email_3() throws ProtocolException, IOException{
        ContactRequest contactrequest = new ContactRequest("Name", "012", "email@111.222.333.44444", "very good", "1");
        int code = contactrequest.getCode();
        String message = contactrequest.getMessage();
        assertEquals("code should be 1001", 1001, code);
        assertEquals("message should be email 7002", "name: &phone: &email: 7002&content: &report_type: ", message);
    }
}

