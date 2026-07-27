package base;

import org.testng.annotations.BeforeClass;

import api.LibraryAPIClient;
import io.restassured.RestAssured;

public class BaseTest 
{
	@BeforeClass
	public void setUp()
	{
		RestAssured.requestSpecification = LibraryAPIClient.getRequestSpec();
        RestAssured.responseSpecification = LibraryAPIClient.getResponseSpec();
		
	}
}
