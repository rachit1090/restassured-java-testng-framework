package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class LibraryAPIClient 
{
	public static final String BASE_URI = "http://216.10.245.166";
	
	
	public static RequestSpecification getRequestSpec()
	{
		return new RequestSpecBuilder()
				.setBaseUri(BASE_URI)
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
                .build();
	}
	
	public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .build();
    }
	
}
