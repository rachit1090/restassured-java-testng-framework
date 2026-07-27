package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddBookResponse 
{
	@JsonProperty("Msg")
	private String msg;
	
	@JsonProperty("ID")
	private String id;
	
	public AddBookResponse() {}
	
	public String getMsg()
	{
		return msg;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setMsg(String msg)
	{
		this.msg=msg;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
}
