package com.ntuc.income.up.steps;

import com.ntuc.income.up.pages.RegisterPage;
import com.ntuc.income.up.setup.Hooks;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class StpRegister {
    public WebDriver driver;

    public StpRegister(){
        driver = Hooks.webDriver;
        PageFactory.initElements(driver, RegisterPage.class);
    }

    @Given("^user launches the facebook$")
    public void user_launches_the_facebook() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        RegisterPage.waitForFacebookPage(driver);
    }

    @When("^user enters signup information \"(.*?)\",\"(.*?)\",\"(.*?)\",\"(.*?)\"$")
    public void user_enters_signup_information(String firstName, String lastName, String emailOrMobile, String signUpPassword) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RegisterPage.enterSignUpInfo(firstName,lastName,emailOrMobile,signUpPassword);
    }

    @When("^user clears sign up information$")
    public void user_clears_sign_up_information() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        RegisterPage.clearSignUpInfo();
    }

    @Then("^sign up info is cleared$")
    public void sign_up_info_is_cleared() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
