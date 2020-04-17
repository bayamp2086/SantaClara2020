package com.bayamp.santaclara2020.utils.arrayutils.tests;

import com.bayamp.santaclara2020.base.BaseClass;
import com.bayamp.santaclara2020.data.utils.ArrayUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.util.Arrays;

@Test(groups = { "regression" })
public class ArrayUtilTests extends BaseClass {

    @Test(groups = { "arrays", "p1", "smoke" })
    public void reverseArrayTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int[] expectedArray = { 40, 30, 20, 10 };
        Reporter.log("The expected array is :" + Arrays.toString(expectedArray));
        int[] actualArray = ArrayUtils.reverseArray(myInputArray);

        Reporter.log("The actual array is :" + Arrays.toString(actualArray));
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualArray, expectedArray);
        Reporter.log("Validations Complete");
    }
}