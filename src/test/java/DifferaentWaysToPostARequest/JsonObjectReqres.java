package DifferaentWaysToPostARequest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaUtility;
import io.restassured.http.ContentType;

public class JsonObjectReqres {
	
JavaUtility jlib=new JavaUtility();
	
	@Test
	public void jsonObjectReqres() {
		baseURI="https://reqres.in/";
		/* Pre Requests*/
	    JSONObject jobj = new JSONObject();
		jobj.put("name", "Srinivasa"+jlib.getRandom());
		jobj.put("job", "VaddiKasulavaru");
		/* step 1: Pre Conditions */
		given().body(jobj).contentType(ContentType.JSON)
		/* step 2:Actions */
		.when().post("/api/users")
		/* step 3:Validation */
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}


}
