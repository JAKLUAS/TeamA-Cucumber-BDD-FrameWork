package com.duobank.stepDefintions;

import com.duobank.pages.LylesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LyleStepDefs {

    @Given("I am on the Expenses section")
    public void i_am_on_the_expenses_section() {
        LylesPage expenses = new LylesPage();
        expenses.verifyPage();

    }
    @When("I enter monthly rental payment")
    public void i_enter_monthly_rental_payment() {
        LylesPage expenses = new LylesPage();
        expenses.enterMonthlyRental();

    }
    @Then("I should click on the next button")
    public void i_should_click_on_the_next_button() {
        LylesPage expenses = new LylesPage();
        expenses.clickNext();
    }

}
