package BDDApproachRMG;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdatePut {

	@Test
	public void updateProject() {
	    baseURI="http://rmgtestingserver";
	    port=8084;
	    String id = "TY_PROJ_24404";
		JSONObject jObj=new JSONObject();
		jObj.put("createdBy", "Puli-Meka");
		jObj.put("projectName", "hiding-Hunt");
		jObj.put("status", "active");
		jObj.put("teamsize",13);
		
		/* step 1: pre conditions */
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		/* step 2: actions */
		.when()
		.put("/projects/"+id)
		/* step 3: Validation */
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
