package basic.testcases;

import java.io.IOException;

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

public class CreateRepoTest {
	Response response;
	ObjectMapper mapper;
	String endpoint = CreateURL.getBaseURI("/user/repos");
	String bearer_token=Authn.getBearerToken();
	
	@Test
	public void createRepositoryTestCase() throws IOException {
		String requestPayload = PayloadGenerator.generateStringPayload("CreatRepo.json");
		
		response= BaseClass.postRequest(endpoint, requestPayload,bearer_token);		
		String responseString= response.getBody().asString();
	
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "name"));
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), CommonUtilFunctions.getResponseKeyValue(requestPayload, "description"));
	}
	
	@Test
	public void createRepoTestCase() throws JsonProcessingException {
		
		CreateRepoPojo requestPayload = new CreateRepoPojo();
		requestPayload.setName("API-testing-Restcalls6");
		requestPayload.setDescription("Repository created via rest assured test 2");
		
		mapper = new ObjectMapper();
		String payload= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(requestPayload);
		
		response= BaseClass.postRequest(endpoint, payload,bearer_token);		
		String responseString= response.getBody().asString();
		
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "name"), requestPayload.getName());
		Assert.assertEquals(CommonUtilFunctions.getResponseKeyValue(responseString, "description"), requestPayload.getDescription());
		
		System.out.println("Request payload name"+requestPayload.getName());
	}
	
}
