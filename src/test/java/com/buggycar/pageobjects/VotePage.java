package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.buggycar.utils.WaitConditions;
import java.time.Duration;
import java.util.Random;

public class VotePage {

    private WebDriver driver;
    WaitConditions wait;
    Random rand ;
    public String expectedMessage = "Thank you for your vote!";

    public VotePage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitConditions(driver);
        rand = new Random();
    }

    public WebElement getPopularModeLink() {
        return driver.findElement(By.cssSelector("img[title='Guilia Quadrifoglio']"));
    }

    public WebElement getTextareaInput() {
        return driver.findElement(By.id("comment"));
    }

    public WebElement getVoteButton() {
        return driver.findElement(By.className("btn-success"));
    }

    public String getActualMessage() {
        return driver.findElement(By.className("card-text")).getText();
    }

    public void WaitModelPresent() {
        wait.WaitLocatorClickable(By.cssSelector("img[title='Guilia Quadrifoglio']"), Duration.ofSeconds(8));
    }

    public void WaitCommentPresent() {
        wait.WaitLocatorVisibility(By.id("comment"), Duration.ofSeconds(8));
    }

    public void WaitSuccessMessage() {
        wait.WaitLocatorVisibility(By.className("card-text"), Duration.ofSeconds(8));
    }

    public void EnterComment(String comment) {
        int randomNumber = rand.nextInt(100);
        getTextareaInput().sendKeys(comment + randomNumber);
    }
   
    
    
}

