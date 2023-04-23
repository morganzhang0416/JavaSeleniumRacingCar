package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameInput() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getFristNameInput() {
        return driver.findElement(By.id("firstName"));
    }

    public WebElement getLastNameInput() {
        return driver.findElement(By.id("lastName"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.id("confirmPassword"));
    }
    
    public WebElement getSubmitButton() {
        return driver.findElement(By.className("btn-default"));
    }

    public WebElement getSuccessMessage() {
        return driver.findElement(By.cssSelector("div.result.alert.alert-success"));
    }

    
    
    
}

