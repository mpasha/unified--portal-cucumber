package com.ntuc.income.up.setup;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    // Holds the WebDriver instance
    public static WebDriver webDriver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @Before
    public void initializeDriver(){
        webDriver = DriverFactory.getDriver();
    }

    // Close the webDriver instance
    @After
    public void closeDriver(){
        webDriver.quit();
    }


}
