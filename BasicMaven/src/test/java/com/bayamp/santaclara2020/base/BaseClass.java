package com.bayamp.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    @BeforeClass
    public void createFile() {

    }

    @AfterClass
    public void deleteFile() {
    }

}
