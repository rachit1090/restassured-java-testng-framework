package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteRequest 
{
	@JsonProperty("ID")
	private String id;
	
	public DeleteRequest(String id)
	{
		this.id=id;
	}
	
	public DeleteRequest()
	{}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
