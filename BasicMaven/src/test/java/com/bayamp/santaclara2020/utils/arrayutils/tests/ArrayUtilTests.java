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

    @Test(groups = { "arrays", "p1", "smoke" })
    public void removeDuplicatesTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 20, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int[] expectedArray = { 10, 40, 20 };
        Reporter.log("The expected array is :" + Arrays.toString(expectedArray));
        int[] actualArray = ArrayUtils.removeDuplicates(myInputArray);

        Reporter.log("The actual array is :" + Arrays.toString(actualArray));
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualArray, expectedArray);
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void highestNumberTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int expectedOutput = 40 ;
        Reporter.log("The expected output is :" + expectedOutput);
        int actualOutput = ArrayUtils.highestNumber(myInputArray);

        Reporter.log("The actual output is :" + actualOutput);
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void secondHighestNumberTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int expectedOutput = 30 ;
        Reporter.log("The expected output is :" + expectedOutput);
        int actualOutput = ArrayUtils.secondHighestNumber(myInputArray);

        Reporter.log("The actual output is :" + actualOutput);
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void smallestNumberTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int expectedOutput = 10 ;
        Reporter.log("The expected output is :" + expectedOutput);
        int actualOutput = ArrayUtils.smallestNumber(myInputArray);

        Reporter.log("The actual output is :" + actualOutput);
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void secondSmallestNumberTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        int expectedOutput = 20 ;
        Reporter.log("The expected output is :" + expectedOutput);
        int actualOutput = ArrayUtils.secondSmallestNumber(myInputArray);

        Reporter.log("The actual output is :" + actualOutput);
        Reporter.log("Perform Validations");
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void searchNumberTest() {
        // TEST DATA
        int[] myInputArray = { 10, 20, 30, 40 };
        int numberToBeFound = 10;
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        Reporter.log("The number to be found in the array is :" + numberToBeFound );
        boolean isFound = ArrayUtils.searchNumber(myInputArray,numberToBeFound);

        Reporter.log("Perform Validations");
        Assert.assertTrue(isFound, "The number is not found in the array");
        Reporter.log("Validations Complete");
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void checkSumTest() {
        // TEST DATA
        int[] myInputArray = {3,4,5,7,2,8,9,10,6};
        int sum =10;
        /*String expectedOutput = "(7,3) ";
        Reporter.log("The input array is :" + Arrays.toString(myInputArray));
        Reporter.log("The expected output is :" + expectedOutput );*/
        StringBuilder sb = ArrayUtils.checkSum(myInputArray,sum);
        String pairs = sb.toString();

        Reporter.log("The pairs are :" + pairs,true);
       /* Reporter.log("Perform Validations");
        Assert.assertEquals(actualOutput, expectedOutput);
        Reporter.log("Validations Complete");*/
    }

    @Test(groups = { "arrays", "p1", "smoke" })
    public void numberCountTest() {
        // TEST DATA
        int[] myInputArray = {2, 3, 3, 4, 10, 3, 5, 4, 1, 3, 3, 1, 7, 4};
        StringBuilder sb =ArrayUtils.numberCount(myInputArray);
        Reporter.log("Highest Repeating to lowest :" + sb.toString(),true);
    }
}