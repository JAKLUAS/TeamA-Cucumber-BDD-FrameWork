package com.duobank.stepDefintions.apiStepDefs;

import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Login2 {

    @When("I send a Post request to the endpoint with wrong credentials")
    public void iSendAPostRequestToTheEndpointWithWrongCredentials() {
         given().
                header("Accept", "application/json").
//                header("Content-Type", "application/json").
        contentType(ContentType.JSON).
                body("{\n" +
                        "  \"email\": \"avril_lavigne@mail.com\",\n" +
                        "  \"password\": \"avril1234\",\n" +
                        "}").
                when(). log().all().
                post("/videogames").
                then(). log().all().
                statusCode(not(200)).
                header("Content-Type", "application/json;charset=UTF-8").
                header("connection", "close").

                body("error", equalTo("Internal Server Error"));

    }
}
