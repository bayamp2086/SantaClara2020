package com.bayamp.selenium.americangiant.tests;

import com.bayamp.selenium.americangiant.pageobject.HomePage;
import com.bayamp.selenium.americangiant.pageobject.WomensPage;
import com.bayamp.selenium.americangiant.base.BaseAmericanGiantUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeTests extends BaseAmericanGiantUI {

    private WebDriver driver;
    private HomePage homePage;


    @BeforeMethod
    public void setUp() throws Exception {

        driver = getDriver();
        homePage =  new HomePage(driver);

    }

    @Test
    public void womensPageBreadCrumbTest() throws Exception {

        WomensPage womensPage = homePage.womensPageBreadCrumbs();
        Assert.assertTrue(womensPage.womensPageBreadCrumbPresent());

    }

    @Test
    public void womensPagePonteLeggingPriceCheck() throws Exception {

        WomensPage womensPage = homePage.womensPageAddToBag();
        Assert.assertTrue(womensPage.womensPageWhiteShirtAddToBag());

    }
}
