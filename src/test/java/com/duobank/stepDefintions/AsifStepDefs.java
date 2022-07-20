package com.duobank.stepDefintions;

import com.duobank.pages.AsifPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AsifStepDefs {
    @When("I should click on mortgage application")
    public void i_should_click_on_mortgage_application() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnMortgage();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagage.php", Driver.getDriver().getCurrentUrl());


    }

    @Then("I need to fill preapproval details")
    public void i_need_to_fill_preapproval_details() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickNoRealtor();
        mortgageDetails.clickNoLoanOfficer();
        mortgageDetails.EnterEstimatePrice();
        mortgageDetails.EnterDownPayment();



    }
    @Then("I should push next button")
    public void i_should_push_next_button() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnNext();



    }
}
