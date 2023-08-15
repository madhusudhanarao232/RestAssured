package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class HashMapRmg {
	@Test
	public void usingMap() {
		baseURI ="http://rmgtestingserver";
		port=8084;
		JavaUtility jlib=new JavaUtility();
		/* Create a pre-request*/
		HashMap <String,Object> map=new HashMap<String, Object>();
		map.put("createdBy", "Kalyan");
		map.put("projectName", "GameOVER"+jlib.getRandom());
		map.put("status", "WIN");
		map.put("teamsize", 19);
		/* step 1: pre conditions */
		given()
		.body(map)
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
