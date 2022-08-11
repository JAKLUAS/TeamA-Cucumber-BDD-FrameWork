package com.duobank.stepDefintions.db;

import com.duobank.stepDefintions.ui.RahimStepDefs;
import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class RahimStepDefDB {

    List<String> actualEconsentColumnNames;

    @When("I send a request to retrieve colum names for mortgage table")
    public void i_send_a_request_to_retrieve_colum_names_for_mortgage_table() {
        actualEconsentColumnNames = DBUtils.getColumnNames("select eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email from tbl_mortagage;");

        System.out.println(actualEconsentColumnNames);

    }

    @Then("It should be the following E-consent columns")
    public void it_should_be_the_following_e_consent_columns(List<String> expectedEconsentColumnNames) {
        Assert.assertEquals(expectedEconsentColumnNames, actualEconsentColumnNames);
    }

    @Then("The database should also have correctly mapped info for Econsent columns")
    public void the_database_should_also_have_correctly_mapped_info_for_econsent_columns(List<Map<String, String>> expectedEconsentData) throws SQLException {
        Map<String, String> expected = expectedEconsentData.get(0);
        String expectedFirstName = expected.get("firstName");
        String expectedLastName = expected.get("lastName");
        String expectedEmail = expected.get("e-mail");

        String query = "SELECT eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email FROM tbl_mortagage WHERE eConsent_declarer_Email = '" + expectedEmail + "'";
        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);
        Map<String, Object> actual = actualList.get(0);
        System.out.println(actual);
        String actualFirstName = (String) actual.get("eConsent_declarer_FirstName");
        String actualLastName = (String) actual.get("eConsent_declarer_LastName");
        String actualEmail = (String) actual.get("eConsent_declarer_Email");

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualFirstName).isEqualTo(expectedFirstName);
        softAssertions.assertThat(actualLastName).isEqualTo(expectedLastName);
        softAssertions.assertThat(actualEmail).isEqualTo(expectedEmail);

    }

    @Then("The database should not map info for Econsent columns")
    public void the_database_should_not_map_info_for_econsent_columns(List<Map<String, String>> expectedEconsentData) throws SQLException {

        Map<String, String> expected = expectedEconsentData.get(0);
        String expectedFirstName = expected.get("firstName");
        String expectedLastName = expected.get("lastName");
        String expectedEmail = expected.get("e-mail");

        String query = "SELECT eConsent_declarer_FirstName, eConsent_declarer_LastName, eConsent_declarer_Email FROM tbl_mortagage WHERE eConsent_declarer_Email = '" + expectedEmail + "'";
        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);
        try {
            Map<String, Object> actual = actualList.get(0);
            System.out.println(actual);
            String actualFirstName = (String) actual.get("eConsent_declarer_FirstName");
            String actualLastName = (String) actual.get("eConsent_declarer_LastName");
            String actualEmail = (String) actual.get("eConsent_declarer_Email");


            Assert.assertNotEquals(actualFirstName, expectedFirstName);
            Assert.assertNotEquals(actualLastName, expectedLastName);
            Assert.assertNotEquals(actualEmail, expectedEmail);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception");
        }


    }
}
