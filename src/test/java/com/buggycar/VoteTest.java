package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.pageobjects.VotePage;
import com.buggycar.utils.Hook;
import com.buggycar.utils.FileUtils;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class VoteTest extends Hook{

    
  @Test(priority = 10)
  public void voteTest(){
      
    LoginPage loginPage = new LoginPage(driver);
    VotePage votePage = new VotePage(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    String password = dotenv.get("PASSWORD");
 
    // Navigate to homepage
    driver.get(baseUrl + "/");

    // Type usrname into login form
    loginPage.EnterUsername(username);

    // Type password into login form      
    loginPage.EnterPassword(password);
      
    // click login button
    loginPage.ClickLoginButton();;
  
    votePage.WaitModelPresent(); 
    // Click the link
    votePage.getPopularModeLink().click();
         
    votePage.WaitCommentPresent();
    votePage.EnterComment("comment from morgan");
    
    // Click on the vote button 
    votePage.getVoteButton().click();;
    // Assert the text content of the p element
    votePage.WaitSuccessMessage();
    String expectedMessage = votePage.expectedMessage;
    String actualMessage = votePage.getActualMessage();
    assertEquals(expectedMessage, actualMessage);       
  }
}
