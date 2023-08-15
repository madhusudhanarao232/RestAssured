package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JsonFileRmg {
	@Test
	public void jsonFilePost(){

		baseURI ="http://rmgtestingserver";
		port=8084;
		/* Create a pre-reqsuest*/
		File file=new File("./src/test/resources/File.json");
		/* step 1: pre conditions */
		given().body(file).contentType(ContentType.JSON)
		/* step 2: actions */
		.when().post("/addProject")
		/* step 3: Validation */
.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	
	}
}
