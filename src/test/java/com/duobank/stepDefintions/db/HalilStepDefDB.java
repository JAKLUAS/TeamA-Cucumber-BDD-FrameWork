package com.duobank.stepDefintions.db;

import com.duobank.pages.HomePage;
import com.duobank.utilities.ConfigReader;
import com.duobank.utilities.DBUtils;
import com.duobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class HalilStepDefDB {

   //1- ui-db

    SoftAssertions softAssertions;

    @Then("The database should also have correctly mapped info")
    public void the_database_should_also_have_correctly_mapped_info(List<Map<String,String>> expectedList) throws SQLException {


        Map<String, String> expected = expectedList.get(0);
        String expectedFirst= expected.get("firstname");
        String expectedLast= expected.get("lastname");
        String expectedEmail= expected.get("email");
        String expectedPassword= DigestUtils.md5Hex(expected.get("password"));

        System.out.println("MD5 pass: " + expectedPassword);

        String query = "SELECT first_name, last_name, email,password FROM tbl_user  where first_name= '"+expectedFirst+"';";
        List<Map<String, Object>> actualList = DBUtils.getQueryResultListOfMaps(query);

        Map<String, Object> actual = actualList.get(0);

        String actualFirst = (String)(actual.get("firstName"));
        String actualLast = (String)(actual.get("lastName"));
        String actualEmail = (String)(actual.get("email"));
        String actualPass = (String)(actual.get("password"));

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualFirst ).isEqualTo(expectedFirst);
        softAssertions.assertThat(actualLast).isEqualTo(expectedLast);
        softAssertions.assertThat(actualEmail).isEqualTo(expectedEmail);
        softAssertions.assertThat(actualPass).isEqualTo(expectedPassword);

        DBUtils.executeUpdate("DELETE from tbl_user WHERE first_name='"+expectedFirst+"'");

       // softAssertions.assertAll();
    }

    //2- db-ui
    Map<String, String> data;
    @When("I add a new user to the database with the following info")
    public void i_add_a_new_user_to_the_database_with_the_following_info(List<Map<String,String>> dataTable) throws SQLException {
         data = dataTable.get(0);

        String query = "INSERT INTO tbl_user ( first_name, last_name, email, password, phone,image,type, created_at ,modified_at,zone_id,church_id,country_id,active ) values ('"+data.get("firstname")+"','"+data.get("lastname")+"','"+data.get("email")+"','"+DigestUtils.md5Hex(data.get("password"))+"','"+data.get("phone")+"','"+data.get("image")+"','"+data.get("type")+"','"+data.get("created_at")+"','"+data.get("modified_at")+"','"+data.get("zone_id")+"','"+data.get("church_id")+"','"+data.get("country_id")+"','"+data.get("active")+"')";

        System.out.println(query);


        DBUtils.executeUpdate(query);

    }
    @Then("I should be able to log in with the same credentials on the UI")
    public void i_should_be_able_to_log_in_with_the_same_credentials_on_the_ui() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

        new HomePage().enterCredentialsAndlogin(data.get("email"), data.get("password"));
        new HomePage().clickOnTheLogin();
        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php", Driver.getDriver().getCurrentUrl());


    }
    @Then("The firstname, lastname also should be correct")
    public void the_firstname_lastname_also_should_be_correct() {
       HomePage homePage = new HomePage();
        String actualFirst = homePage.username.getText().split(" ")[0];
        String actualLast = homePage.username.getText().split(" ")[1];

        softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualFirst).isEqualTo(data.get("first"));
        softAssertions.assertThat(actualLast).isEqualTo(data.get("last"));


      }






// 3- data integrity

    List<String> actualColumnNames;
    @When("I send a request to retrieve colum names for tbl_user table")
    public void i_send_a_request_to_retrieve_colum_names_for_tbl_user_table() {

        actualColumnNames = DBUtils.getColumnNames("SELECT * FROM tbl_user limit 1");

        System.out.println(actualColumnNames);
    }

    @Then("It should be the following")
    public void it_should_be_the_following(List<String> expectedColumnNames) {

        Assert.assertEquals(expectedColumnNames, actualColumnNames);


    }
 // 4- truncate

    StringBuilder sb;
    int unexpected;
    @When("I send a request to add a new first_name that is more than the expected length of {int}")
    public void i_send_a_request_to_add_a_new_first_name_that_is_more_than_the_expected_length_of(int expected) throws SQLException {
        sb = new StringBuilder();

        for (int i = 0; i < expected +99 ; i++) {
            sb.append('H');

        }
               DBUtils.executeUpdate("INSERT IGNORE INTO tbl_user (first_name) values ('"+sb+"') ");

            unexpected = expected;


    }
    @Then("The data should be truncated to the expected length")
    public void the_data_should_be_truncated_to_the_expected_length() {
        List<List<Object>> queryResultAsListOfLists = DBUtils.getQueryResultAsListOfLists("SELECT first_name from tbl_user where first_name like \"HH%\" limit 1;");

        int actualLength = ((String) (queryResultAsListOfLists.get(0).get(0))).length();

        Assert.assertEquals(unexpected, actualLength);

    }

    // 5- business rule
    List<List<Object>> actualList;
    @When("I send a request to retrieve duplicate email addresses")
    public void i_send_a_request_to_retrieve_duplicate_email_addresses() {

        actualList = DBUtils.getQueryResultAsListOfLists("SELECT email , count(*) FROM tbl_user GROUP BY email HAVING (COUNT(*) > 1)");
    }
    @Then("The result should be empty")
    public void the_result_should_be_empty() {

        Assert.assertTrue(actualList.isEmpty());

    }




}







