package com.buggycar.utils;

import org.testng.asserts.Assertion;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

//wait element or locator in case it fails to interact
public class WaitConditions {

    public WebDriver driver;
    public Assertion assertion = new Assertion();

    public WaitConditions(WebDriver driver) {
        this.driver = driver;
    }


    public void WaitLocatorVisibility(By locator, Duration timeout) {
        // time example is Duration.ofSeconds(8), you can change 8 second to any number you need
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (NoSuchElementException | TimeoutException  e) {
            //print out locator which failed to retreive
            assertion.fail("Element not found on page: " + locator);
        }
    }

    public void WaitLocatorClickable(By locator , Duration timeout) {
        // time example is Duration.ofSeconds(8), you can change 8 second to any number you need
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (NoSuchElementException | TimeoutException  e) {
            //print out locator which failed to retreive
            assertion.fail("Element not found on page: " + locator);
        }
    }

   

   
}
