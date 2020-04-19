package com.bayamp.selenium.webmail.tests;

import com.bayamp.selenium.webmail.base.BaseWebUI;
import com.bayamp.selenium.webmail.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseWebUI {

    @Test
    public void loginPositiveTest() {

        WebDriver driver = getDriver();//this driver object is v.important as it holds the state of entire browser session.

        LoginPage loginPage = new LoginPage(driver);
        boolean check = loginPage.login("user1@bayamp.com", "user1");

        Assert.assertTrue(check,"Login Failed");

    }
    @Test
    public void loginNegativeTest() {

        WebDriver driver = getDriver();//this driver object is v.important as it holds the state of entire browser session.

        LoginPage loginPage = new LoginPage(driver);
        boolean check = loginPage.login();

        Assert.assertTrue(check,"Login Failed");

    }
}
