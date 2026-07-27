Feature: Patch Book API
	Scenario: Patch a book with valid details - Positive Test
		Given: I have a valid book ID to patch
		And: I have valid book details to patch
		When: I send a PATCH request to patch book
		Then: the response status should be 200
		And: the response message should be "book is successfully patched"
	
	Scenario: Patch a book with invalid ID - Negative Test
		Given: I have an invalid book ID to patch
		And: I have valid book details to patch
		When: I send a PATCH request to patch book
		Then: the response status should be 404
		And: the response message should contain "not found"
