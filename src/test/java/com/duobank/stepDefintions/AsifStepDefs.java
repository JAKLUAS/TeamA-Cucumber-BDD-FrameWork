package com.duobank.stepDefintions;

import com.duobank.pages.AsifPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AsifStepDefs {
    @When("I should click on mortgage application")
    public void i_should_click_on_mortgage_application() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnMortgage.click();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagage.php", Driver.getDriver().getCurrentUrl());

    }

    @Then("I need to fill preapproval details")
    public void i_need_to_fill_preapproval_details() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickNoRealtor.click();
        mortgageDetails.clickNoLoanOfficer.click();
        mortgageDetails.EnterEstimatePrice.sendKeys("300000");
        mortgageDetails.EnterDownPayment.sendKeys("60000");

    }

    @Then("I should push next button")
    public void i_should_push_next_button() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnNext.click();
        SeleniumUtils.waitFor(3);
        Assert.assertTrue( Driver.getDriver().findElement(By.xpath("//label[@for='proposalTitle1']")).isDisplayed());

    }
    @Then("I should push next negative button")
    public void i_should_push_next_negative_button() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnNext.click();

    }


    @Then("I need to fill preapproval details with negative price")
    public void i_need_to_fill_preapproval_details_with_negative_price() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.EnterRealtorInfo();
        mortgageDetails.EnterNegativeEstimatePrice.sendKeys("-300000");
        mortgageDetails.EnterDownPayment.sendKeys("60000");
        Assert.assertEquals("PLEASE ENTER A VALUE GREATER THAN OR EQUAL TO 1.", Driver.getDriver().findElement(By.id("estimatedprice-error")).getText());
    }

    @Then("I need to fill preapproval details with Realtor, Loan officer and Other Type Payment")
    public void i_need_to_fill_preapproval_details_with_realtor_loan_officer_and_other_type_payment() {

        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.EnterRealtorInfo();
        mortgageDetails.EnterEstimatePrice.sendKeys("300000");
        mortgageDetails.EnterDownPayment.sendKeys("60000");
        SeleniumUtils.scroll(0,200);
        mortgageDetails.clickOnSourceOfDownPayment();
        Assert.assertEquals("Other type of Down Payment", Driver.getDriver().findElement(By.xpath("//span[@title='Other type of Down Payment']")).getText());

    }


    @Then("I need to fill preapproval details with Realtor and Loan officer, with Additional Funds")
    public void i_need_to_fill_preapproval_details_with_realtor_and_loan_officer_with_additional_funds() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.EnterRealtorInfo();
        mortgageDetails.EnterEstimatePrice.sendKeys("300000");
        mortgageDetails.EnterDownPayment.sendKeys("60000");
        SeleniumUtils.scroll(0,300);
        mortgageDetails.clickOnSourceOfDownPayment();
        mortgageDetails.EnterAdditionalFunds.sendKeys("50000");

    }



}
