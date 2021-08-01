package Steps;

import Base.BaseTest;
import Base.Methods;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class partialUpdateBooking extends BaseTest {

    @Test
    public void updateBookingRecord(){
        JsonPath record = Methods.returnRecords().jsonPath();
        int bookingId = record.get("bookingid");

        JSONObject updateRecord = new JSONObject();
        updateRecord.put("firstname", "UpdatedFirstNameEyup");
        updateRecord.put("lastname", "UpdatedLastNameYakupoglu");
        updateRecord.put("totalprice", "999");
        updateRecord.put("depositpaid", "true");

        JSONObject updateRecordDates = new JSONObject();
        updateRecordDates.put("checkin", "2021-11-01");
        updateRecordDates.put("checkout", "2020-12-01");
        updateRecord.put("bookingdates", updateRecordDates);
        updateRecord.put("additionalneeds", "UpdateBreakfast");

        given()
                .header("Cookie", "token="+ Methods.getAuthToken())
                .contentType(ContentType.JSON)
                .body(updateRecord.toString())
                .when()
                .put("/booking/{bookingId}", bookingId)
                .then()
                .statusCode(200)
                .body("firstname", is(equalTo("UpdatedFirstName" + record.get("booking.firstname"))))
                .body("lastname", is(equalTo( "UpdatedLastName" + record.get("booking.lastname"))));

    }
}
