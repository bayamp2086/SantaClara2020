package com.bayamp.pleasanton2020.utils.stringutils.tests;

import com.bayamp.pleasanton2020.base.BaseClass;
import org.testng.annotations.Test;

@Test(groups ={"api","api-regression"} )
public class StringUtilsTests extends BaseClass {

    @Test (groups="string,p1,positive",dataProvider = "getTestData",dataProviderClass = com.bayamp.pleasanton2020.data.utils.StringDataProvider.class)
    public void testCase1(int x,String y) throws Exception {
/*       Reporter.log("Begin Test Case 1 Execution");
       Reporter.log("Input Data to the test case " + row.get("input"));
        boolean actualResponse = StringUtils.isPalindrome(row.get("input"));
        //Valiations
        Assert.assertEquals(actualResponse,row.get("expected"));
        Reporter.log("End Test Case 1 Execution");*/

    }

}

