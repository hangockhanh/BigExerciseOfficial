package brands;
import java.net.ProtocolException;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;

public class BrandsTest {
    @Test
    public void normalTest() throws ProtocolException, IOException{
        BrandsRequest brands = new BrandsRequest();
        int code = brands.getCode();
        String message = brands.getMessage();
        assertEquals("code should be 1000", 1000, code);
        assertEquals("Message shoult be OK", "OK", message);
    } 

    //so luong brands phai la so nguyen duong
    @Test
    public void positiveNumberOfBrands() throws ProtocolException, IOException{
        BrandsRequest brands = new BrandsRequest();
        int count = brands.getNumberOfBrands();
        assertEquals("Number of brands should be greater than 0", true, count > 0);
    }

    //id moi brand la so nguyen duong
    @Test
    public void validID() throws ProtocolException, IOException{
        BrandsRequest brands = new BrandsRequest();
        for (int i = 0; i < brands.getNumberOfBrands(); i++){
            if (brands.getBrands_id()[i] <= 0) assertFalse("ID should be positive", true);
        }
        assertTrue("ID is valid", true);
    }

    //ten moi brand khong duoc de trong
    @Test
    public void validName() throws ProtocolException, IOException{
        BrandsRequest brands = new BrandsRequest();
        for (int i = 0; i < brands.getNumberOfBrands(); i++){
            if (brands.getNames()[i] == null || brands.getNames()[i].length() == 0) assertFalse("Name should not be empty", true);
        }
        assertTrue("Name is valid", true);
    }
} 
