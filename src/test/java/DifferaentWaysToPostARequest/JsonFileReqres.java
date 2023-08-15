package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class JsonFileReqres {
	
	@Test
	public void usingHashMapReqres() {
		baseURI="https://reqres.in/";
		/* Pre Requests*/
		File file=new File("./src/test/resources/JasonFileReqres.json");
		/* step 1: Pre Conditions */
		given().body(file).contentType(ContentType.JSON)
		/* step 2:Actions */
		.when().post("/api/users")
		/* step 3:Validation */
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}


}
