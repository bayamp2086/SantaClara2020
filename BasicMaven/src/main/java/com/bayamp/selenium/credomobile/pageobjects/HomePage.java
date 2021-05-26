package com.bayamp.selenium.credomobile.pageobjects;

import com.bayamp.selenium.credomobile.pageobjects.locators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }
    public PlansPage plans() {

       /* driver.findElement(HomePageLocators.INPUT_FIELD_LOCATOR).sendKeys("Hello World" + Keys.ENTER);
        PlansPage plansPage = new PlansPage(driver);
        return plansPage;*/

        driver.switchTo().frame(1);
        WebElement element = driver.findElement(HomePageLocators.INPUT_FIELD_LOCATOR);
        element.sendKeys("Hello World!/n");
        element.submit();

        PlansPage plansPage = new PlansPage(driver);
        return plansPage;

    }


   /* public PlansPage plans() {

        driver.findElement(HomePageLocators.PLANS_FIELD_ID_LOCATOR).click();
        PlansPage plansPage = new PlansPage(driver);
        return plansPage;

    }

    public ShopPage shop() {

        driver.findElement(HomePageLocators.SHOP_FIELD_ID_LOCATOR).click();
        ShopPage shopPage = new ShopPage(driver);
        return shopPage;

    }*/

    public String getURL() {

        return driver.getCurrentUrl();
    }
}
