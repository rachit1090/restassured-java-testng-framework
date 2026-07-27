package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PutBookResponse 
{
	@JsonProperty("Msg")
	private String msg;
	
	public PutBookResponse() {}
	
	public String getMsg()
	{
		return msg;
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}