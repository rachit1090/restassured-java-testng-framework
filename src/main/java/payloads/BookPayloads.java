package payloads;

import models.AddBookRequest;
import models.DeleteRequest;

public class BookPayloads 
{
	
	private BookPayloads() {}
	
	public static AddBookRequest validAddBook()
	{
		AddBookRequest addBookRequest = new AddBookRequest( "Learn Appium Automation with Java",
		        "bcd",
		        "227",
		        "John Foe");
		return addBookRequest;
	}
	
	
	public static DeleteRequest  deleteBook(String bookId)
	{
		DeleteRequest deleteRequest = new DeleteRequest(bookId);
		return deleteRequest;
	}
}
