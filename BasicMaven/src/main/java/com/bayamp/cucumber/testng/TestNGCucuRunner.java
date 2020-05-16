package com.bayamp.cucumber.testng;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
        "features/login-test.feature"
        },
        glue = "com.bayamp.cucumber.selenium.step.definitions"
)
public class TestNGCucuRunner extends AbstractTestNGCucumberTests{

}
