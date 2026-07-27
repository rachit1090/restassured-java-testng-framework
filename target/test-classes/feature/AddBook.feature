Feature: Add Book API
	Scenario: Add a book with valid details
		Given: I have a valid add book request
		When: I send a POST request to add book
		Then: the response status should be 200
		And: the response message should be "successfully added"
		And: the book id should not be empty 