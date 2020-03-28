package com.bayamp.pleasanton2020.dummy.login.tests;

import com.bayamp.pleasanton2020.base.DummyBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DummyLoginClassTests extends DummyBase {

    @BeforeClass
    public void beforeMethodOfDummyLoginClassTests() {
        Reporter.log("beforeMethodOfDummyLoginClassTests() of Test",true);
       //Assert.fail();
    }

    @Test
    public void validUserNameAndValidPasswordTest() {

        Reporter.log("validUserNameAndValidPasswordTest testmethod of DummyLoginClassTests",true);
    }

    @Test
    public void invalidUserNameTest() {
        Reporter.log("invalidUserNameTest testmethod of DummyLoginClassTests",true);
    }

    @Test
    public void invalidPasswordTest() {
        Reporter.log("invalidPasswordTest testmethod of DummyLoginClassTests",true);
    }

    @Test
    public void nullUserNameTest() {
        Reporter.log("test1 testmethod of DummyLoginClassTests",true);
    }


    @Test
    public void nullPasswordTest() {
        Reporter.log("test1 testmethod of DummyLoginClassTests",true);
    }



}
