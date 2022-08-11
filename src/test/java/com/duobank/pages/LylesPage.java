package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LylesPage {


    public LylesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
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

    @FindBy(id = "estimatedprice")
    public WebElement estimatedPurchasePrice; //

    @FindBy(id = "downpayment")
    public WebElement downpaymentAmount;

    @FindBy(xpath = "//a[@id='PreApprovalEdit']")
    public WebElement preapprovalEdit;  //

    @FindBy(xpath = "//input[@ID='eConsentdeclarerFirstName']")
    public WebElement econsentFirstName;

    @FindBy(xpath = "//input[@ID='eConsentdeclarerLastName']")
    public WebElement econsentLastName;

    @FindBy(xpath = "//input[@ID='eConsentdeclarerEmail']")
    public WebElement econsentEmail;

    @FindBy(xpath = "//a[@id='EmploymentIncomeEdit']")
    public WebElement employmentAndIncomeEdit;

    @FindBy(id = "grossmonthlyincome")
    public WebElement grossmonthlyincomeEdit;

    @FindBy(id = "monthlyovertime")
    public WebElement monthlyOvertimeEdit;

    @FindBy(id = "monthlybonuses")
    public WebElement monthlybonusesEdit;

    @FindBy(id = "monthlycommission")
    public WebElement monthlycommissionEdit;

    @FindBy(id = "monthlydividents")
    public WebElement monthlydividentsEdit;

    @FindBy(xpath = "//a[@id='PersonalnformationEdit']")
    public WebElement personalDetailsEdit;

    @FindBy(xpath = "//input[@id='b_firstName']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@id='b_middleName']")
    public WebElement MiddleName;

    @FindBy(xpath = "//input[@id='b_lastName']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@id='b_email']")
    public WebElement EmailAddress;

    @FindBy(xpath = "//input[@id='b_dob']")
    public WebElement DOB;

    @FindBy(xpath ="//input[@id='b_ssn']" )
    public WebElement SSN;


    public void editPreapprovalDetails(String a, String b) {

        estimatedPurchasePrice.sendKeys(Keys.CONTROL, Keys.chord("a"),a);
        downpaymentAmount.sendKeys(Keys.CONTROL, Keys.chord("a"),b);

    }

    public void editEConsentDetails(String fname, String lname, String email) {

        econsentFirstName.sendKeys(Keys.CONTROL, Keys.chord("a"), fname);
        econsentLastName.sendKeys(Keys.CONTROL, Keys.chord("a"), lname);
        econsentEmail.sendKeys(Keys.CONTROL, Keys.chord("a"), email);

    }

    public void editEmploymentAndIncome(String gmi, String mo, String mb, String mc, String md) {

        grossmonthlyincomeEdit.sendKeys(Keys.CONTROL, Keys.chord("a"), gmi);
        monthlyOvertimeEdit.sendKeys(Keys.CONTROL, Keys.chord("a"), mo);
        monthlybonusesEdit.sendKeys(Keys.CONTROL, Keys.chord("a"), mb);
        monthlycommissionEdit.sendKeys(Keys.CONTROL, Keys.chord("a"), mc);
        monthlydividentsEdit.sendKeys(Keys.CONTROL, Keys.chord("a"), md);

    }

    public void editPersonalDetails(String first, String middle, String last) {

        FirstName.sendKeys(Keys.CONTROL, Keys.chord("a"), first);
        MiddleName.sendKeys(Keys.CONTROL, Keys.chord("a"), middle);
        LastName.sendKeys(Keys.CONTROL, Keys.chord("a"), last);


    }

}