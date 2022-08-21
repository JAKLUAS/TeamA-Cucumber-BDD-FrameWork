package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import com.google.common.cache.AbstractCache;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class MortgageDetails {



    Response response;
    @When("I verify a Post mortgage application to return {string} endpoint with the following values")
    public void i_verify_a_post_mortgage_application_to_return_endpoint_with_the_following_values(String endpoint, Map<String, Object> dataTable) {

        Map<String, Object> payload  = new HashMap<>();
        payload.put("id", "id");
        payload.put("b_firstName", "Maria");
        payload.put("b_lastName","Wuckert" );
        payload.put("email","fae.hilll@hotmail.com");



        response=given().


                header("Accept", "application/vnd.api+json").

                contentType(ContentType.JSON).
                body(payload, ObjectMapperType.JACKSON_2).
                when(). log().all().
                post(endpoint);

    }
    @Then("The response should contain the following informationn")
    public void the_response_should_contain_the_following_informationn(Map<String, String>dataTable) {

        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));


    }


}
