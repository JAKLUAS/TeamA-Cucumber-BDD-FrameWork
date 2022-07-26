package com.duobank.stepDefintions;

import com.duobank.pages.RahimsPage;
import com.duobank.pages.VafaPage;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

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

}
