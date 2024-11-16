package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CommonUtilFunctions {
	
	public static JsonPath jsonPath;
	
	public static String getResponseKeyValue(String response_body,String respnose_key) {
		jsonPath = new JsonPath(response_body);
		String key_value =jsonPath.get(respnose_key);
		return key_value;		
	}
	
	public static String getProperty(String path, String key) {
		String getValue=null;
		try {
			Properties prop = new Properties();
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			getValue =prop.getProperty(key);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return getValue;
	}
	
	public static int getStatusCode(Response response) {
		RestFWLogger.initLogger();
		int statusCode = response.getStatusCode();
		RestFWLogger.info("Request response status code is "+statusCode);
		return statusCode;		
	}
	
	public static String getStatusMsg(Response response) {
		RestFWLogger.initLogger();
		String statusMsg = response.getStatusLine();
		RestFWLogger.info("Request response status message is "+statusMsg);
		return statusMsg;
	}

	public static String getResponseHeader(Response response,String headerKey) {
		RestFWLogger.initLogger();
		String responseHeader= response.getHeader(headerKey);
		RestFWLogger.info("Request response header key is -"+headerKey+" and value is - "+responseHeader);
		return responseHeader;
	}

	public static String getResponseContentType(Response response) {
		RestFWLogger.initLogger();
		String contentType=response.getContentType();
		RestFWLogger.info("Request response content type is -"+contentType);
		return contentType;
	}
	
	public static int getResponseExecutionTime(Response response) {
		RestFWLogger.initLogger();
		int executionTime=(int)response.getTime();
		RestFWLogger.info("Request response execution time is -"+executionTime);
		return executionTime;
	}
}
