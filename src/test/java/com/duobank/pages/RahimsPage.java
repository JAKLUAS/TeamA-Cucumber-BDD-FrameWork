package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RahimsPage {

        public RahimsPage(){
            PageFactory.initElements(Driver.getDriver(),this);

        }

        @FindBy(xpath = "//input[@id='creditreport1']")
        public WebElement clickYesCreditReport;

        @FindBy(xpath = "//input[@id='creditreport2']")
        public WebElement clickNoCreditReport;

        @FindBy(xpath = "//a[@href='#next']")
        public WebElement clickNext;

        @FindBy(xpath = "//input[@ID='eConsentdeclarerFirstName']")
        public WebElement inputFirstName;

        @FindBy(xpath = "//input[@ID='eConsentdeclarerLastName']")
        public WebElement inputLastName;

        @FindBy(xpath = "//input[@ID='eConsentdeclarerEmail']")
        public WebElement inputEmail;

        @FindBy(xpath = "//label[@for='agree']")
        public WebElement consentAgree;

        @FindBy(xpath = "//input[@id='dontagree']")
        public WebElement consentDontAgree;

        @FindBy(xpath = "//a[@id='steps-uid-0-t-4']")
        public WebElement clickCreditReport;

        @FindBy(xpath = "//a[@id='steps-uid-0-t-5']")
        public WebElement clickEconsent;

        @FindBy(xpath = "//ul[@role='tablist']//li[@class='current']")
        public WebElement checkIfCurrent;

        @FindBy(xpath = "//ul[@role='tablist']//li[@class='done'][4]")
        public WebElement checkIfCreditReportDone;

        @FindBy(xpath = "//ul[@role='tablist']//li[@class='done'][5]")
        public WebElement checkIfConsentDone;

        @FindBy(xpath = "//label[@id='eConsentdeclarerEmail-error']")
        public WebElement checkForError;


}


