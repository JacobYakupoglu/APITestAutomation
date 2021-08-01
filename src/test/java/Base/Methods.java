package Base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.instanceOf;

public class Methods extends BaseTest {

    public static String getAuthToken() {
        JSONObject auth = new JSONObject();
        auth.put("username", "admin");
        auth.put("password", "password123");

        return given()
                .contentType(ContentType.JSON)
                .body(auth.toString())
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .body("", hasKey("token"))
                .body("token", instanceOf(String.class))
                .extract().path("token")
                ;
    }
    public static Response returnRecords(){
        JSONObject record = new JSONObject();
        record.put("firstname", "Eyup");
        record.put("lastname", "Yakupoglu");
        record.put("totalprice", "135");
        record.put("depositpaid", "false");

        JSONObject recordDates = new JSONObject();
        recordDates.put("checkin", "2021-10-01");
        recordDates.put("checkout", "2021-12-11");
        record.put("bookingdates", recordDates);
        record.put("additionalneeds", "Breakfast");


        return given()
                .contentType(ContentType.JSON)
                .body(record.toString())
                .when()
                .post("/booking")
                .then()
                .statusCode(200)
                .extract().response();
    }
}
