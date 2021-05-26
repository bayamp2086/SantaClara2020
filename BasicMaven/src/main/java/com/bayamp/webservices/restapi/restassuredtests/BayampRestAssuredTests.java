package com.bayamp.webservices.restapi.restassuredtests;

import com.bayamp.webservices.restapi.locators.RestApiLocators;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


public class BayampRestAssuredTests {

    @Test
    public static Response createEngineerResource() {
        System.out.println("testing");
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "RestAssuredPost");

        return
                given()
                        .contentType("application/json")
                        .body(jsonObj.toString())
                        .when()
                        .request("POST", RestApiLocators.POST_ENDPOINT)
                        .then()
                        .statusCode(201)
                        .statusLine(containsString("Created"))
                        .extract().response();
        //System.out.println(response.getBody().asString());
    }

    @Test
    public static Response updateEngineerResource(String engineerId) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "RestAssuredPut1");

        return given()
                .contentType("application/json")
                .body(jsonObj.toString())
                .when()
                .request("PUT", RestApiLocators.PUT_ENDPOINT + engineerId)
                .then()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .extract().response();
        //System.out.println(response.getBody().asString());
    }

    @Test
    public static Response deleteEngineerResource(String engineerId) {

        return given()
                .when()
                .request("DELETE", RestApiLocators.DELETE_ENDPOINT + engineerId)
                .then()
                .statusCode(200)
                .statusLine(containsString("OK"))
                .extract().response().andReturn();
        //System.out.println(response.getBody().asString());
    }

    @Test
    public static Response getEngineerWithIdResource(String engineerId) {

        return
                when()
                        .get(RestApiLocators.GET_ENDPOINT + "/" + engineerId)
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .statusLine(containsString("OK"))
                        .and()
                        .body("name", equalTo("TrialPost"))
                        .extract().response();
        //System.out.println(response.getBody().asString());
    }

    @Test
    public static Response getAllEngineers() {

        return given()
                .contentType("application/json")
                .get(RestApiLocators.GET_ENDPOINT)
                .then()
                .assertThat()
                .statusCode(200).and()
                .statusLine(containsString("OK"))
                .extract().response();
        //System.out.println(response.getBody().asString());
    }
}
