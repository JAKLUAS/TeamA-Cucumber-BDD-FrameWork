package com.duobank.stepDefintions;

import com.duobank.pages.AsifPage;
import com.duobank.pages.LylesPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class LyleStepDefs{

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
        expenses.verifySummaryPage.click();
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


    }


    @And("I click on edit PreApproval details")
    public void iClickOnEditPreApprovalDetails(List<Map<String, String>> dataTable) {

        LylesPage sprint4 = new LylesPage();
        SeleniumUtils.scroll(0,-200);

        sprint4.preapprovalEdit.click();
        SeleniumUtils.waitFor(2);

        Map<String,String> map = dataTable.get(0);
        new LylesPage().editPreapprovalDetails(map.get("ESTIMATED PURCHASE PRICE"),
                map.get("DOWN PAYMENT AMOUNT"));


        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.saveButton.click();

    }

    @And("I click on edit eConsent and change the name, lastname and email")
    public void iClickOnEditEConsentAndChangeTheNameLastnameAndEmail(List<List<String>> dataTable) {

        LylesPage sprint4 = new LylesPage();
        sprint4.eConsentEdit.click();
        SeleniumUtils.waitFor(2);

        List<String > secondRow =  dataTable.get(1);
        new LylesPage().editEConsentDetails(secondRow.get(0),
                secondRow.get(1),
                secondRow.get(2));

        sprint4.clickNext.click();
        sprint4.saveButton.click();
    }

    @And("I click on edit Employment & Income with some details")
    public void iClickOnEditEmploymentIncomeWithSomeDetails(List<Map<String, String>> dataTable) {

        LylesPage sprint4 = new LylesPage();
        sprint4.employmentAndIncomeEdit.click();
        SeleniumUtils.waitFor(4);

        Map<String,String> map = dataTable.get(0);
        new LylesPage().editEmploymentAndIncome(map.get("Gross Monthly Income"),
                map.get("Monthly Overtime"),
                map.get("Monthly Bonuses"),
                map.get("Monthly Commissions"),
                map.get("Monthly Dividents"));

        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.saveButton.click();
    }

    @And("I click on edit Personal Details with necessary information")
    public void iClickOnEditPersonalDetailsWithNecessaryInformation(List<Map<String, String>> dataTable) {

        LylesPage sprint4 = new LylesPage();
        sprint4.personalDetailsEdit.click();
        SeleniumUtils.waitFor(5);

        Map<String,String> map = dataTable.get(0);
        Faker faker = new Faker();

        new LylesPage().editPersonalDetails(map.get("FirstName"),
                map.get("MiddleName"),
                map.get("LastName"));

        sprint4.EmailAddress.sendKeys(Keys.CONTROL, Keys.chord("a"), faker.internet().emailAddress());
        sprint4.SSN.sendKeys(Keys.CONTROL, Keys.chord("a"), faker.number().digits(9));

        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.clickNext.click();
        sprint4.saveButton.click();
    }
}