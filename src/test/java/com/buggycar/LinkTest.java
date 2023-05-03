package com.buggycar;

import org.testng.annotations.Test;
import com.buggycar.pageobjects.LinkPage;
import com.buggycar.utils.Hook;
import static org.testng.Assert.assertTrue;
import java.nio.file.Paths;

// test for visit different link of home page
public class LinkTest extends Hook{
    @Test(priority = 1)
    public void linkTest(){
        // Navigate to homepage
        String currentPath = Paths.get("").toAbsolutePath().toString();
        System.out.println("Link Current path: " + currentPath);
        LinkPage linkpage = new LinkPage(driver);
        driver.get(baseUrl + "/");

        linkpage.clickPopularMakeLink();
        // Assert that the current URL matches the expected URL
        assertTrue(driver.getCurrentUrl().contains("make"));

    }

    @Test(priority = 2)
    public void linkModelTest(){
        // Navigate to homepage
        LinkPage linkpage = new LinkPage(driver);
        driver.get(baseUrl + "/");

        linkpage.clickPopularModelLink();
         // Assert that the current URL matches the expected URL
        assertTrue(driver.getCurrentUrl().contains("model"));
    
    }

    @Test(priority = 3)
    public void linkOverallTest(){
        // Navigate to homepage
        LinkPage linkpage = new LinkPage(driver);
        driver.get(baseUrl + "/");

        linkpage.clickOverallLink();
        // Assert that the current URL matches the expected URL
        assertTrue(driver.getCurrentUrl().contains("overall"));
        
    }

    

}
