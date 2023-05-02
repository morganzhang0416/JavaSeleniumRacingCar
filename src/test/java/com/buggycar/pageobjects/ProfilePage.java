package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import com.buggycar.utils.WaitConditions;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage {
    public String expectedMessage;
    private WebDriver driver;
    WaitConditions wait;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitConditions(driver);
        expectedMessage = "The profile has been saved successful";
    }

    public WebElement getAgeInput() {
        return driver.findElement(By.id("age"));
    }

    public WebElement getSubmitButton() {
        return driver.findElement(By.className("btn-default"));
    }

    public String getSuccessfulResult() {
        return driver.findElement(By.cssSelector("div.result.alert.alert-success.hidden-md-down")).getText().trim();
    }

    public WebElement getHobbyList() {
        return driver.findElement(By.id("hobby"));
    }
    
    public void WaitAgePresent(){
        wait.WaitLocatorClickable(By.id("age"),Duration.ofSeconds(8));
    }

    public void EnterAge(String age) {
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(age);
    }

    public void SlectHobbhy(String hobby) {
        Select select = new Select(getHobbyList());
        select.selectByVisibleText(hobby);
    }

    public void ClickSubmitButton() {
        driver.findElement(By.className("btn-default")).click();
    }

    public void WaitSuccessMessage() {
        wait.WaitLocatorVisibility(By.cssSelector("div.result.alert.alert-success.hidden-md-down"), Duration.ofSeconds(8));
    }

    
    
}

