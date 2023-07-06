package Examples;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class SpecificationTest {
    RequestSpecification reqSpec;
    ResponseSpecification respSpec;

    int petId;

    @BeforeClass
    public void setup(){
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .addHeader("Content-Type","application/json")
                .build();

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .expectBody("status",equalTo("alive"))
                .build();
    }
    @Test(priority = 1)
    public void postTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 34748);
        reqBody.put("name", "nidev");
        reqBody.put("status", "alive");

        Response response = given().spec(reqSpec).body(reqBody).when().post();

        petId = response.then().extract().path("id");
        response.then().spec(respSpec).body("name", equalTo("nidev"));
    }
    @Test(priority = 2)
    public void getRequest(){
        given().spec(reqSpec).pathParam("petId",petId).
                when().get("/{petId}")
                .then().spec(respSpec).body("name", equalTo("nidev"));
    }
    @Test(priority = 3)
    public void delRequest(){
        given().spec(reqSpec).pathParam("petId",petId).
                when().delete("/{petId}")
                .then().statusCode(200)
                .time(lessThanOrEqualTo(3000L))
                .body("message",equalTo(""+ petId));
    }

}
