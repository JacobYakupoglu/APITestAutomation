package Steps;

import Base.BaseTest;
import Base.Methods;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class deleteBooking extends BaseTest {

    @Test
    public void deleteBookingRecord() {
        JsonPath record = Methods.returnRecords().jsonPath();
        int bookingId = record.get("bookingid");

        given()
                .header("Cookie", "token="+ Methods.getAuthToken())
                .body(record.toString())
                .when()
                .delete("/booking/{bookingId}", bookingId)
                .then()
                .statusCode(201);

    }
    }
