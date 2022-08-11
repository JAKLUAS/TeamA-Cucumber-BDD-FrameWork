package com.duobank.stepDefintions.db;

import com.duobank.pages.AsifPage;
import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class AsifStepDefsDB {

    SoftAssertions softAssertions;

    @Then("The database should also have correctly mapped information for payment")
    public void the_database_should_also_have_correctly_mapped_information_for_payment(List<Map<String, String>> expectedList) throws SQLException {

        Map<String, String> expected = expectedList.get(0);

        System.out.println(expected);

        String expectedFirst = expected.get("realtor_info");
        String expectedPhone = expected.get("b_cell");
        String expectedEstPrice = expected.get("est_purchase_price");
        String expectedDownPayment = expected.get("down_payment");

        System.out.println(expectedPhone);

        String query = "select realtor_info, b_cell, est_purchase_price, down_payment  from tbl_mortagage where b_cell='" + expectedPhone + "'";

        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);

        System.out.println(actualList);

        Map<String, Object> actual = actualList.get(0);

//        System.out.println(actual);

        String actualFirst = (String) (actual.get("realtor_info"));
        String actualPhone = (String) (actual.get("b_cell"));
        String actualEstPrice = (String) (actual.get("est_purchase_price"));
        String actualDownPayment = (String) (actual.get("down_payment"));

        System.out.println(actualPhone);

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualFirst).isEqualTo(expectedFirst);
        softAssertions.assertThat(actualPhone).isEqualTo(expectedPhone);
        softAssertions.assertThat(actualEstPrice).isEqualTo(expectedEstPrice);
        softAssertions.assertThat(actualDownPayment).isEqualTo(expectedDownPayment);

        DBUtils.executeUpdate("DELETE from tbl_mortagage WHERE b_cell='" + expectedPhone + "'");

        // softAssertions.assertAll();


    }

    Map<String, String> data;


    @When("I add new user to database for application")
    public void i_add_new_user_to_database_for_application(List<Map<String, String>> dataTable) throws SQLException {

        data = dataTable.get(0);
        String query = "insert ignore into tbl_mortagage (realtor_info, b_cell, est_purchase_price, down_payment) values ('" + data.get("realtor_info") + "', '" + data.get("b_cell") + "', '" + data.get("est_purchase_price") + "', '" + data.get("down_payment") + "')";
        System.out.println(query);
        DBUtils.executeUpdate(query);
    }

    @Then("I should be able to fill preapproval details with Realtor, Loan officer")
    public void i_should_be_able_to_fill_preapproval_details_with_realtor_loan_officer() {

        AsifPage mortgageDetails = new AsifPage();

        mortgageDetails.EnterRealtorInfo.sendKeys(data.get("realtor_info"), data.get("b_cell"));
        mortgageDetails.EnterEstimatePrice.sendKeys(data.get("est_purchase_price"));
        mortgageDetails.EnterDownPayment.sendKeys(data.get("down_payment"));

    }
}
