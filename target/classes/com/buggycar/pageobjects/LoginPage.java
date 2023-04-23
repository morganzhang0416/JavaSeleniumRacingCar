package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.name("login"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.className("btn-success"));
    }

    public WebElement getProfileButton() {
        return driver.findElement(By.linkText("Profile"));
    }
    
    public WebElement getInvilidLoginMessage() {
        return driver.findElement(By.className("label-warning"));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.linkText("Logout"));
    }

    
}

