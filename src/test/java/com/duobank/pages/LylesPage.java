package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LylesPage {


    public void verifyPage(){
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//a[@id='steps-uid-0-t-2']")).getText(),"EXPENSES");

    }

    public void enterMonthlyRental(){
        Driver.getDriver().findElement(By.xpath("//input[@id='monthlyrentalpayment']")).sendKeys(Keys.ENTER,"1700");

    }

    public void clickNext(){
        Driver.getDriver().findElement(By.xpath("//a[@href='#next']")).click();
    }
}





