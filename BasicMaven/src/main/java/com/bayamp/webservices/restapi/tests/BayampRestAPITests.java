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
import org.apache.http.client.utils.URIBuilder;
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

    private static HttpClient client = new DefaultHttpClient();;

    /*@BeforeClass
    public void setUpHttpClient() {
        client = new DefaultHttpClient();

    }*/

    /**
     * Method updates the engineer's name field to value entered
     *
     * @throws IOException
     */
    @Test
    public static String putEngineerPositiveTest(String engineerId) throws IOException {

        HttpPut putRequest = new HttpPut(RestApiLocators.PUT_ENDPOINT + engineerId);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "PUT-Java"));
        putRequest.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse responseObject = client.execute(putRequest);

        StatusLine responseStatusLine = responseObject.getStatusLine();
        int responseStatusCode = responseStatusLine.getStatusCode();
        String responseStatusMessage = responseStatusLine.getReasonPhrase();

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        HttpEntity entityContent = responseObject.getEntity();
        String responseContentAsString = EntityUtils.toString(entityContent);
        return responseContentAsString;
        //System.out.println(responseContentAsString);
    }

    /**
     * Method gets all the engineers and calls the deleteEngineerPositiveTest method with a specific id
     *
     * @throws IOException,ParseException,URISyntaxException
     */
    @Test
    public static String getAnEngineerFromAllEngineersPositiveTest() throws IOException, ParseException, URISyntaxException {

        HttpGet getRequest = new HttpGet(RestApiLocators.GET_ENDPOINT);
        HttpResponse getResponseObject = client.execute(getRequest);

        StatusLine responseStatusLine = getResponseObject.getStatusLine();
        int responseStatusCode = responseStatusLine.getStatusCode();
        String responseStatusMessage = responseStatusLine.getReasonPhrase();

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        HttpEntity entityContent = getResponseObject.getEntity();
        String jsonContentAsString = EntityUtils.toString(entityContent);

        JSONParser jsonParser = new JSONParser();
        Object jsonObj = jsonParser.parse(jsonContentAsString);
        JSONArray arrayObj = (JSONArray) jsonObj;
        JSONObject obj = (JSONObject) arrayObj.get(0);
        String id = (String) obj.get("id");
        return id;
    }

    /**
     * Method deletes the engineer from database with the given id
     *
     * @throws IOException,URISyntaxException
     */
    @Test
    public static String deleteEngineerPositiveTest(String engineerId) throws IOException, URISyntaxException {

        URIBuilder uriBuilder = new URIBuilder(RestApiLocators.BASE_URI);
        uriBuilder.setPath("/bayamp/delete/" + engineerId);
        String generatedUri = uriBuilder.toString();
        //System.out.println(generatedUri);
        HttpDelete deleteRequest = new HttpDelete(generatedUri);
        HttpResponse responseObject = client.execute(deleteRequest);

        StatusLine responseStatusLine = responseObject.getStatusLine();
        int responseStatusCode = responseStatusLine.getStatusCode();
        String responseStatusMessage = responseStatusLine.getReasonPhrase();

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        HttpEntity entityContent = responseObject.getEntity();
        String responseContentAsString = EntityUtils.toString(entityContent);
        return responseContentAsString;
    }

    /**
     * Method creates a new resource (an engineer) and calls the getEngineerTest method with a created id
     *
     * @throws IOException,URISyntaxException
     */
    @Test
    public static String PostEngineerWithIdPositiveTest() throws IOException, URISyntaxException {

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("name", "Bayamp"));
        HttpPost postRequest = new HttpPost(RestApiLocators.POST_ENDPOINT);
        postRequest.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse responseObject = client.execute(postRequest);

        StatusLine responseStatusLine = responseObject.getStatusLine();
        int responseStatusCode = responseStatusLine.getStatusCode();
        String responseStatusMessage = responseStatusLine.getReasonPhrase();

        Reporter.log("Perform Validations");
        Assert.assertEquals(201,responseStatusCode);
        Assert.assertEquals("Created",responseStatusMessage);
        Reporter.log("Validations Complete");

        HttpEntity entityContent = responseObject.getEntity();
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
    public static String getEngineerPositiveTest(String engineerId) throws IOException, URISyntaxException {

        HttpGet getRequest = new HttpGet(RestApiLocators.GET_ENDPOINT + "/" + engineerId);
        HttpResponse responseObject = client.execute(getRequest);

        StatusLine responseStatusLine = responseObject.getStatusLine();
        int responseStatusCode = responseStatusLine.getStatusCode();
        String responseStatusMessage = responseStatusLine.getReasonPhrase();

        Reporter.log("Perform Validations");
        Assert.assertEquals(200,responseStatusCode);
        Assert.assertEquals("OK",responseStatusMessage);
        Reporter.log("Validations Complete");

        HttpEntity entityContent = responseObject.getEntity();
        String responseContentAsString = EntityUtils.toString(entityContent);
        return responseContentAsString;
    }

}