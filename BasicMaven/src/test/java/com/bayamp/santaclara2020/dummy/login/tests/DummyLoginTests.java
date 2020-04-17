package com.bayamp.santaclara2020.dummy.login.tests;

import com.bayamp.santaclara2020.base.DummyBaseUIClass;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DummyLoginTests extends DummyBaseUIClass {
    @Test(priority = 2)
    public void validUserNameAndValidPasswordTest() {
        Reporter.log("DummyLoginTests:validUserNameAndValidPasswordTest");
        String user = config.getProperty("login.ui.user");
        String password = config.getProperty("login.ui.password");

        Reporter.log("The user is :" + user, true);
        Reporter.log("The password is :" + password, true);
    }

    @Test(priority = 3)
    public void invalidUserNameTest() {
        Reporter.log("DummyLoginTests:invalidUserNameTest");

        // Database
        String dbUser = config.getProperty("oracle.db.user");
        String dbPassword = config.getProperty("oracle.db.password");
    }

    @Test(priority = 4)
    public void invalidPasswordTest() {
        Reporter.log("DummyLoginTests:invalidPasswordTest");
    }

    @Test(priority = 1)
    public void nullUserNameTest() {
        Reporter.log("DummyLoginTests:nullUserNameTest");
    }

    @Test(priority = 1)
    public void nullPasswordTest() {
        Reporter.log("DummyLoginTests:nullPasswordTest");
    }
}
