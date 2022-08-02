package com.duobank.stepDefintions;
import com.duobank.pages.VafaPage;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;


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
            }


//            Sprint 5


    @When("User enters the following credentials")
    public void user_enters_the_following_credentials(List<List<String>> dataTable) {
        List<String > employerDetails =  dataTable.get(1);
        System.out.println(dataTable);
        new VafaPage().enterCredentialsAndClick(employerDetails.get(0),
                employerDetails.get(1),
                employerDetails.get(2),
                employerDetails.get(3));

    }

    @When("user_enters_another_employer_information_with_the_following_credentials")
    public void user_enters_another_employer_information_with_the_following_credentials(List<List<String>> dataTable) {
        List<String > secondEmployerDetails =  dataTable.get(1);
        System.out.println(dataTable);
        new VafaPage().enterSecondEmployerAndClick(secondEmployerDetails.get(0),
                secondEmployerDetails.get(1),
                secondEmployerDetails.get(2),
                secondEmployerDetails.get(3),
                secondEmployerDetails.get(4));
    }


    @When("User enters another employer information with the following credentials including the following Gross Monthly Employment Income")
    public void user_enters_another_employer_information_with_the_following_credentials_including_the_following_gross_monthly_employment_income(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
            Map<String,String> additionalIncome = dataTable.get(0);
            new VafaPage().enterAdditionalInfoAndClick(additionalIncome.get("Employer Name2"),
                    additionalIncome.get("Employer Position2"),
                    additionalIncome.get("City2"),
                    additionalIncome.get("Start Date2"),
                    additionalIncome.get("Gross Monthly Income2"),
                    additionalIncome.get("Monthly Overtime"),
                    additionalIncome.get("Monthly Bonuses"),
                    additionalIncome.get("Monthly Commissions"),
                    additionalIncome.get("Monthly Dividends"));

        }

    @When("User enters another employer information with THREE ADDITIONAL INCOME SOURCES")
    public void user_enters_another_employer_information_with_three_additional_income_sources(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        Map<String,String> threeIncomes = dataTable.get(0);
        new VafaPage().enterAdditionalIncomeAndClick(threeIncomes.get("Employer Name2"),
                threeIncomes.get("Employer Position2"),
                threeIncomes.get("City2"),
                threeIncomes.get("Start Date2"),
                threeIncomes.get("Gross Monthly Income2"),
                threeIncomes.get("Additional Gross Monthly Income"));
    }

    }








