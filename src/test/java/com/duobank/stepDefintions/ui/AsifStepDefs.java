package com.duobank.stepDefintions.ui;

import com.duobank.pages.AsifPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AsifStepDefs {
    @When("I should click on mortgage application")
    public void i_should_click_on_mortgage_application() {
        AsifPage mortgageDetails = new AsifPage();
        SeleniumUtils.waitFor(2);
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



//    DATATABLE AND SCENARIO OUTLINE




    @Then("I need to fill preapproval details with Realtor, Loan officer")
    public void i_need_to_fill_preapproval_details_with_realtor_loan_officer(List<List<String>> dataTable) {

        AsifPage mortgageDetails = new AsifPage();
        List<String> secondRow = dataTable.get(1);
        mortgageDetails.EnterRealtorInfo.sendKeys(secondRow.get(0),secondRow.get(1));
        mortgageDetails.EnterEstimatePrice.sendKeys(secondRow.get(2));
        mortgageDetails.EnterDownPayment.sendKeys(secondRow.get(3));


    }
    @Then("Other Type Payment")
    public void other_type_payment() {
        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickOnSourceOfDownPayment();
        Assert.assertEquals("Other type of Down Payment", Driver.getDriver().findElement(By.xpath("//span[@title='Other type of Down Payment']")).getText());
    }


    @Then("I need to enter mortgage as a mortgage amount and downPayment as a down payment")
    public void i_need_to_enter_mortgage_as_a_mortgage_amount_and_down_payment_as_a_down_payment(List<Map<String,String>> dataTable) {

        AsifPage mortgageDetails = new AsifPage();
        mortgageDetails.clickNoRealtor.click();
        mortgageDetails.clickNoLoanOfficer.click();
        Map <String,String> map = dataTable.get(0);
        mortgageDetails.EnterNegativeEstimatePrice.sendKeys(map.get("mortgage"));
        mortgageDetails.EnterDownPayment.sendKeys(map.get("downPayment"));


    }

    @Then("I need to fill preapproval details with Realtor and Loan officer, with multiple Additional Funds")
    public void i_need_to_fill_preapproval_details_with_realtor_and_loan_officer_with_multiple_additional_funds(List<String> dataTable) {

        AsifPage mortgageDetails = new AsifPage();

        mortgageDetails.EnterRealtorInfo();
        mortgageDetails.EnterEstimatePrice.sendKeys("300000");
        mortgageDetails.EnterDownPayment.sendKeys("60000");
        SeleniumUtils.scroll(0,300);
        mortgageDetails.clickOnSourceOfDownPayment();
        mortgageDetails.EnterAdditionalFunds.sendKeys(dataTable.get(3));



    }


    @Then("I need to check the Application Wizard list to be like following")
    public void i_need_to_check_the_application_wizard_list_to_be_like_following(List<String> dataTable) {

        List<String> actualList = SeleniumUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//ul[@role='tablist']")));
        List<String> expectedList = new ArrayList<>(dataTable);

        Collections.sort(actualList);
        Collections.sort(expectedList);

        Assert.assertEquals(expectedList,expectedList);

    }








}
