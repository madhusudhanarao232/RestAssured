package Interview_RestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class MultipleWaysToSendCookies {

	@Test
	public void firstWay() {
		// using cookie() method 
		RestAssured.given()
		.cookie("sessionId","abc123")
		.cookie("authToken","xyz123")
		.get("/endpoint");
	}
	@Test
	public void secondWay() {
		// Using cookies() method
		HashMap<String, String> cookieMap = new HashMap<>();
		cookieMap.put("sessionId","abc123");
		cookieMap.put("authToken","xyz123");
		
		RestAssured.given()
		.cookies(cookieMap)
		.get("/endpoint");
		
	}
	@Test
	public void thirdWay() {
		// using Cookie class : you can see the io.restassured.http.Cookie class
		// to create cookie object and add them to the request using the .cookie()
		//This approach allows you to set additional cookie attribute like domain,path,expiration,etc...
		
		RequestSpecification reqspec = new RequestSpecBuilder()
				.addCookie("sessionId","abc 123")
				.addCookie("authToken","xyz456")
				.build();
		given().spec(reqspec).get("/endpoint");
	}
	
}
