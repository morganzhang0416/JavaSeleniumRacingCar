package com.buggycar.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.buggycar.utils.WaitConditions;
import java.time.Duration;

public class LinkPage {

    private WebDriver driver;
    private String popularMakeTag = "img[title='Alfa Romeo']";
    private String popularModelTag = "img[title='Guilia Quadrifoglio']";
    private String OverallTag = "img[src='/img/overall.jpg']";
    WaitConditions wait;
    
    public LinkPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitConditions(driver);
    }

    public WebElement getElementPopluarMake() {
        return driver.findElement(By.cssSelector(popularMakeTag));
    }

    public WebElement getElementPopluarModel() {
        return driver.findElement(By.cssSelector(popularModelTag));
    }

    public WebElement getElementOverall() {
        return driver.findElement(By.cssSelector(OverallTag));
    }
    
    public void clickPopularMakeLink() {
        
        wait.WaitLocatorClickable(By.cssSelector(popularMakeTag), Duration.ofSeconds(8));
        getElementPopluarMake().click();
    }

    public void clickPopularModelLink() {
        
        wait.WaitLocatorClickable(By.cssSelector(popularModelTag), Duration.ofSeconds(8));
        getElementPopluarModel().click();
    }

    public void clickOverallLink() {
        
        wait.WaitLocatorClickable(By.cssSelector(OverallTag), Duration.ofSeconds(8));
        getElementOverall().click();
    }
    

    
}

