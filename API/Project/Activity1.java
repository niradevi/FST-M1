import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;


public class Activity1 {
    RequestSpecification reqSpec;
    ResponseSpecification respSpec;

    int keyId;
    String sshkey;

    @BeforeClass
    public void setup(){
        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com/user/keys/")
                .addHeader("Content-Type","application/json")
                .addHeader("Authorization", "token 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")
                .build();

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThanOrEqualTo(3000L))
                .build();
    }
    @Test(priority = 1)
    public void postTest(){
//        Map<String, Object> reqBody = new HashMap<>();
//        reqBody.put("title", "Testapikey");
//        reqBody.put("key", "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIG3dUgEBacLSJ3HjZcdhIuvGrD77PTs3Ckzkwv1/MIpJ");
        String reqBody = "{\"title\": \"Testapikey\", \"key\": \"ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIG3dUgEBacLSJ3HjZcdhIuvGrD77PTs3Ckzkwv1/MIpJ\"}";
        Response response = given().spec(reqSpec).body(reqBody).when().post();

        keyId = response.then().extract().path("id");
        response.then().statusCode(201);
    }
    @Test(priority = 2)
    public void getRequest(){
        given().spec(reqSpec).pathParam("keyId",keyId).
                when().get("{keyId}")
                .then().statusCode(200);
    }
    @Test(priority = 3)
    public void delRequest(){
        given().spec(reqSpec).pathParam("keyId",keyId).
                when().delete("/{keyId}")
                .then().statusCode(204);
    }

}
