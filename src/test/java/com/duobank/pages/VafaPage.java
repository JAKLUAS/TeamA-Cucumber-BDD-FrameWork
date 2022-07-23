package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VafaPage {

     public VafaPage(){PageFactory.initElements(Driver.getDriver(),this); };


    @FindBy(xpath = "//a[@id='steps-uid-0-t-3']")
    public WebElement verifyEmploymentPage;

    @FindBy(xpath = "//input[@id='employername1']")
   public WebElement enterEmployerName;

    @FindBy(xpath = "//input[@id='position1']")
    public WebElement enterEmployerPosition;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement enterCity;

    @FindBy(id = "grossmonthlyincome")
    public WebElement enterGrossMonthlyIncome;

    @FindBy(id = "monthlyovertime")
    public WebElement enterMonthlyOvertime;

    @FindBy(id = "monthlybonuses")
    public WebElement enterMonthlyBonuses;

    @FindBy(id = "monthlycommission")
    public WebElement enterMonthlyCommissions;

    @FindBy(id = "monthlydividents")
    public WebElement enterMonthlyDividends;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement clickNext;

}

