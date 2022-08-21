package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.utilities.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class RahimSDAPI {
    Response response;



    @When("I send a Get request to {string} endpoint with the following values")
    public void i_send_a_get_request_to_endpoint_with_the_following_values(String endpoint, Map<String,String> dataTable) {

        String username = dataTable.get("username");
        String password =  dataTable.get("password");
        response = given().
                header("Authorization", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2xvYW5cL2FwaSIsImF1ZCI6Imh0dHA6XC9cL2xvY2FsaG9zdFwvbG9hblwvYXBpIiwiaWF0IjoxNjYxMTA2NDIyLCJleHAiOjE2NjExMTAwMjIsImRhdGEiOnsidXNlcl9pZCI6IjM1NjYiLCJ0eXBlIjoiMiJ9fQ._WXMLzX7V36db2aZt4ISZ0nHAWSuk_2PfeimA-J0ux4").
                body("{\n" +
                        "  \"username\": \""+username+"\",\n" +
                        "  \"password\" : \""+password+"\" ,\n" +
                        "}").
                when(). log().all().
                post(endpoint);


    }

    @Then("The response should contain the following info")
    public void the_response_should_contain_the_following_info(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));

    }



}
