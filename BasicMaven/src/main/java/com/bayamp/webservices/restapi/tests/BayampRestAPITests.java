package com.bayamp.webservices.restapi.tests;

import com.bayamp.webservices.restapi.locators.RestApiLocators;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class BayampRestAPITests {

    private static HttpClient client = new DefaultHttpClient();
    private static HttpPut putRequest;
    private static HttpGet getRequest;
    private static HttpDelete deleteRequest;
    private static HttpPost postRequest;
    private static List<NameValuePair> params = new ArrayList<NameValuePair>();
    private static HttpResponse responseObject;
    private static StatusLine responseStatusLine;
    private static int responseStatusCode;
    private static String responseStatusMessage;
    private static HttpEntity entityContent;
    private static JSONParser jsonParser = new JSONParser();

    /**
     * Method that returns status code, status message and entity content
     *
     * @throws IOException
     */
    @Test
    public static ResponseObject statusCodeMessageAndContent(HttpResponse responseObject){
        responseStatusLine = responseObject.getStatusLine();
        responseStatusCode = responseStatusLine.getStatusCode();
        responseStatusMessage = responseStatusLine.getReasonPhrase();
        entityContent = responseObject.getEntity();

        return new ResponseObject(responseStatusCode, responseStatusMessage, entityContent);
    }

    /**
     * Method updates the engineer's name field to value entered using PUT request
     *
     * @throws IOException
     */
    @Test
    public static HttpEntity putEngineerPositiveTest(String engineerId) throws IOException {

        putRequest = new HttpPut(RestApiLocators.PUT_ENDPOINT + engineerId);

        params.add(new BasicNameValuePair("name", "PUT-Java"));
        putRequest.setEntity(new UrlEncodedFormEntity(params));
        responseObject = client.execute(putRequest);

        statusCodeMessageAndContent(responseObject);

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        return entityContent;
    }

    /**
     * Method gets all the engineers
     *
     * @throws IOException,ParseException,URISyntaxException
     */
    @Test
    public static HttpEntity getAllEngineersPositiveTest() throws IOException, ParseException, URISyntaxException {

        getRequest = new HttpGet(RestApiLocators.GET_ENDPOINT);
        responseObject = client.execute(getRequest);

        statusCodeMessageAndContent(responseObject);

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        return entityContent;
    }

    /**
     * Method gets an engineer from engineers list
     *
     * @throws IOException,ParseException,URISyntaxException
     */
    public static JSONObject getAnEngineerFromAllEngineersPositiveTest(HttpEntity jsonContent) throws ParseException, IOException {

        String jsonContentAsString = EntityUtils.toString(jsonContent);

        Object jsonObj = jsonParser.parse(jsonContentAsString);
        JSONArray arrayObj = (JSONArray) jsonObj;
        JSONObject obj = (JSONObject) arrayObj.get(0);
        return obj;
    }

    /**
     * Method deletes the engineer from database with the given id
     *
     * @throws IOException,URISyntaxException
     */
    @Test
    public static HttpEntity deleteEngineerPositiveTest(JSONObject obj) throws IOException, URISyntaxException {

        String engineerId = (String) obj.get("id");

        /*URIBuilder uriBuilder = new URIBuilder(RestApiLocators.BASE_URI);
        uriBuilder.setPath("/bayamp/delete/" + engineerId);
        String generatedUri = uriBuilder.toString();
        System.out.println(generatedUri);*/

        deleteRequest = new HttpDelete(RestApiLocators.DELETE_ENDPOINT + engineerId);
        responseObject = client.execute(deleteRequest);

        statusCodeMessageAndContent(responseObject);

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        return entityContent;
    }

    /**
     * Method creates a new resource (an engineer)
     *
     * @throws IOException,URISyntaxException
     */
    @Test
    public static HttpEntity postEngineerPositiveTest() throws IOException, URISyntaxException {

        params.add(new BasicNameValuePair("name", "Bayamp"));
        postRequest = new HttpPost(RestApiLocators.POST_ENDPOINT);
        postRequest.setEntity(new UrlEncodedFormEntity(params));
        responseObject = client.execute(postRequest);

        statusCodeMessageAndContent(responseObject);

        Reporter.log("Perform Validations");
        Assert.assertEquals(201,responseStatusCode);
        Assert.assertEquals("Created",responseStatusMessage);
        Reporter.log("Validations Complete");

        return entityContent;
    }

    /**
     * Method gets the id of the new engineer created using POST request
     *
     * @throws IOException,URISyntaxException
     */
    public static String postEngineerIdPositiveTest(HttpEntity entityContent) throws IOException {

        String responseContentAsString = EntityUtils.toString(entityContent);

        String[] messageArray = responseContentAsString.split(" ");
        String engineerId = messageArray[5];
        return engineerId;
    }

    /**
     * Method get the engineers with given id
     *
     * @throws IOException,URISyntaxException
     */
    @Test
    public static HttpEntity getEngineerPositiveTest(String engineerId) throws IOException, URISyntaxException {

        getRequest = new HttpGet(RestApiLocators.GET_ENDPOINT + "/" + engineerId);
        responseObject = client.execute(getRequest);

        statusCodeMessageAndContent(responseObject);

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        return entityContent;
    }
}