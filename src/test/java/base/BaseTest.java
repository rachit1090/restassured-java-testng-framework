package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import api.LibraryAPIClient;
import io.restassured.RestAssured;
import utility.ExtentReportManager;

public class BaseTest 
{
	@BeforeClass
	public void setUp()
	{
		ExtentReportManager.initializeReport();
		RestAssured.requestSpecification = LibraryAPIClient.getRequestSpec();
        RestAssured.responseSpecification = LibraryAPIClient.getResponseSpec();
	}
	
	@Before
	public void beforeScenario()
	{
		ExtentReportManager.initializeReport();
	}
	
	@After
	public void afterScenario()
	{
		ExtentReportManager.flushReport();
	}
	
	@AfterClass
	public void tearDown()
	{
		ExtentReportManager.flushReport();
	}
}
