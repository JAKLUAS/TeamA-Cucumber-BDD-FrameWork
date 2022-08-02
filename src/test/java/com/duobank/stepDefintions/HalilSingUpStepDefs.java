package com.duobank.stepDefintions;

import com.duobank.pages.AsifPage;
import com.duobank.pages.HomePage;
import com.duobank.utilities.CSVReader;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.Driver;

import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HalilSingUpStepDefs {

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I navigate to singup page and enter valid credentials.")
    public void i_navigate_to_singup_page_and_enter_valid_credentials() {

        HomePage homePage = new HomePage();
        homePage.clickOnSignUpPageLink();
        Faker faker = new Faker();
        homePage.enterCredentialsAndClick(faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.internet().password());

    }
    @Then("I should be able to sing up successfully")
    public void i_should_be_able_to_sing_up_successfully() {


        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php",Driver.getDriver().getCurrentUrl());
    }
    @When("I navigate to signup page and enter invalid credentials")
    public void i_navigate_to_signup_page_and_enter_invalid_credentials() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignUpPageLink();
        Faker faker = new Faker();
        homePage.enterCredentialsAndClick(faker.name().firstName(),
                faker.name().lastName(),
                "dcsvvdsg",
                faker.internet().password());
    }
    @Then("I should not be able to sign up")
    public void i_should_not_be_able_to_sign_up() {
        Assert.assertNotEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());

    }

    @When("I navigate to signup page and enter no credentials")
    public void i_navigate_to_signup_page_and_enter_no_credentials() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignUpPageLink();

        homePage.enterCredentialsAndClick("",
                "",
                "",
                "");
    }

    @When("I navigate to singup page and enter valid credentials as list of maps .")
    public void i_navigate_to_singup_page_and_enter_valid_credentials_as_list_of_maps(List<Map<String,String>> dataTable) {

        HomePage homePage = new HomePage();
        homePage.clickOnSignUpPageLink();

        Map <String,String> map =  dataTable.get(0);
        System.out.println(dataTable);
        new HomePage().enterCredentialsAndClick(
                map.get("firstname"),
                map.get("lastname"),
                map.get("email"),
                map.get("password"));
    }


    @When("I navigate to signup page")
    public void i_navigate_to_signup_page() {
        HomePage homePage = new HomePage();
        homePage.clickOnSignUpPageLink();
    }
    @Then("I read the signup information from csv file and enter the details and should be able to sign up successfully")
    public void i_read_the_signup_information_from_csv_file_and_enter_the_details_and_should_be_able_to_sign_up_successfully() throws IOException {

        SoftAssertions softAssertions = new SoftAssertions();
        List<List<String>> data = CSVReader.readFromCSV("src/test/resources/testData/user-Data.csv");

        for (List<String> each : data) {
            new HomePage().enterCredentialsAndClick(
                    each.get(0),
                    each.get(1),
                    each.get(2),
                    each.get(3));

            softAssertions.assertThat( Driver.getDriver().getCurrentUrl()).isEqualTo("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

            new HomePage().clickOnSignUpPageLink();


        }

        softAssertions.assertAll();
    }


}
