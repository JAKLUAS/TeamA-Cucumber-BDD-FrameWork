package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AsifPage {


    public void clickOnMortgage(){

        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//span[@data-i18n='eCommerce']"));
        action.moveToElement(element).click().perform();

    }

    public void clickNoRealtor(){

        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[@for='realtor2']"));
        action.moveToElement(element).click().perform();

    }

    public void clickNoLoanOfficer() {

        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//label[@for='loanofficer2']"));
        action.moveToElement(element).click().perform();
    }



    public void EnterEstimatePrice(){

        Driver.getDriver().findElement(By.id("estimatedprice")).sendKeys("300000", Keys.ENTER);

    }

    public void EnterDownPayment(){

        Driver.getDriver().findElement(By.id("downpayment")).sendKeys("60000", Keys.ENTER);

    }

    public void clickOnNext() {

        Actions action = new Actions(Driver.getDriver());
        WebElement element = Driver.getDriver().findElement(By.xpath("//ul[@aria-label='Pagination']"));
        action.moveToElement(element).click().perform();
    }






}
