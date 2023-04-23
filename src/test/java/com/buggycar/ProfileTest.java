package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.pageobjects.ProfilePage;
import com.buggycar.utils.BaseTest;
import com.buggycar.utils.FileUtils;
import com.buggycar.utils.WaitConditions;

public class ProfileTest extends BaseTest{

  @Test(priority = 1)
  public void profileTest(){
      
    LoginPage loginPage = new LoginPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    WaitConditions wait = new WaitConditions(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String password = dotenv.get("PASSWORD");
    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    // Navigate to homepage
    driver.get(baseUrl + "/");
 
    // Type usrname into login form
    loginPage.getUsernameInput().sendKeys(username);

    // Type password into login form
    
    loginPage.getPasswordInput().sendKeys(password);
    
    // click login button
    loginPage.getLoginButton().click();

    
    wait.WaitLocatorClickable(By.linkText("Profile"),Duration.ofSeconds(8));
  
    // assert profile displayed that means login sucessfully

    assertTrue(loginPage.getProfileButton().isDisplayed());
    
    loginPage.getProfileButton().click();

       
    wait.WaitLocatorVisibility(By.id("age"), Duration.ofSeconds(8));
    //update age input field
    profilePage.getAgeInput().clear();
    profilePage.getAgeInput().sendKeys("95");
    //update hobby dropdown list
    Select select = new Select(profilePage.getHobbyList());
    select.selectByVisibleText("Working");

    profilePage.getSubmitButton().click();
    
    String expectedMessage = "The profile has been saved successful";

    wait.WaitLocatorVisibility(By.cssSelector("div.result.alert.alert-success.hidden-md-down"), Duration.ofSeconds(8));
    // assert successful infomation pop up
    assertTrue(profilePage.getSuccessfulResult().isDisplayed(), "Success message is not displayed");
    assertEquals(profilePage.getSuccessfulResult().getText().trim(), expectedMessage, "Success message text is not as expected");   

    }

    

}
