package Interview_RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ReqHeaderValidation {
	
	@Test
	public void verifyReqHeader() {
	baseURI="http://rmgtestingserver";	
	port=8084;
	
	String expected_statusLine="HTTP/1.1 200 ";
	String expected_vary="Access-Control-Request-Headers";
	String expected_contentType="application/json";
	String expected_pragma="no-cache";
	String expected_Connection="keep-alive";
		
	Response res = when().get("/projects/TY_PROJ_25169");
	res.then().assertThat()
	.contentType(ContentType.JSON).log().all();
	
	res.prettyPeek();
	
	String statusLine = res.statusLine();
	System.out.println(statusLine);
	Assert.assertEquals(statusLine, expected_statusLine);
	
	Headers headers =res.getHeaders();
	System.out.println(headers);
	
	
	String actual_contentType = res.getHeader("content-Type");
	Assert.assertEquals(actual_contentType,expected_contentType);
	
	
	String actual_pragma=res.getHeader("Pragma");
	Assert.assertEquals(actual_pragma, expected_pragma);
	
	String actual_vary = res.getHeader("Vary");
	Assert.assertEquals(actual_vary, expected_vary);
	
	String actual_connection = res.getHeader("Connection");
	Assert.assertEquals(actual_connection, expected_Connection);
	
	}

}
