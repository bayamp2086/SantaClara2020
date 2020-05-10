package com.bayamp.webservices.restapi.programs;

import com.bayamp.webservices.restapi.tests.BayampRestAPITests;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class BayampRestAPIClient {

    @Test
    public static void bayampRestAPIClient() throws ParseException, IOException, URISyntaxException {

        //updating an engineer's information with PUT request
        HttpEntity putEntityContent = BayampRestAPITests.putEngineerPositiveTest("Eks2geIYU");
        String updateEngineerInfo = EntityUtils.toString(putEntityContent);
        System.out.println(updateEngineerInfo);

        //get an engineer id from a list of ids and delete the same from database
        HttpEntity getAllEntityContent = BayampRestAPITests.getAllEngineersPositiveTest();
        JSONObject engineerId = BayampRestAPITests.getAnEngineerFromAllEngineersPositiveTest(getAllEntityContent);
        HttpEntity  deleteEntityContent = BayampRestAPITests.deleteEngineerPositiveTest(engineerId);
        String deleteEngineerMessage = EntityUtils.toString(deleteEntityContent);
        System.out.println(deleteEngineerMessage);

        //get newly created engineer id from POST request and check the same with GET request
        HttpEntity postEntityContent = BayampRestAPITests.postEngineerPositiveTest();
        String newEngineerID = BayampRestAPITests.postEngineerIdPositiveTest(postEntityContent);
        HttpEntity  getEntityContent = BayampRestAPITests.getEngineerPositiveTest(newEngineerID);
        String getEngineerMessage = EntityUtils.toString(getEntityContent);
        System.out.println(getEngineerMessage);
    }
}
