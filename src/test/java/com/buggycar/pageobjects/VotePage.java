package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VotePage {

    private WebDriver driver;

    public VotePage(WebDriver driver) {
        this.driver = driver;
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

    public WebElement getSuccessfulMessage() {
        return driver.findElement(By.className("card-text"));
    }
   
    
    
}

