package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VafaPage {

    public void verifyEmploymentPage(){
        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//a[@id='steps-uid-0-t-3']")).getText(),"EMPLOYMENT AND INCOME");

    }

    public void enterEmployerName(){
        Driver.getDriver().findElement(By.xpath("//input[@id='employername1']")).sendKeys("Jonh Doe", Keys.ENTER);
    }

    public void enterEmployerPosition(){
        Driver.getDriver().findElement(By.xpath("//input[@id='position1']")).sendKeys("Director", Keys.ENTER);
    }

    public void enterCity(){
        Driver.getDriver().findElement(By.xpath("//input[@id='city']")).sendKeys("NY", Keys.ENTER);
    }

    public void enterGrossMonthlyIncome(){
        Driver.getDriver().findElement(By.id("grossmonthlyincome")).sendKeys("100000", Keys.ENTER);
    }

    public void enterMonthlyOvertime(){
        Driver.getDriver().findElement(By.id("monthlyovertime")).sendKeys("5000", Keys.ENTER);
    }

    public void enterMonthlyBonuses(){
        Driver.getDriver().findElement(By.id("monthlybonuses")).sendKeys("2350", Keys.ENTER);
    }

    public void enterMonthlyCommissions(){
        Driver.getDriver().findElement(By.id("monthlycommission")).sendKeys("1250", Keys.ENTER);
    }
    public void enterMonthlyDividends(){
        Driver.getDriver().findElement(By.id("monthlydividents")).sendKeys("3450", Keys.ENTER);
    }

    public void clickNext(){
        Driver.getDriver().findElement(By.xpath("//a[@href='#next']")).click();
    }


//
//    @FindBy(xpath = "//a[@id='steps-uid-0-t-3']")
//    public WebElement verifyEmploymentPage;
//
//    @FindBy(xpath = "//input[@id='employername1']")
//   public WebElement enterEmployerName;
//
//    @FindBy(xpath = "//input[@id='position1']")
//    public WebElement enterEmployerPosition;
//
//    @FindBy(xpath = "//input[@id='city']")
//    public WebElement enterCity;
//
//    @FindBy(id = "grossmonthlyincome")
//    public WebElement enterGrossMonthlyIncome;
//
//    @FindBy(id = "monthlyovertime")
//    public WebElement enterMonthlyOvertime;
//
//    @FindBy(id = "monthlybonuses")
//    public WebElement enterMonthlyBonuses;
//
//    @FindBy(id = "monthlycommission")
//    public WebElement enterMonthlyCommissions;
//
//    @FindBy(id = "monthlydividents")
//    public WebElement enterMonthlyDividends;
//
//    @FindBy(xpath = "//a[@href='#next']")
//    public WebElement clickNext;

}
