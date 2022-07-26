package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LylesPage {


    public LylesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@id='steps-uid-0-t-2']")
    public WebElement verifyPage;

    @FindBy(xpath = "//input[@placeholder='Monthly Rental Payment']")
    public WebElement monthlyRental;

    @FindBy(xpath = "//a[@href='#next']")
    public WebElement clickNext;

    @FindBy(xpath = "//a[@id='steps-uid-0-t-6']")
    public WebElement verifySummaryPage;

    @FindBy(xpath = "//a[@href='#finish']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-succes']")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@id='ExpenseEdit']")
    public WebElement expenseEdit;

    @FindBy(xpath = "//label[@for='expense2']")
    public WebElement changetoOwn;

    @FindBy(xpath = "//input[@placeholder='First Mortagage Total Payment']")
    public WebElement mortgagePayment;

    @FindBy(xpath = "//a[@id='eConsentEdit']")
    public WebElement eConsentEdit;

    @FindBy(xpath = "//label[@for='dontagree']")
    public WebElement consentDontAgree;


}





