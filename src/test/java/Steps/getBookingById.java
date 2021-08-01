package Steps;

import Base.BaseTest;
import Base.Methods;
import io.restassured.path.json.JsonPath;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class getBookingById extends BaseTest {

    @Test
    public void getBookingRecord() {

        JsonPath response = Methods.returnRecords().jsonPath();
        int bookingId = response.get("bookingid");

        given()
                .when()
                .get("booking/{id}", bookingId)
                .then()
                .statusCode(200)
                .body("firstname", is(equalTo( response.get("booking.firstname"))))
                .body("lastname",  is(equalTo( response.get("booking.lastname" ))))
                .body("totalprice",  is(equalTo( response.get("booking.totalprice" ))))
                .body("depositpaid",  is(equalTo( response.get("booking.depositpaid" ))))
                .body("checkin",  is(equalTo( response.get("booking.checkin" ))))
                .body("checkout",  is(equalTo( response.get("booking.checkout" ))))
                .body("bookingdates",  is(equalTo( response.get("booking.bookingdates" ))))
                .body("additionalneeds",  is(equalTo( response.get("booking.additionalneeds" ))));

        System.out.println(bookingId);
    }
}
