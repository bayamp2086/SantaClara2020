package com.bayamp.selenium.credomobile.base;

import com.bayamp.santaclara2020.data.utils.CredoPropertyUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseCredoUI {
    private WebDriver driver;

    protected WebDriver getDriver() throws IOException{

        System.setProperty("chrome.driver.path","/Users/ranji/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(CredoPropertyUtils.getProperty("web.url"));
        driver.manage().window().maximize();
        return driver;

    }
   /* protected String getUserName() throws IOException {

        String userName = CredoPropertyUtils.getProperty("login.ui.user");
        return userName;

    }

    protected String getPassword() throws IOException {

        String password = CredoPropertyUtils.getProperty("login.ui.password");
        return password;

    }*/

    @AfterMethod
    public void close() throws Exception {

        if(driver != null) {
            driver.quit();
        }

    }
}
