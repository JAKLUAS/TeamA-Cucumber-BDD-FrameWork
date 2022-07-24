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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DildoraPage {


        public DildoraPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

   @FindBy(xpath = "(//h6[@class='py-50'])[1]")
   public WebElement PersonalPageMessage;

    @FindBy(xpath = "(//label[.='Yes'])[3]")
    public WebElement applyCoBorrowers;

    @FindBy(xpath = "//input[@id='b_firstName']")
    public WebElement enterFirstName;

    @FindBy(xpath = "//input[@id='b_middleName']")
    public WebElement enterMiddleName;

    @FindBy(xpath = "//input[@id='b_lastName']")
    public WebElement enterLastName;

    @FindBy(xpath = "//span[@id='select2-b_suffix-container']")
    public WebElement clickSuffix;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement enterSuffix;

    @FindBy(xpath = "//input[@id='b_email']")
    public WebElement enterEmailAddress;

    @FindBy(xpath = "//input[@id='b_dob']")
    public WebElement enterDOB;

    @FindBy(xpath = "//span[@id='select2-b_marital-container']")
    public WebElement clickMaritalStatus;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement enterMaritalStatus;

    @FindBy(xpath = "//input[@id='b_cell']")
    public WebElement enterCellPhone;

    @FindBy(xpath ="//input[@id='b_ssn']" )
    public WebElement enterSSN;

    @FindBy(xpath = "//input[@id='b_home']" )
    public WebElement enterHomePhone;

    @FindBy(xpath = "//input[@id='c_firstName']" )
    public WebElement coBorrowerFirstName;

    @FindBy(xpath = "//input[@id='c_middleName']")
    public WebElement coBorrowerMiddleName;

    @FindBy(xpath = "//input[@id='c_lastName']")
    public WebElement coBorrowerLastName;

    @FindBy(xpath = "//input[@id='c_email']")
    public WebElement coBorrowerEmailAddress;

    @FindBy(xpath = "//input[@id='c_dob']")
    public WebElement coBorrowerDOB;

    @FindBy(xpath = "//input[@id='c_ssn']")
    public  WebElement coBorrowerSSN;

    @FindBy(xpath = "//span[@id='select2-c_marital-container']")
    public  WebElement clickCoBorrowerMaritalStatus;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement enterCoBorrowerMaritalStatus;

    @FindBy(xpath = "//input[@id='c_cell']")
    public  WebElement coBorrowerCellPhone;

    @FindBy(xpath = "//input[@id='c_home']")
    public  WebElement coBorrowerHomePhone;

    @FindBy(xpath = "//a[.='Next']")
    public  WebElement clickNextButton;

    @FindBy(xpath = "//label[.='This field is required.']")
    public WebElement errorMessage;
}
