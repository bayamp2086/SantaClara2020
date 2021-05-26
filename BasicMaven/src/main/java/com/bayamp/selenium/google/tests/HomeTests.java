package com.bayamp.selenium.google.tests;

import com.bayamp.selenium.google.pageobjects.HomePage;
import com.bayamp.selenium.google.base.BaseGoogleUI;
import com.bayamp.selenium.google.pageobjects.LandingPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTests extends BaseGoogleUI {
    private WebDriver driver;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() throws Exception {

        driver = getDriver();
        homePage =  new HomePage(driver);

    }

    @Test
    public void landingPageTest() throws Exception {

        LandingPage landingPage = homePage.searchSuccess();
        Assert.assertTrue(landingPage.landingHelloTxtElementPresent());

    }

}
