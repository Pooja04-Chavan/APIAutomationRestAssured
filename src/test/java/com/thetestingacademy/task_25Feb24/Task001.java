package com.thetestingacademy.task_25Feb24;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Task001 {
    public static void main(String[] args) {


    String loginURL = "https://app.vwo.com/login";

    String payload = "{\n" +
            "  \"username\": \"contact+atb5x@thetestingacademy.com\",\n" +
            "  \"password\": \"ATBx@1234\",\n" +
            "  \"remember\": false,\n" +
            "  \"recaptcha_response_field\": \"\"\n" +
            "}\n";

    Response response= RestAssured.given()
            .contentType(ContentType.JSON)
            .body(payload)
            .post(loginURL);

    if( response.getStatusCode()== 200)
    {
        System.out.println("Login Successful");
    }
    else {
        System.out.println("Login Failed. Status code: "+response.getStatusCode());
    }




}
    }