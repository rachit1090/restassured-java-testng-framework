package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.PatchBookRequest;
import payloads.BookPayloads;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import constants.EndPoint;
import utility.ExtentReportManager;

public class PatchBookSteps 
{
	private PatchBookRequest patchBookRequest;
	private Response response;
	private String validBookId;
	private String invalidBookId;
	
	@Given("I have a valid book ID to patch")
	public void i_have_a_valid_book_id_to_patch()
	{
		validBookId = "1";
		patchBookRequest = new PatchBookRequest(validBookId, "Patched Book", "ISBN456", "Aisle10", "Patched Author");
		ExtentReportManager.logInfo("Valid book ID set to: " + validBookId);
	}
	
	@Given("I have an invalid book ID to patch")
	public void i_have_an_invalid_book_id_to_patch()
	{
		invalidBookId = "99999";
		patchBookRequest = new PatchBookRequest(invalidBookId, "Patched Book", "ISBN456", "Aisle10", "Patched Author");
		ExtentReportManager.logInfo("Invalid book ID set to: " + invalidBookId);
	}
	
	@Given("I have valid book details to patch")
	public void i_have_valid_book_details_to_patch()
	{
		ExtentReportManager.logInfo("Book details set for PATCH request");
	}
	
	@When("I send a PATCH request to patch book")
	public void i_send_a_patch_request_to_patch_book()
	{
		try
		{
			response = given()
				.body(patchBookRequest)
				.when()
				.patch(EndPoint.UPDATE_BOOK);
			ExtentReportManager.logInfo("PATCH request sent to " + EndPoint.UPDATE_BOOK);
		}
		catch (Exception e)
		{
			ExtentReportManager.logException(e);
			throw e;
		}
	}
	
	@Then("the response status should be 200")
	public void the_response_status_should_be_200()
	{
		int statusCode = response.statusCode();
		ExtentReportManager.logInfo("Response status code: " + statusCode);
		Assert.assertEquals(statusCode, 200);
		ExtentReportManager.logPass("Status code is 200 as expected");
	}
	
	@Then("the response status should be 404")
	public void the_response_status_should_be_404()
	{
		int statusCode = response.statusCode();
		ExtentReportManager.logInfo("Response status code: " + statusCode);
		Assert.assertEquals(statusCode, 404);
		ExtentReportManager.logPass("Status code is 404 as expected");
	}
	
	@Then("the response message should be {string}")
	public void the_response_message_should_be(String expectedMessage)
	{
		String actualMessage = response.jsonPath().get("Msg");
		ExtentReportManager.logInfo("Expected message: " + expectedMessage);
		ExtentReportManager.logInfo("Actual message: " + actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage);
		ExtentReportManager.logPass("Response message matches: " + expectedMessage);
	}
	
	@Then("the response message should contain {string}")
	public void the_response_message_should_contain(String expectedSubstring)
	{
		String actualMessage = response.jsonPath().get("Msg");
		ExtentReportManager.logInfo("Expected substring: " + expectedSubstring);
		ExtentReportManager.logInfo("Actual message: " + actualMessage);
		Assert.assertTrue(actualMessage.contains(expectedSubstring), "Response message does not contain: " + expectedSubstring);
		ExtentReportManager.logPass("Response message contains: " + expectedSubstring);
	}
	
}
