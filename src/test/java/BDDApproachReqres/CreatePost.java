package BDDApproachReqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreatePost {

	@Test
	public void createPost() {
		baseURI ="https://reqres.in";
	JavaUtility jlib=new JavaUtility();
	/* Create a pre req*/
	JSONObject jObj=new JSONObject();
	jObj.put("name", "Puli"+jlib.getRandom());
	jObj.put("job", "hidingHunt");
	
	/* step 1: pre conditions */
	given()
	.body("{'name': 'Puli-Meka','job':'madhu'}")
	
	/* step 2: actions */
	.when()
	.post("/api/users")
	/* step 3: Validation */
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
	
	}
}
