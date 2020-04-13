package com.bayamp.santaclara2020.apitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Test
public class BayampLoginTests {

    private static final String APP_URL = "http://webmail.bayamp.com";
    private static WebDriver driver;
    private WebElement userField;
    private WebElement passwordField;
    private WebElement submitButton;

    @BeforeClass
    public void setUpDriver() {
        driver = new ChromeDriver();

    }

    @AfterClass
    public void closeDriver() {
        driver.close();
    }

    @Test // lblUserNameTxt , lblLogout
    public void positiveLoginTest() throws InterruptedException {

        String expectedUserEmail = "user1@bayamp.com";
        String expectedLogOutText = "Logout";
        Reporter.log("Login to application URL: " + APP_URL);
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        // driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        // To Synchronize with the delay in the application loading the pages
        // Thread.sleep(30000);//hard wait of 30secs
        WebDriverWait wait = new WebDriverWait(driver, 30);// max of 30 secs
        wait.until(ExpectedConditions.visibilityOf(userField));
        // ExpectedConditions.presenceOfAllElementsLocatedBy(locator);

        userField.sendKeys("user1@bayamp.com");

        passwordField.sendKeys("user1");

        submitButton.click();

        String actualUserEmail = driver.findElement(By.id("lblUserNameTxt")).getText();
        String actualLogOutText = driver.findElement(By.id("lblLogout")).getText();

        Assert.assertEquals(actualUserEmail, expectedUserEmail);
        Assert.assertEquals(actualLogOutText, expectedLogOutText);

    }

    @Test
    public void negativeLoginTest() {
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        userField.sendKeys("user12@bayamp.com");
        //driver.close();
    }
}

