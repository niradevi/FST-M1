package LiveProject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
//Add header
    Map<String,String> headers = new HashMap<>();
    //Make Contract
    @Pact(consumer = "userConsumer", provider = "UserProvider")
    public RequestResponsePact createpact(PactDslWithProvider builder){
        headers.put("Content-Type","application/json");
        DslPart requestResponseBody = new PactDslJsonBody()
        .numberType("id", 123)
                .stringType("firstName", "aaa")
                .stringType("lastName","zzz")
                .stringType("email","abc.com");
        return  builder.given("request to create a user")
                .uponReceiving("request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest(){
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id",123);
        reqBody.put("firstName", "hjdsvf");
        reqBody.put("lastName", "szdgasg");
        reqBody.put("email","fsga@hb");

        given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).
                when().post().then().statusCode(201).log().all();
    }
}
