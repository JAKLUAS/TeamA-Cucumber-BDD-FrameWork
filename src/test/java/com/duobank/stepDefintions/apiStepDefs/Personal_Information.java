package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.utilities.API_token;
import com.duobank.utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasToString;

public class Personal_Information {

    Response response;
    @When("I send a GET request to {string} endpoint with the following values")
    public void i_send_a_get_request_to_endpoint_with_the_following_values(String endpoint, Map<String,String> dataTable ) {
        String token = API_token.returnToken("http://qa-duobank.us-east-2.elasticbeanstalk.com/api");
        String userName = dataTable.get("userName");
        String password = dataTable.get("password");
        response = given().
                header("Authorization",  token).
                header("Content-Type", "application/json").
                body("{\n"+
                        "\"userName\": \""+userName+"\",\n"+
                        "\"password\": \""+password+"\" ,\n"+
                        "}").
                when().log().all().
                post(endpoint);

    }





    @Then("The response should contain the following information")
    public void the_response_should_contain_the_following_information(Map<String,String> dataTable) {

        response.then().log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));


    }
       //use serilization
    @When("I send a Post request to {string} endpoint with following")
    public void iSendAPostRequestToEndpointWithFollowing(String endpoint,  Map<String,String> dataTable) {

        String token = API_token.returnToken("http://qa-duobank.us-east-2.elasticbeanstalk.com/api");


        Map<String, Object> payload  = new HashMap<>();

        payload.put("id", dataTable.get("id"));
        payload.put("b_firstName", dataTable.get("b_firstName"));
        payload.put("b_lastName", dataTable.get("b_lastName"));
        payload.put("b_marital", dataTable.get("b_marital"));



        response=given().log().all().

                header("Authorization",token).
                header("Content-Type", "application/json; charset=UTF-8").
                contentType(ContentType.JSON).
                body(payload).
                when(). log().all().
                post(endpoint);

    }





    @Then("The Response should have following information")
    public void theResponseShouldHaveFollowingInformation( Map<String,String> dataTable) {

     response.then(). log().all().
                statusCode(200).
                header("Content-Type", "application/json; charset=UTF-8").
               // body("status", equalTo(dataTable.get("Status"))).
                body("single_application.b_firstName",hasToString(dataTable.get("b_firstname"))).
                body("single_application.b_email",hasToString(dataTable.get("b_email")));


    }
}
