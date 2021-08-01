package Steps;

import Base.BaseTest;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class getBookingByIds extends BaseTest {

    @Test
    public void getBookingAllId(){

        given()
                .body(ContentType.JSON)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);

    }
}
