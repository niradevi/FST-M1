package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {
    String ROOT_URI;

    @BeforeClass
    public void setup() {
        ROOT_URI = "https://petstore.swagger.io/v2/pet";
    }
    @Test(priority = 1)
    public void AddNewPet() {
        // Write the request body
        String reqBody = "{ \"id\": 34748, \"name\": \"nidev\",\"status\": \"sold\" }";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
    }
    // Set Base URL
    @Test(priority = 2)
    public void GetPet() {
        // Write the request body
//        String reqBody = "{ \"id\": 34748, \"name\": \"devni\",\"status\": \"sold\" }";

        String url = ROOT_URI+"/34748";
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(url); // Send PUT request

        // Print the response
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        // Assert the updates
        response.then().body("name", equalTo("nidev"));
    }

    @Test(priority = 3)
    public void DeletePet() {

        Response response =

                given().contentType(ContentType.JSON) // Set headers

                        .when().delete(ROOT_URI + "/34748"); // Send DELETE request

        response.then().body("code", equalTo(200));

        response.then().body("message", equalTo("34748"));

    }


}
