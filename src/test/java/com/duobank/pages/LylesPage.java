package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LylesPage {


//    public void verifyPage(){
//        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//a[@id='steps-uid-0-t-2']")).getText(),"EXPENSES");
//
//    }
//
//    public void enterMonthlyRental(){
//        Driver.getDriver().findElement(By.xpath("//input[@id='monthlyrentalpayment']")).sendKeys(Keys.ENTER,"1700");
//
//    }
//
//    public void clickNext(){
//        Driver.getDriver().findElement(By.xpath("//a[@href='#next']")).click();
//    }

    public LylesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='steps-uid-0-t-2']")
    public WebElement verifyPage;

    @FindBy(xpath = "//input[@id='monthlyrentalpayment']")
    public WebElement monthlyRental;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement clickNext;
}





