package com.duobank.stepDefintions.db;

import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;

public class AsifStepDefsMeta {

    List<String> actualColumnNames;
    StringBuilder sbGen;
    int unexpectedNum;

    @When("I send request to add new title that is longer than expected length of {int}")
    public void i_send_request_to_add_new_title_that_is_longer_than_indicated_length(int expected) throws SQLException {

        sbGen = new StringBuilder();

        for (int i = 0; i < expected+20; i++) {

            sbGen.append('a');
         }

       DBUtils.executeUpdate("insert ignore into tbl_user (last_name) values ('"+sbGen+"')");

        unexpectedNum=expected;
    }

    @Then("Data should be truncated to the expected length")
    public void data_should_be_truncated_to_expected_length() {


        List<List<Object>> queryResultAsListOfLists = DBUtils.getQueryResultAsListOfLists("select last_name from tbl_user order by id desc limit 1");

        int actualLength = ((String) (queryResultAsListOfLists.get(0).get(0))).length();

        Assert.assertEquals(unexpectedNum,actualLength);
    }

    @When("I send request to select column names from mortgage table")
    public void i_send_request_to_select_column_names_from_mortgage_table() {

        actualColumnNames = DBUtils.getColumnNames("select * from tbl_mortagage limit 0;");

//        System.out.println(actualColumnNames);

    }
    @Then("It should be listed the following")
    public void it_should_be_listed_the_following(List<String> expectedColumnName) {

        Assert.assertEquals(expectedColumnName,actualColumnNames);


    }




    List<List<Object>> actualIdList;

    @When("I send a request to retrieve duplicate id numbers")
    public void i_send_a_request_to_retrieve_duplicate_id_numbers() {

       actualIdList = DBUtils.getQueryResultAsListOfLists("SELECT id FROM tbl_mortagage GROUP BY id HAVING (COUNT(*) > 1);");

    }
    @Then("The result must be empty")
    public void the_result_must_be_empty() {

        Assert.assertTrue(actualIdList.isEmpty());
    }



    List<List<Object>> expected;
    List<List<Object>> actual;


    @When("I retrieve all emails from mortgage table and checked if they are contain {string}")
    public void i_retrieve_all_emails_from_mortgage_table_and_checked_if_they_are_contain(String string) {

       expected = DBUtils.getQueryResultAsListOfLists("select count(nullif(b_email, ''))  from tbl_mortagage ;");
       actual = DBUtils.getQueryResultAsListOfLists("select (count(*)) from tbl_mortagage where b_email like '%@%';");

    }
    @Then("They all must contain mentioned symbol")
    public void they_all_must_contain_mentioned_symbol() {
     Assert.assertEquals(expected,actual);
    }






}
