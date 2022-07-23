package categories;

import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class CategoriesTest {
    @Test
    public void nomalTest() throws ProtocolException, IOException{
        CategoriesRequest categories = new CategoriesRequest();
        int code = categories.getCode();
        String message = categories.getMessage();
        assertEquals("code should be 1000", 1000, code);
        assertEquals("Message shoult be OK", "OK", message);
    } 
    
    //request nhieu lan lien tuc
    @Test
    public void multipleRequest() throws ProtocolException, IOException{
        try{
            for (int i = 1; i <= 10; i++){
                CategoriesRequest categories = new CategoriesRequest();
            }
        }catch(Exception e){
            assertFalse("cannot send many request continuous", true);
        }
    }    

    //so categories phai > 0
    @Test
    public void positiveNumberOfCategories() throws ProtocolException, IOException{
        CategoriesRequest categories = new CategoriesRequest();
        int count = categories.getNumberOfCate();
        assertEquals("Number of Categories should greater than 0", true, count > 0);
    }

    //moi category_id phai la so nguyen duong
    @Test
    public void positiveCategory_id() throws ProtocolException, IOException{
        CategoriesRequest categories = new CategoriesRequest();
        System.out.println(categories.getNumberOfCate());
        for (int i = 0; i < categories.getNumberOfCate(); i++){
            if (categories.getCategories_id()[i] <= 0) assertFalse("category_id should be positive", true);
        }
        assertTrue("category_id be positive", true);
    }

    //ten san pham khong duoc bo trong
    @Test
    public void validName() throws ProtocolException, IOException{
        CategoriesRequest categories = new CategoriesRequest();
        for (int i = 0; i < categories.getNumberOfCate(); i++){
            if (categories.getNames()[i] == null || categories.getNames()[i].length() == 0) assertFalse("name should not be empty", true);
        }
        assertTrue("Name is valid", true);
    }
}
