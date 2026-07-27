package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBookResponse 
{
	@JsonProperty("book_name")
	private String name;
	
	@JsonProperty("isbn")
	private String isbn;
	
	@JsonProperty("aisle")
	private String aisle;
	
	
	public GetBookResponse() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAisle() {
		return aisle;
	}

	public void setAisle(String aisle) {
		this.aisle = aisle;
	}
	
	
}
