package com.duobank.stepDefintions.apiStepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class A_register {

    Response response;

    @When("I send a Post request to {string} endpoint with the following info")
    public void i_send_a_post_request_to_endpoint_with_the_following_info(String endpoint, Map<String,String> dataTable) {
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
    @Then("The info should contain the following")
    public void the_info_should_contain_the_following(Map<String,String> dataTable) {

        response.then(). log().all().
                statusCode(200).
                header("message", dataTable.get("You have successfully registered.")).
                header("success", dataTable.get(1));

    }



    @When("I send a post request to the end point with ID number")
    public void i_send_a_post_request_to_the_end_point_with_id_number() {

        response = given().
                header("Accept", "application/vnd.api+json").

                contentType(ContentType.JSON).
                body("{\n" +
                        "    \"id\":666\n" +
                        "}").
                when(). log().all().
                post("mortagagedetails.php");

    }
    @Then("verify the following info")
    public void verify_the_following_info(Map<String,String> dataTable) {

        response.then(). log().all().

                header("user_id", dataTable.get(3407)).
                header("first_mortagage_total_payment", dataTable.get(720631)).
                header("rent_own_status", dataTable.get("Own")).
                header("b_suffix", dataTable.get("III"));




    }

}
