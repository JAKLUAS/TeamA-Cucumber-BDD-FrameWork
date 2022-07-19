package com.duobank.stepDefintions;

import com.duobank.pages.HomePage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.Driver;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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



}
