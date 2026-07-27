package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import models.AddBookRequest;
import payloads.BookPayloads;
import static io.restassured.RestAssured.given;
//import sun.rmi.transport.Endpoint;

import org.testng.Assert;

import constants.EndPoint;

public class AddBookSteps 
{
	private AddBookRequest addBookRequest;
	private Response response;
	
	@Given("I have a valid add book request")
	public void i_have_a_valid_add_book_request()
	{
		addBookRequest=BookPayloads.validAddBook();
	}
	
	@When("I send a POST request to add book")
	public void i_send_a_post_request_to_add_book()
	{
		response=given()
        .body(addBookRequest)
        .when()
        .post(EndPoint.ADD_BOOK);
	}
	
	@Then("the response status should be 200")
	public void the_response_status_should_be_200()
	{
		int res = response.statusCode();
		Assert.assertEquals(res, 200);
	}
	
	@Then("the response message should be {string}")
	public void the_response_message_should_be (String message)
	{
		String res = response.jsonPath().get("Msg");
		Assert.assertEquals(res, message);
	}
	
	@Then("the book id should not be empty")
	public void the_book_id_should_not_be_empty()
	{
		String res = response.jsonPath().get("ID");
		Assert.assertNotNull(res);
	}
	
}
