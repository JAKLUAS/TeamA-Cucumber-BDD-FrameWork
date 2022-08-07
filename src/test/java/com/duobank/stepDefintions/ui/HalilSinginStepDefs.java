package com.duobank.stepDefintions.ui;


import com.duobank.pages.HomePage;
import com.duobank.utilities.Driver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



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


    @When("I enter {string} as a username and {string} as password")
    public void i_enter_as_a_username_and_as_password(String email1, String pass1) {

        HomePage homePage = new HomePage();
        homePage.signINEmail.sendKeys(email1);
        homePage.signINPassword.sendKeys(pass1 + Keys.ENTER);
    }

    @Then("I should be able to sign in successfully  and the name should be {string}")
    public void i_should_be_able_to_sing_in_successfully_and_the_name_should_be(String fullname) {

        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());

        Assert.assertEquals(fullname, Driver.getDriver().findElement(By.xpath("//div[@class='user-nav d-sm-flex d-none']")).getText());


    }


}
