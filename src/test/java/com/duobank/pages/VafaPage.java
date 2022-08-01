package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VafaPage {

 public VafaPage() {
  PageFactory.initElements(Driver.getDriver(), this);
 }

 ;

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

 @FindBy(xpath = "//button[@id='addemployer']")
 public WebElement clickAnotherEmployer;

 @FindBy(xpath = "//input[@id='start_date2']")
 public WebElement clickStartDate;

 @FindBy(xpath = "//input[@id='end_date2']")
 public WebElement clickEndDate;

 @FindBy(id = "employername2")
 public WebElement clickSecondEmployerID;

 @FindBy(id = "position2")
 public WebElement clickSecondEmployerPosition;

 @FindBy(id = "city2")
 public WebElement clickSecondCity;

 @FindBy(id = "currentjobsls")
 public WebElement clickThisIsMyCurrentJob;

 @FindBy(id = "start_date1")
 public WebElement clickOnStartDate1;

 @FindBy(id = "start_date1")
 public WebElement clickOnSelectOne;

 @FindBy(id = "Alimnoy/Child Support")
 public WebElement clickOnAlimnoy;

 @FindBy(id = "amount1")
 public WebElement addFirstAmount;

 @FindBy(id = "amount2")
 public WebElement addSecondAmount;

 @FindBy(id = "amount3")
 public WebElement addThirdAmount;


 public void enterCredentialsAndClick(String employerName, String employerPosition, String city, String grossMonthlyIncome) {

  enterEmployerName.sendKeys(employerName);
  enterEmployerPosition.sendKeys(employerPosition);
  enterCity.sendKeys(city);
  enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
  clickNext.click();
 }

 public void enterSecondEmployerAndClick(String employerName, String employerPosition, String city, String startDate1, String grossMonthlyIncome) {
  clickAnotherEmployer.click();
  clickSecondEmployerID.sendKeys(employerName);
  clickSecondEmployerPosition.sendKeys(employerPosition);
  clickSecondCity.sendKeys(city);
  clickOnStartDate1.sendKeys(startDate1);
  enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
  clickNext.click();
 }

 public void enterAdditionalInfoAndClick(String employerName, String employerPosition, String city, String startDate1, String grossMonthlyIncome, String monthlyOvertime, String monthlyBonuses, String monthlyCommissions, String monthlyDividends) {
  clickAnotherEmployer.click();
  clickSecondEmployerID.sendKeys(employerName);
  clickSecondEmployerPosition.sendKeys(employerPosition);
  clickSecondCity.sendKeys(city);
  clickOnStartDate1.sendKeys(startDate1);
  enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
  enterMonthlyOvertime.sendKeys(monthlyOvertime);
  enterMonthlyBonuses.sendKeys(monthlyBonuses);
  enterMonthlyCommissions.sendKeys(monthlyCommissions);
  enterMonthlyDividends.sendKeys(monthlyDividends);
  clickNext.click();
 }


 public void enterAdditionalIncomeAndClick(String employerName, String employerPosition, String city, String startDate1, String grossMonthlyIncome, String amount) {
  clickAnotherEmployer.click();
  clickSecondEmployerID.sendKeys(employerName);
  clickSecondEmployerPosition.sendKeys(employerPosition);
  clickSecondCity.sendKeys(city);
  clickOnStartDate1.sendKeys(startDate1);
  enterGrossMonthlyIncome.sendKeys(grossMonthlyIncome);
  enterMonthlyOvertime.sendKeys(amount);
  clickNext.click();
 }

}

