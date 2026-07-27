package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.DeleteRequest;
import payloads.BookPayloads;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import constants.EndPoint;
import utility.ExtentReportManager;

public class DeleteBookSteps 
{
	private DeleteRequest deleteRequest;
	private Response response;
	private String validBookId;
	private String invalidBookId;
	
	@Given("I have a valid book ID to delete")
	public void i_have_a_valid_book_id_to_delete()
	{
		validBookId = "1";
		deleteRequest = new DeleteRequest(validBookId);
		ExtentReportManager.logInfo("Valid book ID set to: " + validBookId);
	}
	
	@Given("I have an invalid book ID to delete")
		public void i_have_an_invalid_book_id_to_delete()
	{
		invalidBookId = "99999";
		deleteRequest = new DeleteRequest(invalidBookId);
		ExtentReportManager.logInfo("Invalid book ID set to: " + invalidBookId);
	}
	
	@When("I send a DELETE request to delete book")
	public void i_send_a_delete_request_to_delete_book()
	{
		try
		{
			response = given()
				.body(deleteRequest)
				.when()
				.delete(EndPoint.DELETE_BOOK);
			ExtentReportManager.logInfo("DELETE request sent to " + EndPoint.DELETE_BOOK);
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
	
}
