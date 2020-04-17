package com.bayamp.santaclara2020.base;

import com.bayamp.santaclara2020.generic.Constants;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DummyBaseUIClass extends DummyBaseClass {

    protected static Properties uiConfig = null;

    @BeforeClass(alwaysRun = true)
    protected void loadUIConfiguration() throws IOException {
        Reporter.log("DummyBaseClassP:loadConfiguration", true);
        if(uiConfig == null) {
            uiConfig = new Properties();
            File file = new File(Constants.UI_CONFIG_FILE_PATH);
            InputStream fileInput = new FileInputStream(file);
            uiConfig.load(fileInput);
        }
    }

    @AfterClass(alwaysRun = true)
    protected void resetUIConfiguration() {
        Reporter.log("DummyBaseClassP:resetConfiguration", true);
    }

}
