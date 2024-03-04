package com.thetestingacademy.misc.gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GsonDemo {

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

     RequestSpecification requestSpecification;
     ValidatableResponse validatableResponse;

@Test
     public void testPost(){

         Booking booking=new Booking();
         booking.setFirstname("Pooja");
         booking.setLastname("Rathod");
         booking.setTotalprice(112);
         booking.setDepositpaid(true);

         Bookingdates bookingdates=new Bookingdates();
         bookingdates.setCheckin("2024-02-04");
         bookingdates.setCheckout("2024-02-06");

         booking.setBookingdates(bookingdates);
         booking.setAdditionalneeds("Breakfast");

         System.out.println(booking);


         requestSpecification= RestAssured.given();
         requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
         requestSpecification.basePath("booking");
         requestSpecification.contentType(ContentType.JSON);
         requestSpecification.body(booking).log().all();

    Response response= requestSpecification.when().post();



    validatableResponse=response.then().log().all();
    validatableResponse.statusCode(200);

   Integer bookingId= response.then().extract().path("bookingid");
    System.out.println("the booking Id is: " + bookingId);


     }


}
