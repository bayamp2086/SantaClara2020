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

public class DummyBaseClass {

    protected static Properties config = null;

    @BeforeClass(alwaysRun=true)
    protected void loadConfiguration() throws IOException {
        Reporter.log("DummyBaseClassGP:loadConfiguration",true);
        Reporter.log("Load config.properties");

        if(config==null) {
            config = new Properties();
            File file= new File(Constants.CONFIG_FILE_PATH);
            InputStream fileInput = new FileInputStream(file);
            config.load(fileInput);
        }
    }
    @AfterClass(alwaysRun=true)
    protected void resetConfiguration() {
        Reporter.log("DummyBaseClassGP:resetConfiguration",true);
        Reporter.log("Reset config.properties");
    }
}
