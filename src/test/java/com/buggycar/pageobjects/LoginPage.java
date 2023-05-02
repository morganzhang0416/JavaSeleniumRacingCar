package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import com.buggycar.utils.WaitConditions;


public class LoginPage {

    private WebDriver driver;
    WaitConditions wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitConditions(driver);
    }

    public void EnterUsername(String username) {
        driver.findElement(By.name("login")).sendKeys(username);
    }

    public void EnterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
    }

    public void ClickLoginButton() {
        driver.findElement(By.className("btn-success")).click();
        
    }

    public void ClickProfileButton() {
        driver.findElement(By.linkText("Profile")).click();
        
    }

    public WebElement getProfileButton() {
        return driver.findElement(By.linkText("Profile"));
    }
 
    public String getInvilidLoginMessage() {
        return driver.findElement(By.className("label-warning")).getText().trim();
    }

    public void ClickLogoutButton() {
        driver.findElement(By.linkText("Logout")).click();
    }

    public WebElement getElementLogin() {
        return driver.findElement(By.name("login"));
    }


    public void WaitLogoutButtonPresent(){
        wait.WaitLocatorClickable(By.linkText("Logout"),Duration.ofSeconds(8));
    }

    public void WaitProfilePresent(){
        wait.WaitLocatorClickable(By.linkText("Profile"),Duration.ofSeconds(8));
    }

    public void WaitInvalidLoginPresent(){
        wait.WaitLocatorClickable(By.className("label-warning"),Duration.ofSeconds(8));
    }

    public void WaitLoginPresent(){
        wait.WaitLocatorClickable(By.name("login"),Duration.ofSeconds(8));
    }

    
}

