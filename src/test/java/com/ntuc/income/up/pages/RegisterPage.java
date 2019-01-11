package com.ntuc.income.up.pages;

import com.ntuc.income.up.setup.DriverFactory;
import com.ntuc.income.up.setup.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    WebDriver driver = Hooks.webDriver;

    @FindBy(how= How.XPATH, using="//input[@id='email']")
    public static WebElement txtUserName;

    @FindBy(how=How.XPATH, using="//input[@id='pass']")
    public static WebElement txtPassword;

    @FindBy(how=How.XPATH, using="//input[@value='Log In']")
    public static WebElement btnSubmit;

    @FindBy(how= How.XPATH, using="//input[@name='firstname']")
    public static WebElement txtFirstName;

    @FindBy(how= How.XPATH, using="//input[@name='lastname']")
    public static WebElement txtLastName;

    @FindBy(how= How.XPATH, using="//input[@name='reg_email__']")
    public static WebElement txtMobileOrEmail;

    @FindBy(how= How.XPATH, using="//input[@name='reg_passwd__']")
    public static WebElement txtSignupPassword;

    public static void enterSignUpInfo(String firstName,String lastName,String emailOrMobile,String signUpPassword){
        DriverFactory.sendKeys(txtFirstName,firstName);
        DriverFactory.sendKeys(txtLastName,lastName);
        DriverFactory.sendKeys(txtMobileOrEmail,emailOrMobile);
        DriverFactory.sendKeys(txtSignupPassword,signUpPassword);
    }

    public static void clearSignUpInfo(){
        DriverFactory.clear(txtFirstName);
        DriverFactory.clear(txtLastName);
        DriverFactory.clear(txtMobileOrEmail);
        DriverFactory.clear(txtSignupPassword);
    }

    public static void waitForFacebookPage(WebDriver driver){
        DriverFactory.WaitforElementtoLoad(driver,"//input[@name='firstname']");
    }
}
