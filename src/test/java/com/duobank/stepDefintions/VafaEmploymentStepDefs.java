package com.duobank.stepDefintions;

import com.duobank.pages.VafaPage;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;


public class VafaEmploymentStepDefs {

    @Given("User on the employment and income page")
    public void user_on_the_employment_and_income_page() {
        VafaPage vp = new VafaPage();
        vp.verifyEmploymentPage.click();
    }


    @When("User enters all the necessary information")
    public void user_enters_all_the_necessary_information() {
        VafaPage vp = new VafaPage();
        SeleniumUtils.scroll(0, 300);
        vp.enterEmployerName.sendKeys("John Doe", Keys.ENTER);
        vp.enterEmployerPosition.sendKeys("Director", Keys.ENTER);
        vp.enterCity.sendKeys("Homer", Keys.ENTER);
        vp.enterGrossMonthlyIncome.sendKeys("100000", Keys.ENTER);
        vp.enterMonthlyOvertime.sendKeys("5000", Keys.ENTER);
        vp.enterMonthlyBonuses.sendKeys("2000", Keys.ENTER);
        vp.enterMonthlyCommissions.sendKeys("2550", Keys.ENTER);
        vp.enterMonthlyDividends.sendKeys("3240", Keys.ENTER);
    }


    @Then("the user should be able to click on next button")
    public void the_user_should_be_able_to_click_on_next_button() {
        VafaPage vp = new VafaPage();
        vp.clickNext.click();
    }
}
