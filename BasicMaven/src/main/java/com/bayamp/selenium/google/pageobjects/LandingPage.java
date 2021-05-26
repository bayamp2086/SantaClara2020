package com.bayamp.selenium.google.pageobjects;

import com.bayamp.selenium.google.base.BaseGoogleUI;
import com.bayamp.selenium.google.pageobjects.locators.LandingPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class LandingPage extends BaseGoogleUI {
    private WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver= driver;
    }

    public boolean landingHelloTxtElementPresent() {
        WebElement helloTxtElement;

        try {
            //Explicit wait in case of Login Implicit Wait
            helloTxtElement = driver.findElement(LandingPageLocators.HELLO_WORLD_TXT_ID_LOCATOR);
        } catch(NoSuchElementException e){
            Reporter.log("Enough of Waiting", true);
            return false;
        }
        if(helloTxtElement.isDisplayed()){
            return true;
        }
        return false;
    }

}