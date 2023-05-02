package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import com.buggycar.pageobjects.RegisterPage;
import com.buggycar.utils.Hook;
import com.buggycar.utils.FileUtils;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class RegisterTest extends Hook{

  @Test(priority = 1)
  public void registerTest(){
      
    RegisterPage registerPage = new RegisterPage(driver);
    String fileName = "username.txt";
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String usernameprefix = dotenv.get("USERNAMEPREFIX");
    String password = dotenv.get("PASSWORD");
    String firsttname = dotenv.get("FIRSTNAME");
    String lastname = dotenv.get("LASTNAME");

    FileUtils.writeUsernameToFile(usernameprefix,fileName); 
    
    String username = FileUtils.readLastLine(fileName);
    

    driver.get(baseUrl + "/register");
    // Type infomation into register page
    registerPage.EnterUserName(username);
      
    registerPage.EnterFristName(firsttname);

    registerPage.EnterLastName(lastname);

    registerPage.EnterPassword(password);

    registerPage.EnterConfirmPassword(password);
      
      // click register button
    registerPage.ClickSubmitButton();
        
    // wait for successful element until 10s 
    registerPage.WaitSuccessMessage();
    // assert successful infomation pop up
    //assertTrue(registerPage.getSuccessMessage().isDisplayed(), "Success message is not displayed");
    assertEquals(registerPage.getSuccessMessage(), registerPage.expectedMessage, "Success message text is not as expected");      
    }    
}
