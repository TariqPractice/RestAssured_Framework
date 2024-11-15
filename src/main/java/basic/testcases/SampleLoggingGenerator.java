package basic.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;

import utility.RestFWLogger;


public class SampleLoggingGenerator {
	//@Test
	public void REST_TEST01() {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFWLogger.startTestCase("REST_TEST01");
		RestFWLogger.info("Creating rest assured object");
		RestFWLogger.info("Excel sheet opened");
		RestFWLogger.info("New object instantiaed");
		RestFWLogger.info("Implicit wait applied on the test for 10 seconds");
		RestFWLogger.info("URI Launched");
		RestFWLogger.info("Login successfull, and now it is time to log off");
		RestFWLogger.info("Action is performed on logout link");
		RestFWLogger.info("Test case closed");
		RestFWLogger.endTestCase();
	}

	//@Test
	public void REST_TEST02() {
		
		PropertyConfigurator.configure("log4j.properties");
		RestFWLogger.startTestCase("REST_TEST02");
		RestFWLogger.info("Creating rest assured object");
		RestFWLogger.info("Excel sheet opened");
		RestFWLogger.info("New object instantiaed");
		RestFWLogger.info("Implicit wait applied on the test for 10 seconds");
		RestFWLogger.info("URI Launched");
		RestFWLogger.info("Test case closed");
		RestFWLogger.endTestCase();
	}

}
