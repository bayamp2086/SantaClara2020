package com.bayamp.santaclara2020.utils.arrayutils.tests;

import com.bayamp.santaclara2020.base.BaseClass;
import com.bayamp.santaclara2020.data.utils.ArrayUtils;
import com.bayamp.santaclara2020.programs.MyInteger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestUtils extends BaseClass {

    @Test(groups = { "arrays", "p1", "smoke" })
    public void sameIndexElementTest() {
        // TEST DATA
        int[] myInputArray = {2,9,7,3,5,1};
        String expectedOutput = "3";
        Reporter.log("The input array is :" + Arrays.toString(myInputArray),true);
        Reporter.log("The expected output is :" + expectedOutput , true);
        StringBuilder sb = ArrayUtils.sameIndexElement(myInputArray);
        String actualOutput = sb.toString();

        Reporter.log("The actual output  is :" + actualOutput,true);
        Reporter.log("Perform Validations",true);
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete",true);
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void indexOfElementTest() {
        // TEST DATA
        int[] myInputArray = {2,9,7,3,5,1};
        int a=7;
        String expectedOutput = "2";
        Reporter.log("The input array is :" + Arrays.toString(myInputArray),true);
        Reporter.log("The expected output is :" + expectedOutput , true);
        StringBuilder sb = ArrayUtils.indexOfElement(myInputArray,a);
        String actualOutput = sb.toString();

        Reporter.log("The actual output  is :" + actualOutput,true);
        Reporter.log("Perform Validations",true);
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete",true);
    }
    @Test(groups = { "arrays", "p1", "smoke" })
    public void inputStringChkSumTest() {
        String value="1334";
        int temp = 40;
        int sum = MyInteger.parseInt(value,temp);
        System.out.println("The total sum is :" +sum);
    }

}
