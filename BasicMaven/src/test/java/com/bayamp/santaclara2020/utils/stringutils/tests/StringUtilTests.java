package com.bayamp.bayamplib.utils.stringutils.tests;

import com.bayamp.base.BaseClass;
import com.bayamp.utils.Book;
import com.bayamp.utils.Student;
import org.testng.Reporter;
import org.testng.annotations.Test;

@Test(groups = { "regression" })
public class StringUtilTests extends BaseClass {

    /*
     * @Test(dataProvider = "getMapCSVData", groups = { "strings", "p2", "smoke" },
     * dataProviderClass = com.bayamp.utils.BayampDataProvider.class) public void
     * mapTest(Map<String, String> map) {
     *
     * Reporter.log(map.toString(), true);
     *
     * }
     */

    @Test(dataProvider = "getBookCSVData", dataProviderClass = com.bayamp.utils.BayampDataProvider.class)
    public void bookTest(Book b1) {

        Reporter.log(b1.getString(), true);
    }

    @Test(dataProvider = "getXMLData", dataProviderClass = com.bayamp.utils.BayampDataProvider.class)
    public void registration(Student student) {

        Reporter.log(student.getString(), true);
    }

    @Test(dataProvider = "getJSONData", dataProviderClass = com.bayamp.utils.BayampDataProvider.class)
    public void studentDetails(Student student) {

        Reporter.log(student.toString(), true);
    }


}
