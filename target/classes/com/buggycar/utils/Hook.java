package com.buggycar.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


// setup and quite browser in each test case
public class Hook {
    protected WebDriver driver;
    protected String baseUrl;
    
    @Parameters("browserName")
    @BeforeMethod
    public void setUp(String browserName) {
      
        // Get the root directory of the project
        // String projectDir = System.getProperty("user.dir");
        
        // Construct the path to chromedriver
        // Path chromeDriverPath = Paths.get(projectDir, "driver", "chromedriver");
        // Path firefoxDriverPath = Paths.get(projectDir, "driver", "geckodriver");
        // System.out.println(projectDir);
        // // Print the path to chromedriver
        // System.out.println(chromeDriverPath.toString());
        System.out.println(browserName.toString());
        if(browserName.equalsIgnoreCase("chrome")) {	 
            //Initializing the firefox driver (Gecko)
            System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");	
            System.out.println("chrome before" + System.getProperty("webdriver.chrome.driver"));
            driver = new ChromeDriver();
            System.out.println("chrome after" + System.getProperty("webdriver.chrome.driver"));
            
    
        }else if (browserName.equalsIgnoreCase("firefox")) {    
            //Initialize the chrome driver                
            System.setProperty("webdriver.gecko.driver", "./driver/geckodriver");
            System.out.println("firefox before"+System.getProperty("webdriver.gecko.driver"));
            driver = new FirefoxDriver();
            System.out.println("firefox after"+System.getProperty("webdriver.gecko.driver"));
            
        }
        // Set the base URL
        baseUrl = "https://buggy.justtestit.org";

        // Navigate to the website
        // driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        // Quit the driver
        if(driver != null){
            driver.quit();
        }
        
    }
}
