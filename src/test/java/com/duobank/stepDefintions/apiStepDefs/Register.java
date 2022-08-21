package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class Register {



    Response response;
    @Given("The Base URI is set")
    public void the_base_uri_is_set() {
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }



    @When("I send a Post request to {string} endpoint with the following values")
    public void i_send_a_post_request_to_endpoint_with_the_following_values(String endpoint, Map<String,String> dataTable) {

        String name = dataTable.get("first_name");
        String last = dataTable.get("last_name");
        String email= dataTable.get("email");
        String password =  dataTable.get("password");
               response = given().
                header("Accept", "application/vnd.api+json").

                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"first_name\": \""+name+"\",\n" +
                        "    \"last_name\": \""+last+"\",\n" +
                        "    \"email\":\""+email+"\",\n" +
                        "    \"password\":\""+password+"\"\n" +
                        "}").
                when(). log().all().
                post(endpoint);


    }
    @Then("The response should contain the following")
    public void the_response_should_contain_the_following(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server"));

    }


// valid credential hard coded api

    @When("I send a post request to the end point with valid credentials")
    public void i_send_a_post_request_to_the_end_point_with_valid_credentials() {
        response = given().
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"first_name\": \"Jhony\",\n" +
                        "    \"last_name\": \"Deep\",\n" +
                        "    \"email\": \"jhony_deep145@gmail.com\",\n" +
                        "    \"password\" : \"jhony1234\"\n" +
                        "}").
                when(). log().all().
                post(String.valueOf(Endpoints.REGISTER));
    }
    @Then("verify the status code")
    public void verify_the_status_code() {
        response.then(). log().all().
                statusCode(200);
    }

    // negative scenario



    @When("I send a post request to the end point with existing credentials")
    public void i_send_a_post_request_to_the_end_point_with_existing_credentials() {
        response = given().
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"first_name\": \"Halil\",\n" +
                        "    \"last_name\": \"Baba\",\n" +
                        "    \"email\":\"halodkmn1@gmail.com\",\n" +
                        "    \"password\":\"halo1234\"\n" +
                        "}").
                when(). log().all().
                post(String.valueOf(Endpoints.REGISTER));
    }
    @Then("verify the status code  and error message")
    public void verify_the_status_code_and_error_message() {

        response.then(). log().all().
                statusCode(200).
                header("Content-Type", "application/json; charset=UTF-8").
              body("message", equalTo("This E-mail already in use!"));



    }
}
