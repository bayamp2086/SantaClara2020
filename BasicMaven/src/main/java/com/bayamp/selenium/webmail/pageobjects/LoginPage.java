package com.bayamp.selenium.webmail.pageobjects;

import com.bayamp.selenium.webmail.pageobjects.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private WebElement errorMessageWebElement;

    public LoginPage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public LandingPage login(String user,String password) {

        driver.findElement(LoginPageLocators.USER_FIELD_ID_LOCATOR).sendKeys(user);
        driver.findElement(LoginPageLocators.PASSWORD_FIELD_ID_LOCATOR).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON_CSS_LOCATOR).click();

        LandingPage landingPage = new LandingPage(driver);
        return landingPage;

    }

    public String getURL() {

        return driver.getCurrentUrl();
    }
}
