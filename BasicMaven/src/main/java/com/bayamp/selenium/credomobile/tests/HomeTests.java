package com.bayamp.selenium.credomobile.tests;

import com.bayamp.selenium.credomobile.base.BaseCredoUI;
import com.bayamp.selenium.credomobile.pageobjects.HomePage;
import com.bayamp.selenium.credomobile.pageobjects.PlansPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTests extends BaseCredoUI {
    private WebDriver driver;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() throws Exception {

        driver = getDriver();
        homePage =  new HomePage(driver);

    }

    @Test
    public void plansPageTest() throws Exception {

        PlansPage plansPage = homePage.plans();
        Assert.assertTrue(plansPage.plansImageTxtElementPresent());

    }

   /* @Test
    public void shopPageTest() throws Exception {

        ShopPage shopPage = homePage.shop();
        Assert.assertTrue(shopPage.shopImageTxtElementPresent());

    }*/
}
