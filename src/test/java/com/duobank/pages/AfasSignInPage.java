package com.duobank.pages;
import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfasSignInPage {


    public AfasSignInPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

  @FindBy(xpath = "//span[@data-i18n='Analytics']")
    public WebElement clickOnApplication;

    @FindBy(xpath = "//select[@class='custom-select custom-select-sm form-control form-control-sm']")
    public WebElement clickOnSelect;

    @FindBy(xpath = "//option[@value='50']")
  public WebElement clickOnFifTy;

    @FindBy(xpath = "//th[@class='sorting_asc']")
    public WebElement clickOnBorrower;

    @FindBy(xpath = "//a[@class='text-uppercase']")
    public WebElement clickonByDuotechTeam;

    @FindBy(xpath = "//span[@class='user-name']")
    public WebElement clickOnTheName;

    @FindBy(xpath = "//i[@class='bx bx-power-off mr-50']")
    public WebElement clickOnLogOut;


  @FindBy(xpath = "//option[@value='10']")
  public WebElement clickOnValue;

  @FindBy(xpath = "//input[@type='search']")
  public WebElement search;

  @FindBy(xpath = "//a[@href='mortagageloandegtails.php?id=33985']")
  public WebElement viewDetails;

















}
