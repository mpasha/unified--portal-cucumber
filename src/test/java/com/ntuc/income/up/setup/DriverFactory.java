package com.ntuc.income.up.setup;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

//    private static final String URL = System.getenv("REMOTE_URL");
    private static WebDriver driver;

    public static WebDriver getDriver() {

        String browser = System.getProperty("Browser");
        String location = "LOCAL";
        browser = (browser == null) ? "CHROME" : browser;

        return setUpLocal(browser);
    }

    public static WebDriver setUpLocal(String browser) {
        if ("IE".equalsIgnoreCase(browser)) {
            InternetExplorerDriverManager.getInstance().setup();
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("requireWindowFocus", true);
            capabilities.setCapability("ignoreZoomSetting", true);
            return new InternetExplorerDriver(capabilities);
        } else if ("FIREFOX".equalsIgnoreCase(browser)) {
            FirefoxDriverManager.getInstance().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                firefoxOptions.addArguments("--headless");
            }
            return new FirefoxDriver(firefoxOptions);
        }
        ChromeDriverManager.getInstance().setup();

        ChromeOptions options = new ChromeOptions();
        if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        }
        return new ChromeDriver(options);
    }

    /*public static WebDriver setUpRemote(String browser) {
        try {

            switch (browser) {
                case "IE":
                    InternetExplorerDriverManager.getInstance().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "FIREFOX":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                        firefoxOptions.addArguments("--headless");
                        firefoxOptions.addArguments("--disable-gpu");
                    }
                    DesiredCapabilities desiredCapabilities= new DesiredCapabilities();
                    desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS,firefoxOptions);
//                    driver = new RemoteWebDriver(new URL(URL), desiredCapabilities);
                    break;
                case "CHROME":
                default:
                    ChromeOptions options = new ChromeOptions();
                    if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                    }
//                    desiredCapabilities = DesiredCapabilities.chrome();
//                    desiredCapabilities.setVersion(System.getenv("BROWSER_VERSION"));
//                    driver = new RemoteWebDriver(new URL(URL), options);
                    break;
            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        } catch (MalformedURLException e) {
            System.out.println(e.toString());
        }
        return driver;
    }*/

    public static void clear(WebElement element)
    {
        element.clear();
    }

    public static void sendKeys(WebElement element,String Text)
    {
        element.sendKeys(Text);
    }

    public static void WaitforElementtoLoad(WebDriver driver,String Xpath) {
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
    }

    public static void actionSendKeys(WebDriver driver,WebElement element, String text) {

        Actions ob = new Actions(driver);
        ob.moveToElement(element);
        ob.click();
        ob.sendKeys(text);
        Action action  = ob.build();
        action.perform();


    }
}
