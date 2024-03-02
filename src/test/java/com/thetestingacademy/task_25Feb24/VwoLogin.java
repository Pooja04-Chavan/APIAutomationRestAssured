package com.thetestingacademy.task_25Feb24;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VwoLogin {

    @Test(dataProvider ="getData", dataProviderClass = ExcelLoginData.class)
    public void testVwoLogindata( String username, String password)
    {
        //String loginURL = "https://app.vwo.com/login";

        String payload = "{\n" +
                "  \"username\": \""+ username +"\",\n" +
                "  \"password\": \""+ password +"\",\n" +
                "  \"remember\": false,\n" +
                "  \"recaptcha_response_field\": \"\"\n" +
                "}\n";

        Response response= RestAssured.given()
                .baseUri("https://app.vwo.com/")
                .basePath("login")
                .contentType(ContentType.JSON)
                .body(payload)
                .when().post();

        if( response.getStatusCode()== 200)
        {

            System.out.println("Login Successful");
        }
        else {
            System.out.println("Login Failed. Status code: "+response.getStatusCode());
        }
    }

}
