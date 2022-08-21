package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import com.duobank.utilities.ConfigReader;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

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

                header("Content-Type", "application/json; charset=UTF-8").
                header("connection", "keep-alive").
                body("status", equalTo(422)).
                body("message", equalTo("Please Fill in all Required Fields!"));

    }


    @When("I send a post request to the end point with existing email and password")
    public void iSendAPostRequestToTheEndPointWithExistingEmailAndPassword() {
        response = given().
                header("Accept", "application/json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "  \"email\": \"Jhony_deep145@gmail.com\",\n" +
                        "  \"password\": \"jhony1234\",\n" +
                        "}").
                when(). log().all().
                post(String.valueOf(Endpoints.LOGIN));

    }

    @Then("the response payload should have the following body info")
    public void theResponsePayloadShouldHaveTheFollowingBodyInfo(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                body("success", equalTo(dataTable.get("success"))).
                body("message", equalTo(dataTable.get("message")));

    }

}
