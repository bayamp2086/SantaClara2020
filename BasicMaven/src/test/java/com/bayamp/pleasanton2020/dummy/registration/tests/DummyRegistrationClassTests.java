package com.bayamp.pleasanton2020.dummy.registration.tests;

import com.bayamp.pleasanton2020.base.DummyBase;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DummyRegistrationClassTests extends DummyBase {

    @BeforeClass
    public void beforeMethodOfDummyRegistrationClassTests() {
        Reporter.log("beforeMethodOfDummyRegistrationClassTests() of Test",true);
       //Assert.fail();
    }

    @Test(dependsOnMethods = {"testToCheckIFSeverIsUpAndRunning"})
    public void validAddressTest() {

        Reporter.log("validAddressTest testmethod of DummyRegistrationClassTests",true);
    }

}
