package utility;

import org.apache.log4j.Logger;


public class RestFWLogger {//FW - FrameWork
	
	private static Logger log = Logger.getLogger(RestFWLogger.class.getName());
	
	public static void startTestCase(String sTestCaseName) {
		log.info("********************************************************************");
		log.info("********************************************************************");
		log.info("$$$$$$$$$$$$$$$$$$$$$$$"+sTestCaseName+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		log.info("********************************************************************");
		log.info("********************************************************************");
	}

	public static void endTestCase() {
		log.info("***************************** E---N---D ***************************");
		log.info("********************************************************************");
		log.info("");
		log.info("");
	}
	
	//Need to create these methods, so that they can be called
	public static void info(String message) {
		log.info(message);
	}

	public static void warn(String message) {
		log.warn(message);		
	}
	public static void error(String message) {
		log.error(message);
	}
	
	public static void fatal(String message) {
		log.fatal(message);
	}
	
	public static void debug(String message) {
		log.debug(message);
	}
}


