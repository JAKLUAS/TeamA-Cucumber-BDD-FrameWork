package com.duobank.utilities;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.baseURI;

public class API_token {


    public  static String returnToken(String url) {
     baseURI = url;
  //"http://qa-duobank.us-east-2.elasticbeanstalk.com/api"

        String token = given().


                body("{\n" +
                        "    \"email\": \"duotechb5@gmail.com\",\n" +
                        "    \"password\":\"duotechb5\"\n" +
                        "}").


                when().log().all().
                post("/login.php").
                then().log().all().
                statusCode(200).extract().jsonPath().get("token");
        ;

       return token;
}
}
