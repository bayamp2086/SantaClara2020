package com.bayamp.santaclara2020.utils.stringutils.tests;

import com.bayamp.santaclara2020.base.BaseClass;
import com.bayamp.santaclara2020.data.utils.BayampDataProvider;
import com.bayamp.santaclara2020.data.utils.Book;
import com.bayamp.santaclara2020.data.utils.Student;
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

    @Test(dataProvider = "getBookCSVData", dataProviderClass = BayampDataProvider.class)
    public void bookTest(Book b1) {

        Reporter.log(b1.getString(), true);
    }

    @Test(dataProvider = "getXMLData", dataProviderClass = BayampDataProvider.class)
    public void registration(Student student) {

        Reporter.log(student.getString(), true);
    }

    @Test(dataProvider = "getJSONData", dataProviderClass = BayampDataProvider.class)
    public void studentDetails(Student student) {

        Reporter.log(student.toString(), true);
    }


}
