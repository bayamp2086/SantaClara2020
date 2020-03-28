package com.bayamp.pleasanton2020.base;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class BaseClass {

    @AfterMethod
    public void cleanUp() {
        Reporter.log("Let me clean up the data for this test");
    }

}
