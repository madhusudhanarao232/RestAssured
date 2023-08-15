package BDDApproachReqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdatePut {

	@Test
	public void updateProject() {
	    baseURI="https://reqres.in";
		JSONObject jObj=new JSONObject();
		jObj.put("name", "Puli-Meka");
		jObj.put("job", "hiding-Hunt");
				
		/* step 1: pre conditions */
		given()
		.body(jObj)
		.contentType(ContentType.JSON)
		/* step 2: actions */
		.when()
		.put("/api/users/2")
		/* step 3: Validation */
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
