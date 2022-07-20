package com.duobank.stepDefintions;

import com.duobank.pages.DildoraPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DildoraStepDefs {

    @When("I am on the personal information page")
    public void i_am_on_the_personal_information_page() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.verifyPersonalPage();
    }

    @Then("I need fill out the personal information")
    public void i_need_fill_out_the_personal_information() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.clickOnFirstName();
        dildoraPage.clickOnMiddleName();
        dildoraPage.clickOnLastName();
        dildoraPage.selectSuffix();
        dildoraPage.enterSuffix();
        dildoraPage.enterEmail();
        dildoraPage.selectDateOfBirth();
        dildoraPage.enterSSN();
        dildoraPage.selectMaritalStatus();
        dildoraPage.enterMaritalStatus();
        dildoraPage.enterCellPhone();
        dildoraPage.enterHomePhone();

    }

    @Then("I should click on next the button")
    public void i_should_click_on_next_the_button() {
      DildoraPage dildoraPage = new DildoraPage();
      dildoraPage.clickNextButton();
    }
}
