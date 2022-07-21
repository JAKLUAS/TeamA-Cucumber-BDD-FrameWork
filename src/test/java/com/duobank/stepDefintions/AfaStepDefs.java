package com.duobank.stepDefintions;

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
import org.openqa.selenium.Keys;

import java.util.Set;

public class AfaStepDefs {


    @Then("I should be able to sign in successfully")
    public void i_should_be_able_to_sign_in_successfully() {
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/applications.php", Driver.getDriver().getCurrentUrl());
    }

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


}
