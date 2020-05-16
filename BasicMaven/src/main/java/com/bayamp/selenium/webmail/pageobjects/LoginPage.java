package com.bayamp.selenium.webmail.pageobjects;

import com.bayamp.selenium.webmail.pageobjects.locators.LoginPageLocators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
    private WebDriver driver;
    private WebElement errorMessageWebElement;

    public LoginPage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public LandingPage loginSuccessful(String user,String password) {

        driver.findElement(LoginPageLocators.USER_FIELD_ID_LOCATOR).sendKeys(user);
        driver.findElement(LoginPageLocators.PASSWORD_FIELD_ID_LOCATOR).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON_CSS_LOCATOR).click();

        LandingPage landingPage = new LandingPage(driver);
        return landingPage;

    }
    public void login(String user,String password) {

        driver.findElement(LoginPageLocators.USER_FIELD_ID_LOCATOR).sendKeys(user);
        driver.findElement(LoginPageLocators.PASSWORD_FIELD_ID_LOCATOR).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON_CSS_LOCATOR).click();
    }

    public void isErrorMessagePresent() throws NoSuchElementException, InterruptedException {
        String expectedErrorMessage = "You must specify a username to log in.";

        Thread.sleep(3000);
        WebElement errorMessageWebElement = driver.findElement(LoginPageLocators.ERROR_MESSAGE_ID_LOCATOR);
        String actualErrorMessage = errorMessageWebElement.getText();

        Reporter.log("Perform Validations");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
        Reporter.log("Validations Complete");
    }

    public String getURL() {

        return driver.getCurrentUrl();
    }
}
