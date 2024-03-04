package com.thetestingacademy.misc.gson.example;


import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deserialization {


    @Test
    public void testDeserialization(){

        String jsonString="{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        Gson gson=new Gson();
        Employee employee=gson.fromJson(jsonString, Employee.class);

        String firstname= employee.getFirstname();
        String lastname= employee.getLastname();

        Assert.assertEquals(firstname,"Jim");

    }
}
