package com.thetestingacademy.testNG.testNGExample;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {

    String token;
    Integer bookingID;

    public String getToken()
    {
        token="0dabc8dbaf0abbf";
        return token;
    }
@BeforeTest
    public void getTokenAndBookingID()
    {
        token=getToken();
    bookingID=1016;
    }

    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2() {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq3() {
        System.out.println(token);
        System.out.println(bookingID);
    }
}
