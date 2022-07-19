package com.duobank.stepDefintions;

import com.duobank.pages.HomePage;
import com.duobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HalilSinginStepDefs {

    @When("I enter valid credentials.")
    public void i_enter_valid_credentials() {
        HomePage homePage = new HomePage();
        homePage.enterCredentialsAndlogin("halil.dkmn@gmail.com","Halildikmen1");
        homePage.clickOnTheLogin();
    }
    @Then("I should be able to sing in successfully")
    public void i_should_be_able_to_sing_in_successfully() {

        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());

    }

}
