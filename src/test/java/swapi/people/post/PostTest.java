package swapi.people.post;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import swapi.base.BaseTest;
import swapi.model.Swapi;
import swapi.model.Vehicles;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PostTest extends BaseTest {

    private Vehicles vehicles;
    private Swapi swapi;

    @BeforeEach
    public void beforeEach() {
        vehicles = new Vehicles();
        List<String> filmsText = Arrays.asList(VEHICLES + "/" +  TEXTPOST +"/", VEHICLES + "/" +  TEXTPOST +"/");
        vehicles.setFilms(filmsText);
        List<String> pilotesText = Arrays.asList(TEXTPOST, TEXTPOST);
        vehicles.setPilots(pilotesText);
        vehicles.setName(TEXTPOST);
        vehicles.setModel(TEXTPOST);
        vehicles.setManufacturer(TEXTPOST);
        vehicles.setCost_in_credits(TEXTPOST);
        vehicles.setLength(TEXTPOST);
        vehicles.setMax_atmosphering_speed(TEXTPOST);
        vehicles.setCrew(TEXTPOST);
        vehicles.setPassengers(TEXTPOST);
        vehicles.setCargo_capacity(TEXTPOST);
        vehicles.setConsumables(TEXTPOST);
        vehicles.setVehicle_class(TEXTPOST);
        vehicles.setCreated(TEXTPOST);
        vehicles.setEdited(TEXTPOST);
        vehicles.setUrl(VEHICLES + "/" +  TEXTPOST + "/");

        swapi = new Swapi();
        swapi.setCount(TEXTPOST);
        swapi.setPrevious(TEXTPOST);
        swapi.setNext(TEXTPOST);
        swapi.setVehicles(vehicles);
    }
    @Test
    public void createNewVehicles(){

        given()
                .spec(reqSpec)
                .body(vehicles)
                .queryParam("search", "Sand Crawler")
                .when()
                .post(VEHICLES)
                .then()
                .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED);
    }
}