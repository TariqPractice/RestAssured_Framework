package com.restApiBase;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static Response getRequest(String requestURI) {

		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.get(requestURI);
		return response;
	}

	public static Response postRequest(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.post(requestURI);
		return response;
	}
	
	public static Response postRequest(String requestURI, String requestPayload, String bearer_token) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		requestSpecification.header("Authorization", "Bearer "+bearer_token);
		Response response = requestSpecification.post(requestURI);
		return response;
	}

	public static Response putRequest(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.put(requestURI);
		return response;
	}

	public static Response deleteRequest(String requestURI) {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}

	public static Response deleteRequestWithPayload(String requestURI, String requestPayload) {
		RequestSpecification requestSpecification = RestAssured.given().body(requestPayload);
		requestSpecification.contentType(ContentType.JSON);
		Response response = requestSpecification.delete(requestURI);
		return response;
	}
}
