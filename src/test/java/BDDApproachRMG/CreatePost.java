package BDDApproachRMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePost {

	@Test
	public void createPost() {
		baseURI ="http://rmgtestingserver";
		port=8084;
	JavaUtility jlib=new JavaUtility();
	/* Create a pre req*/
	JSONObject jObj=new JSONObject();
	jObj.put("createdBy", "Puli");
	jObj.put("projectName", "hidingHunt"+jlib.getRandom());
	jObj.put("status", "active");
	jObj.put("teamsize", 10);
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
