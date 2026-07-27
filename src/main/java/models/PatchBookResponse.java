package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PatchBookResponse 
{
	@JsonProperty("Msg")
	private String msg;
	
	public PatchBookResponse() {}
	
	public String getMsg()
	{
		return msg;
	}
	
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}
