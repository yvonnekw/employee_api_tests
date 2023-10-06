package base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;

	public Logger logger;
	
	@BeforeClass
	public void setUp() {
		logger=logger.getLogger("Employee Rest API"); //added Logger
		PropertyConfigurator.configure("Log4j.properties"); //added logger
		logger.setLevel(Level.DEBUG);
	}
	
	

}
