Feature: Delete Book API
	Scenario: Delete a book with valid ID - Positive Test
		Given: I have a valid book ID to delete
		When: I send a DELETE request to delete book
		Then: the response status should be 200
		And: the response message should be "book is successfully deleted"
	
	Scenario: Delete a book with invalid ID - Negative Test
		Given: I have an invalid book ID to delete
		When: I send a DELETE request to delete book
		Then: the response status should be 404
		And: the response message should be "book not found"
