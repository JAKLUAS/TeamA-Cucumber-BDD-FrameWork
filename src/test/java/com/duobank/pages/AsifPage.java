package com.duobank.pages;

import com.duobank.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AsifPage {

    public AsifPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@data-i18n='eCommerce']")
    public WebElement clickOnMortgage;


    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement clickNoRealtor;


    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement clickNoLoanOfficer;


    @FindBy(id = "estimatedprice")
    public WebElement EnterEstimatePrice;


    @FindBy(id = "downpayment")
    public WebElement EnterDownPayment;


    @FindBy(xpath = "//ul[@aria-label='Pagination']")
    public WebElement clickOnNext;


    public void EnterRealtorInfo(){

        Faker faker = new Faker();
        String Rname = String.valueOf(faker.name());
        String Rphone = String.valueOf(faker.phoneNumber());

        Driver.getDriver().findElement(By.id("realtorinfo")).sendKeys(Rname + Rphone, Keys.ENTER);

    }

    @FindBy(id = "estimatedprice")
    public WebElement EnterNegativeEstimatePrice;


    public void clickOnSourceOfDownPayment() {

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='src_down_payment']")));
        select.selectByValue("Other type of Down Payment");

    }

    @FindBy(id = "additionalfunds")
    public WebElement EnterAdditionalFunds;


}
