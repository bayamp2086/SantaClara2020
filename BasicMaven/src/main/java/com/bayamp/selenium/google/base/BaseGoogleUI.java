package com.bayamp.selenium.google.base;

import com.bayamp.santaclara2020.data.utils.GooglePropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseGoogleUI {
    private WebDriver driver;

    protected WebDriver getDriver() throws IOException{

        System.setProperty("chrome.driver.path","/Users/ranji/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(GooglePropertyUtils.getProperty("web.url"));
        driver.manage().window().maximize();
        return driver;

    }

    @AfterMethod
    public void close() throws Exception {

        if(driver != null) {
            driver.quit();
        }

    }
}
