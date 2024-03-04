package com.thetestingacademy.misc.payloadMap;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PayloadUsingMap {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPostReq(){
        //{
        //            "firstname" : "Jim",
        //                "lastname" : "Brown",
        //                "totalprice" : 111,
        //                "depositpaid" : true,
        //                "bookingdates" : {
        //            "checkin" : "2018-01-01",
        //                    "checkout" : "2019-01-01"
        //        },
        //            "additionalneeds" : "Breakfast"
        //        }

        // Hashmap
        // JSON paYLOAD -> Map - > Contain further maps

        Map<String, Object> jsonBodyUsingMap= new LinkedHashMap<>();
        Faker faker=new Faker();
        //String name=faker.name().fullName();


        jsonBodyUsingMap.put("firstname", faker.name().fullName());
        jsonBodyUsingMap.put("lastname", faker.name().lastName());
        jsonBodyUsingMap.put("totalprice", faker.random().nextInt(1000));
        jsonBodyUsingMap.put("depositepaid", faker.random().nextBoolean());


        Map<String, Object> bookingDatesMap= new HashMap<>();
        bookingDatesMap.put("checkin", "2024-01-01");
        bookingDatesMap.put("checkout", "2024-01-05");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "breakfast");
        System.out.println(jsonBodyUsingMap);



        requestSpecification= RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response=requestSpecification.when().post();


        Integer bookingId = response.then().extract().path("bookingid");
        System.out.println("Your booking Id is" +bookingId);

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);


    }
}
