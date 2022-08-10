package swapi.people.get;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetTest extends BaseTest {

    @Test
    public void readAllPeople(){

        Response response = given()
                .spec(reqSpec)
                .when()
                .get(BASE_URL + "/" + PEOPLE)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();

        JsonPath json = response.jsonPath();

        List<String> names = json.getList("results.name");
        assertThat(10).isEqualTo(names.size());
    }

    @Test
    public void readOnePeopleWithPathParam(){

        Response response = given()
                .spec(reqSpec)
                .pathParam("peopleId", "1")
                .when()
                .get(BASE_URL + "/" + PEOPLE + "/" + "{peopleId}")
                .then()
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat("Luke Skywalker").isEqualTo(json.get("name"));
    }

    @Test
    public void readOnePeopleWithQuaryParam(){
        Response response = given()
                .spec(reqSpec)
                .queryParam("search", "Luke Skywalker")
                .when()
                .get(BASE_URL + "/" + PEOPLE)
                .then()
                .extract()
                .response();

        JsonPath json = response.jsonPath();
        assertThat("Luke Skywalker").isEqualTo(json.getList("results.name").get(0));
    }
}