package com.duobank.pages;

import com.duobank.utilities.Driver;
import com.duobank.utilities.SeleniumUtils;
import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DildoraPage {


    Faker faker = new Faker();
    public void verifyPersonalPage(){
        SeleniumUtils.waitFor(3);
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("(//h6[@class='py-50'])[1]")).getText(),"Personal Information");

    }

    public void clickOnFirstName(){

        Driver.getDriver().findElement(By.xpath("//input[@id='b_firstName']")).sendKeys(Keys.ENTER+faker.name().firstName());
    }

    public void clickOnMiddleName(){
        Driver.getDriver().findElement(By.xpath("//input[@id='b_middleName']")).sendKeys(Keys.ENTER+faker.name().nameWithMiddle());
    }

    public void clickOnLastName(){
       Driver.getDriver().findElement(By.xpath("//input[@id='b_lastName']")).sendKeys(Keys.ENTER+faker.name().lastName());
    }

    public void selectSuffix(){
     Driver.getDriver().findElement(By.xpath("//span[@id='select2-b_suffix-container']")).click();
    }

    public void enterSuffix(){
        SeleniumUtils.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(faker.name().suffix()+Keys.ENTER);
    }

    public void enterEmail(){
        Driver.getDriver().findElement(By.xpath("//input[@id='b_email']")).sendKeys(Keys.ENTER+faker.internet().emailAddress());

    }

    public void selectDateOfBirth(){
        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//input[@id='b_dob']"));
        action.moveToElement(element).click().perform();
        element.sendKeys("11"+"25"+ "1989");

    }

    public void enterSSN(){
      Driver.getDriver().findElement(By.xpath("//input[@id='b_ssn']")).sendKeys(Keys.ENTER+faker.number().digits(9));
    }

   public void selectMaritalStatus(){
      Driver.getDriver().findElement(By.xpath("//span[@id='select2-b_marital-container']")).click();}

    public void enterMaritalStatus(){
        SeleniumUtils.waitFor(2);

        Driver.getDriver().findElement(By.xpath("//input[@type='search']")).sendKeys("Married"+Keys.ENTER);
    }

    public void enterCellPhone(){

        Driver.getDriver().findElement(By.xpath("//input[@id='b_cell']")).sendKeys(Keys.ENTER+ faker.phoneNumber().cellPhone());
    }
    public void enterHomePhone(){
        Driver.getDriver().findElement(By.xpath("//input[@id='b_home']")).sendKeys(Keys.ENTER+faker.phoneNumber().phoneNumber());

    }
    public void checkPrivacyPolice(){

    }
    public void clickNextButton(){
     Driver.getDriver().findElement(By.xpath("//a[.='Next']")).click();
    }
}
