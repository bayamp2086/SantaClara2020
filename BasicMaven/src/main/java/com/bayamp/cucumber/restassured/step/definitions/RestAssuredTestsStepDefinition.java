package com.bayamp.cucumber.restassured.step.definitions;

import com.bayamp.webservices.restapi.locators.RestApiLocators;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTestsStepDefinition {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    //To get an engineer with id
    @Given("GET \"(.*)\" to get an engineer")
    public void getAnEngineerId(String engineerId) {
        request = given().pathParam("id", engineerId);
    }
    @When("I execute the GET request")
    public void getAnEngineer() {
        // response = request.when().get("https://bayamprestapp.herokuapp.com/bayamp/engineers/{id}");
        response = request.when().get(RestApiLocators.GET_ENDPOINT + "/{id}");
    }
    @Then("I get 200 OK status code for GET request")
    public void validateGetStatusCode() {
        json = response
                .then()
                .statusCode(200)
                .statusLine(containsString("OK"));
    }
    @And("Response includes Name as Bayamp")
    public void responseBody() {
        json.body("name", equalTo("Bayamp"));
    }

    //To create an engineer
    @Given("POST data to create an engineer")
    public void createAnEngineerData(){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "RestAssuredPost");
        request = given().body(jsonObj.toString());
    }
    @When("I execute the POST request")
    public void createAnEngineer(){
        response = request.when().request("POST", RestApiLocators.POST_ENDPOINT);
    }
    @Then("I get 201 Created status code for POST request")
    public void validatePostStatusCode(){
        json = response
                .then()
                .statusCode(201)
                .statusLine(containsString("Created"));
    }

    //To update an engineer
    @Given("PUT data and \"(.*)\" to update an engineer")
    public void updateAnEngineerIdAndData(String engineerId){
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "RestAssuredPut");
        request = given().pathParam("id", engineerId).body(jsonObj.toString());
    }
    @When("I execute the PUT request")
    public void updateAnEngineer(){
        response = request.when().request("PUT", RestApiLocators.PUT_ENDPOINT + "{id}");
    }
    @Then("I get 200 Ok status code for PUT request")
    public void validatePutStatusCode(){
        json = response
                .then()
                .statusCode(200)
                .statusLine(containsString("OK"));
    }

    //To delete an engineer
    @Given("DELETE \"(.*)\" to delete an engineer")
    public void deleteAnEngineerId(String engineerId){
        request = given().pathParam("id", engineerId);
    }
    @When("I execute the DELETE request")
    public void deleteAnEngineer(){
        response = request.when().request("DELETE", RestApiLocators.DELETE_ENDPOINT + "{id}");
    }
    @Then("I get 200 Ok status code for DELETE request")
    public void validateDeleteStatusCode(){
        json = response
                .then()
                .statusCode(200)
                .statusLine(containsString("OK"));
    }
}
