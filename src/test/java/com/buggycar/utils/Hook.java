package com.buggycar.utils;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        String projectDir = System.getProperty("user.dir");
        
        // Construct the path to chromedriver
        Path chromeDriverPath = Paths.get(projectDir, "driver", "chromedriver");
        Path firefoxDriverPath = Paths.get(projectDir, "driver", "geckodriver");
        Path msedgeDriverPath = Paths.get(projectDir, "driver", "msedgedriver");
        // System.out.println(projectDir);
        // // Print the path to chromedriver
        // System.out.println(chromeDriverPath.toString());
        
        if(browserName.equalsIgnoreCase("chrome")) {	 
            //Initializing the firefox driver (Gecko)
            driver = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());	  
    
        }else if (browserName.equalsIgnoreCase("firefox")) {    
            //Initialize the chrome driver    
            
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", firefoxDriverPath.toString());
     
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
