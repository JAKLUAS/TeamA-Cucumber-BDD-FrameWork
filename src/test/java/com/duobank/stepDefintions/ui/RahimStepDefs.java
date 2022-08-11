package com.duobank.stepDefintions.ui;

import com.duobank.pages.RahimsPage;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class RahimStepDefs {

    @Given("I am on the credit report page")
    public void I_am_on_the_credit_report_page() {
        RahimsPage rr = new RahimsPage();
        SeleniumUtils.waitFor(3);
        assert rr.checkIfCurrent.getAttribute("class").equals("current");
    }

    @When("I click yes to order credit report")
    public void I_click_yes_to_order_credit_report() {
        RahimsPage rr = new RahimsPage();
        SeleniumUtils.waitFor(3);
        SeleniumUtils.scroll(0,-200);
        rr.clickYesCreditReport.click();
    }

    @Then("I should be able to click next button")
    public void I_should_be_able_to_click_next_button() {
        RahimsPage rr = new RahimsPage();
        rr.clickNext.click();
        SeleniumUtils.waitFor(3);

    }

    @When("I click No to order credit report")
    public void I_click_No_to_order_credit_report() {
        RahimsPage rr = new RahimsPage();
        rr.clickNoCreditReport.click();
    }


    @Given("I am on the E-consent page")
    public void iAmOnTheEConsentPage() {
        RahimsPage rr = new RahimsPage();
        SeleniumUtils.waitFor(3);
        assert rr.checkIfCreditReportDone.getAttribute("class").equals("done");
    }

    @When("I input incorrect information and click Agree")
    public void iInputIncorrectInformationAndClickAgree() {

        RahimsPage rr = new RahimsPage();
        SeleniumUtils.waitFor(3);
        Faker fakeInfo = new Faker();
        rr.inputFirstName.sendKeys(Keys.ENTER+fakeInfo.number().digits(4));
        rr.inputLastName.sendKeys(Keys.ENTER+fakeInfo.number().digits(4));
        rr.inputEmail.sendKeys(Keys.ENTER+fakeInfo.number().digits(4));
        rr.consentAgree.click();

    }

    @Then("I should not be able to click next button")
    public void iShouldNotBeAbleToClickNextButton() {
        RahimsPage rr = new RahimsPage();
        SeleniumUtils.waitFor(3);
        rr.clickNext.click();
        Assert.assertEquals(rr.checkForError.getText(),"PLEASE ENTER A VALID EMAIL ADDRESS.");


    }

    @When("I input correct information and click Agree")
    public void iInputCorrectInformationAndClickAgree() {
        RahimsPage rr = new RahimsPage();

        Faker fakeInfo = new Faker();
        rr.inputFirstName.sendKeys(Keys.ENTER+fakeInfo.name().firstName());
        rr.inputLastName.sendKeys(Keys.ENTER+fakeInfo.name().lastName());
        rr.inputEmail.sendKeys(Keys.ENTER+fakeInfo.internet().emailAddress());
        rr.consentAgree.click();
        rr.clickNext.click();
        rr.clickEconsent.click();

    }

    @When("I input correct information as list of maps")
    public void i_input_correct_information_as_list_of_maps(List<Map<String,String>> dataTable) {
        Map<String,String> map =  dataTable.get(0);
        //System.out.println(dataTable);
        RahimsPage rr = new RahimsPage();
        rr.inputFirstName.sendKeys(map.get("firstName")+ Keys.ENTER);
        rr.inputLastName.sendKeys(map.get("lastName")+ Keys.ENTER);
        rr.inputEmail.sendKeys(map.get("e-mail")+ Keys.ENTER);
    }

    @When("I input incorrect information as list of maps")
    public void i_input_incorrect_information_as_list_of_maps(List<Map<String,String>> dataTable) {
        Map<String,String> map =  dataTable.get(0);
        System.out.println(dataTable);
        RahimsPage rr = new RahimsPage();
        rr.inputFirstName.sendKeys(map.get("firstName")+ Keys.ENTER);
        rr.inputLastName.sendKeys(map.get("lastName")+ Keys.ENTER);
        rr.inputEmail.sendKeys(map.get("e-mail")+ Keys.ENTER);
    }

    @Then("I should be able to click Agree")
    public void i_should_be_able_to_click_agree() {

        RahimsPage rr = new RahimsPage();
        rr.consentAgree.click();
    }

}