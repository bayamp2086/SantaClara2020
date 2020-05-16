package com.bayamp.cucumber.testng;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
        "features/rest-assured.feature"
        },
        glue = "com.bayamp.cucumber.restassured.step.definitions"
)
public class TestRunner extends AbstractTestNGCucumberTests{

}
