package com.buggycar;

import org.testng.annotations.Test;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.utils.Hook;
import com.buggycar.utils.FileUtils;
import com.buggycar.utils.WaitConditions;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginTest extends Hook{

  LoginPage loginPage;
  WaitConditions wait;
  DotenvBuilder dotenvBuilder;
  Dotenv dotenv;
  String password;
  String wrongPassword = "Gogo_123#";
  String fileName;
  String username;

  public LoginTest(){

    dotenvBuilder =  Dotenv.configure();
    dotenv = dotenvBuilder.load();
    password = dotenv.get("PASSWORD");
    fileName = "username.txt";
    username = FileUtils.readLastLine(fileName);
  }

  //test correct credential
  @Test(priority = 1)
  public void correctCredentialTest(){
         
    loginPage = new LoginPage(driver);
    wait = new WaitConditions(driver);
    // Navigate to homepage
    driver.get(baseUrl + "/");
    // Type usrname into login form
    loginPage.EnterUsername(username);
    // Type password into login form
    loginPage.EnterPassword(password);
    // click login button
    loginPage.ClickLoginButton();
    loginPage.WaitProfilePresent();    
    // assert profile displayed that means login sucessfully
    assertTrue(loginPage.getProfileButton().isDisplayed());
   }
  
   // test wrong credential with wrong password
  @Test(priority = 2)
  public void wrongCredentialTest(){
         
    loginPage = new LoginPage(driver);
    wait = new WaitConditions(driver);
    // Navigate to homepage
    driver.get(baseUrl + "/");

    // Type usrname into login form
    loginPage.EnterUsername(username);

    // Type wrong password into login form  
    loginPage.EnterPassword(wrongPassword);
  
    // click login button
    loginPage.ClickLoginButton();
      
    String expectedMessage = "Invalid username/password";
    
    // wait for wain message element until 8s 
    
    loginPage.WaitInvalidLoginPresent();

      // assert successful infomation pop up
    assertEquals(loginPage.getInvilidLoginMessage(), expectedMessage, "Success message text is not as expected");       
  }

  //test logout function
  @Test(priority = 3)
  public void logoutTest(){

    loginPage = new LoginPage(driver);
    wait = new WaitConditions(driver);
    // Navigate to homepage
    driver.get(baseUrl + "/");

    // Type usrname into login form
    loginPage.EnterUsername(username);

    // Type password into login form      
    loginPage.EnterPassword(password);
          
    // click login button
    loginPage.ClickLoginButton();
    
    loginPage.WaitLogoutButtonPresent();
        
    // assert profile displayed that means logout sucessfully
    loginPage.ClickLogoutButton();

    loginPage.WaitLoginPresent();

    assertTrue(loginPage.getElementLogin().isDisplayed());
   }
}
