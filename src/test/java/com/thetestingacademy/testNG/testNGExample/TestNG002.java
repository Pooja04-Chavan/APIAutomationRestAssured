package com.thetestingacademy.testNG.testNGExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TestNG002 {

    // PUT request
    // Before- Token, ID

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    String token;

    @BeforeTest
    public void getToken(){
        requestSpecification= RestAssured.given();
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.basePath("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response=requestSpecification.post();
        validatableResponse=response.then();

        // Rest Assured -> Matchers (Hamcrest) - 1-2% Times you will be using it
        validatableResponse.body("token", Matchers.notNullValue());

        // TestNG assertion
         token=response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);

        // AssertJ
         assertThat(token).isNotEmpty().isNotNull();

        System.out.println(token);
    }

    @Test
    public void  testNonBDDStylePUTRequest(){
        String jsonString = "{\n" +
                "    \"firstname\": \"Pooja\",\n" +
                "    \"lastname\": \"Rathod\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";
        // Setting content type to specify format in which request payload will be sent.
        // ContentType is an ENUM.
        requestSpecification.contentType(ContentType.JSON);

        // Setting a cookie for authentication as per API documentation
        requestSpecification.cookies("token", token);

        // Adding URL
         requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
         requestSpecification.basePath("booking/1016");

        // Adding body as string
        requestSpecification.body(jsonString);

        // Calling PUT method on URI. After hitting we get Response
        Response response=requestSpecification.put();

        // Printing Response as string
        System.out.println(response.asString());

        // Get Validatable response to perform validation
        validatableResponse=response.then().log().all();

        // Validate status code as 200
        validatableResponse.statusCode(200);

        // Validate value of firstName is updated
        validatableResponse.body("firstName", Matchers.equalTo("Pooja"));

        // Validate value of Lastname is updated
        validatableResponse.body("lastName", Matchers.equalTo("Rathod"));

    }

}
