package com.bayamp.selenium.webmail.pageobjects;

import com.bayamp.selenium.webmail.pageobjects.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private WebElement errorMessageWebElement;
    private WebElement logoutField;

    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    public boolean login(String user,String password) {

        boolean isFound = false;

        driver.findElement(LoginPageLocators.USER_FIELD_ID_LOCATOR).sendKeys(user);
        driver.findElement(LoginPageLocators.PASSWORD_FIELD_ID_LOCATOR).sendKeys(password);
        driver.findElement(LoginPageLocators.LOGIN_BUTTON_CSS_LOCATOR).click();

        logoutField = driver.findElement(LoginPageLocators.LOGOUT_FIELD_ID_LOCATOR);
        //boolean check = driver.findElements(LoginPageLocators.USER_EMAIL_FIELD_ID_LOCATOR).size()>0;

        if(logoutField.isDisplayed()){
            isFound = true;
        }
        return isFound;

    }

    public boolean login() {

        boolean isFound = false;

        driver.findElement(LoginPageLocators.LOGIN_BUTTON_CSS_LOCATOR).click();

        errorMessageWebElement = driver.findElement(LoginPageLocators.ERROR_MESSAGE_ID_LOCATOR);
        if(errorMessageWebElement.isDisplayed()){
             isFound = true;
        }
        return isFound;
    }
}
