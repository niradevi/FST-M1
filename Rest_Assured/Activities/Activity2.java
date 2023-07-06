package Activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity2 {
    String ROOT_URI;

    @BeforeClass
    public void setup() {
        ROOT_URI = "https://petstore.swagger.io/v2/user";
    }
    @Test(priority = 1)
    public void AddNewUser() {
        // Write the request body
        String reqBody =" {\"id\": 34748, \"username\": \"nidev\", \"firstName\": \"niran\", \"lastName\": \"devi\"}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);
    }
    // Set Base URL
    @Test(priority = 2)
    public void GetUser() {

        String url = ROOT_URI+"/nidev";
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().get(url); // Send PUT request

        // Print the response
        String resBody = response.getBody().asPrettyString();
        System.out.println(resBody);

        // Assert the updates
        response.then().body("username", equalTo("nidev"));
    }

    @Test(priority = 3)
    public void DeleteUser() {

        Response response =

                given().contentType(ContentType.JSON) // Set headers

                        .when().delete(ROOT_URI + "/nidev"); // Send DELETE request

        response.then().body("code", equalTo(200));

        response.then().body("message", equalTo("nidev"));

    }
}
