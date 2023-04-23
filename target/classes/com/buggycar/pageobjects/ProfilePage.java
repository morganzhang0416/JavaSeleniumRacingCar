package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAgeInput() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.className("btn-default"));
    }

    public WebElement getSuccessfulResult() {
        return driver.findElement(By.cssSelector("div.result.alert.alert-success.hidden-md-down"));
    }

    public WebElement getHobbyList() {
        return driver.findElement(By.id("hobby"));
    }
    
    
    
}

