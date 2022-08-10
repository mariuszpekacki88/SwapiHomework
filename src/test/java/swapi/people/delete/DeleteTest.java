package swapi.people.delete;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import static io.restassured.RestAssured.given;

public class DeleteTest extends BaseTest {
    @Test
    public void detetePeople() {
        given()
                .spec(reqSpec)
                .when()
                .delete(BASE_URL + "/" + PEOPLE + "/1")
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }
}