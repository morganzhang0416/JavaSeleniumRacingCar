package com.buggycar.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// setup and quite browser in each test case
public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl;

    @BeforeMethod
    public void setUp() {
        // Set path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/opt/homebrew/bin/chromedriver");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        // driver = new FirefoxDriver();
        // driver = new SafariDriver();

        // Set the base URL
        baseUrl = "https://buggy.justtestit.org";

        // Navigate to the website
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Quit the driver
        if(driver != null){
            driver.quit();
        }
        
    }
}
