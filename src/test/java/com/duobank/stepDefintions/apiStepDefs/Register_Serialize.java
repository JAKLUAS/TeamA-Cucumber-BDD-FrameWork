package com.duobank.stepDefintions.apiStepDefs;

import com.duobank.stepDefintions.Endpoints;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Register_Serialize {



    Response response;
    @When("i send a post request to the end point  with faker")
    public void i_send_a_post_request_to_the_end_point_with_faker() {
         Faker faker = new Faker();
        Map<String, Object> payload  = new HashMap<>();


        payload.put("first_name", ""+faker.name().firstName()+"");
        payload.put("last_name", ""+faker.name().lastName()+"");
        payload.put("email", ""+faker.internet().emailAddress()+"");
        payload.put("password", ""+faker.internet().password()+"");

        response = given().
                header("Accept", "application/vnd.api+json").
                contentType(ContentType.JSON).
                body(payload,ObjectMapperType.JACKSON_2).
                when(). log().all().
                post(String.valueOf(Endpoints.REGISTER));
    }


    @Then("The response should contain the following credentials")
    public void the_response_should_contain_the_following_credentials(Map<String,String> dataTable) {
        response.then(). log().all().
                statusCode(200).
                header("Content-Type", dataTable.get("Content-Type")).
                header("Server", dataTable.get("Server")).
                body("message",equalTo(dataTable.get("message")));

    }

}
