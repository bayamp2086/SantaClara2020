package com.bayamp.santaclara2020.apitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BayampMessageToolBarTests {


    private static final String APP_URL = "http://webmail.bayamp.com";
    private static WebDriver driver;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement composeField;
    private WebElement submitButton;

    @BeforeClass
    public void setUpDriver() {
        driver = new ChromeDriver();

    }

    @AfterClass
    public void closeDriver() {
        driver.switchTo().defaultContent();
        driver.close();
    }

    @Test //rcmbtn107,_from
    public void composeMailTest() throws InterruptedException {

        String expectedUserEmail = "user1@bayamp.com";

        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        userField.sendKeys("user1@bayamp.com");
        passwordField.sendKeys("user1");
        submitButton.click();

        //Switch driver to frame to access the compose field
        driver.switchTo().frame(driver.findElement(By.id("mailFrame")));
        composeField = driver.findElement(By.id("rcmbtn107")); // xpath("//*[@id=\"messagetoolbar\"]/a[@id=\"rcmbtn107\"]"
        composeField.click();

        //select to find the element from dropdown
        Select select = new Select(driver.findElement(By.id("_from")));
        WebElement option = select.getFirstSelectedOption();
        String actualUserEmail = option.getText();

        Assert.assertEquals(actualUserEmail, expectedUserEmail);

    }

}
