package com.bayamp.webservices.restapi.programs;

import com.bayamp.webservices.restapi.restassuredtests.BayampRestAssuredTests;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class BayampRestAssuredClient {

    @Test
    public void bayampRestAssuredClient(){

        //getting all engineers list
        Response responseAllEngineers = BayampRestAssuredTests.getAllEngineers();
        String allEngineers = responseAllEngineers.getBody().asString();
        System.out.println(allEngineers);

        //getting an engineer information with his id
        Response responseAnEngineer = BayampRestAssuredTests.getEngineerWithIdResource("EJJIAzxcd");
        String anEngineer = responseAnEngineer.getBody().asString();
        System.out.println(anEngineer);

        //creating an engineer from POST request
        Response responseCreateEngineer = BayampRestAssuredTests.createEngineerResource();
        String createEngineer = responseCreateEngineer.getBody().asString();
        System.out.println(createEngineer);

        //updating an engineer's information with PUT request
        Response responseUpdateEngineer = BayampRestAssuredTests.updateEngineerResource("EJeoQyxcO");
        String updateEngineerInfo = responseUpdateEngineer.getBody().asString();
        System.out.println(updateEngineerInfo);

        //deleting an engineer
        Response responseDeleteEngineer = BayampRestAssuredTests.deleteEngineerResource("E1cBCCQFL");
        String deleteEngineer = responseDeleteEngineer.getBody().asString();
        System.out.println(deleteEngineer);
    }
}
