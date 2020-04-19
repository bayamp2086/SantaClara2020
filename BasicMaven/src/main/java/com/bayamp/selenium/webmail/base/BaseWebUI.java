package com.bayamp.selenium.webmail.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseWebUI {

    protected WebDriver getDriver() {

        //System.setProperty("chrome.driver.path","never give the absolute path");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://webmail.bayamp.com");

        return driver;

    }
}
