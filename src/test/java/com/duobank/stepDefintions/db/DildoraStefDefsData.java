package com.duobank.stepDefintions.db;

import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DildoraStefDefsData {


    StringBuilder firstname;
    int unexpectedTotal;
    @When("I send a request to add a new b_firstName that is more than the expected length of {int}")
    public void i_send_a_request_to_add_a_new_b_first_name_that_is_more_than_the_expected_length_of(int expectedNum) throws SQLException {

        firstname=new StringBuilder();
        for (int i = 0; i < expectedNum+30; i++) {

            firstname.append('d');

        }

        DBUtils.executeUpdate("Insert Ignore into tbl_mortagage (b_firstName ) values ('"+firstname+"');");
        unexpectedTotal=expectedNum;
    }






    @Then("The data should be truncated to the expected size")
    public void the_data_should_be_truncated_to_the_expected_size() {

        List<List<Object>> queryResultAsListOfLists =  DBUtils.getQueryResultAsListOfLists("Select b_firstName from  tbl_mortagage order by id desc limit 8");
         int actualSize = ((String)(queryResultAsListOfLists.get(0).get(0))).length();
        Assert.assertEquals(unexpectedTotal,actualSize);
    }





    StringBuilder marital;
    int unexpectedSum;
    @When("I send a request to add a new b_marital that is more than the expected length of {int}")
    public void i_send_a_request_to_add_a_new_b_marital_that_is_more_than_the_expected_length_of(int expected) throws SQLException {

        marital=new StringBuilder();
        for (int i = 0; i < expected+50; i++) {

            marital.append('s');

        }

        DBUtils.executeUpdate("Insert Ignore into tbl_mortagage (b_marital ) values ('"+marital+"');");
        unexpectedSum=expected;

    }



    @Then("Data should be truncated to the expected size")
    public void data_should_be_truncated_to_the_expected_size() {
        List<List<Object>> queryResultAsListOfLists =  DBUtils.getQueryResultAsListOfLists("Select b_marital from  tbl_mortagage order by id desc limit 5");
        int actualSize = ((String)(queryResultAsListOfLists.get(0).get(0))).length();
        Assert.assertEquals(unexpectedSum,actualSize);
    }

    List<List<Object>> actualSSNList;
    @When("I send a request to retrieve duplicate SSN numbers")
    public void i_send_a_request_to_retrieve_duplicate_ssn_numbers() {
        actualSSNList = DBUtils.getQueryResultAsListOfLists("  Select b_ssn, count(*) from tbl_mortagage group by b_ssn having count(*)>1;");
    }



    @Then("The result must be empty in the test case")
    public void the_result_must_be_empty_in_the_test_case() {
        Assert.assertTrue(actualSSNList.isEmpty());

    }

    SoftAssertions softAssertions;

    @Then("Data base should also have correct information")
    public void data_base_should_also_have_correct_information(List<Map<String,String>> dataTable) {
        Map<String, String> expected = dataTable.get(0);
        String expectedFirst= expected.get("firstName");
        String expectedMiddle= expected.get("middleName");
        String expectedLast= expected.get("lastName");
        String expectedEmail= expected.get("email");
        String expectedDateOfBirth= expected.get("dateOfBirth");
        String expectedSSN= expected.get("SSN");
        String expectedMaritalStatus= expected.get("maritalStatus");
        String expectedCellPhone= expected.get("cellPhone");
        String expectedHomePhone= expected.get("homePhone");

        String query = "select b_firstName, b_middleName, b_lastName,b_dob, b_ssn, b_marital, b_cell, b_home from  tbl_mortagage  where b_email= '"+expectedEmail+"';";


        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);

        Map<String, Object> actual = actualList.get(0);


        String actualFirst = (String) (actual.get("firstName"));
        String actualMiddle = (String) (actual.get("middleName"));
        String actualLast = (String) (actual.get("firstLast"));
        String actualEmail = (String) (actual.get("email"));
        String actualDOB = (String) (actual.get("dateOfBirth"));
        String actualSSN = (String) (actual.get("SSN"));
        String actualMarital = (String) (actual.get("maritalStatus"));
        String actualCellPhone = (String) (actual.get("cellPhone"));
        String actualHomePhone = (String) (actual.get("homePhone"));

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualFirst ).isEqualTo(expectedFirst);
        softAssertions.assertThat(actualMiddle ).isEqualTo(expectedMiddle);
        softAssertions.assertThat(actualLast).isEqualTo(expectedLast);
        softAssertions.assertThat(actualEmail).isEqualTo(expectedEmail);
        softAssertions.assertThat(actualDOB).isEqualTo(expectedDateOfBirth);
        softAssertions.assertThat(actualSSN).isEqualTo(expectedSSN);
        softAssertions.assertThat(actualMarital).isEqualTo(expectedMaritalStatus);
        softAssertions.assertThat(actualCellPhone).isEqualTo(expectedCellPhone);
        softAssertions.assertThat(actualHomePhone).isEqualTo(expectedHomePhone);



    }

}




