package com.restApiBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.RestFWLogger;

public class BaseClass {

	public static Response getRequest(String requestURI) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is "+requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		RestFWLogger.info("Response is :"+ response.getBody().asString());
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayload) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);
		RestFWLogger.info("Request Payload is :"+requestPayload);
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		RestFWLogger.info("Response is :"+ response.getBody().asString());
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayload, String bearer_token) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);
		RestFWLogger.info("Request Payload is :"+requestPayload);

		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer "+bearer_token);
		Response response = requestSpecification.post(requestURI);
		RestFWLogger.info("Response is :"+ response.getBody().asString());
		return response;
	}

	public static Response putRequest(String requestURI, String requestPayload) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);
		RestFWLogger.info("Request Payload is :"+requestPayload);

		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		RestFWLogger.info("Response is :"+ response.getBody().asString());
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestFWLogger.info("Response status code is :"+ response.getStatusCode());
		return response;
	}
	
	public static Response deleteRequest(String requestURI, String bearer_token) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer "+bearer_token);
		Response response = requestSpecification.delete(requestURI);
		RestFWLogger.info("Response status code is :"+ response.getStatusCode());
		return response;
	}

	public static Response deleteRequestWithPayload(String requestURI, String requestPayload) {
		RestFWLogger.initLogger();
		RestFWLogger.info("Request URI is :"+requestURI);
		RestFWLogger.info("Request Payload is :"+requestPayload);

		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		RestFWLogger.info("Response status code is :"+ response.getStatusCode());
		return response;
	}
}
