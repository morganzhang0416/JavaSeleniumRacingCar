package com.buggycar;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import com.buggycar.pageobjects.LinkPage;
import com.buggycar.utils.BaseTest;
import com.buggycar.utils.WaitConditions;

import static org.testng.Assert.assertTrue;

// test for visit different link of home page
public class LinkTest extends BaseTest{

    @Test(priority = 1)
    public void linkTest(){
        // Navigate to homepage
        LinkPage linkpage = new LinkPage(driver);
        WaitConditions wait = new WaitConditions(driver);
        driver.get(baseUrl + "/");

        // Assert that the current URL matches the expected URL
        wait.WaitLocatorClickable(By.cssSelector("img[title='Alfa Romeo']"), Duration.ofSeconds(8));
        linkpage.getLinkPopluarMake().click();
         // Get the current URL of the page
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "make";
        System.out.println(currentUrl);
        assertTrue(currentUrl.contains(expectedUrl));
        

    }

    @Test(priority = 2)
    public void linkModelTest(){
        // Navigate to homepage
        LinkPage linkpage = new LinkPage(driver);
        WaitConditions wait = new WaitConditions(driver);
        driver.get(baseUrl + "/");

        // Assert that the current URL matches the expected URL
        wait.WaitLocatorClickable(By.cssSelector("img[title='Guilia Quadrifoglio']"), Duration.ofSeconds(8));
        linkpage.getLinkPopluarModel().click();
         // Get the current URL of the page
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "model";
        System.out.println(currentUrl);
        assertTrue(currentUrl.contains(expectedUrl));
        

    }

    @Test(priority = 3)
    public void linkOverallTest(){
        // Navigate to homepage
        LinkPage linkpage = new LinkPage(driver);
        WaitConditions wait = new WaitConditions(driver);
        driver.get(baseUrl + "/");

        // Assert that the current URL matches the expected URL
        wait.WaitLocatorClickable(By.cssSelector("img[src='/img/overall.jpg']"), Duration.ofSeconds(8));
        linkpage.getLinkOverall().click();
         // Get the current URL of the page
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "overall";
        System.out.println(currentUrl);
        assertTrue(currentUrl.contains(expectedUrl));
        

    }

    

}
