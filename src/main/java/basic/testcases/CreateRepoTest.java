package basic.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restApiBase.BaseClass;

import io.restassured.response.Response;
import resourcesresources.pojoclasses.CreateRepoPojo;
import utility.Authn;
import utility.CommonUtilFunctions;
import utility.CreateURL;
import utility.PayloadGenerator;
import utility.RestFWLogger;

public class CreateRepoTest {
	Response response;
	ObjectMapper mapper;
	String endpoint = CreateURL.getBaseURI("/user/repos");
	String bearer_token=Authn.getBearerToken();
	
	@Test
	public void createRepositoryTestCase() throws IOException {
		PropertyConfigurator.configure("log4j.properties");
		RestFWLogger.startTestCase("createRepositoryTestCase");
		RestFWLogger.info("Started create Repo Test");
		RestFWLogger.info("Request URI is "+endpoint);
		String requestPayload = PayloadGenerator.generateStringPayload("CreatRepo.json");
		RestFWLogger.info("Request payload is "+requestPayload);
		
		response= BaseClass.postRequest(endpoint, requestPayload,bearer_token);		
		String responseString= response.getBody().asString();
		
		RestFWLogger.info("Response is "+responseString);
	
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "name"));
		RestFWLogger.info("Assertion Repo name is done");
		RestFWLogger.info("Name from Request - "+CommonUtilFunctions.getResponseKeyValue(requestPayload, "name"));
		RestFWLogger.info("Name from Response - "+CommonUtilFunctions.getResponseKeyValue(responseString, "name"));
		
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "description"));
		RestFWLogger.info("Assertion Repo description is done");
		RestFWLogger.info("Description from Request - "+CommonUtilFunctions.getResponseKeyValue(requestPayload, "description"));
		RestFWLogger.info("Description from Response - "+CommonUtilFunctions.getResponseKeyValue(responseString, "description"));
		
		RestFWLogger.endTestCase();
	}
	
	@Test
	public void createRepoTestCase() throws JsonProcessingException {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFWLogger.startTestCase("createRepoTestCase");
		RestFWLogger.info("Started create Repo Test via POJO");
		RestFWLogger.info("Request URI is "+endpoint);
		
		CreateRepoPojo requestPayload = new CreateRepoPojo();
		requestPayload.setName("API-testing-Restcalls7");
		requestPayload.setDescription("Repository created via rest assured test 2");
		
		mapper = new ObjectMapper();
		String payload= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		RestFWLogger.info("Request Payload :"+payload);
		
		response= BaseClass.postRequest(endpoint, payload,bearer_token);		
		String responseString= response.getBody().asString();
		RestFWLogger.info("Response Payload :"+responseString);
		
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), requestPayload.getName());
		RestFWLogger.info("Assertion Repo name is done");
		RestFWLogger.info("Name from Request - "+requestPayload.getName());
		RestFWLogger.info("Name from Response - "+CommonUtilFunctions.getResponseKeyValue(responseString, "name"));
		
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), requestPayload.getDescription());
		RestFWLogger.info("Assertion Repo description is done");
		RestFWLogger.info("Description from Request - "+requestPayload.getDescription());
		RestFWLogger.info("Description from Response - "+CommonUtilFunctions.getResponseKeyValue(responseString, "description"));
		
		RestFWLogger.endTestCase();
	}
	
}
