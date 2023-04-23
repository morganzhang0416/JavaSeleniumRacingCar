package com.buggycar;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.utils.BaseTest;
import com.buggycar.utils.FileUtils;
import com.buggycar.utils.WaitConditions;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest{
  
  //test correct credential
  @Test(priority = 1)
  public void correctCredentialTest(){
         
    LoginPage loginPage = new LoginPage(driver);
    WaitConditions wait = new WaitConditions(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String password = dotenv.get("PASSWORD");
    // Navigate to homepage
    driver.get(baseUrl + "/");

    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    System.out.println(username);

    // Type usrname into login form
    loginPage.getUsernameInput().sendKeys(username);

    // Type password into login form
      
    loginPage.getPasswordInput().sendKeys(password);
          
 
    // click login button
    loginPage.getLoginButton().click();
    
    wait.WaitLocatorClickable(By.linkText("Profile"),Duration.ofSeconds(8));
        
    // assert profile displayed that means login sucessfully

    assertTrue(loginPage.getProfileButton().isDisplayed());
   }
  
   // test wrong credential with wrong password
  @Test(priority = 2)
  public void wrongCredentialTest(){
         
    LoginPage loginPage = new LoginPage(driver);
    WaitConditions wait = new WaitConditions(driver);
    // Navigate to homepage
    driver.get(baseUrl + "/");

    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    System.out.println(username);

    // Type usrname into login form
    loginPage.getUsernameInput().sendKeys(username);

    // Type wrong password into login form
      
    loginPage.getPasswordInput().sendKeys("Gogo_123#");
          
 
    // click login button
    loginPage.getLoginButton().click();
    
    wait.WaitLocatorVisibility(By.className("label-warning"),Duration.ofSeconds(8));
    String expectedMessage = "Invalid username/password";
    
    // wait for wain message element until 8s 
    
    wait.WaitLocatorVisibility(By.className("label-warning"),Duration.ofSeconds(8));
      // assert successful infomation pop up
    assertTrue(loginPage.getInvilidLoginMessage().isDisplayed(), "Success message is not displayed");
    assertEquals(loginPage.getInvilidLoginMessage().getText().trim(), expectedMessage, "Success message text is not as expected");       
  }

  //test logout function
  @Test(priority = 3)
  public void logoutTest(){

    LoginPage loginPage = new LoginPage(driver);
    WaitConditions wait = new WaitConditions(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String password = dotenv.get("PASSWORD");
    // Navigate to homepage
    driver.get(baseUrl + "/");

    String fileName = "username.txt";
    String username = FileUtils.readLastLine(fileName);
    System.out.println(username);

    // Type usrname into login form
    loginPage.getUsernameInput().sendKeys(username);

    // Type password into login form
      
    loginPage.getPasswordInput().sendKeys(password);
          
 
    // click login button
    loginPage.getLoginButton().click();
    
    wait.WaitLocatorClickable(By.linkText("Logout"),Duration.ofSeconds(8));
        
    // assert profile displayed that means login sucessfully
    loginPage.getLogoutButton().click();

    wait.WaitLocatorVisibility(By.name("login"), Duration.ofSeconds(8));

    assertTrue(loginPage.getLoginButton().isDisplayed());
   }
}
