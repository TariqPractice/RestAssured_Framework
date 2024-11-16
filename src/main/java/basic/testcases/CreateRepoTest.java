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
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("createRepositoryTestCase");

		RestFWLogger.info("Step 1: Generating payload String");
		String requestPayload = PayloadGenerator.generateStringPayload("CreatRepo.json");
		
		RestFWLogger.info("Step 2: Executing create repo api");
		response= BaseClass.postRequest(endpoint, requestPayload,bearer_token);		
		String responseString= response.getBody().asString();

		RestFWLogger.info("Step 3: Validating repository name");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "name"));
		
		RestFWLogger.info("Step 4: Validating repository description");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "description"));
		RestFWLogger.info("Assertion Repo description is done");
		
		RestFWLogger.endTestCase();
	}
	
	@Test
	public void createRepoTestCase() throws JsonProcessingException {
		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("createRepoTestCase");
		
		RestFWLogger.info("Step 1: Generating payload String");		
		CreateRepoPojo requestPayload = new CreateRepoPojo();
		requestPayload.setName("API-testing-Restcalls7");
		requestPayload.setDescription("Repository created via rest assured test 2");
		
		mapper = new ObjectMapper();
		String payload= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		RestFWLogger.info("Request Payload :"+payload);
		
		RestFWLogger.info("Step 2: Executing create repo api");
		response= BaseClass.postRequest(endpoint, payload,bearer_token);		
		String responseString= response.getBody().asString();
		
		RestFWLogger.info("Step 3: Validating repository name");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), requestPayload.getName());
		
		RestFWLogger.info("Step 4: Validating repository description");
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), requestPayload.getDescription());
		RestFWLogger.info("Assertion Repo description is done");
		
		RestFWLogger.endTestCase();
	}
	@Test
	public void deletRepo() throws IOException {		
		RestFWLogger.initLogger();

		RestFWLogger.startTestCase("deletRepo");
		
		RestFWLogger.info("Step 1: Generating deleting requesting payload");
		String requestPayload = PayloadGenerator.generateStringPayload("CreatRepo.json");
		RestFWLogger.info("Request payload is "+requestPayload);

		RestFWLogger.info("Step 2: Generating endpoint to hit to delete repo");
		String deleteEndpoint = CreateURL.getBaseURI("/repos/tariqdummy/")+CommonUtilFunctions.getResponseKeyValue(requestPayload, "name");
		
		RestFWLogger.info("Delete endpoint : "+deleteEndpoint);
		
		RestFWLogger.info("Step 3: Executing delete repo");
		response = BaseClass.deleteRequest(deleteEndpoint,bearer_token);

		RestFWLogger.info("Step 4: Validating status code");
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
		RestFWLogger.endTestCase();
	}
	
	@Test
	public void deletRepoPOJO() throws IOException {		

		RestFWLogger.initLogger();
		RestFWLogger.startTestCase("deletRepoPOJO");

		RestFWLogger.info("Step 1: Generating payload String");
		CreateRepoPojo requestPayload = new CreateRepoPojo();
		requestPayload.setName("API-testing-Restcalls7");
		requestPayload.setDescription("Repository delete via POJO");
		
		mapper = new ObjectMapper();
		String payload= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		RestFWLogger.info("Request Payload :"+payload);

		RestFWLogger.info("Step 2: Generating endpoint to hit to delete repo");
		String deleteEndpoint = CreateURL.getBaseURI("/repos/tariqdummy/")+requestPayload.getName();
		RestFWLogger.info("Delete endpoint : "+deleteEndpoint);
		
		RestFWLogger.info("Step 3: Executing delete repo");
		response = BaseClass.deleteRequest(deleteEndpoint,bearer_token);

		RestFWLogger.info("Step 4: Validating status code and message");		
		Assert.assertEquals(CommonUtilFunctions.getStatusCode(response), 204);
		RestFWLogger.info(CommonUtilFunctions.getStatusMsg(response));
		RestFWLogger.endTestCase();
		
	}
}
