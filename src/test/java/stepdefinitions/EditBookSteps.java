package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.PutBookRequest;
import payloads.BookPayloads;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import constants.EndPoint;
import utility.ExtentReportManager;

public class EditBookSteps 
{
	private PutBookRequest putBookRequest;
	private Response response;
	private String validBookId;
	private String invalidBookId;
	
	@Given("I have a valid book ID to edit with PUT")
	public void i_have_a_valid_book_id_to_edit_with_put()
	{
		validBookId = "1";
		putBookRequest = new PutBookRequest(validBookId, "Updated Book", "ISBN123", "Aisle5", "Updated Author");
		ExtentReportManager.logInfo("Valid book ID set to: " + validBookId);
	}
	
	@Given("I have an invalid book ID to edit with PUT")
	public void i_have_an_invalid_book_id_to_edit_with_put()
	{
		invalidBookId = "99999";
		putBookRequest = new PutBookRequest(invalidBookId, "Updated Book", "ISBN123", "Aisle5", "Updated Author");
		ExtentReportManager.logInfo("Invalid book ID set to: " + invalidBookId);
	}
	
	@Given("I have valid book details to update with PUT")
	public void i_have_valid_book_details_to_update_with_put()
	{
		ExtentReportManager.logInfo("Book details set for PUT request");
	}
	
	@When("I send a PUT request to edit book")
	public void i_send_a_put_request_to_edit_book()
	{
		try
		{
			response = given()
				.body(putBookRequest)
				.when()
				.put(EndPoint.UPDATE_BOOK);
			ExtentReportManager.logInfo("PUT request sent to " + EndPoint.UPDATE_BOOK);
		}
		catch (Exception e)
		{
			ExtentReportManager.logException(e);
			throw e;
		}
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
