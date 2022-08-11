package com.duobank.stepDefintions.db;

import com.duobank.pages.HomePage;
import com.duobank.pages.LylesPage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.DBUtils;
import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LyleStefDefDB {

    SoftAssertions softAssertions;

    @And("database should also have the same mapped info")
    public void databaseShouldAlsoHaveTheSameMappedInfo(List<Map<String, String>> expectedList) throws SQLException {


        Map<String, String> expected = expectedList.get(0);
        String expectedEstPurchasePrice = expected.get("ESTIMATED PURCHASE PRICE");
        String expectedEstDownPayment = expected.get("DOWN PAYMENT AMOUNT");


        String query = "SELECT est_purchase_price, down_payment from tbl_mortagage where est_purchase_price ='" + expectedEstPurchasePrice + "'";

        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);

        Map<String, Object> actual = actualList.get(0);

        String actualEstPurchasePrice = (String) (actual.get("est_purchase_price"));
        String actualEstDownPayment = (String) (actual.get("down_payment"));

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualEstPurchasePrice).isEqualTo(expectedEstPurchasePrice);
        softAssertions.assertThat(expectedEstDownPayment).isEqualTo(actualEstDownPayment);


        DBUtils.executeUpdate("DELETE from tbl_mortagage where est_purchase_price='" + expectedEstPurchasePrice + "'");


        softAssertions.assertAll();

    }
    Map<String, String> data;
    @When("I modify Database Econsent by changing the name, lastname and email")
    public void iModifyDatabaseEconsentByChangingTheNameLastnameAndEmail(List<Map<String, String>> dataTable) throws SQLException {

        data = dataTable.get(0);

        String query = "INSERT ignore INTO tbl_mortagage (eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email) values ( '"+data.get("firstName")+"', '"+data.get("lastName")+"', '"+data.get("emailAddress")+"')";


        DBUtils.executeUpdate(query);

    }

    @Then("I should be able to log in with the same modifying information for Econsent in the UI")
    public void iShouldBeAbleToLogInWithTheSameModifyingInformationForEconsentInTheUI() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        HomePage homePage = new HomePage();
        homePage.enterCredentialsAndlogin("halil.dkmn@gmail.com","Halildikmen1");
        homePage.clickOnTheLogin();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());
    }

    @And("all the information that i edited should be correct")
    public void allTheInformationThatIEditedShouldBeCorrect() {
        LylesPage lylesPage = new LylesPage();
        String actualFirstName = lylesPage.econsentFirstName.getText();
        String actualLastName = lylesPage.econsentLastName.getText();
        String actualEmail =  lylesPage.econsentEmail.getText();

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualFirstName).isEqualTo(data.get("firstName"));
        softAssertions.assertThat(actualLastName).isEqualTo(data.get("lastName"));
        softAssertions.assertThat(actualEmail).isEqualTo(data.get("emailAddress"));
    }

    @Then("I should be able to edit eConsent using same info from UI")
    public void iShouldBeAbleToEditEConsentUsingSameInfoFromUI() {

        LylesPage sprint5 = new LylesPage();
        sprint5.eConsentEdit.click();
        SeleniumUtils.waitFor(2);


        new LylesPage().editEConsentDetails(data.get("firstName"),
                data.get("lastName"),
                data.get("emailAddress"));


        sprint5.clickNext.click();
        sprint5.saveButton.click();
    }
}

