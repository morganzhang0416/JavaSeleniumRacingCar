package com.buggycar;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import com.buggycar.pageobjects.RegisterPage;
import com.buggycar.utils.BaseTest;
import com.buggycar.utils.WaitConditions;
import com.buggycar.utils.FileUtils;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvBuilder;

public class RegisterTest extends BaseTest{

  @Test(priority = 1)
  public void registerTest(){
      
    WaitConditions wait = new WaitConditions(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    driver.get(baseUrl + "/register");
    String fileName = "username.txt";
    DotenvBuilder dotenvBuilder = Dotenv.configure();
    Dotenv dotenv = dotenvBuilder.load();
    String usernameprefix = dotenv.get("USERNAMEPREFIX");
    String password = dotenv.get("PASSWORD");
    String firsttname = dotenv.get("FIRSTNAME");
    String lastname = dotenv.get("LASTNAME");

    FileUtils.writeUsernameToFile(usernameprefix,fileName); 
    
    String username = FileUtils.readLastLine(fileName);
    // Type infomation into register page
    registerPage.getUsernameInput().sendKeys(username);
      
    registerPage.getFristNameInput().sendKeys(firsttname);

    registerPage.getLastNameInput().sendKeys(lastname);

    registerPage.getPasswordInput().sendKeys(password);

    registerPage.getConfirmPasswordInput().sendKeys(password);
      

      // click register button
    registerPage.getSubmitButton().click();

    String expectedMessage = "Registration is successful";

        
    // wait for successful element until 10s 
    
    wait.WaitLocatorVisibility(By.cssSelector("div.result.alert.alert-success"), Duration.ofSeconds(8));
      // assert successful infomation pop up
    assertTrue(registerPage.getSuccessMessage().isDisplayed(), "Success message is not displayed");
    assertEquals(registerPage.getSuccessMessage().getText().trim(), expectedMessage, "Success message text is not as expected");      
    }    
}
