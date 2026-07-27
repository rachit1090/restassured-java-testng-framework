Feature: Edit Book API using PUT
	Scenario: Edit a book with valid details using PUT - Positive Test
		Given: I have a valid book ID to edit with PUT
		And: I have valid book details to update with PUT
		When: I send a PUT request to edit book
		Then: the response status should be 200
		And: the response message should be "book is successfully updated"
	
	Scenario: Edit a book with invalid ID using PUT - Negative Test
		Given: I have an invalid book ID to edit with PUT
		And: I have valid book details to update with PUT
		When: I send a PUT request to edit book
		Then: the response status should be 404
		And: the response message should contain "not found"
