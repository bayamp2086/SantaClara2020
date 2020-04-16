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

public class BayampMailBoxFunctionalityTests {


    private static final String APP_URL = "http://webmail.bayamp.com";
    private static WebDriver driver;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement composeField;
    private WebElement inboxField;
    private WebElement mailfield;
    private WebElement replyField;
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

    /**
     * Checks whether when compose is clicked it goes to compose mail window and user email is under from drop down
     *
     * @throws InterruptedException
     */
    @Test
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

    /**
     * Checks whether when mail in Inbox is clicked the reply button is be enabled
     *
     * @throws InterruptedException
     */
    @Test
    public void inboxMailTest() throws InterruptedException {

        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        userField.clear();
        userField.sendKeys("user1@bayamp.com");
        passwordField.sendKeys("user1");
        submitButton.click();

        //Switch driver to frame to access the inbox field
        driver.switchTo().frame(driver.findElement(By.id("mailFrame")));
        inboxField = driver.findElement(By.id("rcmliSU5CT1g"));

        inboxField.click();
        Thread.sleep(1000);
        mailfield = driver.findElement(By.id("rcmrowNw"));
        mailfield.click();
        replyField = driver.findElement(By.id("rcmbtn108"));
        boolean isEnabled = replyField.getAttribute("aria-disabled").equals("false");

        Assert.assertTrue(isEnabled, "The reply field is not enabled when mail in Inbox is clicked");
    }

}
