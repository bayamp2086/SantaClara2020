package com.bayamp.selenium.webmail.base;

import com.bayamp.santaclara2020.data.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseWebUI {
    private WebDriver driver;

    protected WebDriver getDriver() throws IOException{

        //System.setProperty("chrome.driver.path","never give the absolute path");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PropertyUtils.getProperty("web.url"));
        driver.manage().window().maximize();
        return driver;

    }

    protected String getUserName() throws IOException {

        String userName = PropertyUtils.getProperty("login.ui.user");
        return userName;

    }

    protected String getPassword() throws IOException {

        String password = PropertyUtils.getProperty("login.ui.password");
        return password;

    }

    @AfterMethod
    public void close() throws Exception {

        if(driver != null) {
            driver.quit();
        }

    }
}
