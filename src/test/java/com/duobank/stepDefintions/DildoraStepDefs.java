package com.duobank.stepDefintions;

import com.duobank.pages.DildoraPage;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DildoraStepDefs {

    @When("I am on the personal information page")
    public void i_am_on_the_personal_information_page() {
        DildoraPage dildoraPage = new DildoraPage();
        SeleniumUtils.waitFor(3);
        Assert.assertEquals(dildoraPage.PersonalPageMessage.getText(),"Personal Information");

    }

    @Then("I need fill out the personal information")
    public void i_need_fill_out_the_personal_information() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterFirstName.sendKeys(Keys.ENTER+faker.name().firstName());
        dildoraPage.enterMiddleName.sendKeys(Keys.ENTER+faker.name().lastName());
        dildoraPage.enterLastName.sendKeys(Keys.ENTER+faker.name().lastName());
        dildoraPage.clickSuffix.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterSuffix.sendKeys(faker.name().suffix()+ Keys.ENTER);
        dildoraPage.enterEmailAddress.sendKeys(Keys.ENTER+faker.internet().emailAddress());
        dildoraPage.enterSSN.sendKeys(Keys.ENTER+faker.number().digits(9));
        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='b_dob']"));
        action.moveToElement(element).click().perform();
        element.sendKeys("9"+"5"+ "1988");
        dildoraPage.clickMaritalStatus.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterMaritalStatus.sendKeys("Married"+Keys.ENTER);
        dildoraPage.enterCellPhone.sendKeys(Keys.ENTER+faker.phoneNumber().cellPhone());
        dildoraPage.enterHomePhone.sendKeys(Keys.ENTER+faker.phoneNumber().phoneNumber());
        dildoraPage.clickNextButton.click();







    }

    @Then("I should click on next the button")
    public void i_should_click_on_next_the_button() {
      DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.clickNextButton.click();
    }



    @When("user want applying with a Co - Borrower’s")
    public void user_want_applying_with_a_co_borrower_s() {
        DildoraPage dildoraPage = new DildoraPage();
        SeleniumUtils.scroll(0,-200);
        dildoraPage.applyCoBorrowers.click();

    }


    @When("user enter {string} as a first name, {string} as a middle name, {string} as a last name")
    public void user_enter_as_a_first_name_as_a_middle_name_as_a_last_name(String string, String string2, String string3) {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.enterFirstName.sendKeys(string);
        dildoraPage.enterMiddleName.sendKeys(string2);
        dildoraPage.enterLastName.sendKeys(string3);
        dildoraPage.clickSuffix.click();
        SeleniumUtils.waitFor(2);
        Faker faker = new Faker();
        dildoraPage.enterSuffix.sendKeys(faker.name().suffix()+ Keys.ENTER);
    }

    @When("{int} as a month {int} as a day {int} as a year  for a DOB ,random email address")
    public void as_a_month_as_a_day_as_a_year_for_a_dob_random_email_address(Integer int1, Integer int2, Integer int3) {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterEmailAddress.sendKeys(Keys.ENTER+faker.internet().emailAddress());
        dildoraPage.enterDOB.sendKeys(int1.toString()+int2.toString()+int3.toString());
    }



    @When("write random marital status , random cell phone")
    public void write_random_marital_status_random_cell_phone() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.clickMaritalStatus.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterMaritalStatus.sendKeys("Married"+Keys.ENTER);
        dildoraPage.enterCellPhone.sendKeys(Keys.ENTER+faker.phoneNumber().cellPhone());

    }


    @When("random SSN  and random home phone")
    public void random_ssn_and_random_home_phone() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterSSN.sendKeys(Keys.ENTER+faker.number().digits(9));
        dildoraPage.enterHomePhone.sendKeys(Keys.ENTER+faker.phoneNumber().phoneNumber());
    }


    @When("add all random information about Co - Borrower’s")
    public void add_all_random_information_about_co_borrower_s() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.coBorrowerFirstName.sendKeys(Keys.ENTER+faker.name().firstName());
        dildoraPage.coBorrowerMiddleName.sendKeys(Keys.ENTER+faker.name().nameWithMiddle());
        dildoraPage.coBorrowerLastName.sendKeys(Keys.ENTER+faker.name().lastName());
        dildoraPage.coBorrowerEmailAddress.sendKeys(Keys.ENTER+faker.internet().emailAddress());
        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='c_dob']"));
        action.moveToElement(element).click().perform();
        element.sendKeys("10"+"02"+ "1987");
        dildoraPage.coBorrowerSSN.sendKeys(Keys.ENTER+faker.number().digits(9));
        dildoraPage.clickCoBorrowerMaritalStatus.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterCoBorrowerMaritalStatus.sendKeys("Married"+Keys.ENTER);
        dildoraPage.coBorrowerCellPhone.sendKeys(Keys.ENTER+ faker.phoneNumber().cellPhone());
        dildoraPage.coBorrowerHomePhone.sendKeys(Keys.ENTER+faker.phoneNumber().phoneNumber());
    }


    @Then("user should be able click on the next button.")
    public void user_should_be_able_click_on_the_next_button() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.clickNextButton.click();

    }


    @When("write random  marital status, random cell phone and random SSN")
    public void write_random_marital_status_random_cell_phone_and_random_ssn() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.clickMaritalStatus.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterMaritalStatus.sendKeys("Married"+Keys.ENTER);
        dildoraPage.enterCellPhone.sendKeys(Keys.ENTER+faker.phoneNumber().cellPhone());
        dildoraPage.enterSSN.sendKeys(Keys.ENTER+faker.number().digits(9));
    }


    @When("Co - Borrower’s don’t want to write home phone information")
    public void co_borrower_s_don_t_want_to_write_home_phone_information() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.coBorrowerHomePhone.click();
    }

    @When("user write random first name, random middle name, random last name")
    public void user_write_random_first_name_random_middle_name_random_last_name() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterFirstName.sendKeys(Keys.ENTER+faker.name().firstName());
        dildoraPage.enterMiddleName.sendKeys(Keys.ENTER+faker.name().nameWithMiddle());
        dildoraPage.enterLastName.sendKeys(Keys.ENTER+faker.name().lastName());
    }
    @When("write random email address, DOB , random marital status, random cell phone")
    public void write_random_email_address_dob_random_marital_status_random_cell_phone() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterEmailAddress.sendKeys(Keys.ENTER+faker.internet().emailAddress());
        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='b_dob']"));
        action.moveToElement(element).click().perform();
        element.sendKeys("9"+"5"+ "1988");
        dildoraPage.clickMaritalStatus.click();
        SeleniumUtils.waitFor(2);
        dildoraPage.enterMaritalStatus.sendKeys("Married"+Keys.ENTER);
        dildoraPage.enterCellPhone.sendKeys(Keys.ENTER+faker.phoneNumber().cellPhone());


    }
    @When("user don’t want write SSN number and home phone")
    public void user_don_t_want_write_ssn_number_and_home_phone() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.enterSSN.click();
        dildoraPage.enterHomePhone.click();
    }

    @Then("System must show error message.")
    public void system_must_show_error_message() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.clickNextButton.click();
        dildoraPage.errorMessage.isDisplayed();
         Assert.assertEquals("THIS FIELD IS REQUIRED.",dildoraPage.errorMessage.getText());
    }

    @When("user random write email address, random DOB")
    public void user_random_write_email_address_random_dob() {
        DildoraPage dildoraPage = new DildoraPage();
        Faker faker = new Faker();
        dildoraPage.enterEmailAddress.sendKeys(Keys.ENTER+faker.internet().emailAddress());
        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='b_dob']"));
        action.moveToElement(element).click().perform();
        element.sendKeys("3"+"10"+ "1988");
    }


    @When("user don’t want to write first name middle name, last name")
    public void user_don_t_want_to_write_first_name_middle_name_last_name() {
        DildoraPage dildoraPage = new DildoraPage();
        dildoraPage.enterFirstName.click();
        dildoraPage.enterMiddleName.click();
        dildoraPage.enterLastName.click();
    }



}
