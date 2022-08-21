package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Login2 {


    Response response;
    @When("I send a Post request to the endpoint with wrong credentials")
    public void iSendAPostRequestToTheEndpointWithWrongCredentials() {
         response = given().
                        header("Accept", "application/json").
                        contentType(ContentType.JSON).
                        body("{\n" +
                                "  \"email\": \"Jhony_deep5@gmail.com\",\n" +
                                "  \"password\": \"jhony12345\",\n" +
                                "}").
                    when(). log().all().
                        post(String.valueOf(Endpoints.LOGIN));

    }

    @Then("The response should contain an error message")
    public void theResponseShouldContainAnErrorMessage() {

        response.then(). log().all().
                statusCode(200).
                header("Content-Type", "application/json; charset=UTF-8").
                header("connection", "keep-alive").
                body("status", equalTo(422)).
                body("message", equalTo("Please Fill in all Required Fields!"));

    }
}
