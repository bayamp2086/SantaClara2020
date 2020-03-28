package com.bayamp.pleasanton2020.base;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DummyBase {

    @BeforeClass
    public void dummyBeforeClassInDummyBase() {
        Reporter.log("this is my parent @BEfore class of dummyBeforeClassInDummyBase: ",true);
    }

    @Test
    public void testToCheckIFSeverIsUpAndRunning() {

        Reporter.log("Some Health Check ",true);
        Assert.fail();
    }

    @AfterClass
    protected void dummyAfterClassInDummyBase() {

        Reporter.log("this is my parent @After class of dummyBeforeClassInDummyBase: ",true);
    }
}
