package com.bayamp.selenium.google.pageobjects;

import com.bayamp.selenium.google.base.BaseGoogleUI;
import com.bayamp.selenium.google.pageobjects.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseGoogleUI {
    private WebDriver driver;
    //private WebElement errorMessageWebElement;

    public HomePage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }
    public LandingPage searchSuccess() {

        //driver.switchTo().frame(1);
        driver.switchTo().frame("backgroundImage");
        WebElement element = driver.findElement(HomePageLocators.INPUT_FIELD_LOCATOR);
        element.sendKeys("Hello World!/n");
        element.submit();

        LandingPage landingPage = new LandingPage(driver);
        return landingPage;

    }

    public String getURL() {

        return driver.getCurrentUrl();
    }
}
