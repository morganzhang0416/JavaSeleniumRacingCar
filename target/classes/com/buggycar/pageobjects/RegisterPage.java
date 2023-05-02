package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.buggycar.utils.WaitConditions;
import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;
    public String expectedMessage ;
    WaitConditions wait;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        expectedMessage = "Registration is successful";
        wait = new WaitConditions(driver);
    }

    public void EnterUserName(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    public void EnterFristName(String firstName) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void EnterLastName(String lastName) {
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }

    public void EnterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    public void EnterConfirmPassword(String confirmPassword) {
        driver.findElement(By.id("confirmPassword")).sendKeys(confirmPassword);
    }

    public void ClickSubmitButton() {
        driver.findElement(By.className("btn-default")).click();
    }

    public void WaitSuccessMessage() {
        wait.WaitLocatorVisibility(By.cssSelector("div.result.alert.alert-success"), Duration.ofSeconds(8));
    }

    public String getSuccessMessage() {
        return driver.findElement(By.cssSelector("div.result.alert.alert-success")).getText().trim();
    }    
    
}

