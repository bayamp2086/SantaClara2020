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

    /**
     * Method checks whether the page logs in when valid username and password is entered
     *
     * @throws InterruptedException
     */
    @Test
    public void positiveLoginTest() throws InterruptedException {

        String expectedUserEmail = "user1@bayamp.com";
        String expectedLogOutText = "Logout";
        Reporter.log("Login to application URL: " + APP_URL);
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

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

    /**
     * Method checks whether an empty username field prompts a message to enter username
     *
     * @throws InterruptedException
     */
    @Test
    public void negativeLoginTest() throws InterruptedException {
        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        String expectedValidation = "You must specify a username to log in.";
        Thread.sleep(1000);
        By divElement = By.id("login-status-message");
        WebElement errorMessageWebElement = driver.findElement(divElement);
        String valueOfTheMessage = errorMessageWebElement.getText();

        Assert.assertEquals(valueOfTheMessage, expectedValidation);
    }

    /**
     * Method checks whether the password field is masked
     */
   @Test
    public void maskedPasswordTest() {
        driver.get(APP_URL);
        passwordField = driver.findElement(By.id("pass"));

        boolean isMasked = passwordField.getAttribute("type").equals("password");

        Assert.assertTrue(isMasked, "The password field is not masked");
    }

    /**
     * Method checks whether upper case entry in username field is not treated as invalid.
     *
     * @throws InterruptedException
     */
    @Test
    public void upperCaseLoginTest() throws InterruptedException {

        String expectedUserEmail = "user1@bayamp.com";
        String expectedLogOutText = "Logout";

        driver.get(APP_URL);
        userField = driver.findElement(By.id("user"));
        passwordField = driver.findElement(By.id("pass"));
        submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

        userField.clear();
        userField.sendKeys("USER1@BAYAMP.COM");

        //userField.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), "USER1@BAYAMP.COM");

        passwordField.sendKeys("user1");

        submitButton.click();

        String actualUserEmail = driver.findElement(By.id("lblUserNameTxt")).getText();
        String actualLogOutText = driver.findElement(By.id("lblLogout")).getText();

        Assert.assertEquals(actualUserEmail, expectedUserEmail);
        Assert.assertEquals(actualLogOutText, expectedLogOutText);
    }
}

