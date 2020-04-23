package com.bayamp.selenium.webmail.tests;

import com.bayamp.selenium.webmail.base.BaseWebUI;
import com.bayamp.selenium.webmail.pageobjects.LandingPage;
import com.bayamp.selenium.webmail.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseWebUI {
    private WebDriver driver;
    private LoginPage loginPage;
    private String userName,password;

    @BeforeMethod
    public void setUp() throws Exception {

        driver = getDriver();
        loginPage =  new LoginPage(driver);

    }

    @Test
    public void loginPositiveTest() throws Exception {

       userName = getUserName();
       password = getPassword();
        LandingPage landingPage = loginPage.login(userName,password);
        Assert.assertTrue(landingPage.isLogOutElementPresent());

    }

    @Test
    public void loginNegativeTest() throws Exception {

        LandingPage landingPage = loginPage.login("dfff","");
        Assert.assertFalse(landingPage.isLogOutElementPresent());

    }
}
