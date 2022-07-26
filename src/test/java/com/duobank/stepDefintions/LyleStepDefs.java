package com.duobank.stepDefintions;

import com.duobank.pages.LylesPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LyleStepDefs {

    @When("I am on the Expenses section")
    public void i_am_on_the_expenses_section() {
        LylesPage expenses = new LylesPage();
        SeleniumUtils.waitFor(3);
        expenses.verifyPage.click();
        Assert.assertEquals(expenses.verifyPage.getText(),"EXPENSES");

    }

    @And("I enter monthly rental payment")
    public void i_enter_monthly_rental_payment() {
        LylesPage expenses = new LylesPage();
        expenses.monthlyRental.sendKeys(Keys.ENTER , "1700");
    }

    @Then("I should click on the next button")
    public void i_should_click_on_the_next_button() {
        LylesPage expenses = new LylesPage();
        expenses.clickNext.click();
    }

    @When("I am on the Summary section")
    public void iAmOnTheSummarySection() {
        LylesPage expenses = new LylesPage();
        Assert.assertEquals(expenses.verifySummaryPage.getText(),"SUMMARY");
    }

    @And("I click on the save button")
    public void iClickOnTheSaveButton() {
        LylesPage expenses = new LylesPage();
        expenses.saveButton.click();
    }

    @Then("I should be able to apply successfully")
    public void iShouldBeAbleToApplySuccessfully() {
        LylesPage expenses = new LylesPage();
        Assert.assertEquals(expenses.successMessage.getText(),"Application Submiited Successfully");
    }

    @And("I click on edit Expenses and change to Own and amount")
    public void iClickOnEditExpensesAndChangeToOwnAndAmount() {
        LylesPage expenses = new LylesPage();
        expenses.expenseEdit.click();
        expenses.changetoOwn.click();
        expenses.mortgagePayment.sendKeys(Keys.ENTER , "2000");
        expenses.clickNext.click();
        expenses.clickNext.click();
        expenses.clickNext.click();
        expenses.clickNext.click();
        expenses.saveButton.click();
    }

    @And("I click on edit eConsent and change to Disagree")
    public void iClickOnEditEConsentAndChangeToDisagree() {
        LylesPage expenses = new LylesPage();
        expenses.eConsentEdit.click();
        expenses.consentDontAgree.click();
        expenses.clickNext.click();
        expenses.saveButton.click();

        //commit2


    }
}
