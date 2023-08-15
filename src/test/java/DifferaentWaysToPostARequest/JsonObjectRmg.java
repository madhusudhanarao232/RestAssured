package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class JsonObjectRmg {
	@Test
	public void usingJsonObject() {
		baseURI ="http://rmgtestingserver";
		port=8084;
		JavaUtility jlib=new JavaUtility();
		/* Create a pre req*/
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Keshava");
		jObj.put("projectName", "HOMEDOWN"+jlib.getRandom());
		jObj.put("status", "IN-active");
		jObj.put("teamsize", 7);
		/* step 1: pre conditions */
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		/* step 2: actions */
		.when()
		.post("/addProject")
		/* step 3: Validation */
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all(); 
	}
}
