package com.bayamp.webservices.restapi.tests;

import org.apache.http.HttpEntity;

final class ResponseObject {

    public int responseStatusCode;
    public String responseStatusMessage;
    public HttpEntity entityContent;

    public ResponseObject(int responseStatusCode, String responseStatusMessage, HttpEntity entityContent) {
        this.responseStatusCode = responseStatusCode;
        this.responseStatusMessage = responseStatusMessage;
        this.entityContent = entityContent;
    }
}
