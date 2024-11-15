package utility;

public class Authn {
	
	
	
	
	public static String getBearerToken() {
		String bearer_token = CommonUtilFunctions.getProperty(System.getProperty("user.dir")+"\\token.properties", "bearer");
		return bearer_token;
	}

}
