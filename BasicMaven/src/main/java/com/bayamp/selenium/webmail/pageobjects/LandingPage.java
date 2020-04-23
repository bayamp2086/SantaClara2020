package com.bayamp.selenium.webmail.pageobjects;

import com.bayamp.selenium.webmail.base.BaseWebUI;
import com.bayamp.selenium.webmail.pageobjects.locators.LandingPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class LandingPage extends BaseWebUI {
   private WebDriver driver;

   public LandingPage(WebDriver driver){
        this.driver= driver;
    }

   public String getUserName(){

        String actualUserEmail = driver.findElement(LandingPageLocators.USER_EMAIL_FIELD_ID_LOCATOR).getText();
        return actualUserEmail;

   }

   public boolean isLogOutElementPresent() {
       WebElement logoutElement;

       try {
           //Explicit wait in case of Login Implicit Wait
           logoutElement = driver.findElement(LandingPageLocators.LOGOUT_FIELD_ID_LOCATOR);
       } catch(NoSuchElementException e){
           Reporter.log("Enough of Waiting", true);
           return false;
       }
       if(logoutElement.isDisplayed()){
           return true;
       }
       return false;
   }

}
