package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchBookRequest 
{
	@JsonProperty("ID")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("isbn")
	private String isbn;
	
	@JsonProperty("aisle")
	private String aisle;
	
	@JsonProperty("author")
	private String author;
	
	public PatchBookRequest() {}
	
	public PatchBookRequest(String id, String name, String isbn, String aisle, String author) 
	{
		this.id = id;
		this.name = name;
		this.isbn = isbn;
		this.aisle = aisle;
		this.author = author;
	}

	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getIsbn() 
	{
		return isbn;
	}

	public void setIsbn(String isbn) 
	{
		this.isbn = isbn;
	}

	public String getAisle() 
	{
		return aisle;
	}

	public void setAisle(String aisle) 
	{
		this.aisle = aisle;
	}

	public String getAuthor() 
	{
		return author;
	}

	public void setAuthor(String author) 
	{
		this.author = author;
	}
	
}