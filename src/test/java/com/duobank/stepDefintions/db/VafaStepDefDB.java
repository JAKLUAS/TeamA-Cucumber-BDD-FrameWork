package com.duobank.stepDefintions.db;


import com.duobank.utilities.DBUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class VafaStepDefDB {

    @Then("The database should also have the same info for Employment and Income columns")
    public void the_database_should_also_have_the_same_info_for_employment_and_income_columns(List<Map<String, String>> expectedEmploymentData) throws SQLException {


Map<String, String> expected = expectedEmploymentData.get(0);
String expectedEmployerName = expected.get("employer_name");
String expectedPosition = expected.get("position");
String expectedCity = expected.get("city");
String expectedStartDate = expected.get("start_date");
String expectedMonthlyIncome = expected.get("gross_monthly_income");
String query = "SELECT employer_name, position, city, start_date, gross_monthly_income FROM tbl_mortagage WHERE gross_monthly_income = '" + expectedMonthlyIncome + "'";
List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);

Map<String, Object> actual = actualList.get(0);

String actualEmployerName = (String) actual.get("employer_name");
String actualPosition = (String) actual.get("position");
String actualCity = (String) actual.get("city");
String actualStartDate = (String) actual.get("start_date");
String actualMonthlyIncome = (String) actual.get("gross_monthly_income");
SoftAssertions softAssertions = new SoftAssertions();
softAssertions.assertThat(actualEmployerName).isEqualTo(expectedEmployerName);
softAssertions.assertThat(actualPosition).isEqualTo(expectedPosition);
softAssertions.assertThat(actualCity).isEqualTo(expectedCity);
softAssertions.assertThat(actualStartDate).isEqualTo(expectedStartDate);
softAssertions.assertThat(actualMonthlyIncome).isEqualTo(expectedMonthlyIncome);

    }

    List<String> actualEmploymentColumnNames;
    @When("I send a request to retrieve colum names for mortagage table")
    public void i_send_a_request_to_retrieve_colum_names_for_mortagage_table() {
        actualEmploymentColumnNames = DBUtils.getColumnNames("SELECT employer_name, position, city, start_date, end_date, current_job, co_employer_name, co_position, co_city, co_state, co_start_date, co_end_date, co_current_job, gross_monthly_income, monthly_over_time, monthly_bonuses, monthly_commision, monthly_dividents, c_gross_monthly_income, c_monthly_over_time, c_monthly_bonuses, c_monthly_commision, c_monthly_dividents, add_belong, income_source, amount FROM tbl_mortagage;");

        System.out.println(actualEmploymentColumnNames);
    }
    @Then("I should be able to see following Employment and Income columns")
    public void i_should_be_able_to_see_following_employment_and_income_columns(List<String> expectedEmploymentColumnNames) {
        Assert.assertEquals(expectedEmploymentColumnNames, actualEmploymentColumnNames);
    }

        List<List<Object>> actualList;
    @When("I send a request to retrieve duplicate IDs")
    public void i_send_a_request_to_retrieve_duplicate_i_ds() {
        actualList = DBUtils.getQueryResultAsListOfLists("SELECT id, count(*) FROM tbl_mortagage GROUP BY id HAVING (COUNT(*) > 1)");
    }
    @Then("The result should show as empty")
    public void the_result_should_show_as_empty() {
        Assert.assertTrue(actualList.isEmpty());

    }


    List<List<Object>> actualDownpaymentList;
    @When("I send a request to retrieve minimum down-payment")
    public void i_send_a_request_to_retrieve_minimum_down_payment() {
        actualDownpaymentList = DBUtils.getQueryResultAsListOfLists("select min(down_payment) from tbl_mortagage");

    }
    @Then("The result should not be empty")
    public void the_result_should_not_be_empty() {
        Assert.assertFalse(actualDownpaymentList.isEmpty());
    }


    List<List<Object>> actualMaxDownpaymentList;
    @When("I send a request to retrieve maximum down-payment")
    public void i_send_a_request_to_retrieve_maximum_down_payment() {
        actualMaxDownpaymentList = DBUtils.getQueryResultAsListOfLists("select max(down_payment) from tbl_mortagage");

    }
    @Then("The result shouldn't be empty")
    public void the_result_shouldn_t_be_empty() {
        Assert.assertFalse(actualMaxDownpaymentList.isEmpty());


    }





}







