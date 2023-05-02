package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;
import com.buggycar.pageobjects.LoginPage;
import com.buggycar.pageobjects.ProfilePage;
import com.buggycar.utils.Hook;
import com.buggycar.utils.FileUtils;

public class ProfileTest extends Hook{

  @Test(priority = 1)
  public void profileTest(){
      
    LoginPage loginPage = new LoginPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String fileName = "username.txt";
    String password = dotenv.get("PASSWORD");
    String username = FileUtils.readLastLine(fileName);
    // Navigate to homepage
    driver.get(baseUrl + "/");
 
    // Type usrname into login form
    loginPage.EnterUsername(username);

    // Type password into login form
    loginPage.EnterPassword(password);
    
    // click login button
    loginPage.ClickLoginButton();;

    loginPage.WaitProfilePresent();

  
    // assert profile displayed that means login sucessfully
    assertTrue(loginPage.getProfileButton().isDisplayed());
    
    loginPage.ClickProfileButton();
     
    profilePage.WaitAgePresent();
    //update age input field
    profilePage.EnterAge("95");
   
    //update hobby dropdown list
    profilePage.SlectHobbhy("Working");

    profilePage.ClickSubmitButton();

    profilePage.WaitSuccessMessage();
    // assert successful infomation pop up
    //assertTrue(profilePage.getSuccessfulResult().isDisplayed(), "Success message is not displayed");
    assertEquals(profilePage.getSuccessfulResult(), profilePage.expectedMessage, "Success message text is not as expected");   

    }

    

}
