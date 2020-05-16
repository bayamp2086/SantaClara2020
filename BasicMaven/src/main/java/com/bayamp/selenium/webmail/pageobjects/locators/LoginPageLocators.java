package com.bayamp.selenium.webmail.pageobjects.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By USER_FIELD_ID_LOCATOR = By.id("user");
    public static final By PASSWORD_FIELD_ID_LOCATOR = By.id("pass");
    public static final By LOGIN_BUTTON_CSS_LOCATOR = By.cssSelector("button[type='submit']");
    public static final By ERROR_MESSAGE_ID_LOCATOR=  By.id("login-status-message");
    //By.xpath("//*[text()='You must specify a username to log in.']")
}
