package com.duobank.pages;

import com.duobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@href='register.php']")
    private WebElement signUpPageLink;



    @FindBy (id = "inputfirstname4")
    private WebElement firstName;

    @FindBy (id = "inputlastname4")
    private WebElement lastName;

    @FindBy (id = "email")
    private WebElement email;

    @FindBy (id = "exampleInputPassword1")
    private WebElement password;

    @FindBy (id = "register")
    private WebElement signUpButton;

    @FindBy (id = "exampleInputEmail1")
    public WebElement signINEmail;

    @FindBy (id = "exampleInputPassword1")
    public WebElement signINPassword;

    @FindBy (name = "login")
    private WebElement loginButton;


    public void clickOnSignUpPageLink(){

        signUpPageLink.click();
    }


    public void enterCredentialsAndClick( String Halil, String Dikmen ,String email1,  String halil1234) {


        firstName.sendKeys(Halil);
        lastName.sendKeys(Dikmen);
        email.sendKeys(email1);
        password.sendKeys(halil1234);
        signUpButton.click();

    }
    public void enterCredentialsAndlogin( String emailh,  String password1) {



        signINEmail.sendKeys(emailh);
        signINPassword.sendKeys(password1);


    }

    public void clickOnTheLogin() {
        loginButton.click();
    }
}
