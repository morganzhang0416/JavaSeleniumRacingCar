package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.pageobjects.VotePage;
import com.buggycar.utils.BaseTest;
import com.buggycar.utils.FileUtils;
import com.buggycar.utils.WaitConditions;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class VoteTest extends BaseTest{

    
  @Test(priority = 10)
  public void voteTest(){
      
    LoginPage loginPage = new LoginPage(driver);
    VotePage votePage = new VotePage(driver);
    WaitConditions wait = new WaitConditions(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String password = dotenv.get("PASSWORD");
    // Navigate to homepage
    driver.get(baseUrl + "/");

    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    System.out.println(username);
    Random rand = new Random();
    int randomNumber = rand.nextInt(100);
    // Type usrname into login form
    loginPage.getUsernameInput().sendKeys(username);

    // Type password into login form
      
    loginPage.getPasswordInput().sendKeys(password);
      
    // click login button
    loginPage.getLoginButton().click();
      
    // Navigate to homepage
    wait.WaitLocatorClickable(By.cssSelector("img[title='Guilia Quadrifoglio']"), Duration.ofSeconds(8));  
    // Click the link
    votePage.getPopularModeLink().click();
         
    wait.WaitLocatorClickable(By.id("comment"), Duration.ofSeconds(8));
    votePage.getTextareaInput().sendKeys("test comment from mz" + randomNumber);
    
    // Click on the vote button 
    votePage.getVoteButton().click();;
    // Assert the text content of the p element
    wait.WaitLocatorVisibility(By.className("card-text"), Duration.ofSeconds(8));
    String expectedMessage = "Thank you for your vote!";
    String actualMessage = votePage.getSuccessfulMessage().getText();
    assertEquals(expectedMessage, actualMessage); 
    
         
  }

    

}
