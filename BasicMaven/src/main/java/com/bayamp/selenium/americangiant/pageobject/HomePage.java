package com.bayamp.selenium.americangiant.pageobject;

import com.bayamp.selenium.americangiant.base.BaseAmericanGiantUI;
import com.bayamp.selenium.americangiant.pageobjects.locators.HomePageLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class HomePage extends BaseAmericanGiantUI {
    private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver= driver;
        PageFactory.initElements(driver, this);

    }

    public WomensPage womensPageBreadCrumbs() {

        driver.findElement(HomePageLocators.SHOP_WOMEN_FIELD_LOCATOR).click();
        WomensPage womensPage = new WomensPage(driver);
        return womensPage;

    }
    public void clickLinkByHref(String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while(i.hasNext()) {
            WebElement anchor = i.next();
            if(anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }

    /*public WomensPage womensPagePriceCheck() {
        driver.findElement(HomePageLocators.SHOP_WOMEN_FIELD_LOCATOR).click();
        clickLinkByHref("//www.american-giant.com/products/womens-classic-cotton-crew-t-white");
        WomensPage womensPage = new WomensPage(driver);
        return womensPage;
    }*/

    public WomensPage womensPageAddToBag(){
        driver.findElement(HomePageLocators.SHOP_WOMEN_FIELD_LOCATOR).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        WebElement element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.american-giant.com/collections/classic-bundles']")));
        element1.click();
       // clickLinkByHref("https://www.american-giant.com/collections/classic-bundles");
        clickLinkByHref("//www.american-giant.com/products/womens-ponte-legging-kick-flare-super-black");
        WomensPage womensPage = new WomensPage(driver);
        return womensPage;
    }


}
