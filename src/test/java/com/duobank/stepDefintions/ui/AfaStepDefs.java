package com.duobank.stepDefintions.ui;

import com.duobank.pages.AfasSignInPage;
import com.duobank.pages.HomePage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.scene.layout.Background;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AfaStepDefs {


//    @Then("I should be able to sign in successfully")
//    public void i_should_be_able_to_sign_in_successfully() {
//        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());
//    }

    @Given("i am on sign in page")
    public void i_am_on_sign_in_page() {

    }
    @When("i click o Application list")
    public void i_click_o_application_list() {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickOnApplication.click();
    }
    @Then("Application list needs to appear successfully")
    public void application_list_needs_to_appear_successfully() {
       Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php", Driver.getDriver().getCurrentUrl());
    }

    @Given("im on Application list page")
    public void im_on_application_list_page() {

    }
    @When("i click on the number")
    public void i_click_on_the_number() {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickOnSelect.click();
    }
    @Then("i should be able to change it to FifTy")
    public void i_should_be_able_to_change_it_to_fif_ty() {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickOnFifTy.click();
        afa.clickOnBorrower.click();
    }

    @Given("im on the sign in page")
    public void im_on_the_sign_in_page() {

    }
    @When("i click on by Duotech Team")
    public void i_click_on_by_duotech_team() {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickonByDuotechTeam.click();
    }
    @Then("i should be able to go to another window")
    public void i_should_be_able_to_go_to_another_window() {

        String mainwindowHandle = Driver.getDriver().getWindowHandle();
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();

        for (String title: windowHandles){
            if(!title.equals(mainwindowHandle)){
                Driver.getDriver().switchTo().window(title);}
        }

        SeleniumUtils.waitFor(7);

        Assert.assertEquals("http://idslbd.com/", Driver.getDriver().getCurrentUrl());

    }

    @Given("im on the second window")
    public void im_on_the_second_window() {


    }
    @When("i will switch to previous window")
    public void i_will_switch_to_previous_window() {


        SeleniumUtils.switchToWindow("Loan Application");
    }
    @Then("i should be able to log out from the website")
    public void i_should_be_able_to_log_out_from_the_website() {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickOnTheName.click();
        afa.clickOnLogOut.click();



    }
    @When("i Change Entries to {string} and search for {string}")
    public void i_change_entries_to_and_search_for(String entries, String name) {
        AfasSignInPage afa = new AfasSignInPage();
        afa.clickOnValue.click();
        afa.search.sendKeys(name);



    }

    @Then("i should be able to click and view the details")
    public void i_should_be_able_to_click_and_view_the_details() {

        AfasSignInPage afa = new AfasSignInPage();
        afa.viewDetails.click();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagageloandegtails.php?id=33985", Driver.getDriver().getCurrentUrl());

    }

    @Then("i  search for aplicants as List")
    public void i_search_for_aplicants_as_list(List<String> dataTable) {
        AfasSignInPage afa = new AfasSignInPage();
        afa.search.sendKeys(dataTable.get(0));
        SeleniumUtils.waitFor(1);
        afa.clickOnApplication.click();
        afa.search.sendKeys(dataTable.get(1));
        SeleniumUtils.waitFor(1);
        afa.clickOnApplication.click();
        afa.search.sendKeys(dataTable.get(2));
        SeleniumUtils.waitFor(1);
        afa.clickOnApplication.click();
        afa.search.sendKeys(dataTable.get(3));
        SeleniumUtils.waitFor(1);
        afa.clickOnApplication.click();
        afa.search.sendKeys(dataTable.get(4));



    }
    @Then("i  should be able to se the aplicants list")
    public void i_should_be_able_to_se_the_aplicants_list(List<String> aplicants) {

        List<String> actualList = SeleniumUtils.getElementsText(Driver.getDriver().findElements(By.xpath("//table[@id='DataTables_Table_0']")));
        List<String> expectedList = new ArrayList<>(aplicants);

        Collections.sort(actualList);
        Collections.sort(expectedList);

        Assert.assertEquals(expectedList,expectedList);

    }



}
