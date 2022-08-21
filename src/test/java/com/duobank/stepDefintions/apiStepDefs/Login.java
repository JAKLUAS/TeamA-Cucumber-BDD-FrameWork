package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Login {



    Response response;

    @When("I send a Post request to {string} endpoint with the following information")
    public void i_send_a_post_request_to_endpoint_with_the_following_information(String endpoint, Map<String,String> dataTable) {
        String email= dataTable.get("email");
        String password =  dataTable.get("password");
        response = given().
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "  \"email\" : \""+email+"\",\n" +
                        "  \"password\" : \""+password+"\" ,\n" +
                        "}").
                when().log().all().
                post(endpoint);
    }
    @Then("the response should contain the following data")
    public void the_response_should_contain_the_following_data(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));
    }


    @When("I send a POST request to the endpoint with existing credentials")
    public void i_send_a_post_request_to_the_endpoint_with_existing_credentials() {

        response = given().
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"email\": \"halil.dkmn@gmail.com\",\n" +
                        "    \"password\":\"Halildikmen1\"\n" +
                        "}").
                when().log().all().
               post(String.valueOf(Endpoints.LOGIN));


    }
    @Then("I verify the status code")
    public void i_verify_the_status_code() {
        response.then().log().all().
                statusCode(200);
    }


    @Then("the return response should be less that 1000ms")
    public void the_return_response_should_be_less_that_1000ms() {
        response.then().log().all().
                time(lessThan(1000L));
    }


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
                body("status", Matchers.equalTo(422)).
                body("message", Matchers.equalTo("Please Fill in all Required Fields!"));

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
                body("success", Matchers.equalTo(dataTable.get("success"))).
                body("message", Matchers.equalTo(dataTable.get("message")));

    }


}
