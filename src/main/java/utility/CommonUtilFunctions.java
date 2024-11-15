package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.path.json.JsonPath;

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

}
