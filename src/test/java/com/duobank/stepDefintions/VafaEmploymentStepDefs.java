package com.duobank.stepDefintions;

import com.duobank.pages.VafaPage;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;


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

    @When("User enters another employer information")
    public void user_enters_another_employer_information() {
        VafaPage vp = new VafaPage();
        vp.enterEmployerName.sendKeys("John Doe", Keys.ENTER);
        vp.enterEmployerPosition.sendKeys("Director", Keys.ENTER);
        vp.enterCity.sendKeys("Homer", Keys.ENTER);
        vp.clickAnotherEmployer.click();
        vp.clickSecondEmployerID.sendKeys("Richard Jones", Keys.ENTER);
        vp.clickSecondEmployerPosition.sendKeys("President", Keys.ENTER);
        vp.clickSecondCity.sendKeys("NY", Keys.ENTER);
        vp.clickStartDate.sendKeys("10252010", Keys.ENTER);
        vp.clickEndDate.sendKeys("11262012", Keys.ENTER);
        vp.enterGrossMonthlyIncome.sendKeys("4000", Keys.ENTER);
        vp.enterMonthlyOvertime.sendKeys("1340", Keys.ENTER);
        vp.enterMonthlyBonuses.sendKeys("4321", Keys.ENTER);
        vp.enterMonthlyCommissions.sendKeys("4566", Keys.ENTER);
        vp.enterMonthlyDividends.sendKeys("7650", Keys.ENTER);
    }

    @When("User deselects the This is my current job for First Employer")
    public void user_deselects_the_this_is_my_current_job_for_first_employer() {
        VafaPage vp = new VafaPage();
        vp.clickThisIsMyCurrentJob.click();

    }

    @When("User should be able to include start date for current job")
    public void user_should_be_able_to_include_start_date_for_current_job() {
        VafaPage vp = new VafaPage();
        vp.clickOnStartDate1.sendKeys("05012020", Keys.ENTER);
    }

    @When("User include additional gross monthly income")
    public void user_include_additional_gross_monthly_income() {
        VafaPage vp = new VafaPage();
        vp.addFirstAmount.sendKeys("2500", Keys.ENTER);
        vp.addSecondAmount.sendKeys("3246", Keys.ENTER);
        vp.addThirdAmount.sendKeys("150", Keys.ENTER);

//            public void AlimnoyDropdown(int index){
//                Select drop = new Select(vp.clickOnSelectOne);
//                drop.selectByIndex(1);

            }
    }

