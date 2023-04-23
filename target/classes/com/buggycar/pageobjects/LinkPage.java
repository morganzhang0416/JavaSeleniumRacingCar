package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkPage {

    private WebDriver driver;
    
    public LinkPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public WebElement getLinkPopluarMake() {
        return driver.findElement(By.cssSelector("img[title='Alfa Romeo']"));
    }

    public WebElement getLinkPopluarModel() {
        return driver.findElement(By.cssSelector("img[title='Guilia Quadrifoglio']"));
    }

    public WebElement getLinkOverall() {
        return driver.findElement(By.cssSelector("img[src='/img/overall.jpg']"));
    }
    
    

    
}

