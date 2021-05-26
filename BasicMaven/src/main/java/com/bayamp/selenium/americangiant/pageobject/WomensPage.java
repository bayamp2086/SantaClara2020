package com.bayamp.selenium.americangiant.pageobject;

import com.bayamp.selenium.americangiant.base.BaseAmericanGiantUI;
import com.bayamp.selenium.americangiant.pageobjects.locators.WomensPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class WomensPage extends BaseAmericanGiantUI {
    private WebDriver driver;

    public WomensPage(WebDriver driver){
        this.driver= driver;
    }

    public boolean womensPageBreadCrumbPresent() {
        WebElement txtElement;

        try {
            txtElement = driver.findElement(WomensPageLocators.WOMEN_PAGE_BREADCRUMB_LOCATOR);
        } catch(NoSuchElementException e){
            Reporter.log("Enough of Waiting", true);
            return false;
        }
        if(txtElement.isDisplayed()){
            return true;
        }
        return false;
    }

    /*public boolean womensPageWhiteShirtPriceCheck() {
        WebElement txtElement;

        try {
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            txtElement = driver.findElement(WomensPageLocators.WHITE_SHIRT_PRIZE_LOCATOR);
        } catch(NoSuchElementException e){
            Reporter.log("Enough of Waiting", true);
            return false;
        }
        if(txtElement.isDisplayed()){
            return true;
        }
        return false;
    }*/

    public boolean womensPageWhiteShirtAddToBag() {
        WebElement txtElement;
        String price;

        try {
            driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
            price = driver.findElement(WomensPageLocators.PONTE_LEGGING_PRIZE_LOCATOR).getText();
        } catch (NoSuchElementException e) {
            Reporter.log("Enough of Waiting", true);
            return false;
        }
       /* if(txtElement.isDisplayed()){
            return true;
        }*/

        if (price == "$84") {
            return true;
        }
        return false;
    }

}
