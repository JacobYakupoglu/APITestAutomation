package Steps;

import Base.BaseTest;
import Base.Methods;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

public class createBooking extends BaseTest {

    @Test
    public void bookingPost()
    {
        JsonPath response = Methods.returnRecords().jsonPath();
        int bookingId = response.get("bookingid");

        System.out.println(bookingId);
    }
}