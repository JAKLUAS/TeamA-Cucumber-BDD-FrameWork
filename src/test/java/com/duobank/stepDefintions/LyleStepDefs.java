package com.duobank.stepDefintions;

import com.duobank.pages.LylesPage;
import com.duobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LyleStepDefs {

    @When("I am on the Expenses section")
    public void i_am_on_the_expenses_section() {
        LylesPage expenses = new LylesPage();
        Assert.assertEquals(expenses.verifyPage.getText(),"EXPENSES");
    }

    @And("I enter monthly rental payment")
    public void i_enter_monthly_rental_payment() {
        LylesPage expenses = new LylesPage();
        expenses.monthlyRental.sendKeys(Keys.ENTER, "1700");

    }
    @Then("I should click on the next button")
    public void i_should_click_on_the_next_button() {
        LylesPage expenses = new LylesPage();
        expenses.clickNext.click();
    }

}
