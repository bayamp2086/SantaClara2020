package com.bayamp.selenium.credomobile.pageobjects;

import com.bayamp.selenium.credomobile.base.BaseCredoUI;
import com.bayamp.selenium.credomobile.pageobjects.locators.ShopPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class ShopPage extends BaseCredoUI {
    private WebDriver driver;

    public ShopPage(WebDriver driver){
        this.driver= driver;
    }

    public boolean shopImageTxtElementPresent() {
        WebElement imageTxtElement;

        try {
            //Explicit wait in case of Login Implicit Wait
            imageTxtElement = driver.findElement(ShopPageLocators.SHOP_IMAGE_TXT_ID_LOCATOR);
        } catch(NoSuchElementException e){
            Reporter.log("Enough of Waiting", true);
            return false;
        }
        if(imageTxtElement.isDisplayed()){
            return true;
        }
        return false;
    }
}
